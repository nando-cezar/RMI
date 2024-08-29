package br.edu.ifba.rmi.consumer2;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class Consumer2Application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer2Application.class, args);
    }
}
