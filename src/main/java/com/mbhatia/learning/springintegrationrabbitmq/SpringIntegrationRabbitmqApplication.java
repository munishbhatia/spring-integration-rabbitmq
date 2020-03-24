package com.mbhatia.learning.springintegrationrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@ComponentScan(value = {"com.mbhatia.learning.configurations", "com.mbhatia.learning.mediums",
                "com.mbhatia.learning.controllers"})
@IntegrationComponentScan(basePackages = {"com.mbhatia.learning.mediums"})
@EnableIntegration
public class SpringIntegrationRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationRabbitmqApplication.class, args);
    }
}
