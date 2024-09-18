package com.uis.sisgan.persistence;

import com.uis.sisgan.persistence.crud.UserCrudRepository;
import com.uis.sisgan.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public Optional<User> findByEmail(String email) {
        return userCrudRepository.findByEmail(email);
    }

    /**
     * Encuentra un usuario por su correo electrónico y contraseña.
     *
     * @param email    El correo electrónico del usuario a encontrar.
     * @param password La contraseña del usuario a encontrar.
     * @return Un opcional que contiene la entidad de User si se encuentra, o
     *         vacío si no se encuentra.
     */
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    /**
     * Guarda un usuario en BD.
     * 
     * @param user Usuario a guardar en BD.
     * @return La entidad usuario que se guardo en BD.
     */
    public User save(User user) {
        return userCrudRepository.save(user);
    }
}
