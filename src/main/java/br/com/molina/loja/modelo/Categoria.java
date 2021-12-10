package br.com.molina.loja.modelo;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "categorias")
public class Categoria {

    @EmbeddedId
    private CategoriaId id;
    public Categoria() {
    }

    public Categoria(String nome) {
        this.id = new CategoriaId(nome,"xpto");
    }

    public String getNome() {
        return this.id.getNome();
    }


}
