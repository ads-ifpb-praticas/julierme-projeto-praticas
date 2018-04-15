/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.controladores;

import br.edu.ifpb.praticas.sparta.entidades.Cliente;
import br.edu.ifpb.praticas.sparta.interfaces.daos.Controlador;
import br.edu.ifpb.praticas.sparta.interfaces.services.ClienteServece;
import br.edu.ifpb.praticas.sparta.services.ClienteService;
import java.io.Serializable;
import java.sql.SQLException;
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
    @ClienteServece
    private ClienteService service;
    @Inject
    private Cliente cliente;
    
    public String cadastroCliente() throws SQLException{
        int id = cliente.getId();
        String nome = cliente.getNome();
        String email = cliente.getEmail();
        service.add(id, nome, email);
        return "index?faces-redirect=true";
    }
    
    public String excluiCliente() throws SQLException{
        String email = cliente.getEmail();
        service.remove(email);
        return "index?faces-redirect=true";
    }
    
    public void buscaCliente() throws SQLException{
        String nome = cliente.getNome();
        List<Cliente> clientes = service.buscar(nome);
    }
    
    public void listaClientes() throws SQLException { List<Cliente> clientes = service.listar(); }
    
    public String fazLogin() {
        boolean logado = service.logar();
        if (logado == true){ return "caos"; }
        return "index";
    }
    
}
