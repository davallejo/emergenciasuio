package com.example.backemergencias.entity;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "emergencia")
public class Emergencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "fecha_emergencia", nullable = false)
    private Date fechaEmergencia;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "temperatura", nullable = false)
    private Double temperatura;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaEmergencia() {
        return fechaEmergencia;
    }

    public void setFechaEmergencia(Date fechaEmergencia) {
        this.fechaEmergencia = fechaEmergencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    // Getters y setters
}
