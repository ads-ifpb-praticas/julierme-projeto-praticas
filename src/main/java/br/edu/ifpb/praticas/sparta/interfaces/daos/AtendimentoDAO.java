package br.edu.ifpb.praticas.sparta.interfaces.daos;

import com.datastax.driver.core.Row;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface AtendimentoDAO {

    public int agendar(int atentente, int cliente, int tipo, Date data, Time horario);
    public int cancelar(int cliente, Date data, Time horario);
    public List<Row> listarAgendamentos(int matricula);

}
