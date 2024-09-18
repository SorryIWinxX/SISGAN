package com.uis.sisgan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Este controlador expone URIs para conocer si el servidor en general está 
 * funcionando.
 * 
 * Su propósito final es poder establecer los modulos funcionando del sistema, 
 * más no realizar operaciones que alteren su estado.
 *
 * @author Anderson Acuña
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/health")
public class HealthChecker {
    
    @GetMapping(path = "/say-hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from server.");
    }
}
