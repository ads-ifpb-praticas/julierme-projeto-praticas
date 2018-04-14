package br.edu.ifpb.praticas.sparta.interfaces;

import br.edu.ifpb.praticas.sparta.entidades.Cliente;
import java.util.List;

public interface ClienteDAO {

    public void cadastrarCliente(int id, String nome, String email);
    public void removerCliente(String email);
    public List<Cliente> buscarCliente(String nome);

}
