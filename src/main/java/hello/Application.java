package hello;

import config.MyApiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableMapRepositories("repository")
@Import({MyApiConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Application ready.");
    }

}