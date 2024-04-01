package com.example.FiltroFinal.web.controller;

import com.example.FiltroFinal.domain.service.ListaAudiovisualImpl;
import com.example.FiltroFinal.persistence.entity.ListaAudiovisual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/ListaAudiovisual")
public class ListaAudiovisualController {
    private final ListaAudiovisualImpl listaAudiovisualImpl;

    @Autowired
    public ListaAudiovisualController(ListaAudiovisualImpl listaAudiovisualImpl) {
        this.listaAudiovisualImpl = listaAudiovisualImpl;
    }

    @GetMapping("/getAllListas")
    public List<ListaAudiovisual> getAllListas(){
        return listaAudiovisualImpl.getAll();
    }

    @GetMapping("getLista/{id}")
    public ResponseEntity<ListaAudiovisual> getGeneroById(@PathVariable Object id) {
        return listaAudiovisualImpl.getById(id);
    }

    @PostMapping("/saveLista")
    public ResponseEntity<ListaAudiovisual> saveLista(@RequestBody ListaAudiovisual listaAudiovisualSave) {
        return listaAudiovisualImpl.save(listaAudiovisualSave);
    }

    @DeleteMapping("deleteLista/{id}")
    public ResponseEntity<Void> deleteLista(@PathVariable Long id) {
        return listaAudiovisualImpl.delete(id);
    }

    @PutMapping("/editLista/{id}")
    public ResponseEntity<ListaAudiovisual> updateGenero( @PathVariable Object id, @RequestBody ListaAudiovisual ListaAudiovisualUpdate) {
        return listaAudiovisualImpl.update(id, ListaAudiovisualUpdate);
    }
}
