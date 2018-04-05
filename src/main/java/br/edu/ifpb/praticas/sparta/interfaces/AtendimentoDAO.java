package br.edu.ifpb.praticas.sparta.interfaces;

import java.sql.Date;
import java.sql.Time;

public interface AtendimentoDAO {

    public void agendar(int atentente, int cliente, String tipo, Date data, Time horario);
    public void cancelar(int cliente);

}
