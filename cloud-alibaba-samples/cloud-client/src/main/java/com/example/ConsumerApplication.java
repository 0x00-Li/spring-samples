package com.example;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient(autoRegister = true)
@EnableFeignClients
public class ConsumerApplication {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    @Scope(value = "prototype")
    public IRule loadBalanceRule(){
        return new NacosRule();
    }
    @RestController
    class TestController {
        @Autowired
        EchoService echoService;

        @GetMapping("/echo-feign")
        public String feign() {
            return echoService.index();
        }
    }

    @FeignClient(name = "server-samples")
    interface EchoService {
        @GetMapping("/")
        String index();
    }
}
