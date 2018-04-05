package br.edu.ifpb.praticas.sparta.entidades;

public class Agenda {

    private int atendente;
    private int atendimento;

    public Agenda(){ }

    public Agenda(int atendente, int atendimento){
        this.atendente = atendente;
        this.atendimento = atendimento;
    }

    public int getAtendente() {return atendente;}
    public void setAtendente(int atendente) {this.atendente = atendente;}
    public int getAtendimento() {return atendimento;}
    public void setAtendimento(int atendimento) {this.atendimento = atendimento;}

}
