package br.edu.ifba.rmi.replication;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ReplicationApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReplicationApplication.class, args);
	}
}
