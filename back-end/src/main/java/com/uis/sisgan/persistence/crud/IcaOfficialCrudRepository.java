package com.uis.sisgan.persistence.crud;

import com.uis.sisgan.persistence.entity.IcaOfficial;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface IcaOfficialCrudRepository extends CrudRepository<IcaOfficial, Integer> {
    
    Optional<IcaOfficial> findByEmail(String email);
}