package br.com.caelum.livraria.dao;

import br.com.caelum.livraria.model.Livro;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LivroDao {

    @PersistenceContext
    private EntityManager manager;


    public Livro findOne(Integer id) {
        return manager.find(Livro.class, id);
    }

    public void save(Livro Livro) {
        manager.persist(Livro);
    }

    public List<Livro> findAll() {
        return manager.createQuery("select l from Livro l", Livro.class).getResultList();
    }

    public List<Livro> findTresMaisRecentes() {
        TypedQuery<Livro> query = manager.createQuery("select l from Livro l ORDER BY l.dataEstimadaPublicacao DESC", Livro.class);
        query.setMaxResults(3);
        return query.getResultList();
    }

    public List<Livro> findAllByAutor(Integer autorId) {
        TypedQuery<Livro> query = manager.createQuery("select l from Livro l WHERE l.autor.id = :autorId", Livro.class);
        query.setParameter("autorId", autorId);
        return query.getResultList();
    }

    public void delete(Integer id) {
        manager.remove(findOne(id));
    }

}

