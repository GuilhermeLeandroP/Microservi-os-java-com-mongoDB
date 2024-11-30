package br.univille.microservprojetosextensao.gestaoequipes.service;

import java.util.List;

import br.univille.microservprojetosextensao.gestaoequipes.entities.BolsistasEntity;

public interface BolsistasService {
    List<BolsistasEntity> getAll();

    BolsistasEntity save(BolsistasEntity bolsistasEntity);

    BolsistasEntity update(String id, BolsistasEntity bolsistasEntity);

    BolsistasEntity delete(String id);
}
