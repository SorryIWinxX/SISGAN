package com.uis.sisgan.service;

import java.util.Optional;

import com.uis.sisgan.persistence.UserRepository;
import com.uis.sisgan.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    /**
     * Carga un usuario por su nombre de usuario (correo electrónico) y contraseña.
     *
     * @param email El correo electrónico del usuario a cargar.
     * @param password La contraseña del usuario a cargar.
     * @return Optional<User> Un Optional que contiene la entidad de User si se encuentra, o vacío si no se encuentra.
     */
    public Optional<User> loadUserByUserName(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    
    /**
     * Gestiona el registro de nuevos usuarios.
     * 
     * @param user Usuario nuevo a guardar.
     * @return El usuario que se guardó.
     */
    public User save(User user) {
        return userRepository.save(user);
    }
}
