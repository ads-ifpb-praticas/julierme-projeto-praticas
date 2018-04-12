/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.services;

import br.edu.ifpb.praticas.sparta.entidades.Cliente;
import br.edu.ifpb.praticas.sparta.interfaces.ClienteDAO;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Sinbad Heinstein
 */
@RequestScoped
public class ClienteService {
    
    private ClienteDAO clientedao;
    
    public void add(int id, String nome, String email){ clientedao.cadastrarCliente(id,nome,email); }
    public void remove(String email){ clientedao.removerCliente(email); }
    public Cliente buscar(String nome) { return clientedao.buscarCliente(nome); }
    public boolean logar(){ return true; }
    
}
