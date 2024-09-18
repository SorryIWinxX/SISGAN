package com.uis.sisgan.persistence;

import java.util.Optional;
import com.uis.sisgan.persistence.crud.IcaOfficialCrudRepository;
import com.uis.sisgan.persistence.entity.IcaOfficial;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Repository;

@Repository
public class IcaOfficialRepository {

    @Autowired
    private IcaOfficialCrudRepository icaOfficialCrudRepository;

    /**
     * Busca un funcionario del ICA por su correo electrónico.
     *
     * @param email Correo electrónico del funcionario del ICA.
     * @return Si se encuentra un funcionario con el correo entonces se retornan
     *         sus datos, de lo contrario retornará nulo.
     */
    public IcaOfficial findByEmail(String email) {
        Optional<IcaOfficial> search = icaOfficialCrudRepository.findByEmail(email);

        if (search.isPresent()) {
            return search.get();
        } else {
            return null;
        }
    }

    /**
     * Guarda o actualiza los datos de un funcionario del ICA.
     *
     * Si queremos guardar los datos para un nuevo funcionario debemos enviar
     * una entidad con el atributo del identificador nulo. Si lo que queremos es
     * actualizar los datos entonces debemos enviar el identificador de un
     * funcionario existente.
     *
     * @param icaOfficial Datos del funcionario.
     * @return Si la operación es exitosa, se devuelven los datos que se
     *         guardaron en la BD sobre ese funcionario. Si algo falla entonces
     *         se retornará nulo.
     */
    public IcaOfficial save(IcaOfficial icaOfficial) {
        IcaOfficial saved = null;

        try {
            saved = icaOfficialCrudRepository.save(icaOfficial);
        } catch (IllegalArgumentException iaEx) {
            Logger.getLogger(IcaOfficialRepository.class.getName()).log(Level.SEVERE, "The entity has null.", iaEx);
        } catch (OptimisticLockingFailureException olfEx) {
            Logger.getLogger(IcaOfficialRepository.class.getName()).log(Level.SEVERE, "The entity for update doesn't exist.", olfEx);
        }

        return saved;
    }
}
