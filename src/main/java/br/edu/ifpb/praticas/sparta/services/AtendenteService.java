/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.services;

import br.edu.ifpb.praticas.sparta.entidades.Atendente;
import br.edu.ifpb.praticas.sparta.interfaces.AtendenteDAO;
import com.datastax.driver.core.Row;
import javax.enterprise.context.RequestScoped;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sinbad Heinstein
 */
@RequestScoped
public class AtendenteService {
    
    private AtendenteDAO atendao;
    
    public void cadastrarAtendente(int matricula, String nome, Date atendimento, Time hora_chegada, Time hora_saida) throws SQLException{
        atendao.cadastrarAtendente(matricula, nome, atendimento, hora_chegada, hora_saida);
    }
    
    public void removerAtendente(int matricula) throws SQLException{ atendao.removerAtendente(matricula); }
    
    public List<Atendente> buscarAtendente(String nome) throws SQLException{
        List<Row> list = atendao.buscarAtendente(nome);
        List<Atendente> atends = new ArrayList();
        int total = list.size();
        for(int i = 1; i <= total; i++){
            Atendente a = (Atendente) list.get(i);
            atends.add(a);
        }
        return atends;
    }
    
    public boolean logar(){
        return true;
    }
    
}
