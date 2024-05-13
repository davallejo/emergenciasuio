package com.example.backemergencias.repository;

import com.example.backemergencias.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, String> {
    // Agrega métodos personalizados de consulta si es necesario
}
