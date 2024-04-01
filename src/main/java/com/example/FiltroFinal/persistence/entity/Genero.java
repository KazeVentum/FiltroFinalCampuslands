package com.example.FiltroFinal.persistence.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreGenero", nullable = false)
    private String nombreGenero;

    @Column(name = "nombreDescripcion", nullable = false)
    private String nombreDescripcion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "generoXlistaAudiovisual",
            joinColumns = @JoinColumn(name = "genero_id"),
            inverseJoinColumns = @JoinColumn(name = "lista_id")
    )
    private Set<ListaAudiovisual> listaAudiovisual;

    public Genero() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    public String getNombreDescripcion() {
        return nombreDescripcion;
    }

    public void setNombreDescripcion(String nombreDescripcion) {
        this.nombreDescripcion = nombreDescripcion;
    }

    public Set<ListaAudiovisual> getListaAudiovisual() {
        return listaAudiovisual;
    }

    public void setListaAudiovisual(Set<ListaAudiovisual> listaAudiovisual) {
        this.listaAudiovisual = listaAudiovisual;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", nombreGenero='" + nombreGenero + '\'' +
                ", nombreDescripcion='" + nombreDescripcion + '\'' +
                '}';
    }
}
