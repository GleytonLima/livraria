package br.com.caelum.livraria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autor {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String email;

    /**
     * @deprecated hibernate only
     */
    public Autor() {

    }

    public Autor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}