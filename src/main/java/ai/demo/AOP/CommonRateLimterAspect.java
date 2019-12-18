package ai.demo.AOP;

import ai.demo.annotation.MyAnnotation;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @author yu
 * @date 2019/12/12 0012
 */
@Component
@Aspect
public class CommonRateLimterAspect {
    @Autowired
    private HttpServletResponse response;

    private RateLimiter rateLimiter=RateLimiter.create(10);

    @Pointcut("execution(public * ai.demo.controller.*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object process(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        MyAnnotation annotation = signature.getMethod().getAnnotation(MyAnnotation.class);
        if (annotation==null){
            return proceedingJoinPoint.proceed();
        }
        double rate = annotation.rate();
        long timeout = annotation.timeout();
        rateLimiter.setRate(rate);
        boolean tryAcquire = rateLimiter.tryAcquire(timeout, TimeUnit.SECONDS);
        if (!tryAcquire) {
            defaultBack();
            return null;
        }
        return proceedingJoinPoint.proceed();
    }

    private void defaultBack() {
        response.setHeader("Content-type","text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print("当前访问人数过多");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           if (out!=null){
               out.close();
           }
        }
    }
}
