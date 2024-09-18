package com.uis.sisgan.controller;

import java.net.URI;
import com.uis.sisgan.persistence.entity.Propietary;
import com.uis.sisgan.service.PropietaryService;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Anderson Acuña
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/propietary")
public class PropietaryController {
    
    @Autowired
    private PropietaryService propietaryService;
    
    @GetMapping()
    public ResponseEntity<Propietary> getInfo(Principal principal) {
        Propietary propietary = propietaryService.findByEmail(principal.getName());
        
        if (propietary == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(propietary);
        }
    }
    
    @PostMapping()
    public ResponseEntity<Propietary> register(@RequestBody Propietary propietary, UriComponentsBuilder ucb) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPss = encoder.encode(propietary.getPassword());
        propietary.setPassword(encodedPss);
        Propietary savedPropietary = propietaryService.save(propietary);
        
        URI location = ucb
            .path("propietary/" + savedPropietary.getId())
            .buildAndExpand(savedPropietary.getId())
            .toUri();
        
        ResponseEntity<Propietary> res = ResponseEntity.created(location).body(savedPropietary);
        return res;
    }
}
