/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.objneg;

import br.edu.ifpb.praticas.sparta.interfaces.PesquisaDAO;

/**
 *
 * @author Sinbad Heinstein
 */
public class PesquisaService {
    
    private PesquisaDAO pesquisadao;
    
    public boolean pesquisaRealizada(int id, int atendimento, boolean respondido, float nota){
        
        int ver = pesquisadao.realizarPesquisa(id, atendimento, respondido, nota);
        if(ver == 1){ return true; }
        return false;
        
    }
    
}
