package com.example.FiltroFinal.domain.service;


import com.example.FiltroFinal.domain.exception.GeneroIdNotFoundException;
import com.example.FiltroFinal.domain.exception.GeneroNotFoundException;
import com.example.FiltroFinal.persistence.entity.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.FiltroFinal.domain.repository.GeneroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroInterfaceImpl implements CrudInterface<Genero> {


    private final GeneroRepository generoRepository;

    @Autowired
    public GeneroInterfaceImpl (GeneroRepository generoRepository){
        this.generoRepository = generoRepository;
    }
    @Override
    public List<Genero> getAll() {
        return generoRepository.findAll();
    }

    @Override
    public ResponseEntity<Genero> getById(Object id) {
        try{
            Long  newId = Long.parseLong(id.toString());
            Genero optionalGenero = generoRepository.findById(newId)
                    .orElseThrow(() -> new GeneroNotFoundException("Genero no encontrado"));
            return ResponseEntity.ok(optionalGenero);

        }catch (NumberFormatException e){
            throw new GeneroIdNotFoundException("Haz ingresado una letra u/o otro caracter diferente a un Número de tipo Long");
        }
    }

    @Override
    public ResponseEntity<Genero> save(Genero genero) {
        generoRepository.save(genero);
        return ResponseEntity.ok(genero);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        if (generoRepository.existsById(id)) {
            generoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Genero> update(Object id, Genero generoUpdate) {
        try{
            Long newId = Long.parseLong(id.toString());
            Optional<Genero> optionalGenero = generoRepository.findById(newId);
            if(optionalGenero.isPresent()){

                Genero generoSend = optionalGenero.get();
                generoSend.setNombreGenero(generoUpdate.getNombreGenero());
                generoSend.setNombreDescripcion(generoUpdate.getNombreDescripcion());
                generoRepository.save(generoSend);

                return ResponseEntity.ok(generoSend);
            } else {
                throw new GeneroNotFoundException("Genero no encontrado por dicho ID para actualizar");
            }
        }catch (NumberFormatException e){
            throw new GeneroIdNotFoundException("Haz ingresado una letra u/o otro caracter diferente a un Número de tipo Long");
        }
    }
}