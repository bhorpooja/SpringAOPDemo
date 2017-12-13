package com.codekul.SpringAspectDemo.aspect;

import com.codekul.SpringAspectDemo.domain.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by pooja on 12/12/17.
 */
@Component
@Aspect
public class StudentAspect {

    @Before(" execution(* com.codekul.SpringAspectDemo.controller.*.*(..))")
    public void logBefore()
    {
        System.out.println("@Before:"+ LocalDate.now());
    }

    @After("execution(* com.codekul.SpringAspectDemo.controller.StudentController+.*(..))")
    public void logAfter()
    {
        System.out.println("@After:"+LocalDate.now());
    }

//    @Around("execution(* com.codekul.SpringAspectDemo.controller.StudentController.getStudent(..)) && args(.., name)")
//    public Object logAround(ProceedingJoinPoint joinPoint,String name) throws Throwable {
//        System.out.println("@Before"+LocalDate.now());
//        Object obj= joinPoint.proceed();
//        System.out.println("@After"+joinPoint.getArgs().toString());
//        return obj;
//    }


    @Around("execution(* com.codekul.SpringAspectDemo.controller.StudentController.getStudent(..)) && args(.., name)")
    public Object useArgs(ProceedingJoinPoint pjp, String name) throws Throwable{
        System.out.println("it works!"+pjp.getArgs().toString());
        return pjp.proceed();
    }

    @AfterReturning("execution(* com.codekul.SpringAspectDemo.controller.StudentController+.*(..))")
    public void logAfterReturn(JoinPoint jp)
    {
//            Log.getLog("@After","Student Added ",true);
        System.out.println("@AfterReturning:"+jp.getTarget().toString());
    }
}