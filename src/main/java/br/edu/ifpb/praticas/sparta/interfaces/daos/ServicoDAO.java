package br.edu.ifpb.praticas.sparta.interfaces.daos;

import com.datastax.driver.core.Row;
import java.util.List;

public interface ServicoDAO {

    public void cadastrarServico(int atendente, int duracao, String categoria);
    public void removerServico(long codigo);
    public List<Row> buscarServico(String categoria);
    public List<Row> servicosCadastrados();

}
