package br.edu.ifba.rmi.consumer2.service;

import br.edu.ifba.rmi.consumer2.model.InformationEntity;
import br.edu.ifba.rmi.consumer2.repository.InformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class GroupMemberService {

    private static final Logger logger = LoggerFactory.getLogger(GroupMemberService.class);
    private final InformationRepository informationRepository;

    public GroupMemberService(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveSQLCommandFromQueue(String sql) {
        logger.info("Received SQL command from queue 2: {}", sql);

        if (isValidSQL(sql)) {
            executeSQL(sql);
        } else {
            logger.warn("Received invalid SQL command: {}", sql);
        }
    }

    private boolean isValidSQL(String sql) {
        // Add more sophisticated validation as needed
        return StringUtils.hasText(sql);
    }

    @Transactional
    public void executeSQL(String sql) {
        try {
            saveSQLCommand(sql);
            logger.info("Successfully executed SQL command: {}", sql);
        } catch (Exception e) {
            logger.error("Failed to execute SQL command: {}", sql, e);
            // Optionally, you could rethrow the exception or handle it differently
        }
    }

    private void saveSQLCommand(String sql) {
        InformationEntity entity = new InformationEntity();
        entity.setValue(sql);
        informationRepository.save(entity);
    }
}