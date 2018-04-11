package br.edu.ifpb.praticas.sparta.interfaces;

import java.sql.Date;
import java.sql.Time;

public interface AtendimentoDAO {

    public int agendar(int atentente, int cliente, String tipo, Date data, Time horario);
    public int cancelar(int cliente, Date data, Time horario);

}
