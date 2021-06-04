package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.InMemoryRouteDefinitionRepository;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


//@Component
public class ApplicationStartup implements ApplicationRunner {

    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("应用启动");
        // 加载路由
//        RouteDefinition definition = new RouteDefinition();
//        definition.setId("aaa");
//        definition.setUri(new URI("http://www.ziroom.com"));
//        List<PredicateDefinition> predicateDefinitions = gatewayDefine.getPredicateDefinition();
//        if (predicateDefinitions != null) {
//            definition.setPredicates(predicateDefinitions);
//        }
//        List<FilterDefinition> filterDefinitions = gatewayDefine.getFilterDefinition();
//        if (filterDefinitions != null) {
//            definition.setFilters(filterDefinitions);
//        }
        //--
//        FilterDefinition filterDefinition = new FilterDefinition();
//        List<FilterDefinition> list=new ArrayList<>();
//        list.add(filterDefinition);
//        definition.setFilters(list);
//
//        routeDefinitionWriter.save(Mono.just(definition)).subscribe();
//
//
//        publisher.publishEvent(new RefreshRoutesEvent(this));
    }
}
