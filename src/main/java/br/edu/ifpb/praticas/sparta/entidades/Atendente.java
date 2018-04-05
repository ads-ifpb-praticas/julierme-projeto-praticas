package br.edu.ifpb.praticas.sparta.entidades;

import java.sql.Date;
import java.sql.Time;

public class Atendente {

    private int matricula;
    private String nome;
    private Date atendimento;
    private Time hora_chegada;
    private Time hora_saida;

    public Atendente(){ }

    public Atendente(int matricula, String nome, Date atendimento, Time hora_chegada, Time hora_saida){
        this.matricula = matricula;
        this.nome = nome;
        this.atendimento = atendimento;
        this.hora_chegada = hora_chegada;
        this.hora_saida = hora_saida;
    }

    public int getMatricula() {return matricula;}
    public void setMatricula(int matricula) {this.matricula = matricula;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public Date getAtendimento() {return atendimento;}
    public void setAtendimento(Date atendimento) {this.atendimento = atendimento;}
    public Time getHora_chegada() {return hora_chegada;}
    public void setHora_chegada(Time hora_chegada) {this.hora_chegada = hora_chegada;}
    public Time getHora_saida() {return hora_saida;}
    public void setHora_saida(Time hora_saida) {this.hora_saida = hora_saida;}

}
