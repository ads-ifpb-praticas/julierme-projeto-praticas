package br.edu.ifpb.praticas.sparta.interfaces.daos;

import com.datastax.driver.core.Row;
import java.util.List;

public interface ClienteDAO {

    public void cadastrarCliente(int id, String nome, String email);
    public void removerCliente(String email);
    public List<Row> buscarCliente(String nome);
    public List<Row> clientesCadastrados();

}
