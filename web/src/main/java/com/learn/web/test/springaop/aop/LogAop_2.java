package com.learn.web.test.springaop.aop;


import com.learn.web.test.springaop.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.UUID;

@Aspect
@Component
public class LogAop_2 {

    ThreadLocal<Long> time=new ThreadLocal<Long>();
    ThreadLocal<String> tag=new ThreadLocal<String>();

    @Pointcut("@annotation(com.learn.web.test.springaop.annotation.Log)")
    public void log(){
        System.out.println("我是一个切入点");
    }

    /**
     * 在所有标注@Log的地方切入
     * @param joinPoint
     */
    @Before("log()")
    public void beforeExec(JoinPoint joinPoint){

        time.set(System.currentTimeMillis());
        tag.set(UUID.randomUUID().toString());

        info(joinPoint);

        MethodSignature ms=(MethodSignature) joinPoint.getSignature();
        Method method=ms.getMethod();
        System.out.println(method.getAnnotation(Log.class).name()+"标记"+tag.get());
    }

    @After("log()")
    public void afterExec(JoinPoint joinPoint){
        MethodSignature ms=(MethodSignature) joinPoint.getSignature();
        Method method=ms.getMethod();
        System.out.println("标记为"+tag.get()+"的方法"+method.getName()+"运行消耗"+(System.currentTimeMillis()-time.get())+"ms");
    }

//    TODO 为什么在Controller中使用@Around页面报404
//    @Around("log()")
//    public void aroundExec(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("我是Around，来打酱油的");
//        pjp.proceed();
//    }

    private void info(JoinPoint joinPoint){
        System.out.println("--------------------------------------------------");
        System.out.println("King:\t"+joinPoint.getKind());
        System.out.println("Target:\t"+joinPoint.getTarget().toString());
        Object[] os=joinPoint.getArgs();
        System.out.println("Args:");
        for(int i=0;i<os.length;i++){
            System.out.println("\t==>参数["+i+"]:\t"+os[i].toString());
        }
        System.out.println("Signature:\t"+joinPoint.getSignature());
        System.out.println("SourceLocation:\t"+joinPoint.getSourceLocation());
        System.out.println("StaticPart:\t"+joinPoint.getStaticPart());
        System.out.println("--------------------------------------------------");
    }

}