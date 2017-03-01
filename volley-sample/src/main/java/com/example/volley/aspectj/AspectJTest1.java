package com.example.volley.aspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 代码来源 http://blog.csdn.net/eclipsexys/article/details/54425414
 * Created by xiongcen on 17/2
 * <p>
 * Call（Before）
 * Pointcut{
 * Pointcut Method
 * }
 * Call（After）
 */
@Aspect
public class AspectJTest1 {

    private static final String TAG = "AspectJTest";

    // 在testAOP2()方法内
    @Pointcut("withincode(* com.example.volley.aspectj.AspectJTestActivity1.testAOP2(..))")
    public void invokeAOP2() {

    }

    // 在调用testAOP()方法的时候
    @Pointcut("call(* com.example.volley.aspectj.AspectJTestActivity1.testAOP(..))")
    public void invokeAOP() {

    }

    // 同时满足前面的条件，即在testAOP2()方法内调用testAOP()方法的时候才切入
    @Pointcut("invokeAOP() && invokeAOP2()")
    public void invokeAOPOnlyAOP2() {

    }

    @Before("invokeAOPOnlyAOP2()")
    public void beforeInvokeAOPOnlyAOP2(JoinPoint joinPoint) {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "beforeInvokeAOPOnlyAOP2:" + key);
    }
}
