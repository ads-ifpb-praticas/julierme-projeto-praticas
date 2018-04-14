package br.edu.ifpb.praticas.sparta.interfaces;

import br.edu.ifpb.praticas.sparta.entidades.Servico;
import java.util.List;

public interface ServicoDAO {

    public void cadastrarServico(int codigo, int duracao, String categoria);
    public void removerServico(int id);
    public List<Servico> buscarServico(String tipo);

}
