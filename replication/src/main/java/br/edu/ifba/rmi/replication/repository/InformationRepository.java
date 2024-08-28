package br.edu.ifba.rmi.replication.repository;

import br.edu.ifba.rmi.replication.model.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<InformationEntity, Long> {}
