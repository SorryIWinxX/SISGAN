package com.uis.sisgan.service;


import com.uis.sisgan.persistence.entity.IcaOfficial;
import com.uis.sisgan.persistence.entity.Propietary;
import com.uis.sisgan.persistence.entity.Transporter;
import com.uis.sisgan.DTO.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private PropietaryService propietaryService;

    @Autowired
    private IcaOfficialService icaOfficialService;

    @Autowired
    private TransporterService transporterService;


    public Object registerUser(UserRegistrationRequest request) {
        return switch (request.getRole()) {
            case PROPIETARY -> propietaryService.save(createPropietary(request));
            case ICA -> icaOfficialService.save(createIcaOfficial(request));
            case TRANSPORTER -> transporterService.save(createTransporter(request));
            default -> throw new IllegalArgumentException("Invalid user role");
        };
    }

    private Propietary createPropietary(UserRegistrationRequest request) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPss = encoder.encode(request.getPassword());

        Propietary propietary = new Propietary();
        propietary.setEmail(request.getEmail());
        propietary.setPassword(encodedPss);
        propietary.setLastName(request.getLastName());
        propietary.setFirstName(request.getFirstName());
        propietary.setMark(request.getMark());
        propietary.setBirthDate(request.getBirthDate());
        propietary.setIdCard(request.getIdCard());
        propietary.setFarmName(request.getFarmName());
        propietary.setRole(request.getRole());

        return propietary;
    }

    private IcaOfficial createIcaOfficial(UserRegistrationRequest request) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPss = encoder.encode(request.getPassword());


        IcaOfficial icaOfficial = new IcaOfficial();
        icaOfficial.setEmail(request.getEmail());
        icaOfficial.setPassword(encodedPss);
        icaOfficial.setLastName(request.getLastName());
        icaOfficial.setFirstName(request.getFirstName());
        icaOfficial.setIdCardIca(request.getIdCardIca());
        icaOfficial.setBirthDate(request.getBirthDate());
        icaOfficial.setIdCard(request.getIdCard());
        icaOfficial.setRole(request.getRole());
        return icaOfficial;
    }

    private Transporter createTransporter(UserRegistrationRequest request) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPss = encoder.encode(request.getPassword());


        Transporter transporter = new Transporter();
        transporter.setEmail(request.getEmail());
        transporter.setPassword(encodedPss);
        transporter.setLastName(request.getLastName());
        transporter.setFirstName(request.getFirstName());
        transporter.setIdDrivingLicense(request.getIdDrivingLicense());
        transporter.setBirthDate(request.getBirthDate());
        transporter.setIdCard(request.getIdCard());
        transporter.setRole(request.getRole());
        return transporter;
    }
}
