package com.example.backemergencias.repository;

import com.example.backemergencias.entity.EmergenciaPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergenciaPersonalRepository extends JpaRepository<EmergenciaPersonal, Integer> {
    // Agrega métodos personalizados de consulta si es necesario
}
