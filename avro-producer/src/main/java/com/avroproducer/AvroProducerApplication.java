package com.avroproducer;

import com.avroproducer.config.BrokerTrustStoreConfig;
import com.avroproducer.config.KerberosServiceConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({BrokerTrustStoreConfig.class, KerberosServiceConfig.class})
@Slf4j
public class AvroProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvroProducerApplication.class, args);
	}


}
