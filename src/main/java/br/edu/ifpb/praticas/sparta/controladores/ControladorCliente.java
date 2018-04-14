/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.controladores;

import br.edu.ifpb.praticas.sparta.entidades.Cliente;
import br.edu.ifpb.praticas.sparta.interfaces.Controlador;
import br.edu.ifpb.praticas.sparta.services.ClienteService;
import java.io.Serializable;
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
public class ControladorCliente implements Controlador,Serializable{
    
    @Inject
    private ClienteService service;
    private Cliente cliente;
    
    public void cadastroCliente(){
        int id = cliente.getId();
        String nome = cliente.getNome();
        String email = cliente.getEmail();
        service.add(id, nome, email);
    }
    
    public void excluiCliente(){
        String email = cliente.getEmail();
        service.remove(email);
    }
    
    public void buscaCliente(){
        String nome = cliente.getNome();
        List<Cliente> clientes = service.buscar(nome);
    }
    
    public String fazLogin() {
        boolean logado = service.logar();
        if (logado == true){ return "caos"; }
        return "index";
    }
    
}
