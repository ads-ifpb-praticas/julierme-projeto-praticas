package br.edu.ifpb.praticas.sparta.interfaces.daos;

import java.sql.ResultSet;

public interface ClienteDAO {

    public void cadastrarCliente(String nome, String email);
    public void removerCliente(String email);
    public ResultSet buscarCliente(String nome);
    public ResultSet clientesCadastrados();

}
