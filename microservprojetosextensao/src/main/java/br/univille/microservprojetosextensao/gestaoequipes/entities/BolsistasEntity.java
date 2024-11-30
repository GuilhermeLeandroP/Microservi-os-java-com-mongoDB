package br.univille.microservprojetosextensao.gestaoequipes.entities;

public class BolsistasEntity {
    public String id;
    public String nome;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public BolsistasEntity(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
}
