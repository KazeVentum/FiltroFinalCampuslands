package com.example.FiltroFinal.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @JoinColumn(name = "lista_audiovisual_id", nullable = false)
    @OneToOne(fetch = FetchType.EAGER)
    private ListaAudiovisual listaAudiovisual;

    public Usuario() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ListaAudiovisual getListaAudiovisual() {
        return listaAudiovisual;
    }

    public void setListaAudiovisual(ListaAudiovisual listaAudiovisual) {
        this.listaAudiovisual = listaAudiovisual;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", listaAudiovisual_id=" + listaAudiovisual +
                '}';
    }
}
