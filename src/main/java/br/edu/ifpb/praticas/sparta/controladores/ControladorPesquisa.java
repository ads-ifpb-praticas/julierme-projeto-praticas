/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.controladores;

import br.edu.ifpb.praticas.sparta.entidades.Pesquisa;
import br.edu.ifpb.praticas.sparta.interfaces.services.PesquisaServece;
import br.edu.ifpb.praticas.sparta.services.PesquisaService;
import java.io.Serializable;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sinbad Heinstein
 */
@Named
@RequestScoped
public class ControladorPesquisa implements Serializable{
    
    @Inject
    @PesquisaServece
    private PesquisaService service;
    @Inject
    private Pesquisa pesquisa;
    
    public void fazPesquisa() throws SQLException{
        long atend = pesquisa.getAtendimento();
        boolean respondido = pesquisa.isRespondido();
        float nota = pesquisa.getNota();
        service.pesquisaRealizada(atend, respondido, nota);
    }
    
}
