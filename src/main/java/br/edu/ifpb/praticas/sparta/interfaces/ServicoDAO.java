package br.edu.ifpb.praticas.sparta.interfaces;

import com.datastax.driver.core.Row;
import java.util.List;

public interface ServicoDAO {

    public void cadastrarServico(int codigo, int duracao, String categoria);
    public void removerServico(int id);
    public List<Row> buscarServico(String categoria);

}
