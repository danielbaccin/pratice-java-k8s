package com.kenuiworks.pratice.java.k8s.service;

import com.kenuiworks.pratice.java.k8s.model.Squad;
import com.kenuiworks.pratice.java.k8s.repository.SquadRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SquadService {

    private SquadRepository repository;

    @Transactional(propagation = Propagation.REQUIRED)
    public Squad create(Squad squad) {
        return repository.save(squad);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Squad findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Squad not found with id:" + id));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Squad> findAll() {
        List<Squad> squads = new ArrayList<>();
        Iterator<Squad> iterator = repository.findAll().iterator();
        iterator.forEachRemaining(squads::add);
        return squads;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Squad user) {
        repository.delete(user);
    }


}
