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

    @Around("execution(* com.codekul.SpringAspectDemo.controller.StudentController.updateStudent(..)) && args(.., city)")
    public Object logAround(ProceedingJoinPoint jp,String city) throws Throwable {
        System.out.println("@Before"+city);
        Object obj= jp.proceed();
        System.out.println("@After"+city);
        return  obj;
    }


    @Around("execution(* com.codekul.SpringAspectDemo.controller.StudentController.getStudent(..)) && args(.., name)")
    public Object useArgs(ProceedingJoinPoint pjp, String name) throws Throwable{
        System.out.println("Around:"+pjp.getArgs().toString());
        System.out.println("Name : "+name);
        return pjp.proceed();
    }

    @AfterReturning(pointcut = "execution(* com.codekul.SpringAspectDemo.controller.StudentController.getStudent(..))",returning = "val")
    public void logAfterReturn(Student val)
    {
//            Log.getLog("@After","Student Added ",true);
        System.out.println("Method Return : "+val);
        System.out.println("@AfterReturning:"+LocalDate.now());
    }
}
