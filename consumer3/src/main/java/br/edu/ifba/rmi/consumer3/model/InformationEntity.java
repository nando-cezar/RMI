package br.edu.ifba.rmi.consumer3.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "information")
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
