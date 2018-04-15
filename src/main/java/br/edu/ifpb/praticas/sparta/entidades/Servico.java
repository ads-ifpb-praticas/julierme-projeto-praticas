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
    private long codigo;
    @Column(nullable = false)
    private int atendente;
    @Column(nullable = false)
    private int duracao;
    @Column(nullable = false, unique = true)
    private Categoria categoria;

    public Servico(){ }
    
    public Servico(int atendente, int duracao, Categoria categoria){
        this.atendente = atendente;
        this.duracao = duracao;
        this.categoria = categoria;
    }

    public Servico(long codigo, int atendente, int duracao, Categoria categoria){
        this.codigo = codigo;
        this.atendente = atendente;
        this.duracao = duracao;
        this.categoria = categoria;
    }

    public long getCodigo() {return codigo;}
    public void setCodigo(long codigo) {this.codigo = codigo;}
    public int getAtendente() {return atendente;}
    public void setAtendente(int atendente) {this.atendente = atendente;}
    public int getDuracao() {return duracao;}
    public void setDuracao(int duracao) {this.duracao = duracao;}
    public Categoria getCategoria() {return categoria;}
    public void setCategoria(Categoria categoria) {this.categoria = categoria;}

}