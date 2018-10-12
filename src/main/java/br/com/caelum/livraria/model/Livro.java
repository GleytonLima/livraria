package br.com.caelum.livraria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue
    private Integer id;
    private String titulo;
    private String sumario;
    private BigDecimal preco;
    private LocalDate dataEstimadaPublicacao;
    //Para o exercicio vamos considerar que um livro possui somente um autor
    @ManyToOne
    private Autor autor;


    /**
     * @deprecated hibernate only
     */
    public Livro() {

    }

    public Livro(String titulo, String sumario, LocalDate dataEstimadaPublicacao, BigDecimal preco, Autor autor) {
        this.titulo = titulo;
        this.sumario = sumario;
        this.dataEstimadaPublicacao = dataEstimadaPublicacao;
        this.preco = preco;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getDataEstimadaPublicacao() {
        return dataEstimadaPublicacao;
    }

    public void setDataEstimadaPublicacao(LocalDate dataEstimadaPublicacao) {
        this.dataEstimadaPublicacao = dataEstimadaPublicacao;
    }
}
