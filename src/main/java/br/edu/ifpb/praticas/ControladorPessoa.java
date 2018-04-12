/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Sinbad Heinstein
 */
@Named
@ViewScoped
public class ControladorPessoa implements Serializable {
    private Pessoa pessoa = new Pessoa();
    
    private List<Pessoa> pessoas = new LinkedList<Pessoa>();
    
    public void cadastrar() {
        pessoas.add(pessoa);
        pessoa = new Pessoa();
    }
    // Gets e sets

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
}
