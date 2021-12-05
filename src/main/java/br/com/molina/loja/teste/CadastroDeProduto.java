package br.com.molina.loja.teste;

import br.com.molina.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Xiomi Redmi");
        celular.setDescricao("Muito legal");
        celular.setPreco(new BigDecimal("800"));

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("loja");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }

}
