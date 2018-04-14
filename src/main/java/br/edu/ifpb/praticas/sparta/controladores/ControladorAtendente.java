/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.controladores;

import br.edu.ifpb.praticas.sparta.entidades.Atendente;
import br.edu.ifpb.praticas.sparta.interfaces.Controlador;
import br.edu.ifpb.praticas.sparta.services.AtendenteService;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Sinbad Heinstein
 */
@Named
@SessionScoped
public class ControladorAtendente implements Controlador,Serializable{
    
    private AtendenteService service;
    private Atendente atende;
    
    public void cadastroAtendente(){
        int mat = atende.getMatricula();
        String nome = atende.getNome();
        Date data = atende.getAtendimento();
        Time chegada = atende.getHora_chegada();
        Time saida = atende.getHora_saida();
        service.cadastrarAtendente(mat, nome, data, chegada, saida);
    }
    
    public void excluiAtendente(){
        int mat = atende.getMatricula();
        service.removerAtendente(mat);
    }
    
    public String fazLogin(){
        boolean logado = service.logar();
        if (logado == true){ return "caos"; }
        return "index";
    }
    
}
