package com.example.backemergencias.service;

import com.example.backemergencias.entity.Emergencia;

import java.util.List;
import java.util.Optional;

public interface EmergenciaService {

    List<Emergencia> getAllEmergencias();

    Optional<Emergencia> getEmergenciaById(int id);

    Emergencia createEmergencia(Emergencia emergencia);

    Emergencia updateEmergencia(int id, Emergencia emergencia);

    void deleteEmergencia(int id);

    // Otros métodos específicos si es necesario...
}
