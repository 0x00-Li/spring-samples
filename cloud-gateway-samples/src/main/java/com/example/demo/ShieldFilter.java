package com.example.demo;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
//@Component
public class ShieldFilter implements GlobalFilter, Ordered {
    public ShieldFilter(){
        System.out.println("start shield");
    }
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Shield Filter");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -2;
    }
}
