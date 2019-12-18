package ai.demo.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author yu
 * @date 2019/12/5 0005
 */
@Component
@Aspect
public class WebControllerAOP {
    @Pointcut("execution(* ai.demo.AOP..*.*(..))")
    public  void executeService(){

    }
    @Before("execution(* ai.demo.AOP..*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        System.out.println(("URL : " + request.getRequestURL().toString()));
        System.out.println(("HTTP_METHOD : " + request.getMethod()));
        System.out.println(("IP : " + request.getRemoteAddr()));
        System.out.println(("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()));
        System.out.println(("ARGS : " + Arrays.toString(joinPoint.getArgs())));
    }
    //通过args可以获取到目标对象里的参数
    @Around("executeService()&&" + "args(id,name)")
    public Object around(ProceedingJoinPoint joinPoint,String id,String name) throws Throwable {
        // 接收到请求，记录请求内容
        System.out.println("方法之前。。。");
        Object proceed = joinPoint.proceed();
        System.out.println(id);
        System.out.println("方法之后。。。");
        return proceed;
    }
}
