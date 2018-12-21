package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan({
        "service",
        "repository"
})
@Configuration
public class MyApiConfig {

    public MyApiConfig() {
        System.out.println("Configuration initialized.");
    }
}
