package br.edu.ifba.rmi.replication.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Externalizando o nome da fila
    @Value("${rabbitmq.queue.name}")
    private String queueName;

    /**
     * Define a fila RabbitMQ utilizada para receber comandos SQL.
     *
     * @return uma instância da fila configurada.
     */
    @Bean
    public Queue queue() {
        return new Queue(queueName, false);
    }
}