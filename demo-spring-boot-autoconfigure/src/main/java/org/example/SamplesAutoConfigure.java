package org.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = SamplesProperties.class)
public class SamplesAutoConfigure {
    @Bean
    @ConditionalOnMissingBean
    public SamplesService samplesService() {
        SamplesServiceImpl service = new SamplesServiceImpl(samplesProperties.getName(), samplesProperties.getIp());
        return service;
    }

    private final SamplesProperties samplesProperties;

    public SamplesAutoConfigure(SamplesProperties samplesProperties) {
        this.samplesProperties = samplesProperties;
    }
}
