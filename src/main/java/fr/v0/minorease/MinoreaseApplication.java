package fr.v0.minorease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("fr.v0.minorease.entity")
@EnableJpaRepositories("fr.v0.minorease.repository")
public class MinoreaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinoreaseApplication.class, args);
    }

}
