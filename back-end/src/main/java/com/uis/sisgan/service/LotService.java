package com.uis.sisgan.service;
import com.uis.sisgan.persistence.LotRepository;
import com.uis.sisgan.persistence.PropietaryRepository;
import com.uis.sisgan.persistence.entity.Cattle;
import com.uis.sisgan.persistence.entity.Lot;
import com.uis.sisgan.persistence.entity.Propietary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LotService {
    // Repositorio utilizado para acceder y gestionar entidades de Lot

    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private PropietaryRepository propietaryRepository;
    /**
     * Recupera todas las entidades de Lot.
     *
     * @return List<Lot> Una lista de todas las entidades de Lot.
     */
    public List<Lot> getAll() {
        return (List<Lot>) lotRepository.getAll();
    }

    /**
     * Recupera una entidad de Lot por su ID.
     *
     * @param lotId El ID de la entidad de Lot a recuperar.
     * @return Optional<Lot> Un Optional que contiene la entidad de Lot si se encuentra, o vacío si no se encuentra.
     */
    public Optional<Lot> getLot(int lotId) {
        return lotRepository.getLot(lotId);
    }

    /**
     * Guarda una entidad de Lot en el repositorio.
     *
     * @param lot La entidad de Lot a guardar.
     * @return Lot La entidad de Lot guardada.
     */
    public Lot save(Lot lot) {
        return lotRepository.save(lot);
    }

    /**
     * Elimina una entidad de Lot por su ID si existe.
     *
     * @param lotId El ID de la entidad de Lot a eliminar.
     * @return boolean true si la entidad de Lot fue encontrada y eliminada, false en caso contrario.
     */
    public boolean delete(int lotId) {
        return getLot(lotId).map(lot -> {
            lotRepository.delete(lotId);
            return true;
        }).orElse(false);
    }

    public Optional<List<Lot>> getByUser(Integer id){
        return lotRepository.getByUserId(id);
    }

    public Optional<List<Lot>> getByPropietary(Integer id){
        return propietaryRepository.getById(id).map(
                propietary -> lotRepository.getByPropietary(propietary))
                .orElse(null);
    }

    public Lot patchLot(Integer id, Lot lot){
        Optional<Lot> optionalLot = lotRepository.getLot(id);
        if(optionalLot.isPresent()){
            Lot lotOp = optionalLot.get();
            PatchUtils.copyNonNullProperties(lot, lotOp);
            return lotRepository.save(lotOp);
        }else {
            throw new RuntimeException("Lot No found");
        }
    }

    public Optional<List<Lot>> getLotByEmail(String email) {
        Optional<Propietary> propietary = propietaryRepository.findByEmail(email);
        if (propietary.isPresent()) {
            return Optional.ofNullable(propietary.get().getLots());
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
