package com.uis.sisgan.persistence.crud;

import java.util.Optional;
import com.uis.sisgan.persistence.entity.Transporter;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Anderson Acuña.
 */
public interface TransporterCrudRepository extends CrudRepository<Transporter, Integer>{
    
    Optional<Transporter> findByEmail(String email);
}
