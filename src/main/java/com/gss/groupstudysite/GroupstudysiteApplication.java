package com.gss.groupstudysite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class GroupstudysiteApplication {

    private static final String PROPERTIES = "spring.config.location=" +
            "classpath:/application.yml" +
            ",classpath:/secret.yml";

    public static void main(String[] args) {
        //SpringApplication.run(GroupstudysiteApplication.class, args);
        new SpringApplicationBuilder(GroupstudysiteApplication.class)
                .properties(PROPERTIES)
                .run(args);
    }

}
