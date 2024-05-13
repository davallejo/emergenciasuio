package com.example.backemergencias.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@IdClass(EmergenciaPersonalId.class)
public class EmergenciaPersonal implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "emergencia_id")
    private Emergencia emergencia;

    @Id
    @ManyToOne
    @JoinColumn(name = "personal_cedula")
    private Personal personal;

    // Constructor, getters, setters, etc.
}
