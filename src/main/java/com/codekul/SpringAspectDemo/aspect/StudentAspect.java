package com.codekul.SpringAspectDemo.aspect;

import com.codekul.SpringAspectDemo.domain.Student;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Created by pooja on 12/12/17.
 */
@Component
@Aspect
public class StudentAspect {



      @AfterThrowing(pointcut = "execution(* com.codekul.SpringAspectDemo.controller.StudentController.div(..))",throwing = "exception")
      public void afterthrowing(Exception exception){
          System.out.println("After Returning : "+LocalDate.now());
          System.out.println("Exception : "+exception.getMessage());

      }


//    @Around("execution(* com.codekul.SpringAspectDemo.controller.StudentController.updateStudent(..))")
//    public void logAround(ProceedingJoinPoint jp) throws Throwable {
//        System.out.println("@Before Update: ");
////        System.out.println(jp.getArgs()[0]);
//        Object[] objArg=jp.getArgs();
//        for (Object obj:objArg){
//            System.out.println(obj.toString());
//        }
//        jp.proceed();
//        System.out.println("@After Update : ");
//        Object objTrg= jp.getTarget();
//        System.out.println(objTrg.toString());
//    }

//    @After("execution(* com.codekul.SpringAspectDemo.controller.StudentController.getList(..))")
//    public void logAfter(JoinPoint jp)
//    {
//        System.out.println("@Get List : "+jp.getArgs().toString());
//        Object args=jp.getTarget();
//        Student student= (Student) args;
//
//        System.out.println("Id : "+student.getId().toString());
//        System.out.println("Name : "+student.getName().toString());
////        for (Object obj:args) {
////            System.out.println(args.toString());
////        }
//    }



    @Around("execution(* com.codekul.SpringAspectDemo.controller.StudentController.getStudent(..)) && args(.., name)")
    public Object useArgs1(ProceedingJoinPoint pjp, String name) throws Throwable{
        System.out.println("Around : exp With args WAY2 : using args()");
        System.out.println("Name : "+name);
        return pjp.proceed();
    }

    @After("execution(* com.codekul.SpringAspectDemo.controller.StudentController.getStudent(..))")
    public void useArgs(JoinPoint jp) {
        System.out.println("Around : exp With args WAY1 : using JP");
        Object obj = jp.getTarget();
//        for (Object ob : obj) {
            System.out.println(obj.toString());
//        }

    }
    @AfterReturning(pointcut = "execution(* com.codekul.SpringAspectDemo.controller.StudentController.getStudent(..))",returning = "val")
    public void logAfterReturn(Student val)
    {
        System.out.println("AfterReturning: "+val);
//        System.out.println("@AfterReturning : "+LocalDate.now());
    }



    @After("execution(* com.codekul.SpringAspectDemo.controller.StudentController+.*(..))")
    public void logAfter()
    {
        System.out.println("@After : "+LocalDate.now());
    }

    @Before(" execution(* com.codekul.SpringAspectDemo.controller.*.*(..))")
    public void logBefore()
    {
        System.out.println("@Before : "+ LocalDate.now());
    }


}
