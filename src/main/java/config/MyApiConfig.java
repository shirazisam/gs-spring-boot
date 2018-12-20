package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.map.repository.config.EnableMapRepositories;

// @EnableMapRepositories("repository")
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
