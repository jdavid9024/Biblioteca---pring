package com.virtualibrary.Biblioteca.model;

import jakarta.persistence.*;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuario;
    private String sala;
    private String fecha;
    private String hora;

    public Reserva() {}

    public Reserva(String usuario, String sala, String fecha, String hora) {
        this.usuario = usuario;
        this.sala = sala;
        this.fecha = fecha;
        this.hora = hora;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
