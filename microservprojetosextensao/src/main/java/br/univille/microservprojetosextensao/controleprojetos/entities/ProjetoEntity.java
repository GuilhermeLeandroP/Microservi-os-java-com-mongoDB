package br.univille.microservprojetosextensao.controleprojetos.entities;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import br.univille.microservprojetosextensao.gestaoequipes.entities.EquipeEntity;

@Container(containerName = "projeto", autoCreateContainer = true)
public class ProjetoEntity {
    @Id
    @PartitionKey
    @GeneratedValue
    public String id;
    public String titulo;
    public String objetivo;
    public EquipeEntity equipe;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public EquipeEntity getEquipe() {
        return equipe;
    }

    public void setEquipe(EquipeEntity equipe) {
        this.equipe = equipe;
    }

    public ProjetoEntity(String id, String titulo, String objetivo, EquipeEntity equipe) {
        this.id = id;
        this.titulo = titulo;
        this.objetivo = objetivo;
        this.equipe = equipe;
    }

}
