package com.uis.sisgan.persistence.crud;

import com.uis.sisgan.persistence.entity.Cattle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CattleCrudRepository extends CrudRepository<Cattle, Integer> {

    /*
        Aqui se Muestra una Busqueda con QueryMehtods para selecionar el ganado
        Que tenga Cierto peso y que Raza es.
     */

    Optional<List<Cattle>> findByWeightLessThanAndBreed(float weight, String breed);

    Optional<List<Cattle>> findByLotId(Integer lotId);


}
