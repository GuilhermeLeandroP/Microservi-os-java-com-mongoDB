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

import br.univille.microservprojetosextensao.gestaoequipes.entities.BolsistasEntity;
import br.univille.microservprojetosextensao.gestaoequipes.service.BolsistasService;

@RestController
@RequestMapping("api/v1/bolsistas")
public class BolsistasController {
    
    @Autowired
    private BolsistasService service;

    @GetMapping
    public ResponseEntity<List<BolsistasEntity>> get() {
        var listaBolsistas = service.getAll();

        return new ResponseEntity<List<BolsistasEntity>>(listaBolsistas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BolsistasEntity> post(@RequestBody BolsistasEntity bolsistas) {
        if (bolsistas == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var bolsistasSalvo = service.save(bolsistas);
        return new ResponseEntity<>(bolsistasSalvo, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<BolsistasEntity> put(
            @PathVariable("id") String id,
            @RequestBody BolsistasEntity bolsistasEntity) {
        if (bolsistasEntity == null || id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bolsistasEntity = service.update(id, bolsistasEntity);
        if (bolsistasEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BolsistasEntity>(bolsistasEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BolsistasEntity> delete(
            @PathVariable("id") String id) {
        if (id == "" || id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var bolsistasEntity = service.delete(id);
        if (bolsistasEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BolsistasEntity>(bolsistasEntity, HttpStatus.OK);

    }
}
