/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.controladores;

import br.edu.ifpb.praticas.sparta.entidades.Atendente;
import br.edu.ifpb.praticas.sparta.interfaces.daos.Controlador;
import br.edu.ifpb.praticas.sparta.interfaces.services.AtendenteServece;
import br.edu.ifpb.praticas.sparta.services.AtendenteService;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sinbad Heinstein
 */
@Named
@SessionScoped
public class ControladorAtendente implements Controlador,Serializable{
    
    @Inject
    @AtendenteServece
    private AtendenteService service;
    @Inject
    private Atendente atende;
    
    public String cadastroAtendente() throws SQLException{
        int mat = atende.getMatricula();
        String nome = atende.getNome();
        Date data = atende.getAtendimento();
        Time chegada = atende.getHora_chegada();
        Time saida = atende.getHora_saida();
        service.cadastrarAtendente(mat, nome, data, chegada, saida);
        return "index?faces-redirect=true";
    }
    
    public String excluiAtendente() throws SQLException{
        int mat = atende.getMatricula();
        service.removerAtendente(mat);
        return "index?faces-redirect=true";
    }
    
    public List<Atendente> buscarAtendente() throws SQLException{
        String nome = atende.getNome();
        return service.buscarAtendente(nome);
    }
    
    public List<Atendente> listaAtendentes() throws SQLException{
        return service.listarAtendentes();
    }
    
    public Atendente getAtendente(){
        return atende;
    }
    
    public void setAtendente(Atendente atendente){
        this.atende = atendente;
    }
    
    public String fazLogin(){
        boolean logado = service.logar();
        if (logado == true){ return "caos"; }
        return "index";
    }
    
}
