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
    private long id;
    @Column(nullable = false, unique = true)
    private long atendimento;
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean respondido;
    private float nota;

    public Pesquisa(){ }

    public Pesquisa(long id, long atendimento, boolean respondido, float nota){
        this.id = id;
        this.atendimento = atendimento;
        this.respondido = respondido;
        this.nota = nota;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public long getAtendimento() {return atendimento;}
    public void setAtendimento(long atendimento) {this.atendimento = atendimento;}
    public boolean isRespondido() {return respondido;}
    public void setRespondido(boolean respondido) {this.respondido = respondido;}
    public float getNota() {return nota;}
    public void setNota(float nota) {this.nota = nota;}

}
