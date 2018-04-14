package br.edu.ifpb.praticas.sparta.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Agenda {

    @Id
    @GeneratedValue
    private int atendente ;
    @ManyToOne
    private List<Atendimento> atendimentos;

    public Agenda(){ }

    public Agenda(int atendente, List<Atendimento> atendimentos){
        this.atendente = atendente;
        this.atendimentos = atendimentos;
    }

    public int getAtendente() {return atendente;}
    public void setAtendente(int atendente) {this.atendente = atendente;}
    public List<Atendimento> getAtendimentos() {return atendimentos;}
    public void setAtendimentos(List<Atendimento> atendimentos) {this.atendimentos = atendimentos;}

}
