package com.uis.sisgan.persistence;

import com.uis.sisgan.persistence.entity.Transporter;
import com.uis.sisgan.persistence.crud.TransporterCrudRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anderson Acuña
 */
@Repository
public class TransporterRepository {

    @Autowired
    private TransporterCrudRepository transporterCrudRepository;

    /**
     * Devuelve el transportador según su identificador numérico.
     *
     * @param id Identificador numérico del usuario transportador.
     * @return Si se encuentra un transportador con ese identificador entonces
     *         se retorna un objeto con sus datos, de lo contrario retorna nulo.
     */
    public Transporter findById(Integer id) {
        Optional<Transporter> transporter = transporterCrudRepository.findById(id);
        if (transporter.isPresent()) {
            return transporter.get();
        } else {
            return null;
        }
    }

    /**
     * Devuelve el transportador que tiene el correo electrónico suministrado.
     *
     * @param id Correo electrónico del usuario transportador.
     * @return Si se encuentra un transportador con ese correo entonces se
     *         retorna un objeto con sus datos, de lo contrario retorna nulo.
     */
    public Transporter findByEmail(String email) {
        Optional<Transporter> transporter = transporterCrudRepository.findByEmail(email);

        if (transporter.isPresent()) {
            return transporter.get();
        } else {
            return null;
        }
    }

    /**
     * Guarda o actualiza los datos de un transportador.
     *
     * Si queremos guardar los datos para un nuevo transportador debemos enviar
     * una entidad con el atributo del identificador nulo. Si lo que queremos es
     * actualizar los datos entonces debemos enviar el identificador de un
     * transportador existente.
     *
     * @param transporter Datos del transportador.
     * @return Si la operación es exitosa, se devuelven los datos que se
     *         guardaron en la BD sobre ese transportador. Si algo falla
     *         entonces se retornará nulo.
     */
    public Transporter save(Transporter transporter) {
        Transporter saved = null;

        try {
            saved = transporterCrudRepository.save(transporter);
        } catch (IllegalArgumentException iaEx) {
            Logger.getLogger(TransporterRepository.class.getName()).log(Level.SEVERE, "The entity has null.", iaEx);
        } catch (OptimisticLockingFailureException olfEx) {
            Logger.getLogger(TransporterRepository.class.getName()).log(Level.SEVERE, "The entity for update doesn't exist.", olfEx);
        }

        return saved;
    }
}
