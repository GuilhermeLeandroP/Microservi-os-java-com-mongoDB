package br.univille.microservprojetosextensao.gestaoequipes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.microservprojetosextensao.gestaoequipes.entities.EquipeEntity;
import br.univille.microservprojetosextensao.gestaoequipes.service.EquipeService;

@RestController
@RequestMapping("api/v1/equipe")
public class EquipeController {
    
    @Autowired
    private EquipeService service;

        @GetMapping
    public ResponseEntity<List<EquipeEntity>> get() {
        var listaEquipes = service.getAll();

        return new ResponseEntity<List<EquipeEntity>>(listaEquipes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EquipeEntity> post(@RequestBody EquipeEntity equipe) {
        if (equipe == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var equipeSalvo = service.save(equipe);
        return new ResponseEntity<>(equipeSalvo, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipeEntity> put(
            @PathVariable("id") String id,
            @RequestBody EquipeEntity equipeEntity) {
        if (equipeEntity == null || id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        equipeEntity = service.update(id, equipeEntity);
        if (equipeEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<EquipeEntity>(equipeEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EquipeEntity> delete(
            @PathVariable("id") String id) {
        if (id == "" || id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var equipeEntity = service.delete(id);
        if (equipeEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<EquipeEntity>(equipeEntity, HttpStatus.OK);

    }
}
