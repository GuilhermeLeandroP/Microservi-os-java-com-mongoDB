package br.univille.microservprojetosextensao.gestaoequipes.service;

import java.util.List;

import br.univille.microservprojetosextensao.gestaoequipes.entities.EquipeEntity;

public interface EquipeService {
    List<EquipeEntity> getAll();

    EquipeEntity save(EquipeEntity equipeEntity);

    EquipeEntity update(String id, EquipeEntity equipeEntity);

    EquipeEntity delete(String id);
}
