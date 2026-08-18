package com.erp.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Entry point of the shared {@code core-model} module.
 *
 * <p>{@link DataSourceAutoConfiguration} is explicitly excluded so this module does
 * NOT bring its own datasource — the consuming service supplies the datasource,
 * dialect and {@code @EntityScan}. The module only provides the data dictionary
 * (entities), shared REST contracts (errors/util/vm) and standard communication.</p>
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableJpaAuditing
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }
}
