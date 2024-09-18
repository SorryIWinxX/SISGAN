package com.uis.sisgan.service;

import com.uis.sisgan.persistence.entity.Transporter;
import com.uis.sisgan.persistence.TransporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anderson Acuña
 */
@Service
public class TransporterService {

    @Autowired
    private TransporterRepository transporterRepository;

    /**
     * Devuelve un transportador por el identificador.
     *
     * @param id Identificador del transportador objetivo.
     * @return Si se halla una coincidencia se devuelve un objeto con los datos
     *         del transportador, sino se retorna nulo.
     */
    public Transporter findById(Integer id) {
        Transporter res;

        res = transporterRepository.findById(id);
        return res;
    }

    /**
     * Devuelve un transportador por el correo electrónico.
     *
     * @param email Correo electrónico del transportador objetivo.
     * @return Si se halla una coincidencia se devuelve un objeto con los datos
     *         del transportador, sino se retorna nulo.
     */
    public Transporter findByEmail(String email) {
        Transporter res;

        res = transporterRepository.findByEmail(email);
        return res;
    }
    /**
     * Guarda o actualiza los datos sobre un transportador.
     *
     * @param transporter Datos del transportador.
     * @return Si la operación es exitosa se retorna los datos del
     *         transportador, en caso contrario se retorna nulo.
     */
    public Transporter save(Transporter transporter) {
        Transporter saved = transporterRepository.save(transporter);

        return saved;
    }
}
