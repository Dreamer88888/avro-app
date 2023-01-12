package com.avroproducer.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "data.data.spring.kafka.producer.ssl")
@Data
@NoArgsConstructor
public class BrokerTrustStoreConfig {

    private String trustStoreLocation;
    private String trustStorePassword;

}
