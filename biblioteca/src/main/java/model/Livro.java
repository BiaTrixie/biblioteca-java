package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Livro")
public class Livro {
    @Id
    @Column(name = "Titulo")
    private String Titulo;
    @Column(name = "Autor")
    private String Autor;
    @Column(name = "Ano")
    private int Ano;
    @Column(name = "Nota")
    private int Nota;
    @Column(name = "Categoria")
    private String Categoria;
    @Column(name ="SubCategoria")
    private String SubCategoria;

    public Livro() {}

    public Livro(String titulo, String autor, int ano, int nota, String categoria, String subCategoria) {
        Titulo = titulo;
        Autor = autor;
        Ano = ano;
        this.Nota = nota;
        this.Categoria = categoria;
        SubCategoria = subCategoria;
    }
    
    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
    public String getAutor() {
        return Autor;
    }
    public void setAutor(String autor) {
        Autor = autor;
    }
    public int getAno() {
        return Ano;
    }
    public void setAno(int ano) {
        Ano = ano;
    }
    public int getNota() {
        return Nota;
    }
    public void setNota(int nota) {
        this.Nota = nota;
    }
    public String getCategoria() {
        return Categoria;
    }
    public void setCategoria(String categoria) {
        this.Categoria = categoria;
    }
    public String getSubCategoria() {
        return SubCategoria;
    }
    public void setSubCategoria(String subCategoria) {
        SubCategoria = subCategoria;
    }

    
}
