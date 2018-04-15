/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.services;

import br.edu.ifpb.praticas.sparta.entidades.Cliente;
import br.edu.ifpb.praticas.sparta.interfaces.ClienteDAO;
import com.datastax.driver.core.Row;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Sinbad Heinstein
 */
@RequestScoped
public class ClienteService {
    
    private ClienteDAO clientedao;
    
    public void add(int id, String nome, String email) throws SQLException{ clientedao.cadastrarCliente(id,nome,email); }
    public void remove(String email)  throws SQLException{ clientedao.removerCliente(email); }
    public List<Cliente> buscar(String nome)  throws SQLException{
        List<Row> list = clientedao.buscarCliente(nome);
        List<Cliente> clientes = new ArrayList();
        int total = list.size();
        for(int i = 1; i <= total; i++){
            Cliente c = (Cliente) list.get(i);
            clientes.add(c);
        }
        return clientes;
    }
    public boolean logar(){ return true; }
    
}
