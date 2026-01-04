package de.tauber.gradi;

import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import org.apache.webbeans.annotation.DefaultLiteral;
import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

import java.util.Set;

/**
 * Main Class which bootstraps OWB.
 *
 * @author atauber
 */
public final class Main {

    /**
     * Private construtor.
     */
    private Main() {
    }


    /**
     * Main Method.
     *
     * @param args Start application.
     */
    public static void main(final String[] args) {
        RedirectLogging.configureJavaUtilLogging();
        ContainerLifecycle lifecycle = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);
        System.out.println("Starting application context");
        lifecycle.startApplication(null);
        try {
            BeanManager beanManager = lifecycle.getBeanManager();
            Set<Bean<?>> beans = beanManager.getBeans(MathService.class, DefaultLiteral.INSTANCE);
            System.out.println("Count MathService: " + beans.size());
            if (beans.isEmpty()) {
                System.err.println("No MathService beans found");
                return;
            }
            Bean<?> mathBean = beans.iterator().next();
            MathService mathService = (MathService) beanManager.getReference(mathBean, MathService.class, beanManager.createCreationalContext(mathBean));
            int adding = mathService.adding(3, 5);
            System.out.println("Adding: " + adding);
        } finally {
            lifecycle.stopApplication(null);
        }
    }
}
