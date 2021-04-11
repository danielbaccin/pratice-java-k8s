package com.kenuiworks.pratice.java.k8s.repository;

import com.kenuiworks.pratice.java.k8s.model.Squad;
import org.springframework.data.repository.CrudRepository;

public interface SquadRepository extends CrudRepository<Squad, Long> {
}
