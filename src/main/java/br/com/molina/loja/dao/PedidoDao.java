package br.com.molina.loja.dao;

import br.com.molina.loja.modelo.Pedido;
import br.com.molina.loja.modelo.Produto;
import br.com.molina.loja.vo.RelatorioDeVendasVo;

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

    public BigDecimal valorTotalVendido(){
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return em.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }
    public List<RelatorioDeVendasVo> relatorioDeVendas(){
        String jpql = "SELECT new br.com.molina.loja.vo.RelatorioDeVendasVo("
            + "produto.nome, "
            + "SUM(item.quantidade), "
            + "MAX(pedido.data)) "
            + "FROM Pedido pedido "
            + "JOIN pedido.itens item "
            + "JOIN item.produto produto "
            + "GROUP BY produto.nome "
            + "ORDER BY item.quantidade DESC";
        return em.createQuery(jpql, RelatorioDeVendasVo.class)
            .getResultList();
    }
}