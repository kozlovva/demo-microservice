package io.github.kozlovva.os.application;

import io.github.kozlovva.utils.spring.autoregisterer.EnableCleanArcAutoRegisterer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCleanArcAutoRegisterer(basePackages = "io.github.kozlovva.os")
@SpringBootApplication(scanBasePackages = "io.github.kozlovva.os")
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
