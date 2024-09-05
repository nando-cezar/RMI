package br.edu.ifba.rmi.consumer3.repository;


import br.edu.ifba.rmi.consumer3.model.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<InformationEntity, Long> {}
