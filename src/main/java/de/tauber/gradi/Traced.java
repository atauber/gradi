package de.tauber.gradi;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;

/**
 * Annotation which configures tracing on classes and methods
 * 
 * @author atauber
 */
@Inherited
@InterceptorBinding
@Retention(RUNTIME)
@Target({METHOD, TYPE})
public @interface Traced {
}
