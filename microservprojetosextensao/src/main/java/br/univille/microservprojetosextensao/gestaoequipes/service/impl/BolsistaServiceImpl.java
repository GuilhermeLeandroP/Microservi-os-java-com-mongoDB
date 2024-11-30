package br.univille.microservprojetosextensao.gestaoequipes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.microservprojetosextensao.gestaoequipes.entities.BolsistasEntity;
import br.univille.microservprojetosextensao.gestaoequipes.repository.BolsistasRepository;
import br.univille.microservprojetosextensao.gestaoequipes.service.BolsistasService;

@Service
public class BolsistaServiceImpl implements BolsistasService {

    @Autowired
    private BolsistasRepository repository;

    @Override
    public List<BolsistasEntity> getAll() {
        var retornoIterador = repository.findAll();
        var listaBolsistas = new ArrayList<BolsistasEntity>();

        retornoIterador.forEach(listaBolsistas::add);
        return listaBolsistas;
    }

    @Override
    public BolsistasEntity save(BolsistasEntity bolsistasEntity) {

        return repository.save(bolsistasEntity);
    }

    @Override
    public BolsistasEntity update(String id, BolsistasEntity bolsistasEntity) {
        var buscarBolsistas = repository.findById(id);
        if (buscarBolsistas.isPresent()) {
            var bolsistasAntigo = buscarBolsistas.get();
            bolsistasAntigo.setId(bolsistasEntity.getId());
            bolsistasAntigo.setNome(bolsistasEntity.getNome());
            repository.save(bolsistasAntigo);
            return bolsistasAntigo;
        }
        return null;
    }

    @Override
    public BolsistasEntity delete(String id) {
        var buscarBolsistas = repository.findById(id);
        if (buscarBolsistas.isPresent()) {
            var projetoAntigo = buscarBolsistas.get();
            repository.delete(projetoAntigo);
            return projetoAntigo;

        }
        return null;
    }

}
