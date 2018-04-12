/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.services;

import br.edu.ifpb.praticas.sparta.interfaces.AtendimentoDAO;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Sinbad Heinstein
 */
public class AtendimentoService {
    
    private AtendimentoDAO atendidao;
    
    public boolean agendar (int atentente, int cliente, String tipo, Date data, Time horario){
        int ver = atendidao.agendar(atentente, cliente, tipo, data, horario);
        if(ver == 1){ return true; }
        else{ return false; }
    }
    
    public boolean cancelar(int cliente, Date data, Time horario){
        int ver = atendidao.cancelar(cliente, data, horario);
        if(ver == 1){ return true; }
        else{ return false; }
    }
    
}
