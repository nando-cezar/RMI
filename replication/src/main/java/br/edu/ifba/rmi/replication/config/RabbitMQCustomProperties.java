package br.edu.ifba.rmi.replication.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "custom.rabbitmq")
public class RabbitMQCustomProperties {
    private List<String> queues;
}
