package com.example.backemergencias.repository;

import com.example.backemergencias.entity.Emergencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergenciaRepository extends JpaRepository<Emergencia, Integer> {
    // Agrega métodos personalizados de consulta si es necesario
}
