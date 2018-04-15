package br.edu.ifpb.praticas.sparta.interfaces.daos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;

public interface AtendimentoDAO {

    public int agendar(int atentente, int cliente, int tipo, Date data, Time horario);
    public int cancelar(int cliente, Date data, Time horario);
    public ResultSet listarAgendamentos(int matricula);

}
