package br.univille.microservprojetosextensao.controleprojetos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.univille.microservprojetosextensao.controleprojetos.entities.ProjetoEntity;

@Repository
public interface ProjetoRepository extends CrudRepository<ProjetoEntity, String> {
}
