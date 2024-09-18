package com.uis.sisgan.persistence;

import com.uis.sisgan.persistence.crud.InternalMovementCrudRepository;
import com.uis.sisgan.persistence.entity.InternalMovementGuide;
import com.uis.sisgan.persistence.entity.Transporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InternalMovementGuideRepository {

    @Autowired
    private InternalMovementCrudRepository internalMovementCrudRepository;

    /**
     * Recupera todas las entidades de InternalMovementGuide que corresponden a
     * un usuario.
     *
     * @return {@link List} Una lista de todas las entidades de
     *         InternalMovementGuide.
     */
    public List<InternalMovementGuide> getAllByTransporter(Transporter transporter) {
        return internalMovementCrudRepository.findByTransporter(transporter);
    }


    public List<InternalMovementGuide> getAll(){
        return (List<InternalMovementGuide>) internalMovementCrudRepository.findAll();
    }

    /**
     * Recupera una entidad de InternalMovementGuide por su ID.
     *
     * @param internalMovementId El ID de la entidad de InternalMovementGuide a
     *                           recuperar.
     * @return {@link Optional} Un Optional que contiene la entidad de
     *         InternalMovementGuide si se encuentra, o vacío si no se
     *         encuentra.
     */
    public Optional<InternalMovementGuide> getInternalMovementGuideById(int internalMovementId) {
        return internalMovementCrudRepository.findById(internalMovementId);
    }

    /**
     * Guarda una entidad de InternalMovementGuide en el repositorio.
     *

     * @param internalMovementGuide La entidad de InternalMovementGuide a
     *                              guardar.
     * @return La entidad de InternalMovementGuide guardada.
     */
    public InternalMovementGuide save(InternalMovementGuide internalMovementGuide) {
        return internalMovementCrudRepository.save(internalMovementGuide);
    }

    /**
     * Elimina una entidad de InternalMovementGuide por su ID.
     *

     * @param internalMovementId El ID de la entidad de InternalMovementGuide a
     *                           eliminar.
     */
    public void delete(Integer internalMovementId) {
        internalMovementCrudRepository.deleteById(internalMovementId);
    }

    /**
     * Elimina las guías de movimiento interno que correspondan a los
     * identificadores que se pasen en una lista.
     *
     * @param ids Lista con los identificadores de las guías de movimiento a
     *            eliminar.
     * @return Si se eliminaron todos las guías requeridas entonces retorna
     *         {@code true}, de lo contrario retorna {@code false}.
     */
    public boolean deleteAllById(List<Integer> ids) {
        if (ids.isEmpty()) {
            return false;
        }

        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == null) {
                ids.remove(i);
            }
        }

        internalMovementCrudRepository.deleteAllById(ids);
        return true;
    }
}
