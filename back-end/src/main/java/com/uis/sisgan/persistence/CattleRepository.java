package com.uis.sisgan.persistence;

import com.uis.sisgan.persistence.crud.CattleCrudRepository;
import com.uis.sisgan.persistence.entity.Cattle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CattleRepository {

    @Autowired
    private CattleCrudRepository cattleCrudRepository;

    /**
     * Recupera todas las entidades de Cattle.
     *
     * @return List<Cattle> Una lista de todas las entidades de Cattle.
     */
    public List<Cattle> getAll() {
        return (List<Cattle>) cattleCrudRepository.findAll();
    }

    /**
     * Recupera una entidad de Cattle por su ID.
     *
     * @param cattleId El ID de la entidad de Cattle a recuperar.
     * @return Optional<Cattle> Un Optional que contiene la entidad de Cattle si se encuentra, o vacío si no se encuentra.
     */
    public Optional<Cattle> getCattle(Integer cattleId) {
        return cattleCrudRepository.findById(cattleId);
    }

    public Optional<List<Cattle>> getCattlesByIds(List<Integer> cattlesId) {
        List<Cattle> cattles = (List<Cattle>) cattleCrudRepository.findAllById(cattlesId);
        return cattles.isEmpty() ? Optional.empty() : Optional.of(cattles);
    }

    /**
     * Guarda una entidad de Cattle en el repositorio.
     *
     * @param cattle La entidad de Cattle a guardar.
     * @return Cattle La entidad de Cattle guardada.
     */
    public Cattle save(Cattle cattle) {
        return cattleCrudRepository.save(cattle);
    }

    /**
     * Elimina una entidad de Cattle por su ID.
     *
     * @param cattles El ID de la entidad de Cattle a eliminar.
     */
    public void deleteAll(List<Cattle> cattles) {
        List<Integer> cattlesId = cattles.stream().map(Cattle::getId).collect(Collectors.toList());
        cattleCrudRepository.deleteAllById(cattlesId);
    }

    /**
     * Recupera entidades de Cattle por su peso y raza.
     *
     * @param weight El peso del ganado a recuperar.
     * @param breed La raza del ganado a recuperar.
     * @return Optional<List<Cattle>> Un Optional que contiene una lista de entidades de Cattle que coinciden con el peso y la raza, o vacío si no se encuentra ninguna.
     */
    public Optional<List<Cattle>> getCattleByWeightAndBreed(float weight, String breed) {
        return cattleCrudRepository.findByWeightLessThanAndBreed(weight, breed);
    }


    public Optional<List<Cattle>> findByLotId(Integer lotId){
        return cattleCrudRepository.findByLotId(lotId);
    }
}
