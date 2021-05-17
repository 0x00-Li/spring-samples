package com.example;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(ProviderApplication.class, args);
    }

    @RestController
    class EchoController implements ApplicationContextAware {
        ApplicationContext ctx;
        @RequestMapping("/")
        public String index(){
            return "ok"+ctx.getEnvironment().getProperty("server.port");
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            ctx=applicationContext;
        }
    }
}
