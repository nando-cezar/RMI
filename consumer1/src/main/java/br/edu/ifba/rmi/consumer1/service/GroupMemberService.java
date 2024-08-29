package br.edu.ifba.rmi.consumer1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class GroupMemberService {

    private static final Logger logger = LoggerFactory.getLogger(GroupMemberService.class);
    private final JdbcTemplate jdbcTemplate;

    public GroupMemberService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RabbitListener(queues = "sql_commands_queue_1")
    public void receiveSQLCommandFromQueue(String sql) {
        logger.info("Received SQL command from queue 1: {}", sql);
        executeSQL(sql);
    }

    public void executeSQL(String sql) {
        try {
            //jdbcTemplate.execute(sql);
            logger.info("Successfully executed SQL command: {}", sql);
        } catch (Exception e) {
            logger.error("Failed to execute SQL command: {}", sql, e);
        }
    }
}