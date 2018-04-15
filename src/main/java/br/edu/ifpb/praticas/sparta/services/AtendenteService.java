/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.services;

import br.edu.ifpb.praticas.sparta.entidades.Atendente;
import br.edu.ifpb.praticas.sparta.interfaces.daos.AtendenteDAO;
import br.edu.ifpb.praticas.sparta.interfaces.services.AtendenteServece;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sinbad Heinstein
 */
@AtendenteServece
public class AtendenteService{
    
    private AtendenteDAO atendao;
    
    public void cadastrarAtendente(String nome, Date atendimento, Time hora_chegada, Time hora_saida) throws SQLException{
        atendao.cadastrarAtendente(nome, atendimento, hora_chegada, hora_saida);
    }
    
    public void removerAtendente(int matricula) throws SQLException{ atendao.removerAtendente(matricula); }
    
    public List<Atendente> listarAtendentes() throws SQLException{
        ResultSet list = atendao.atendentesCadastrados();
        List<Atendente> atends = new ArrayList();
        while(list.next()){
            int matricula = list.getInt("matricula");
            String nome = list.getString("nome");
            Date atendimento = list.getDate("atendimento");
            Time chegada = list.getTime("hora_chegada");
            Time saida = list.getTime("hora_saida");
            Atendente a = new Atendente(matricula,nome,atendimento,chegada,saida);
            atends.add(a);
        }
        return atends;
    }
    
    public List<Atendente> buscarAtendente(String nome) throws SQLException{
        ResultSet list = atendao.buscarAtendente(nome);
        List<Atendente> atends = new ArrayList();
        while(list.next()){
            int matricula = list.getInt("matricula");
            String name = list.getString("nome");
            Date atendimento = list.getDate("atendimento");
            Time chegada = list.getTime("hora_chegada");
            Time saida = list.getTime("hora_saida");
            Atendente a = new Atendente(matricula,name,atendimento,chegada,saida);
            atends.add(a);
        }
        return atends;
    }
    
    public boolean logar(){
        return true;
    }
    
}
