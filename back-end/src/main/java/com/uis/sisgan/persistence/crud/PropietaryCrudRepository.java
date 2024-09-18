package com.uis.sisgan.persistence.crud;

import java.util.Optional;
import com.uis.sisgan.persistence.entity.Propietary;

import org.springframework.data.repository.CrudRepository;

public interface PropietaryCrudRepository extends CrudRepository<Propietary, Integer> {
    
    Optional<Propietary> findByEmail(String email);
}