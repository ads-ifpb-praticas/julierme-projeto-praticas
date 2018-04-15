/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.services;

import br.edu.ifpb.praticas.sparta.entidades.Cliente;
import br.edu.ifpb.praticas.sparta.interfaces.daos.ClienteDAO;
import br.edu.ifpb.praticas.sparta.interfaces.services.ClienteServece;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sinbad Heinstein
 */
@ClienteServece
public class ClienteService {
    
    private ClienteDAO clientedao;
    
    public void add(String nome, String email) throws SQLException{
        clientedao.cadastrarCliente(nome,email);
        System.out.println("cadastro realizado com sucesso");
    }
    public void remove(String email)  throws SQLException{ clientedao.removerCliente(email); }
    public List<Cliente> listar()  throws SQLException{
        ResultSet list = clientedao.clientesCadastrados();
        List<Cliente> clientes = new ArrayList();
        while(list.next()){
            int id = list.getInt("id");
            String nome = list.getString("cliente");
            String email = list.getString("email");
            Cliente c = new Cliente(id,nome,email);
            clientes.add(c);
        }
        return clientes;
    }
    public List<Cliente> buscar(String nome)  throws SQLException{
        ResultSet list = clientedao.buscarCliente(nome);
        List<Cliente> clientes = new ArrayList();
        while(list.next()){
            int id = list.getInt("id");
            String name = list.getString("cliente");
            String email = list.getString("email");
            Cliente c = new Cliente(id,name,email);
            clientes.add(c);
        }
        return clientes;
    }
    public boolean logar(){ return true; }
    
}
