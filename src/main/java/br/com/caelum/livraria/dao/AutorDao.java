package br.com.caelum.livraria.dao;

import br.com.caelum.livraria.model.Autor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AutorDao {

    @PersistenceContext
    private EntityManager manager;


    public Autor findOne(Integer id) {
        return manager.find(Autor.class, id);
    }

    public void save(Autor Autor) {
        manager.persist(Autor);
    }

    public List<Autor> findAll() {
        return manager.createQuery("select f from Autor f", Autor.class).getResultList();
    }

    public void delete(Integer id) {
        manager.remove(findOne(id));
    }
}