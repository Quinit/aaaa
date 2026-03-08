package com.quinit.aaaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

//SpringBoot对SERVLET的支持
@ServletComponentScan
@SpringBootApplication
public class AaaaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AaaaApplication.class, args);
    }

}
