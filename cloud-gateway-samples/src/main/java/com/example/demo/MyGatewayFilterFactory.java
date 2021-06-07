package com.example.demo;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config> implements Ordered {

    public MyGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("isDo");
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            System.out.println("My Filter ....");
            return chain.filter(exchange);
        };
    }

    @Override
    public int getOrder() {
        return 0;
    }

    public static class Config {
        private boolean isDo;

        public boolean isDo() {
            return isDo;
        }

        public void setDo(boolean aDo) {
            isDo = aDo;
        }
    }
}
