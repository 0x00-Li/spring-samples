package com.example.demo;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoGatewayFilter implements GatewayFilterFactory<DemoGatewayFilter.Config> {

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {
            System.out.println("demo");
            return chain.filter(exchange);
        };
    }

    public static class Config{
        private boolean t;

        public boolean isT() {
            return t;
        }

        public void setT(boolean t) {
            this.t = t;
        }
    }
}
