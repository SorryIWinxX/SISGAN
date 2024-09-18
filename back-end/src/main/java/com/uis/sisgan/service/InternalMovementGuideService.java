package com.uis.sisgan.service;

import com.uis.sisgan.persistence.InternalMovementGuideRepository;
import com.uis.sisgan.persistence.TransporterRepository;
import com.uis.sisgan.persistence.entity.InternalMovementGuide;
import com.uis.sisgan.persistence.entity.Lot;
import com.uis.sisgan.persistence.entity.Transporter;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternalMovementGuideService {

    @Autowired
    private TransporterRepository transporterRepository;

    @Autowired
    private InternalMovementGuideRepository internalMovementGuideRepository;

    /**
     * Recupera todas las guías de movimiento interno que tiene un usuario.
     *
     * @return {@link List} Una lista de todas las guías de movimiento interno.
     */
    public List<InternalMovementGuide> getAllByTransporter(String email) throws UserPrincipalNotFoundException {
        Transporter transporter = transporterRepository.findByEmail(email);

        if (transporter == null) {
            throw new UserPrincipalNotFoundException(email);
        }

        List<InternalMovementGuide> guides = transporter.getInternalMovementGuides();
        return guides;
    }

    /**
     * Busca una guía de movimiento interno según su identificador.
     *
     * @param id Identificador de la guía de movimiento interno.
     * @return Si se encuentra una guía con ese identificador, se retornarán sus
     *         datos; de lo contrario, se retornará nulo.
     */
    public InternalMovementGuide findById(Integer id) {
        Optional<InternalMovementGuide> guide;

        guide = internalMovementGuideRepository.getInternalMovementGuideById(id);
        if (guide.isPresent()) {
            return guide.get();
        }
        return null;
    }

    public List<InternalMovementGuide> getAll(){
        return (List<InternalMovementGuide>) internalMovementGuideRepository.getAll();
    }

    /**
     * Guarda una guía de movimiento interno en el repositorio.
     *
     * @param internalMovementGuide La guía de movimiento interno a guardar.
     * @return La guía de movimiento interno guardada.
     */
    public InternalMovementGuide save(InternalMovementGuide internalMovementGuide) {
        if (internalMovementGuide.getId() == null) {
            return internalMovementGuideRepository.save(internalMovementGuide);
        }
        return null;
    }

    /**
     * Actualiza una guía de movimiento interno en el repositorio.
     *
     * @param internalMovementGuide La guía de movimiento interno a actualizar
     *                              con los nuevos valores.
     * @return Si es exitoso, retorna la guía de movimiento interno actualizada;
     *         por otro lado, si algo falla retorna nulo.
     */
    public InternalMovementGuide update(InternalMovementGuide internalMovementGuide) {
        if (internalMovementGuide.getId() != null) {
            return internalMovementGuideRepository.save(internalMovementGuide);
        }
        return null;
    }

    /**
     * Elimina todas las guías de movimiento interno que estén en la lista de
     * identificadores objetivo.
     *
     * @param ids Lista de identificadores de las guías de movimiento a
     *            eliminar.
     * @return Si la eliminación tuvo éxito, retorna {@code true}; de lo
     *         contrario, retorna {@code false}.
     */
    public boolean deleteAllById(List<Integer> ids) {
        return internalMovementGuideRepository.deleteAllById(ids);
    }

    public InternalMovementGuide patchMovement(Integer id, InternalMovementGuide internalMovementGuide){
        Optional<InternalMovementGuide> optionalInternalMovementGuide = internalMovementGuideRepository.getInternalMovementGuideById(id);
        if(optionalInternalMovementGuide.isPresent()){
            InternalMovementGuide internalMovementGuideOp = optionalInternalMovementGuide.get();
            PatchUtils.copyNonNullProperties(internalMovementGuide, internalMovementGuideOp);
            return internalMovementGuideRepository.save(internalMovementGuideOp);
        }else {
            throw new RuntimeException("Internal Movement No found");
        }
    }
}