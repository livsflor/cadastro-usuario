package com.projeto1.cadastro_usuario.controller;

import com.projeto1.cadastro_usuario.business.MusicaService;
import com.projeto1.cadastro_usuario.infrastructure.entitys.Musica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musica")
public class MusicaController {

    private final MusicaService musicaService;

    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }

    @PostMapping
    public ResponseEntity<Void> salvarMusica(@RequestBody Musica musica) {
        musicaService.salvarMusica(musica);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Musica> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(musicaService.buscarPorTitulo(titulo));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarPorTitulo(@RequestParam String titulo) {
        musicaService.deletarPorTitulo(titulo);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarMusica(@RequestParam Integer id, @RequestBody Musica musica) {
        musicaService.atualizarMusica(id, musica);
        return ResponseEntity.ok().build();
    }
}

