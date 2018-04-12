/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas;

/**
 *
 * @author Sinbad Heinstein
 */
public class Pessoa {
    
    private String nome;

    public Pessoa() {
    }
    
    public Pessoa(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
