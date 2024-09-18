package com.uis.sisgan.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("Transporter")
public class Transporter extends User {

    @Column(name = "id_driving_license")
    private String idDrivingLicense;

    @OneToMany(mappedBy = "transporter")
    @JsonIgnore
    private List<InternalMovementGuide> internalMovementGuides;

    /**
     * Retorna el identificador de la licencia de conducción.
     *
     * @return Número de la tarjeta de conducción.
     */
    public String getIdDrivingLicense() {
        return idDrivingLicense;
    }

    /**
     * Retorna todas las guías de movimiento interno que tiene asignadas el
     * transportador.
     *
     * @return Lista con las guías de movimiento interno.
     */
    public List<InternalMovementGuide> getInternalMovementGuides() {
        return internalMovementGuides;
    }

    /**
     * Cambia el identificador de la licencia de conducción.
     *
     * @param idDrivingLicense Número de la tarjeta de conducción.
     */
    public void setIdDrivingLicense(String idDrivingLicense) {
        this.idDrivingLicense = idDrivingLicense;
    }

    /**
     * Cambia la lista de las guías de movimiento interno que tiene el
     * transportador. Si se pasa nulo no se asigna, pero si se pasa una lista
     * vacía entonces se desasignan las guías que posee en el momento.
     *
     * @param internalMovementGuides Lista con la guías de movimiento interno a
     *                               anexar.
     */
    public void setInternalMovementGuides(List<InternalMovementGuide> internalMovementGuides) {
        if (internalMovementGuides != null) {
            this.internalMovementGuides = internalMovementGuides;
        }
    }
}
