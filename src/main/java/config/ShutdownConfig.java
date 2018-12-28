package config;

import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shiraz on 28/12/2018.
 */
@Configuration
public class ShutdownConfig {

    private ServiceRegistry registry;

    public ShutdownConfig(ServiceRegistry registry) {
        this.registry = registry;
        System.out.println("registry = " + registry);
    }

    @Bean
    public TerminateBean getTerminateBean() {
        return new TerminateBean(registry);
    }
}