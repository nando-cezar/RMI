package br.edu.ifba.rmi.replication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LeaderService {

    private static final Logger logger = LoggerFactory.getLogger(LeaderService.class);

    private final RabbitTemplate rabbitTemplate;
    private final String exchangeName;

    /**
     * Construtor que injeta as dependências necessárias e configura o nome da fila.
     *
     * @param rabbitTemplate Template do RabbitMQ para envio de mensagens.
     * @param exchangeName Nome da fila para envio dos comandos SQL.
     */
    public LeaderService(RabbitTemplate rabbitTemplate,
                         @Value("${rabbitmq.exchange.name}") String exchangeName) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchangeName = exchangeName;
    }

    /**
     * Envia um comando SQL para a fila configurada no RabbitMQ.
     *
     * @param sql O comando SQL a ser enviado.
     */
    public void sendSQLCommand(String sql) {
        rabbitTemplate.convertAndSend(exchangeName, "", sql);
        logger.info("Sent SQL command to exchangeName {}: {}", exchangeName, sql);
    }
}
