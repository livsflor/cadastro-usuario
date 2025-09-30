package com.projeto1.cadastro_usuario.business;

import com.projeto1.cadastro_usuario.infrastructure.entitys.Musica;
import com.projeto1.cadastro_usuario.infrastructure.repository.MusicaRepository;
import org.springframework.stereotype.Service;

@Service
public class MusicaService {

    private final MusicaRepository repository;

    public MusicaService(MusicaRepository repository) {
        this.repository = repository;
    }

    public void salvarMusica(Musica musica) {
        repository.saveAndFlush(musica);
    }

    public Musica buscarPorTitulo(String titulo) {
        return repository.findByTitulo(titulo).orElseThrow(() -> new RuntimeException("Música não encontrada"));
    }

    public void deletarPorTitulo(String titulo) {
        Musica musica = repository.findByTitulo(titulo)
                .orElseThrow(() -> new RuntimeException("Música não encontrada"));
        repository.delete(musica);
    }

    public void atualizarMusica(Integer id, Musica musica) {
        Musica existente = repository.findById(id).orElseThrow(() -> new RuntimeException("ID não encontrado"));
        Musica atualizado = Musica.builder()
                .id(existente.getId())
                .titulo(musica.getTitulo() != null ? musica.getTitulo() : existente.getTitulo())
                .artista(musica.getArtista() != null ? musica.getArtista() : existente.getArtista())
                .build();

        repository.saveAndFlush(atualizado);
    }
}

