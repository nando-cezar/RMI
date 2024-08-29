package br.edu.ifba.rmi.replication.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RabbitMQCustomProperties.class)
public class AppConfig {}
