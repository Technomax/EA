import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

import java.util.Date;

@Aspect
public class TraceAdvice {
//    //  Solution 1;
//    @After("execution(* EmailSender.sendEmail(..))")
//    public void solution1(JoinPoint joinPoint) {
//        Date localTime = new Date();
//        System.out.println(localTime + " method=" + joinPoint.getSignature().getName());
//    }
//
//    //  Solution 2;
//    @After("execution(* EmailSender.sendEmail(..)) && args(email,message)")
//    public void solution2(JoinPoint joinPoint, String email, String message) {
//        Date localTime = new Date();
//        System.out.println(localTime + " method=" + joinPoint.getSignature().getName() + " address=" + email);
//        System.out.println("message=" + message);
//    }
//
    //  Solution 3;
    @After("execution(* EmailSender.sendEmail(..)) && args(email,message)")
    public void solution3(JoinPoint joinPoint, String email, String message) {
        Date localTime = new Date();
        System.out.println(localTime + " method=" + joinPoint.getSignature().getName() + " address=" + email);
        System.out.println("message=" + message);
        System.out.println("outgoing mail server=" + ((IEmailSender) joinPoint.getTarget()).getOutgoingMailServer());
    }

    //  Solution 4;
    @Around("execution(* CustomerDAO.save(..))")
    public Object invoke(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        System.out.println("Time to execute save = " + totaltime);
        return retVal;
    }
}
