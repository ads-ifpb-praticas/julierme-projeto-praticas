package br.edu.ifpb.praticas.sparta.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sinbad Heinstein
 */
@Entity
public class Atendente implements Serializable {

    @Id
    @GeneratedValue
    private int matricula;
    @Column(nullable = false)
    private String nome;
    @Temporal(TemporalType.DATE)
    @Column(length = 70, nullable = false)
    private Date atendimento;
    @Temporal(TemporalType.TIME)
    @Column(length = 70, nullable = false)
    private Time hora_chegada;
    @Temporal(TemporalType.TIME)
    @Column(length = 70, nullable = false)
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
