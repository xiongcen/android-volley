package com.example.volley.inject;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiongcen on 17/2/24.
 */

public class ProxyInvocationHandler implements InvocationHandler {

    private Map<String, Method> methodMap = new HashMap<>();
    private WeakReference<Object> target;
    private long invokeTime = -1;
    private long shakeTime = 800;

    public ProxyInvocationHandler(@NonNull Object target) {
        this.target = new WeakReference<Object>(target);
    }

    public void addHandleMethod(String proxyMethodName, Method proxyMethod) {
        methodMap.put(proxyMethodName, proxyMethod);
    }

    /**
     * 设置防抖动时间，单位为毫秒
     *
     * @param shakeTime
     */
    public void setShakeTime(long shakeTime) {
        this.shakeTime = shakeTime;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String proxyMethodName = method.getName();
        if (proxyMethodName.equals("onClick")) {
            Method proxyMethod = methodMap.get(proxyMethodName);
            if (proxyMethod != null && target != null) {
                proxyMethod.setAccessible(true);

                if (invokeTime > 0 && System.currentTimeMillis() - invokeTime < shakeTime) {
                    return null;
                }
                invokeTime = System.currentTimeMillis();
            }
            return target != null && proxyMethod != null ? proxyMethod.invoke(target.get(), args) : null;
        } else {
            return proxy != null ? method.invoke(proxy, args) : null;
        }
    }
}
