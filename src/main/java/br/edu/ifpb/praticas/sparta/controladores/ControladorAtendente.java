/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.controladores;

import br.edu.ifpb.praticas.sparta.interfaces.Controlador;
import br.edu.ifpb.praticas.sparta.services.AtendenteService;
import java.io.Serializable;
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
    
    public String fazerLogin(){
        boolean logado = service.logar();
        if (logado == true){ return "caos"; }
        return "index";
    }
    
}
