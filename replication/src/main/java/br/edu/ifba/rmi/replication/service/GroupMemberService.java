package br.edu.ifba.rmi.replication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class GroupMemberService {

    private static final Logger logger = LoggerFactory.getLogger(GroupMemberService.class);

    private final JdbcTemplate jdbcTemplate;

    // Injeção de dependência via construtor
    public GroupMemberService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Listener para receber comandos SQL da fila RabbitMQ.
     *
     * @param sql Comando SQL recebido.
     */
    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveSQLCommand(String sql) {
        logger.info("Received SQL command: {}", sql);
        executeSQL(sql);
    }

    /**
     * Executa o comando SQL recebido.
     *
     * @param sql Comando SQL a ser executado.
     */
    public void executeSQL(String sql) {
        try {
            jdbcTemplate.execute(sql);
            logger.info("Successfully executed SQL command: {}", sql);
        } catch (Exception e) {
            logger.error("Failed to execute SQL command: {}", sql, e);
        }
    }
}