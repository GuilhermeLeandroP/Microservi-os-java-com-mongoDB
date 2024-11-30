package br.univille.microservprojetosextensao.controleprojetos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.microservprojetosextensao.controleprojetos.entities.ProjetoEntity;
import br.univille.microservprojetosextensao.controleprojetos.repository.ProjetoRepository;
import br.univille.microservprojetosextensao.controleprojetos.service.ProjetoService;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    @Override
    public List<ProjetoEntity> getAll() {
        var retornoIterador = repository.findAll();
        var listaProjetos = new ArrayList<ProjetoEntity>();

        retornoIterador.forEach(listaProjetos::add);
        return listaProjetos;
    }

    @Override
    public ProjetoEntity save(ProjetoEntity projetoEntity) {

        return repository.save(projetoEntity);
    }

    @Override
    public ProjetoEntity update(String id, ProjetoEntity projetoEntity) {
        var buscarProjeto = repository.findById(id);
        if (buscarProjeto.isPresent()) {
            var projetoAntigo = buscarProjeto.get();
            projetoAntigo.setEquipe(projetoEntity.getEquipe());
            projetoAntigo.setId(projetoEntity.getId());
            projetoAntigo.setObjetivo(projetoEntity.getObjetivo());
            projetoAntigo.setTitulo(projetoEntity.getTitulo());
            repository.save(projetoAntigo);
            return projetoAntigo;
        }
        return null;
    }

    @Override
    public ProjetoEntity delete(String id) {
        var buscarProjeto = repository.findById(id);
        if (buscarProjeto.isPresent()) {
            var projetoAntigo = buscarProjeto.get();
            repository.delete(projetoAntigo);
            return projetoAntigo;

        }
        return null;
    }

}
