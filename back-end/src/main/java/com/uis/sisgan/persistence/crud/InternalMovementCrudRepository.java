package com.uis.sisgan.persistence.crud;

import java.util.List;

import com.uis.sisgan.persistence.entity.Transporter;
import com.uis.sisgan.persistence.entity.InternalMovementGuide;
import org.springframework.data.repository.CrudRepository;

public interface InternalMovementCrudRepository extends CrudRepository<InternalMovementGuide,Integer> {

    List<InternalMovementGuide> findByTransporter(Transporter transporter);
}
