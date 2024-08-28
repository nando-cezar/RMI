package br.edu.ifba.rmi.replication.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "information") // Nome da tabela em minúsculas e plural
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", length = 255, nullable = false)
    private String value;
}
