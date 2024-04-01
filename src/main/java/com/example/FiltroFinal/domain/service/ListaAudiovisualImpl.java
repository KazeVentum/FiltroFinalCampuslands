package com.example.FiltroFinal.domain.service;


import com.example.FiltroFinal.domain.exception.ListaAudiovisualIdNotFoundException;
import com.example.FiltroFinal.domain.exception.NotFoundException;
import com.example.FiltroFinal.domain.repository.ListaAudiovisualRepository;
import com.example.FiltroFinal.persistence.entity.ListaAudiovisual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaAudiovisualImpl implements CrudInterface<ListaAudiovisual> {
    private final ListaAudiovisualRepository listaAudiovisualRepository;

    @Autowired
    public ListaAudiovisualImpl (ListaAudiovisualRepository listaAudiovisualRepository){
        this.listaAudiovisualRepository = listaAudiovisualRepository;
    }

    @Override
    public List<ListaAudiovisual> getAll() {
        return listaAudiovisualRepository.findAll();
    }

    @Override
    public ResponseEntity<ListaAudiovisual> getById(Object id) {
        try{
            Long newId = Long.parseLong(id.toString());
            ListaAudiovisual optionalAudiovisual = listaAudiovisualRepository.findById(newId)
                    .orElseThrow(() -> new ListaAudiovisualIdNotFoundException("Lista Audiovisual no encontrada"));
            return ResponseEntity.ok(optionalAudiovisual);

        }catch (NumberFormatException e){
            throw new NotFoundException("Haz ingresado una letra u/o otro caracter diferente a un Número de tipo Long");
        }
    }

    @Override
    public ResponseEntity<ListaAudiovisual> save(ListaAudiovisual listaAudiovisual) {
        listaAudiovisualRepository.save(listaAudiovisual);
        return ResponseEntity.ok(listaAudiovisual);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        if (listaAudiovisualRepository.existsById(id)) {
            listaAudiovisualRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<ListaAudiovisual> update(Object id, ListaAudiovisual listaAudiovisualUpdate) {
        try{
            Long newId = Long.parseLong(id.toString());
            Optional<ListaAudiovisual> optionalListaAudiovisual = listaAudiovisualRepository.findById(newId);
            if(optionalListaAudiovisual.isPresent()){

                ListaAudiovisual ListaAudiovisualSend = optionalListaAudiovisual.get();
                ListaAudiovisualSend.setNombre(listaAudiovisualUpdate.getNombre());
                ListaAudiovisualSend.setTipoContenido(listaAudiovisualUpdate.getTipoContenido());
                ListaAudiovisualSend.setEstadoVisualizacion(listaAudiovisualUpdate.getEstadoVisualizacion());
                ListaAudiovisualSend.setPlataformas(listaAudiovisualUpdate.getPlataformas());
                ListaAudiovisualSend.setCalificacion(listaAudiovisualUpdate.getCalificacion());
                ListaAudiovisualSend.setComentario(listaAudiovisualUpdate.getComentario());

                listaAudiovisualRepository.save(ListaAudiovisualSend);

                return ResponseEntity.ok(ListaAudiovisualSend);
            } else {
                throw new ListaAudiovisualIdNotFoundException("Lista Audiovisual no encontrada por dicho ID para actualizar");
            }
        }catch (NumberFormatException e){
            throw new NotFoundException("Haz ingresado una letra u/o otro caracter diferente a un Número de tipo Long");
        }
    }
}

