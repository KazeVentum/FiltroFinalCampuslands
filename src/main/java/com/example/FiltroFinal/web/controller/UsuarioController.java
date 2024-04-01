package com.example.FiltroFinal.web.controller;

import com.example.FiltroFinal.domain.service.GeneroInterfaceImpl;
import com.example.FiltroFinal.domain.service.UsuarioInterfaceImpl;
import com.example.FiltroFinal.persistence.entity.Genero;
import com.example.FiltroFinal.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioInterfaceImpl usuarioInterfaceImpl;

    @Autowired
    public UsuarioController(UsuarioInterfaceImpl usuarioInterfaceImpl){
        this.usuarioInterfaceImpl = usuarioInterfaceImpl;
    }


    @GetMapping("/getAllUsuarios")
    public List<Usuario> getAllUsuarios(){
        return usuarioInterfaceImpl.getAll();
    }

    @GetMapping("getUsuario/{id}")
    public ResponseEntity<Usuario> getGeneroById(@PathVariable Object id) {
        return usuarioInterfaceImpl.getById(id);
    }

    @PostMapping("/saveUsuario")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuarioSave) {
        return usuarioInterfaceImpl.save(usuarioSave);
    }

    @DeleteMapping("deleteUsuario/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        return usuarioInterfaceImpl.delete(id);
    }

    @PutMapping("/editUsuario/{id}")
    public ResponseEntity<Usuario> editUsuario( @PathVariable Object id, @RequestBody Usuario usuarioUpdate) {
        return usuarioInterfaceImpl.update(id, usuarioUpdate);
    }
}
