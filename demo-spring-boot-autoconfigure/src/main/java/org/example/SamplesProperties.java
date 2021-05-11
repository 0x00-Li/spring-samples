package org.example;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(value = "org.example")
public class SamplesProperties {
    private String name;
    private String ip;
}
