package com.uis.sisgan.service;

import com.uis.sisgan.persistence.IcaOfficialRepository;
import com.uis.sisgan.persistence.entity.IcaOfficial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Anderson Acuña
 */
@Service
public class IcaOfficialService {

    @Autowired
    private IcaOfficialRepository icaOfficialRepository;

    /**
     * Retorna los datos del funcionario del ICA, usando su correo electrónico.
     *
     * @param email Correo electrónico del funcionario del ICA.
     * @return Si hay un funcionario relacionado con ese correo, se retornarán
     *         sus datos; en caso contrario, se retorna nulo.
     */
    public IcaOfficial findByEmail(String email) {
        IcaOfficial icaOfficial = null;

        if (email != null) {
            icaOfficial = icaOfficialRepository.findByEmail(email);
        }

        return icaOfficial;
    }

    /**
     * Guarda o actualiza los datos sobre un funcionario.
     *
     * @param icaOfficial Datos del funcionario.
     * @return Si la operación es exitosa se retorna los datos del funcionario,
     *         en caso contrario se retorna nulo.
     */
    public IcaOfficial save(IcaOfficial icaOfficial) {

        return icaOfficialRepository.save(icaOfficial);
    }
}
