package de.tauber.gradi;


import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

/**
 * Implements tracing of classes and methods.
 *
 * @author atauber
 *
 */
@Interceptor
@Traced
public class TracedInterceptor {

    /**
     * Logger.
     */
    @SuppressWarnings("PMD")
    @Inject
    private Logger logger;

    /**
     * Message for errors when trace.
     */
    private static final String MSG_TRACE_ERROR
            = "Could not proceed after tracing";

    /**
     * Tracing.
     *
     * @param invocationContext context of current invocation
     * @return result of method execution
     */
    @AroundInvoke
    public Object logMethodEntry(final InvocationContext invocationContext) {
        if (logger.isInfoEnabled()) {
            logger.info("Entering method: "
                    + invocationContext.getMethod().getName()
                    + " in class "
                    + invocationContext.getMethod().getDeclaringClass()
                    .getName());
        }
        try {
            return invocationContext.proceed();
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error(MSG_TRACE_ERROR, e);
            }
            throw new RuntimeException(MSG_TRACE_ERROR, e);
        }

    }
}
