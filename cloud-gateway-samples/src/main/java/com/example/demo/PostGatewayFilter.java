package com.example.demo;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
//@Component
public class PostGatewayFilter extends AbstractGatewayFilterFactory<PostGatewayFilter.PostGatewayConfig> {

    @Override
    public GatewayFilter apply(PostGatewayConfig config) {
        return (exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(()->{
            System.out.println("Post Gateway Config...");
            ServerHttpResponse resp=exchange.getResponse();
            System.out.println(resp);

        }));
    }

    public static class PostGatewayConfig{}
}
