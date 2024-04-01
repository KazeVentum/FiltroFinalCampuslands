package com.example.FiltroFinal.domain.service;



import com.example.FiltroFinal.domain.exception.NotFoundException;
import com.example.FiltroFinal.domain.exception.UsuarioIdNotFoundException;
import com.example.FiltroFinal.domain.repository.UsuarioRepository;
import com.example.FiltroFinal.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioInterfaceImpl implements CrudInterface<Usuario> {

    private final UsuarioRepository usuarioRepository;

    @Autowired

    public UsuarioInterfaceImpl (UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public ResponseEntity<Usuario> getById(Object id) {
        try{
            Long  newId = Long.parseLong(id.toString());
            Usuario optionalUsuario = usuarioRepository.findById(newId)
                    .orElseThrow(() -> new UsuarioIdNotFoundException("Usuario no encontrado"));
            return ResponseEntity.ok(optionalUsuario);

        }catch (NumberFormatException e){
            throw new NotFoundException("Haz ingresado una letra u/o otro caracter diferente a un Número de tipo Long");
        }
    }

    @Override
    public ResponseEntity<Usuario> save(Usuario usuario) {
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Usuario> update(Object id, Usuario usuarioUpdate) {
        try{
            Long newId = Long.parseLong(id.toString());
            Optional<Usuario> optionalUsuario = usuarioRepository.findById(newId);
            if(optionalUsuario.isPresent()){

                Usuario usuarioSend = optionalUsuario.get();
                usuarioSend.setNombre(usuarioUpdate.getNombre());
                usuarioSend.setEmail(usuarioUpdate.getEmail());
                usuarioSend.setListaAudiovisual(usuarioUpdate.getListaAudiovisual());
                usuarioRepository.save(usuarioSend);

                return ResponseEntity.ok(usuarioSend);
            } else {
                throw new UsuarioIdNotFoundException("Usuario no encontrado por dicho ID para actualizar");
            }
        }catch (NumberFormatException e){
            throw new NotFoundException("Haz ingresado una letra u/o otro caracter diferente a un Número de tipo Long");
        }
    }
}

