package ai.demo.annotation;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yu
 * @date 2019/12/12 0012
 */
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    double rate();
    long timeout() default 0;
}
