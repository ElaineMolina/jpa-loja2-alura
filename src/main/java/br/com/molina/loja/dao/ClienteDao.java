package br.com.molina.loja.dao;

import br.com.molina.loja.modelo.Cliente;
import br.com.molina.loja.modelo.Pedido;
import br.com.molina.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ClienteDao {
    private EntityManager em;

    public ClienteDao(EntityManager em) {

        this.em = em;
    }

    public void cadastrar(Cliente cliente) {

        this.em.persist(cliente);
    }
    public Cliente buscarPorId(Long id) {
        return em.find(Cliente.class, id);
    }
}