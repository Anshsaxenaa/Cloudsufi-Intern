package com.example.etlproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"config", "controller", "dao", "service", "util"})
public class EtlApplication {
    public static void main(String[] args) {
        SpringApplication.run(EtlApplication.class, args);
    }

}
