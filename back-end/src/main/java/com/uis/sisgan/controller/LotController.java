package com.uis.sisgan.controller;


import com.uis.sisgan.persistence.PropietaryRepository;
import com.uis.sisgan.persistence.entity.Cattle;
import com.uis.sisgan.persistence.entity.Lot;
import com.uis.sisgan.security.JWTUtils;
import com.uis.sisgan.service.CattleService;
import com.uis.sisgan.service.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/lots")
@RestController
public class LotController {

    @Autowired
    private LotService lotService;

    @Autowired
    private JWTUtils jwtUtils;


    @GetMapping()
    public ResponseEntity<List<Lot>> getLotByEmail(@RequestHeader("Authorization") String authorizationHeader){
        String email = jwtUtils.extractEmailFromToken(authorizationHeader);
        return lotService.getLotByEmail(email).map(
                        lots -> new ResponseEntity<>(lots, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @GetMapping("/all")
    public ResponseEntity<List<Lot>> getAll(){

        return new ResponseEntity<>(lotService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Lot> save(@RequestBody Lot lot){
        return new ResponseEntity<>(lotService.save(lot), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer lotId){
        if(lotService.delete(lotId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity patch(@PathVariable("id") Integer id, @RequestBody Lot lot){
        return new ResponseEntity<>(lotService.patchLot(id,lot),HttpStatus.OK);
    }

    private String extractEmailFromAuthorizationHeader(String authorizationHeader) {
        String base64Credentials = authorizationHeader.substring("Basic".length()).trim();
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decodedBytes);
        String[] values = credentials.split(":", 2);
        return values[0]; // This is the email (username)
    }

}
