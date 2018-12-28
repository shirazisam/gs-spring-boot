package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;

import javax.annotation.PreDestroy;

/**
 * Created by shiraz on 28/12/2018.
 */
public class TerminateBean {

    @Value("${spring.application.name}")
    private String applicationId;

    private ServiceRegistry registry;

    TerminateBean(ServiceRegistry registry) {
        this.registry = registry;
    }

    /**
     * Inform the Eureka registry that the application is terminated, removing the registry entry
     * @throws Exception
     */
    @PreDestroy
    public void onDestroy() throws Exception {
        System.out.println("Spring Container is destroyed! Deregistering application: " + applicationId);
        registry.deregister(() -> applicationId);
    }
}