package br.univille.microservprojetosextensao.controleprojetos.service;

import java.util.List;

import br.univille.microservprojetosextensao.controleprojetos.entities.ProjetoEntity;

public interface ProjetoService {
    List<ProjetoEntity> getAll();

    ProjetoEntity save(ProjetoEntity projetoEntity);

    ProjetoEntity update(String id, ProjetoEntity projetoEntity);

    ProjetoEntity delete(String id);
}
