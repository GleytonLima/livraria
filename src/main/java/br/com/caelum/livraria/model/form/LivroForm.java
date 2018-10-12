package br.com.caelum.livraria.model.form;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.model.Livro;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;


public class LivroForm {

    private Integer id;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    private String titulo;

    @NotNull
    private String sumario;


    private BigDecimal preco;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dataEstimadaPublicacao;

    @NotNull
    private Integer autorId;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
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


    public Livro toLivro(AutorDao autorDao) {
        Autor autor = autorDao.findOne(this.getAutorId());
        return new Livro(titulo, sumario, dataEstimadaPublicacao, preco, autor);
    }
}