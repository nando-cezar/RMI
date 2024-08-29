package br.edu.ifba.rmi.consumer2.repository;


import br.edu.ifba.rmi.consumer2.model.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<InformationEntity, Long> {}
