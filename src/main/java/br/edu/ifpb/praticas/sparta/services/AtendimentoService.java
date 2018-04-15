/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.services;

import br.edu.ifpb.praticas.sparta.entidades.Agenda;
import br.edu.ifpb.praticas.sparta.interfaces.daos.AtendimentoDAO;
import br.edu.ifpb.praticas.sparta.interfaces.services.AtendimentoServece;
import com.datastax.driver.core.Row;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sinbad Heinstein
 */
@AtendimentoServece
public class AtendimentoService {
    
    private AtendimentoDAO atendidao;
    
    public boolean agendar (int atentente, int cliente, int tipo, Date data, Time horario)  throws SQLException{
        int ver = atendidao.agendar(atentente, cliente, tipo, data, horario);
        if(ver == 1){ return true; }
        return false;
    }
    
    public boolean cancelar(int cliente, Date data, Time horario)  throws SQLException{
        int ver = atendidao.cancelar(cliente, data, horario);
        if(ver == 1){ return true; }
        return false;
    }
    
    public List<Agenda> listar(int matricula)  throws SQLException{
        List<Row> list = atendidao.listarAgendamentos(matricula);
        List<Agenda> atends = new ArrayList();
        int total = list.size();
        for(int i = 1; i <= total; i++){
            Agenda a = (Agenda) list.get(i);
            atends.add(a);
        }
        return atends;
    }
    
}
