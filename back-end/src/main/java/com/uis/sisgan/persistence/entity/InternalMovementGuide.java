package com.uis.sisgan.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "INTERNAL_MOVEMENT_GUIDES")
public class InternalMovementGuide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user_transporter", updatable = false)
    private Transporter transporter;

    @Column(name ="vehicle_plate", length = 10)
    private String vehiclePlate;

    @Column(name = "origin", length = 100)
    private String origin;

    @Column(name = "destination", length = 100)
    private String destination;

    @Column(name = "signature_petitioner", length = 100)
    private String signaturePetitioner;

    @Column(name = "application_date")
    private LocalDate applicationDate;

    @Column(name = "movement_date")
    private LocalDate movementDate;

    @Column(name = "signature_ica_official", length = 100)
    private String signatureIcaOfficial;

    @OneToMany(mappedBy = "internalMovementGuide")
    private List<Lot> lots;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Transporter getTransporter() {
        return transporter;
    }

    public void setTransporter(Transporter transporter) {
        this.transporter = transporter;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSignaturePetitioner() {
        return signaturePetitioner;
    }

    public void setSignaturePetitioner(String signaturePetitioner) {
        this.signaturePetitioner = signaturePetitioner;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public LocalDate getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(LocalDate movementDate) {
        this.movementDate = movementDate;
    }

    public String getSignatureIcaOfficial() {
        return signatureIcaOfficial;
    }

    public void setSignatureIcaOfficial(String signatureIcaOfficial) {
        this.signatureIcaOfficial = signatureIcaOfficial;
    }

    public List<Lot> getLots() {
        return lots;
    }

    public void setLots(List<Lot> lots) {
        this.lots = lots;
    }


}