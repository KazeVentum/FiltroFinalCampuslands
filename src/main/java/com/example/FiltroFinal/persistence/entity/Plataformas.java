package com.example.FiltroFinal.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="plataformas")
public class Plataformas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @JoinColumn(name="plataforma_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private ListaAudiovisual listaAudiovisual;

    public Plataformas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ListaAudiovisual getListaAudiovisual() {
        return listaAudiovisual;
    }

    public void setListaAudiovisual(ListaAudiovisual listaAudiovisual) {
        this.listaAudiovisual = listaAudiovisual;
    }

    @Override
    public String toString() {
        return "Plataformas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", listaAudiovisual=" + listaAudiovisual +
                '}';
    }
}
