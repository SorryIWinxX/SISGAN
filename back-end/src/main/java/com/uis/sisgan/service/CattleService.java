package com.uis.sisgan.service;

import com.uis.sisgan.persistence.CattleRepository;
import com.uis.sisgan.persistence.PropietaryRepository;
import com.uis.sisgan.persistence.entity.Cattle;
import com.uis.sisgan.persistence.entity.Propietary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CattleService {

    // Repositorio utilizado para acceder y gestionar entidades de Cattle
    @Autowired
    private CattleRepository cattleRepository;

    @Autowired
    private PropietaryRepository propietaryRepository;

    /**
     * Recupera todas las entidades de Cattle.
     *
     * @return List<Cattle> Una lista de todas las entidades de Cattle.
     */
    public List<Cattle> getAll() {
        return (List<Cattle>) cattleRepository.getAll();
    }

    /**
     * Recupera una entidad de Cattle por su ID.
     *
     * @param cattleId El ID de la entidad de Cattle a recuperar.
     * @return Optional<Cattle> Un Optional que contiene la entidad de Cattle si se encuentra, o vacío si no se encuentra.
     */
    public Optional<Cattle> getCattle(Integer cattleId) {
        return cattleRepository.getCattle(cattleId);
    }

    public Optional<List<Cattle>> getCattles(List<Integer> cattlesId) {
        return  cattleRepository.getCattlesByIds(cattlesId);
    }

    /**
     * Guarda una entidad de Cattle en el repositorio.
     *
     * @param cattle La entidad de Cattle a guardar.
     * @return Cattle La entidad de Cattle guardada.
     */
    public Cattle save(Cattle cattle) {
        return cattleRepository.save(cattle);
    }

    /**
     * Elimina una entidad de Cattle por su ID si existe.
     *
     * @param cattlesId El ID de la entidad de Cattle a eliminar.
     * @return boolean true si la entidad de Cattle fue encontrada y eliminada, false en caso contrario.
     */
    public boolean deleteAll(List<Integer> cattlesId) {
        return getCattles(cattlesId).map(cattles -> {
            if (cattles.isEmpty()) {
                return false;
            }
            cattleRepository.deleteAll(cattles);
            return true;
        }).orElse(false);
    }

    public Cattle patchCattle(Integer id, Cattle cattle){
        Optional<Cattle> optionalCattle = cattleRepository.getCattle(id);
        if(optionalCattle.isPresent()){
            Cattle cattleOp = optionalCattle.get();
            PatchUtils.copyNonNullProperties(cattle, cattleOp);
            return cattleRepository.save(cattleOp);
        }else {
            throw new RuntimeException("Cattle No found");
        }
    }

    public Optional<List<Cattle>> getCattlesByEmail(String email) {
        Optional<Propietary> user = propietaryRepository.findByEmail(email);
        if (user.isPresent()) {
            return Optional.of(user.get().getLots().stream()
                    .flatMap(lot -> lot.getCattles().stream())
                    .collect(Collectors.toList()));
        } else {
            throw new RuntimeException("User not found");
        }
    }

    /**
     * Recupera entidades de Cattle por su peso y raza.
     *
     * @param weight El peso del ganado a recuperar.
     * @param breed La raza del ganado a recuperar.
     * @return Optional<List<Cattle>> Un Optional que contiene una lista de entidades de Cattle que coinciden con el peso y la raza, o vacío si no se encuentra ninguna.
     */
    public Optional<List<Cattle>> getCattleByWeightAndBreed(float weight, String breed) {
        return cattleRepository.getCattleByWeightAndBreed(weight, breed);
    }

    public Optional<List<Cattle>> findByLotId(Integer lotId){
        return cattleRepository.findByLotId(lotId);
    }
}
