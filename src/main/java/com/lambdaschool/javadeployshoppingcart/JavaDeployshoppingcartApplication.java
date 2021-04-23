package com.lambdaschool.javadeployshoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
//@PropertySource(value = "file:/Users/jacks/desktop/lambdaProjects/unit4/w3d4/java-deployejavadeployshoppingcart/")
public class JavaDeployshoppingcartApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaDeployshoppingcartApplication.class, args);
    }

}
