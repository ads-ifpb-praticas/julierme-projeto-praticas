package br.edu.ifpb.praticas.sparta.entidades;

public class Servico {

    private int codigo;
    private String tipo;
    private int duracao;
    private String categoria;

    public Servico(){ }

    public Servico(int codigo, String tipo, int duracao, String categoria){
        this.codigo = codigo;
        this.tipo = tipo;
        this.duracao = duracao;
        this.categoria = categoria;
    }

    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}
    public int getDuracao() {return duracao;}
    public void setDuracao(int duracao) {this.duracao = duracao;}
    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}

}