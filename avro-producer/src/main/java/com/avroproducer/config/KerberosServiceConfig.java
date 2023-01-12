package com.avroproducer.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.kafka.properties.sasl.kerberos.service")
@Data
@NoArgsConstructor
public class KerberosServiceConfig {

    private String name;

}
