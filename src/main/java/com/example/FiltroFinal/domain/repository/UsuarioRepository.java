package com.example.FiltroFinal.domain.repository;

import com.example.FiltroFinal.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
