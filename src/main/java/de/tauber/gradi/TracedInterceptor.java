package de.tauber.gradi;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

/**
 * Implements tracing of classes and methods
 * 
 * @author atauber
 *
 */
@Interceptor @Traced
public class TracedInterceptor {
    
	@Inject
	private static Logger logger;
	
	@AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext)
            throws Exception {
        
		logger.info("Entering method: "
                + invocationContext.getMethod().getName() + " in class "
                + invocationContext.getMethod().getDeclaringClass().getName());
		
        return invocationContext.proceed();
    }
}
