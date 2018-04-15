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
public class Pesquisa implements Serializable{

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, unique = true)
    private int atendimento;
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean respondido;
    private float nota;

    public Pesquisa(){ }

    public Pesquisa(int id, int atendimento, boolean respondido, float nota){
        this.id = id;
        this.atendimento = atendimento;
        this.respondido = respondido;
        this.nota = nota;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getAtendimento() {return atendimento;}
    public void setAtendimento(int atendimento) {this.atendimento = atendimento;}
    public boolean isRespondido() {return respondido;}
    public void setRespondido(boolean respondido) {this.respondido = respondido;}
    public float getNota() {return nota;}
    public void setNota(float nota) {this.nota = nota;}

}
