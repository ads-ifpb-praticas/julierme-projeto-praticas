/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.services;

import br.edu.ifpb.praticas.sparta.entidades.Servico;
import br.edu.ifpb.praticas.sparta.interfaces.ServicoDAO;
import java.util.List;

/**
 *
 * @author Sinbad Heinstein
 */
public class Service {
    
    private ServicoDAO servicodao;
    
    public void cadastrarServico(int codigo, int duracao, String categoria){
        servicodao.cadastrarServico(codigo, duracao, categoria);
    }
    public void removerServico(int codigo){
        servicodao.removerServico(codigo);
    }
    public List<Servico> buscarServico(String tipo){
        /* servicodao.buscarServico(tipo); */
        return null;
    }
    
}
