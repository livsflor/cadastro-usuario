package com.projeto1.cadastro_usuario.infrastructure.repository;

import com.projeto1.cadastro_usuario.infrastructure.entitys.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {
    Optional<Musica> findByTitulo(String titulo);
}

