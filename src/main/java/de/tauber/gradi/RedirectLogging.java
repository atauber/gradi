package de.tauber.gradi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Implements redirecting of JUL Logging to SLF4J.
 *
 * @author Andreas Tauber
 */
public final class RedirectLogging {

    /**
     * Private default constructor.
     */
    private RedirectLogging() {
    }

    /**
     * Helper methode for redirecting logs.
     */
    public static void configureJavaUtilLogging() {
        final java.util.logging.Logger rootLogger = java.util.logging.Logger.getLogger("");
        for (final java.util.logging.Handler handler : rootLogger.getHandlers()) {
            handler.setLevel(Level.OFF);
        }
        rootLogger.setLevel(Level.INFO);
        rootLogger.addHandler(new java.util.logging.Handler() {

            @Override
            public void publish(final LogRecord record) {
                final Logger log = LoggerFactory.getLogger(record.getSourceClassName());
                if (record.getLevel() == Level.SEVERE) {
                    if (record.getThrown() == null) {
                        log.error(record.getMessage());
                    } else {
                        log.error(record.getMessage(), record.getThrown());
                    }
                } else if (record.getLevel() == Level.WARNING) {
                    log.warn(record.getMessage());
                } else if (record.getLevel() == Level.INFO) {
                    log.info(record.getMessage());
                } else {
                    log.debug(record.getMessage());
                }
            }

            @Override
            public void flush() {
            }

            @Override
            public void close() throws SecurityException {
            }

        });
    }
}
