/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.services;

import br.edu.ifpb.praticas.sparta.interfaces.daos.PesquisaDAO;
import br.edu.ifpb.praticas.sparta.interfaces.services.PesquisaServece;
import java.sql.SQLException;

/**
 *
 * @author Sinbad Heinstein
 */
@PesquisaServece
public class PesquisaService {
    
    private PesquisaDAO pesquisadao;
    
    public boolean pesquisaRealizada(long atendimento, boolean respondido, float nota)  throws SQLException{
        int ver = pesquisadao.realizarPesquisa(atendimento, respondido, nota);
        if(ver == 1){ return true; }
        return false;
    }
    
}
