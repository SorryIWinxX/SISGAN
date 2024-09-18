package com.uis.sisgan.persistence.crud;

import java.util.Optional;

import com.uis.sisgan.persistence.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User,Integer> {

    Optional<User> findByEmail(String email);
    
    Optional<User> findByEmailAndPassword(String email, String password);

}
