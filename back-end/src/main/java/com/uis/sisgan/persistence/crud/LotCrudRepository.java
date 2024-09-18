package com.uis.sisgan.persistence.crud;

import com.uis.sisgan.persistence.entity.Lot;
import com.uis.sisgan.persistence.entity.Propietary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LotCrudRepository  extends CrudRepository<Lot, Integer> {


    Optional<List<Lot>> findByUserId(Integer userId);
    Optional<List<Lot>> findByPropietary(Propietary propietary);


}
