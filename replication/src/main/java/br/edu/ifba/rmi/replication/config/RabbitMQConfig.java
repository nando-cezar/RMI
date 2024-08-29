package br.edu.ifba.rmi.replication.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(exchangeName);
    }

    private final RabbitMQCustomProperties rabbitMQCustomProperties;

    public RabbitMQConfig(RabbitMQCustomProperties rabbitMQCustomProperties) {
        this.rabbitMQCustomProperties = rabbitMQCustomProperties;
    }

    @Bean
    public Queue queue1() {
        return new Queue(rabbitMQCustomProperties.getQueues().get(0), false);
    }

    @Bean
    public Queue queue2() {
        return new Queue(rabbitMQCustomProperties.getQueues().get(1), false);
    }

    @Bean
    public Binding binding1(FanoutExchange fanoutExchange, Queue queue1) {
        return BindingBuilder.bind(queue1).to(fanoutExchange);
    }

    // Faz o binding da fila2 ao Fanout Exchange
    @Bean
    public Binding binding2(FanoutExchange fanoutExchange, Queue queue2) {
        return BindingBuilder.bind(queue2).to(fanoutExchange);
    }

}