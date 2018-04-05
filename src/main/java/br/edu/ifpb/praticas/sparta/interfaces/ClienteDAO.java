package br.edu.ifpb.praticas.sparta.interfaces;

import br.edu.ifpb.praticas.sparta.entidades.Cliente;

public interface ClienteDAO {

    public void cadastrarCliente(int id, String nome);
    public void removerCliente(int id);
    public Cliente buscarCliente(String nome);

}
