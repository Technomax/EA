import dao.AccountDAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

@Aspect
public class AdviceTracker {
    @After("execution(* dao.*.*(..))")
    public void logMe(JoinPoint joinPoint) {
        java.util.logging.Logger.getLogger("AOP BankLogger").info(joinPoint.getSignature().getName());
    }

    @Around("execution(* service.*.*(..))")
    public Object invoke(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        System.out.println("Method Name:"+call.getSignature().getName()+"::"+"Time to execute save = " + totaltime);
        java.util.logging.Logger.getLogger("AOP BankLogger").info("Time to execute save = " + totaltime);
        return retVal;
    }

    @After("execution(* jms.JMSSender.sendJMSMessage(..)) && args(text)")
    public void logJMS(JoinPoint joinPoint, String text) {
        java.util.logging.Logger.getLogger("JMS Logger").info(joinPoint.getSignature().getName()+" message:"+text);
    }
}
