package com.gmSearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by gm on 2017/4/21.
 */
@SpringBootApplication
@EntityScan(basePackages = "com.gmSearch.entity")
public class application {
    public static void main(String[] args) {
        SpringApplication.run(application.class, args);
    }
}
