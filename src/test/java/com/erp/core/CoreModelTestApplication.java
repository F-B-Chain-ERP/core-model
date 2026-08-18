package com.erp.core;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * Test-only Spring Boot configuration that boots the core-model context so the
 * module can be verified standalone (without a consumer like {@code backend-service}).
 *
 * <p>Located in {@code src/test}, so it is never packaged into the library jar.
 * It enables full auto-configuration (including a datasource + JPA auditing) and
 * component-scans {@code com.erp.core} while deliberately EXCLUDING the production
 * {@link CoreApplication}, whose {@code DataSourceAutoConfiguration} exclusion would
 * otherwise remove the test datasource.</p>
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    basePackages = "com.erp.core",
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = CoreApplication.class)
)
public class CoreModelTestApplication {
}
