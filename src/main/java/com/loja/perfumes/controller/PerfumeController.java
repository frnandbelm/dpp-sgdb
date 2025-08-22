package com.loja.perfumes.controller;

import com.loja.perfumes.model.Perfume;
import com.loja.perfumes.repository.PerfumeRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/perfumes")
public class PerfumeController {

    private final PerfumeRepository repository;

    public PerfumeController(PerfumeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Perfume> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfume> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Perfume> salvar(@Valid @RequestBody Perfume perfume) {
        Perfume salvo = repository.save(perfume);
        return ResponseEntity.created(URI.create("/perfumes/" + salvo.getId())).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfume> atualizar(@PathVariable Long id, @Valid @RequestBody Perfume perfume) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setNome(perfume.getNome());
                    existente.setMarca(perfume.getMarca());
                    existente.setPreco(perfume.getPreco());
                    Perfume salvo = repository.save(existente);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
