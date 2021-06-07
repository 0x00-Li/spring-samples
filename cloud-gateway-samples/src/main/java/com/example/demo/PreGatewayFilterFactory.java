package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Component
public class PreGatewayFilterFactory extends AbstractGatewayFilterFactory<PreGatewayFilterFactory.PreFilterConfig> {

    public PreGatewayFilterFactory() {
        super(PreFilterConfig.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("enabled");
    }

    @Override
    public GatewayFilter apply(PreFilterConfig config) {
        return (exchange, chain) -> {
            System.out.println("Pre Gateway Filter...");
            return chain.filter(exchange);
//            ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
//
//            ServerHttpResponse resp = exchange.getResponse();
////            resp.setStatusCode(HttpStatus.UNAUTHORIZED);
//            JSONObject data = new JSONObject();
//            data.put("code", "40000");
//            data.put("msg", "鉴权失败");
//
//
//            byte[] bytes = data.toJSONString().getBytes(StandardCharsets.UTF_8);
//            DataBuffer buffer = resp.bufferFactory().wrap(bytes);
////            resp.writeWith(Mono.just(buffer));
//            resp.getHeaders().set("Content-Type", "application/json");
////            resp.writeAndFlushWith(Mono.just(Mono.just(buffer)));
//            return exchange.getResponse().writeWith(Mono.just(buffer));

//            return chain.filter(exchange.mutate().request(builder.build()).build());
        };
    }

    public static class PreFilterConfig {
        private boolean enabled;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
