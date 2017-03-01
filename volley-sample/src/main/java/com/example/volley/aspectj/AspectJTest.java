package com.example.volley.aspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 代码来源 http://blog.csdn.net/eclipsexys/article/details/54425414
 * Created by xiongcen on 17/2
 * <p>
 * Pointcut{
 * execution（Before）
 * Pointcut Method
 * execution（After）
 * }
 */
@Aspect
public class AspectJTest {

    private static final String TAG = "AspectJTest";

    // 使用@Before注解来定义一个AspectJ文件，
    // 编译器在编译的时候，就会自动去解析，并不需要主动去调用AspectJ类里面的代码。

    /**
     * @param joinPoint
     * @Before：Advice，也就是具体的插入点 execution：处理Join Point的类型，例如call、execution
     * (* android.app.Activity.on**(..))：这个是最重要的表达式，第一个『*』表示返回值，『*』表示返回值为任意类型，
     * 后面这个就是典型的包名路径，其中可以包含『*』来进行通配，几个『*』没区别。
     * 同时，这里可以通过『&&、||、!』来进行条件组合。()代表这个方法的参数，你可以指定类型，例如android.os.Bundle，或者(..)这样来代表任意类型、任意个数的参数。
     * public void onActivityMethodBefore：实际切入的代码。
     */
    @Before("execution(* com.example.volley.aspectj.AspectJTestActivity.on*(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "onActivityMethodBefore:" + key);
    }

    @After("execution(* com.example.volley.aspectj.AspectJTestActivity.on*(..))")
    public void onActivityMethodAfter(JoinPoint joinPoint) {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "onActivityMethodAfter:" + key);
    }

    @Around("execution(* com.example.volley.aspectj.AspectJTestActivity.testAOP())")
    public void onActivityMethodAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String key = proceedingJoinPoint.getSignature().toString();
        Log.d(TAG, "onActivityMethodAroundFirst: " + key);
        proceedingJoinPoint.proceed();
        Log.d(TAG, "onActivityMethodAroundSecond: " + key);
    }
}
