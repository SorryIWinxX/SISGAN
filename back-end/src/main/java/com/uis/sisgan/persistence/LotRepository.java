package com.uis.sisgan.persistence;

import com.uis.sisgan.persistence.crud.LotCrudRepository;
import com.uis.sisgan.persistence.entity.Lot;
import com.uis.sisgan.persistence.entity.Propietary;
import com.uis.sisgan.service.LotService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// This class represents a repository for Lot entities.
@Repository
public class LotRepository {

    // Repositorio CRUD utilizado para acceder y gestionar entidades de Lot
    @Autowired
    private LotCrudRepository lotCrudRepository;

    /**
     * Recupera todas las entidades de Lot.
     *
     * @return List<Lot> Una lista de todas las entidades de Lot.
     */
    public List<Lot> getAll() {
        return (List<Lot>) lotCrudRepository.findAll();
    }



    /**
     * Recupera una entidad de Lot por su ID.
     *
     * @param lotId El ID de la entidad de Lot a recuperar.
     * @return Optional<Lot> Un Optional que contiene la entidad de Lot si se encuentra, o vacío si no se encuentra.
     */
    public Optional<Lot> getLot(int lotId) {
        return lotCrudRepository.findById(lotId);
    }

    /**
     * Guarda una entidad de Lot en el repositorio.
     *
     * @param lot La entidad de Lot a guardar.
     * @return Lot La entidad de Lot guardada.
     */
    public Lot save(Lot lot) {
        return lotCrudRepository.save(lot);
    }

    /**
     * Elimina una entidad de Lot por su ID.
     *
     * @param lotId El ID de la entidad de Lot a eliminar.
     */
    public void delete(int lotId) {
        lotCrudRepository.deleteById(lotId);
    }

    public Optional<List<Lot>> getByUserId(Integer userId){
        return lotCrudRepository.findByUserId(userId);
    }

    public Optional<List<Lot>> getByPropietary(Propietary propietary){
        return lotCrudRepository.findByPropietary(propietary);
    }

}