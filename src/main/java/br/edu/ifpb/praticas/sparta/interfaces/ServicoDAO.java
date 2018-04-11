package br.edu.ifpb.praticas.sparta.interfaces;

import br.edu.ifpb.praticas.sparta.entidades.Servico;

public interface ServicoDAO {

    public void cadastrarServico(int codigo, int duracao, String categoria);
    public void removerServico(int id);
    public Servico buscarServico(String tipo);

}
