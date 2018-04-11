/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.objneg;

import br.edu.ifpb.praticas.sparta.entidades.Atendente;
import br.edu.ifpb.praticas.sparta.interfaces.AtendenteDAO;
import javax.enterprise.context.RequestScoped;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sinbad Heinstein
 */
@RequestScoped
public class AtendenteService {
    
    private AtendenteDAO atendao;
    
    public void cadastrarAtendente(int matricula, String nome, Date atendimento, Time hora_chegada, Time hora_saida){ try {
        atendao.cadastrarAtendente(matricula, nome, atendimento, hora_chegada, hora_saida);
        } catch (SQLException ex) {
            Logger.getLogger(AtendenteService.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public void removerAtendente(int matricula){ try {
        atendao.removerAtendente(matricula);
        } catch (SQLException ex) {
            Logger.getLogger(AtendenteService.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public Atendente buscarAtendente(String nome){
        try {
            return atendao.buscarAtendente(nome);
        } catch (SQLException ex) {
            Logger.getLogger(AtendenteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
