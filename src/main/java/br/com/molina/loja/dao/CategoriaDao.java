package br.com.molina.loja.dao;

import br.com.molina.loja.modelo.Categoria;
import javax.persistence.EntityManager;

public class CategoriaDao {
    private EntityManager em;

    public CategoriaDao(EntityManager em) {

        this.em = em;
    }

    public void cadastrar (Categoria categoria) {
        this.em.persist(categoria); //com uma �nica linha
    }
    public void atualizar (Categoria categoria) {
        this.em.merge(categoria); //com uma �nica linha
    }
    public void remover(Categoria categoria) {
        categoria = em.merge(categoria);
        this.em.remove(categoria);
    }

}
