package com.example.FiltroFinal.persistence.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
@Table(name="lista_audiovisual")
public class ListaAudiovisual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "listaAudiovisual", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TipoContenido> tipoContenido;

    @Column(name = "estado_visualizacion", nullable = false)
    private String estadoVisualizacion;

    @OneToMany(mappedBy = "listaAudiovisual", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Plataformas> plataformas;

    @Column(name = "calificacion", nullable = true)
    private double calificacion;

    @Column(name = "comentario", nullable = true)
    private String comentario;

    @OneToOne(mappedBy ="listaAudiovisual", cascade = CascadeType.ALL)
    private Usuario usuario;

    @ManyToMany(mappedBy = "listaAudiovisual", fetch = FetchType.EAGER) //
    private Set<Genero> generos;

    public ListaAudiovisual() {
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

    public List<TipoContenido> getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(List<TipoContenido> tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public String getEstadoVisualizacion() {
        return estadoVisualizacion;
    }

    public void setEstadoVisualizacion(String estadoVisualizacion) {
        this.estadoVisualizacion = estadoVisualizacion;
    }

    public List<Plataformas> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<Plataformas> plataformas) {
        this.plataformas = plataformas;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(Set<Genero> generos) {
        this.generos = generos;
    }

    @Override
    public String toString() {
        return "ListaAudiovisual{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipoContenido=" + tipoContenido +
                ", estadoVisualizacion='" + estadoVisualizacion + '\'' +
                ", plataforma=" + plataformas +
                ", calificacion=" + calificacion +
                ", comentario='" + comentario + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
