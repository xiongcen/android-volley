package com.example.volley.inject;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xiongcen on 17/2/24.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OnClick {
    int[] value();
    Class listenerType() default View.OnClickListener.class;
    String proxyMethodName() default "onClick";
    long shakeTime() default 0;//View点击的防抖动时间，单位是毫秒

}
