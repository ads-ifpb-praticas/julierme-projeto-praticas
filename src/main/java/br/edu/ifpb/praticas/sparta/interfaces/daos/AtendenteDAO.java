package br.edu.ifpb.praticas.sparta.interfaces.daos;

import com.datastax.driver.core.Row;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface AtendenteDAO{

    public void cadastrarAtendente(String nome, Date atendimento, Time hora_chegada, Time hora_saida);
    public void removerAtendente(int matricula);
    public List<Row> buscarAtendente(String nome);
    public List<Row> atendentesCadastrados();

}
