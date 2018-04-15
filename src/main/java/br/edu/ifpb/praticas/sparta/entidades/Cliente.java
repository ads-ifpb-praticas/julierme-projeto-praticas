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
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;

    public Cliente(){ }
    
    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public Cliente(int id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

}
