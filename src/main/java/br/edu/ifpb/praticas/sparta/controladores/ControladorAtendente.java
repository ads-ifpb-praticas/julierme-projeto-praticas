/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.controladores;

import br.edu.ifpb.praticas.sparta.entidades.Atendente;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sinbad Heinstein
 */
@Named
@SessionScoped
public class ControladorAtendente implements Serializable{
    
    @Inject
    private Atendente funcionario;
    private Atendente ativo;

    public Atendente getFuncionario() { return funcionario; }
    public void setFuncionario(Atendente funcionario) { this.funcionario = funcionario; }
    public Atendente getAtivo() { return ativo; }
    public void setAtivo(Atendente ativo) { this.ativo = ativo; }

    public String fazerLogin(){
        return "home";
    }
    
}
