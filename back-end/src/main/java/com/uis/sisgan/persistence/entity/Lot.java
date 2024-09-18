package com.uis.sisgan.persistence.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * Un lote es una agrupación de ganado, que pertenece a cierto propietario.
 *
 * @author Anderson Acuña (GitHub: ThesplumCoder).
 */
@Entity
@Table(name = "LOTS")
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_user", nullable = false)
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    @JsonIgnore
    private Propietary propietary;

    @ManyToOne
    @JoinColumn(name = "id_internal_movement_guide")
    @JsonIgnore
    private InternalMovementGuide internalMovementGuide;

    @Column(name = "lot_name", length = 80,  unique = true)
    private String lotName;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "last_modification")
    private LocalDate lastModification;

    @OneToMany(mappedBy = "lot", cascade = {CascadeType.ALL})
    private List<Cattle> cattles;

    /**
     * Retorna el identificador del lote.
     *
     * @return Número que identifica el lote.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Retorna el propietario del lote.
     *
     * @return Instancia de {@link Propietary} que tiene los datos del
     *         propietario.
     */
    public Propietary getPropietary() {
        return propietary;
    }

    /**
     * Retorna la guía de movimiento interna en la que está el lote. Si ninguna
     * guía se refiere al lote entonces devolverá nulo.
     *
     * @return Instancia de {@link InternalMovementGuide} en la que está adjunto
     *         el lote.
     */
    public InternalMovementGuide getInternalMovementGuide() {
        return internalMovementGuide;
    }

    /**
     * Retorna el nombre del lote.
     *
     * @return Texto con el nombre del lote.
     */
    public String getLotName() {
        return lotName;
    }

    /**
     * Retorna la fecha de creación del lote.
     *
     * @return Fecha de creación del lote.
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Retorna la fecha de última modificación del lote.
     *
     * @return Fecha de última modificación.
     */
    public LocalDate getLastModification() {
        return lastModification;
    }

    /**
     * Retorna todo el ganado que está en el lote.
     *
     * @return Una lista con todo el ganado del lote.
     */
    public List<Cattle> getCattles() {
        return cattles;
    }

    /**
     * Cambia el identificador del lote. Si se pasa un nulo no lo asigna.
     *
     * @param id Identificador numérico del lote.
     */
    public void setId(Integer id) {
        if (id != null) {
            this.id = id;
        }
    }

    /**
     * Cambia el propietario de lote, si se pasa nulo no lo asigna.
     *
     * @param propietary Objeto de con los datos del nuevo propietario.
     */
    public void setPropietary(Propietary propietary) {
        if (propietary != null) {
            this.propietary = propietary;
        }
    }

    /**
     * Cambia la guía de movimiento interno en la que aparece el lote. Si se
     * pasa nulo el lote se desvinculará de la guía.
     *
     * @param internalMovementGuide Guía de movimiento interno a la que se
     *                              anexará el lote.
     */
    public void setInternalMovementGuide(InternalMovementGuide internalMovementGuide) {
        this.internalMovementGuide = internalMovementGuide;
    }

    /**
     * Cambia el nombre del lote. Si se pasa un nulo como nombre entonces el
     * campo quedará vacío.
     *
     * @param lotName Nombre del lote.
     */
    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    /**
     * Cambia la fecha de creación del lote. Si se pasa nulo no lo asigna.
     *
     * @param creationDate Fecha de creación de lote.
     */
    public void setCreationDate(LocalDate creationDate) {
        if (creationDate != null) {
            this.creationDate = creationDate;
        }
    }

    /**
     * Cambia la fecha de última modificación del lote. Si se pasa nulo no lo
     * asigna.
     *
     * @param lastModification Fecha de última modificación.
     */
    public void setLastModification(LocalDate lastModification) {
        if (lastModification != null) {
            this.lastModification = lastModification;
        }
    }

    /**
     * Cambia la lista que contiene todo el ganado que está relacionado con el
     * lote.
     *
     * @param cattles Lista con el ganado que pertenece al lote.
     */
    public void setCattles(List<Cattle> cattles) {
        if (cattles != null) {
            this.cattles = cattles;
        }
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
