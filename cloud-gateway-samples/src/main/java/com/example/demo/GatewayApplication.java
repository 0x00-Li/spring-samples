package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }


//        @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
//
//
//        return builder.routes()
//                .route("test",
//                        r->r.path("/jd/**")
//                                .filters(f-> f.filters(preGatewayFilter.apply(new PreGatewayFilterFactory.PreFilterConfig())
//
//                                ))
//                                .uri("http://www.jd.com/"))
//
//                .build();
//    }
    @Bean
    @Order(Integer.MIN_VALUE)
    public GlobalFilter a() {
        return (exchange, chain) -> {
            System.out.println("inner global filter");
            return chain.filter(exchange);
        };
    }
}
