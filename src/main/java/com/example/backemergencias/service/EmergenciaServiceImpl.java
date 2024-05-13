package com.example.backemergencias.service;

import com.example.backemergencias.entity.Emergencia;
import com.example.backemergencias.repository.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmergenciaServiceImpl implements EmergenciaService {

    private final EmergenciaRepository emergenciaRepository;

    @Autowired
    public EmergenciaServiceImpl(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
    }

    @Override
    public List<Emergencia> getAllEmergencias() {
        return emergenciaRepository.findAll();
    }

    @Override
    public Optional<Emergencia> getEmergenciaById(int id) {
        return emergenciaRepository.findById(id);
    }

    @Override
    public Emergencia createEmergencia(Emergencia emergencia) {
        return emergenciaRepository.save(emergencia);
    }

    @Override
    public Emergencia updateEmergencia(int id, Emergencia emergencia) {
        if (emergenciaRepository.existsById(id)) {
            emergencia.setId(id);
            return emergenciaRepository.save(emergencia);
        }
        return null; // Manejar este caso según tus necesidades
    }

    @Override
    public void deleteEmergencia(int id) {
        emergenciaRepository.deleteById(id);
    }

    // Otros métodos específicos si es necesario...
}
