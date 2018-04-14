package br.edu.ifpb.praticas.sparta.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Servico {

    @Id
    @GeneratedValue
    private int codigo;
    private String tipo;
    private int duracao;
    private Categoria categoria;

    public Servico(){ }

    public Servico(int codigo, int duracao, Categoria categoria){
        this.codigo = codigo;
        this.duracao = duracao;
        this.categoria = categoria;
    }

    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    public int getDuracao() {return duracao;}
    public void setDuracao(int duracao) {this.duracao = duracao;}
    public Categoria getCategoria() {return categoria;}
    public void setCategoria(Categoria categoria) {this.categoria = categoria;}

}