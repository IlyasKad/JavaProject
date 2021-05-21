package com.travelset.laba3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.vaadin.artur.helpers.LaunchUtil;


@SpringBootApplication
@EnableJpaRepositories("com.travelset.laba3.model.repository")
@EntityScan("com.travelset.laba3.model.entity")
@ComponentScan(basePackages = {"com.travelset.laba3.services", "com.travelset.laba3.controllers"})
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(WebApplication.class, args));
    }

}
