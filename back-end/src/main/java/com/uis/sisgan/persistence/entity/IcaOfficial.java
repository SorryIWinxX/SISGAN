package com.uis.sisgan.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Un funcionario del Instituto Colombiano Agropecuario (ICA) es un actor que 
 * permite autorizar diferentes procesos en el ICA por parte de los propietarios 
 * de ganado.
 *
 * @author Anderson Acuña (GitHub: ThesplumCoder).
 */
@Entity
@DiscriminatorValue("IcaOfficial")
public class IcaOfficial extends User {
    
    @Column(name = "id_card_ica")
    private Integer idCardIca;
    
    /**
     * Retorna el identificador que le da el ICA al funcionario.
     * 
     * @return Número que identifica cada funcionario del ICA.
     */
    public Integer getIdCardIca() {
        return idCardIca;
    }
    
    /**
     * Cambia el identificador del ICA para el funcionario. Si el valor 
     * suministrado es nulo o menor a cero, no se asigna.
     * 
     * @param idCardIca Número que identifica al funcionario del ICA.
     */
    public void setIdCardIca(Integer idCardIca) {
        if (idCardIca != null && idCardIca > 0) {
            this.idCardIca = idCardIca;
        }
    }
}
