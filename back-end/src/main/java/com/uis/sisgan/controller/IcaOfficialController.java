package com.uis.sisgan.controller;

import com.uis.sisgan.persistence.InternalMovementGuideRepository;
import com.uis.sisgan.persistence.entity.IcaOfficial;
import com.uis.sisgan.persistence.entity.InternalMovementGuide;
import com.uis.sisgan.persistence.entity.Lot;
import com.uis.sisgan.persistence.entity.Propietary;
import com.uis.sisgan.service.IcaOfficialService;
import java.net.URI;
import java.security.Principal;
import java.util.List;

import com.uis.sisgan.service.InternalMovementGuideService;
import com.uis.sisgan.service.LotService;
import com.uis.sisgan.service.PropietaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/ica-official")
public class IcaOfficialController {
    
    @Autowired
    private IcaOfficialService icaOfficialService;


    @Autowired
    private InternalMovementGuideService internalMovementGuideService;

    @Autowired
    private LotService lotService;

    @Autowired
    private PropietaryService propietaryService;
    
    @GetMapping()
    public ResponseEntity<IcaOfficial> getInfo(Principal principal) {
        IcaOfficial icaOfficial = icaOfficialService.findByEmail(principal.getName());
        
        if (icaOfficial == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(icaOfficial);
        }
    }
    
    @PostMapping()
    public ResponseEntity<IcaOfficial> register(@RequestBody IcaOfficial icaOfficial, UriComponentsBuilder ucb) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPss = encoder.encode(icaOfficial.getPassword());
        icaOfficial.setPassword(encodedPss);
        IcaOfficial savedIcaOfficial = icaOfficialService.save(icaOfficial);
        
        URI location = ucb
            .path("ica-official/" + savedIcaOfficial.getId())
            .buildAndExpand(savedIcaOfficial.getId())
            .toUri();
        
        ResponseEntity<IcaOfficial> res = ResponseEntity.created(location).body(savedIcaOfficial);
        return res;
    }

    @GetMapping("/movements")
    public ResponseEntity<List<InternalMovementGuide>> getAllMovements(){
       return new ResponseEntity<>(internalMovementGuideService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/lots")
    public ResponseEntity<List<Lot>> getAllLots(){
        return new ResponseEntity<>(lotService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/propietaries")
    public ResponseEntity<List<Propietary>> getAllPropietaries(){
        return new ResponseEntity<>(propietaryService.getAll(),HttpStatus.OK);
    }


}