package br.univille.microservprojetosextensao.controleprojetos.controller;

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

import br.univille.microservprojetosextensao.controleprojetos.entities.ProjetoEntity;
import br.univille.microservprojetosextensao.controleprojetos.service.ProjetoService;

@RestController
@RequestMapping("/api/v1/projeto")
public class ProjetoAPIController {

    @Autowired
    private ProjetoService service;

    @GetMapping
    public ResponseEntity<List<ProjetoEntity>> get() {
        var listaProjetos = service.getAll();

        return new ResponseEntity<List<ProjetoEntity>>(listaProjetos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjetoEntity> post(@RequestBody ProjetoEntity projeto) {
        if (projeto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var projetoSalvo = service.save(projeto);
        return new ResponseEntity<>(projetoSalvo, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoEntity> put(
            @PathVariable("id") String id,
            @RequestBody ProjetoEntity projetoEntity) {
        if (projetoEntity == null || id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        projetoEntity = service.update(id, projetoEntity);
        if (projetoEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProjetoEntity>(projetoEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProjetoEntity> delete(
            @PathVariable("id") String id) {
        if (id == "" || id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var projetoEntity = service.delete(id);
        if (projetoEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProjetoEntity>(projetoEntity, HttpStatus.OK);

    }
}
