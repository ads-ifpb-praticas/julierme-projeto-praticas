/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.interfaces.daos;

/**
 *
 * @author Sinbad Heinstein
 */
public interface PesquisaDAO {
    
    public int realizarPesquisa(long atendimento, boolean respondido, float nota);
        
}
