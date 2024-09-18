package com.uis.sisgan.persistence;

import java.util.List;
import com.uis.sisgan.persistence.entity.Propietary;
import com.uis.sisgan.persistence.crud.PropietaryCrudRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PropietaryRepository {

    @Autowired
    private PropietaryCrudRepository propietaryCrudRepository;
    
    public Optional<Propietary> getById(Integer id) {
        return propietaryCrudRepository.findById(id);
    }

    public List<Propietary> getAll() {
        return (List<Propietary>) propietaryCrudRepository.findAll();
    }
    
    public Optional<Propietary> findByEmail(String email) {
        return propietaryCrudRepository.findByEmail(email);
    }

    public Propietary save(Propietary propietary) {
        return propietaryCrudRepository.save(propietary);
    }

}
