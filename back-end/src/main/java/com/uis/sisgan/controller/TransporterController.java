package com.uis.sisgan.controller;

import com.uis.sisgan.persistence.entity.InternalMovementGuide;
import com.uis.sisgan.persistence.entity.Transporter;
import com.uis.sisgan.security.JWTUtils;
import com.uis.sisgan.service.InternalMovementGuideService;
import com.uis.sisgan.service.TransporterService;
import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Anderson Acuña
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/transporter")
public class TransporterController {
    
    @Autowired
    private TransporterService transporterService;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private InternalMovementGuideService internalMovementGuideService;
    
    @GetMapping()
    public ResponseEntity<Transporter> getInfo(Principal principal) {
        Transporter transporter = transporterService.findByEmail(principal.getName());
        
        if (transporter == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transporter);
        }
    }

    @GetMapping("/movements")
    public ResponseEntity<?> getMovementsByEmail(@RequestHeader("Authorization") String authorizationHeader){
        String email = jwtUtils.extractEmailFromToken(authorizationHeader);

        ArrayList<InternalMovementGuide> guides = null;
        ResponseEntity<List<InternalMovementGuide>> response;

        try {
            guides = new ArrayList<>(internalMovementGuideService.getAllByTransporter(email));
            response = ResponseEntity.ok(guides);
        } catch (UserPrincipalNotFoundException upnfEx) {
            response = ResponseEntity.badRequest().build();
        }

        return response;
    }
    
    @PostMapping()
    public ResponseEntity<Transporter> register(@RequestBody Transporter transporter, UriComponentsBuilder ucb) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPss = encoder.encode(transporter.getPassword());
        transporter.setPassword(encodedPss);
        Transporter savedTransporter = transporterService.save(transporter);
        
        URI location = ucb
            .path("transporter/" + savedTransporter.getId())
            .buildAndExpand(savedTransporter.getId())
            .toUri();
        
        ResponseEntity<Transporter> res = ResponseEntity.created(location).body(savedTransporter);
        return res;
    }
}