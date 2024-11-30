package br.univille.microservprojetosextensao.gestaoequipes.entities;

import java.util.List;

public class EquipeEntity {
    public String id;
    public List<BolsistasEntity> integrantes;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<BolsistasEntity> getIntegrantes() {
        return integrantes;
    }
    public void setIntegrantes(List<BolsistasEntity> integrantes) {
        this.integrantes = integrantes;
    }
    public EquipeEntity(String id, List<BolsistasEntity> integrantes) {
        this.id = id;
        this.integrantes = integrantes;
    }
    
}
