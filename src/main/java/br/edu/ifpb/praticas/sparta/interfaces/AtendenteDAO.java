package br.edu.ifpb.praticas.sparta.interfaces;

import com.datastax.driver.core.Row;
import java.sql.Date;
import java.sql.Time;
import java.sql.SQLException;
import java.util.List;

public interface AtendenteDAO{

    public void cadastrarAtendente(int matricula, String nome, Date atendimento, Time hora_chegada, Time hora_saida) throws SQLException;
    public void removerAtendente(int matricula) throws SQLException;
    public List<Row> buscarAtendente(String nome) throws SQLException;

}
