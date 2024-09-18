package com.uis.sisgan.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("Propietary")
public class Propietary extends User {

    @Column(name = "mark")
    private String mark;

    @Column(name = "farm_name")
    private String farmName;
    
    @OneToMany(mappedBy = "propietary")
    private List<Lot> lots;



    /**
     * Retorna la ruta hacia la imágen que representa la marca.
     *
     * @return Texto con la ruta hacia la imágen de la marca.
     */
    public String getMark() {
        return mark;
    }

    /**
     * Retorna el nombre de la finca, granja o hacienda que haya registrado el
     * propietario del ganado.
     *
     * @return Texto con el nombre de la finca.
     */
    public String getFarmName() {
        return farmName;
    }
    
    /**
     * Retorna todos los lotes de ganado que ha registrado el propietario.
     * 
     * @return Una lista con los lotes registrados.
     */
    public List<Lot> getLots() {
        return lots;
    }

    /**
     * Cambia la ruta hacia la imágen de la marca. Si la ruta ingresada es un
     * nulo entonces no lo asigna.
     *
     * @param mark Ruta del archivo de imágen que representa la marca.
     */
    public void setMark(String mark) {
        if (mark != null) {
            this.mark = mark;
        }
    }

    /**
     * Cambia el nombre de la finca, granja o hacienda que haya registrado el
     * propietario del ganado. Si el nombre pasado es nulo entonces no lo
     * asigna.
     *
     * @param farmName Nombre de la finca.
     */
    public void setFarmName(String farmName) {
        if (farmName != null) {
            this.farmName = farmName;
        }
    }
    
    /**
     * Cambia la lista de lotes que el propietario posee. Si la lista apunta a 
     * nulo entonces no lo asigna.
     * 
     * @param lots Lista con los lotes de ganado.
     */
    public void setLots(List<Lot> lots) {
        if (lots != null) {
            this.lots = lots;
        }
    }
}
