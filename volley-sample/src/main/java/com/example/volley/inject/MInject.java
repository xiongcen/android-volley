package com.example.volley.inject;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.view.View;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xiongcen on 17/2/24.
 */

public class MInject {

    /**
     * Dialog中使用，
     *
     * @param dialog
     */
    public static void inject(Dialog dialog) {
        inject(dialog, dialog.getWindow().getDecorView());
    }

    /**
     * 在Activity中使用
     *
     * @param activity
     */
    public static void inject(Activity activity) {
        inject(activity, activity.getWindow().getDecorView());
    }

    /**
     * 在v4包中的Fragment中使用
     *
     * @param fragment
     */
    public static void inject(Fragment fragment) {
        inject(fragment, fragment.getView());
    }

    /**
     * 在Fragment中使用
     *
     * @param fragment
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void inject(android.app.Fragment fragment) {
        inject(fragment, fragment.getView());
    }

    public static void inject(final Object target, View rootView) {
        if (target == null) {
            return;
        }
        injectView(target, rootView);
        injectOnClick(target, rootView);
    }

    public static void injectView(final Object target, View rootView) {
        Field[] declaredFields = target.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            Inject annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                int viewId = annotation.value();
                if (viewId != -1) {
                    try {
                        Object injectView = rootView.findViewById(viewId);
                        if (injectView == null) {
                            throw new Resources.NotFoundException("未找到id为" + viewId + "的view");
                        }
                        field.setAccessible(true);
                        field.set(target, injectView);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new IllegalArgumentException("MViewInject注解的参数异常");
                }
            }
        }
    }

    private static final String METHOD_NAME_SETONCLICKLISTENER = "setOnClickListener";

    /**
     * 设置的点击事件是用setiOnClickListener();
     * 然后View.OnClickListener是一个接口，不能用反射来获得他的实例，那么怎么办呢？
     * 这里可以巧妙地用动态代理来完成。
     *
     * @param target
     * @param rootView
     */
    public static void injectOnClick(final Object target, View rootView) {
        Method[] declaredMethods = target.getClass().getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method declaredMethod = declaredMethods[i];
            declaredMethod.setAccessible(true);
            OnClick annotation = declaredMethod.getAnnotation(OnClick.class);
            if (annotation != null) {
                int[] viewIds = annotation.value();
                Class listenerType = annotation.listenerType();
                long shakeTime = annotation.shakeTime();//获取防抖时间

                ProxyInvocationHandler handler = new ProxyInvocationHandler(target);
                handler.addHandleMethod(annotation.proxyMethodName(), declaredMethod);
                handler.setShakeTime(shakeTime);

                Object proxyListener = Proxy.newProxyInstance(listenerType.getClassLoader(), new Class[]{listenerType}, handler);
                for (int viewId :
                        viewIds) {
                    View view = rootView.findViewById(viewId);
                    if (view != null) {
                        try {
                            Method method = view.getClass().getMethod(METHOD_NAME_SETONCLICKLISTENER, new Class[]{listenerType});
                            method.setAccessible(true);
                            method.invoke(view, proxyListener);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }
}
