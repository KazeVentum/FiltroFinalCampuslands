package com.example.FiltroFinal.web.controller;

import com.example.FiltroFinal.domain.service.GeneroInterfaceImpl;
import com.example.FiltroFinal.persistence.entity.Admin;
import com.example.FiltroFinal.persistence.entity.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/genero")
public class GeneroController {

    private final GeneroInterfaceImpl generoInterfaceImpl;

    @Autowired
    public GeneroController(GeneroInterfaceImpl generoInterfaceImpl){
        this.generoInterfaceImpl = generoInterfaceImpl;
    }

    @GetMapping("/getAllGeneros")
    public List<Genero> getAllGeneros(){
        return generoInterfaceImpl.getAll();
    }

    @GetMapping("getGenero/{id}")
    public ResponseEntity<Genero> getGeneroById(@PathVariable Object id) {
        return generoInterfaceImpl.getById(id);
    }

    @PostMapping("/saveGenero")
    public ResponseEntity<Genero> saveGenero(@RequestBody Genero generoSave) {
        return generoInterfaceImpl.save(generoSave);
    }

    @DeleteMapping("deleteGenero/{id}")
    public ResponseEntity<Void> deleteGenero(@PathVariable Long id) {
        return generoInterfaceImpl.delete(id);
    }

    @PutMapping("/editGenero/{id}")
    public ResponseEntity<Genero> updateGenero( @PathVariable Object id, @RequestBody Genero generoUpdate) {
        return generoInterfaceImpl.update(id, generoUpdate);
    }
}
