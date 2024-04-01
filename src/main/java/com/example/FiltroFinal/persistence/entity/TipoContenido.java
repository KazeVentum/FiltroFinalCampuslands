package com.example.FiltroFinal.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tipo_contenido")
public class TipoContenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_contenido", nullable = false)
    private String nombreContenido;
    @JoinColumn(name="tipoContenido_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private ListaAudiovisual listaAudiovisual;

    public TipoContenido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreContenido() {
        return nombreContenido;
    }

    public void setNombreContenido(String nombreContenido) {
        this.nombreContenido = nombreContenido;
    }

    public ListaAudiovisual getListaAudiovisual() {
        return listaAudiovisual;
    }

    public void setListaAudiovisual(ListaAudiovisual listaAudiovisual) {
        this.listaAudiovisual = listaAudiovisual;
    }

    @Override
    public String toString() {
        return "TipoContenido{" +
                "id=" + id +
                ", nombreContenido='" + nombreContenido + '\'' +
                ", listaAudiovisual=" + listaAudiovisual +
                '}';
    }
}
