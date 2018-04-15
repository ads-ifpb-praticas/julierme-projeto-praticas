package br.edu.ifpb.praticas.sparta.interfaces.daos;

import java.sql.ResultSet;

public interface ServicoDAO {

    public void cadastrarServico(int atendente, int duracao, String categoria);
    public void removerServico(long codigo);
    public ResultSet buscarServico(String categoria);
    public ResultSet servicosCadastrados();

}
