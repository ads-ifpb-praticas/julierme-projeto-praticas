/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.controladores;

import br.edu.ifpb.praticas.sparta.entidades.Pesquisa;
import br.edu.ifpb.praticas.sparta.services.PesquisaService;
import java.io.Serializable;
import javax.inject.Named;

/**
 *
 * @author Sinbad Heinstein
 */
@Named
public class ControladorPesquisa implements Serializable{
    
    private PesquisaService service;
    private Pesquisa pesquisa;
    
    public void fazPesquisa(){
        int id = pesquisa.getId();
        int atend = pesquisa.getAtendimento();
        boolean respondido = pesquisa.isRespondido();
        float nota = pesquisa.getNota();
        service.pesquisaRealizada(id, atend, respondido, nota);
    }
    
}
