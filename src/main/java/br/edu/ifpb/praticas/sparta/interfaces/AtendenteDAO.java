package br.edu.ifpb.praticas.sparta.interfaces;

import br.edu.ifpb.praticas.sparta.entidades.Atendente;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public interface AtendenteDAO{

    public void cadastrarAtendente(int matricula, String nome, Date atendimento, Time hora_chegada, Time hora_saida) throws SQLException;
    public void removerAtendente(int matricula) throws SQLException;
    public Atendente buscarAtendente(String nome) throws SQLException;

}
