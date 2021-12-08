package br.com.molina.loja.dao;

import br.com.molina.loja.modelo.Pedido;
import br.com.molina.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {
    private EntityManager em;

    public PedidoDao(EntityManager em) {

        this.em = em;
    }

    public void cadastrar(Pedido pedido) {

        this.em.persist(pedido);
    }

}