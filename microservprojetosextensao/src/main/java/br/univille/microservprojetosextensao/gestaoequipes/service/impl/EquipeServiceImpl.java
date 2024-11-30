package br.univille.microservprojetosextensao.gestaoequipes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.microservprojetosextensao.gestaoequipes.entities.EquipeEntity;
import br.univille.microservprojetosextensao.gestaoequipes.repository.EquipeRepository;
import br.univille.microservprojetosextensao.gestaoequipes.service.EquipeService;

@Service
public class EquipeServiceImpl implements EquipeService {
    
    @Autowired
    private EquipeRepository repository;

    @Override
    public List<EquipeEntity> getAll() {
        var retornoIterador = repository.findAll();
        var listaEquipe = new ArrayList<EquipeEntity>();

        retornoIterador.forEach(listaEquipe::add);
        return listaEquipe;
    }

    @Override
    public EquipeEntity save(EquipeEntity equipeEntity) {

        return repository.save(equipeEntity);
    }

    @Override
    public EquipeEntity update(String id, EquipeEntity equipeEntity) {
        var buscarEquipe = repository.findById(id);
        if (buscarEquipe.isPresent()) {
            var equipeAntigo = buscarEquipe.get();
            equipeAntigo.setId(equipeEntity.getId());
            equipeAntigo.setIntegrantes(equipeEntity.getIntegrantes());
            repository.save(equipeAntigo);
            return equipeAntigo;
        }
        return null;
    }

    @Override
    public EquipeEntity delete(String id) {
        var buscarEquipe = repository.findById(id);
        if (buscarEquipe.isPresent()) {
            var equipeAntigo = buscarEquipe.get();
            repository.delete(equipeAntigo);
            return equipeAntigo;

        }
        return null;
    }
}
