package com.travelset.laba3.context;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.travelset.laba3.model.repository")
@EntityScan("com.travelset.laba3.model.entity")
@ComponentScan(basePackages = {"com.travelset.laba3.services", "com.travelset.laba3.controllers"})
public class TestConfig {

}