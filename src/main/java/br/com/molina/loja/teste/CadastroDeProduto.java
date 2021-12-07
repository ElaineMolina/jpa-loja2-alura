package br.com.molina.loja.teste;

import br.com.molina.loja.dao.CategoriaDao;
import br.com.molina.loja.dao.ProdutoDao;
import br.com.molina.loja.modelo.Categoria;
import br.com.molina.loja.modelo.Produto;
import br.com.molina.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getPreco());

        List<Produto> todos = produtoDao.buscarTodos();
        todos.forEach(p2 -> System.out.println(p.getNome()) );

        List<Produto> todos1 = produtoDao.buscarPorNome("Xiomi Redmi");
        todos1.forEach(p3 -> System.out.println(p.getNome()) );

        List<Produto> todos2 = produtoDao.buscarPorNomeDaCategoria("CELULARES");
        todos2.forEach(p3 -> System.out.println(p.getNome()) );
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiomi Redmi", "Muito legal", new BigDecimal("800"), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }

}
