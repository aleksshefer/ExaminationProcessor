package ru.shefer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Конфигурация настроек приложения
 */
@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesConfig {
}
