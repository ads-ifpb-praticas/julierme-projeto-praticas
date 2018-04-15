package br.edu.ifpb.praticas.sparta.interfaces.daos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;

public interface AtendenteDAO{

    public void cadastrarAtendente(String nome, Date atendimento, Time hora_chegada, Time hora_saida);
    public void removerAtendente(int matricula);
    public ResultSet buscarAtendente(String nome);
    public ResultSet atendentesCadastrados();

}
