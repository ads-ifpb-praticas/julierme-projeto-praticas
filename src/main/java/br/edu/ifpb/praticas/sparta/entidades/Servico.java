package br.edu.ifpb.praticas.sparta.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Sinbad Heinstein
 */
@Entity
public class Servico implements Serializable{

    @Id
    @GeneratedValue
    private int codigo;
    @Column(nullable = false)
    private int duracao;
    @Column(nullable = false)
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