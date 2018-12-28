package rest;

import config.MyApiConfig;
import config.ShutdownConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
@EnableAutoConfiguration
@EnableMapRepositories("repository")
@Import({MyApiConfig.class, ShutdownConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Application ready.");
    }

}