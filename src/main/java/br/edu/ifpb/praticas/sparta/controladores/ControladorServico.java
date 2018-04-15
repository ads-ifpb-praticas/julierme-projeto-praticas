/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.controladores;

import br.edu.ifpb.praticas.sparta.entidades.Servico;
import br.edu.ifpb.praticas.sparta.interfaces.services.Servece;
import br.edu.ifpb.praticas.sparta.services.Service;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sinbad Heinstein
 */
@Named
@RequestScoped
public class ControladorServico implements Serializable{

    @Inject
    @Servece
    private Servico servico;
    @Inject
    private Service serv;
    
    public String cadastroServico() throws SQLException{
        int cod = servico.getCodigo();
        int dur = servico.getDuracao();
        String cat = servico.getCategoria().toString();
        serv.cadastrarServico(cod, dur, cat);
        return "index?faces-redirect=true";
    }
        
    public String excluiServico() throws SQLException{
        int cod = servico.getCodigo();
        serv.removerServico(cod);
        return "index?faces-redirect=true";
    }
    
    public void buscaServico() throws SQLException{
        String tipo = servico.getCategoria().toString();
        List<Servico> servicos = serv.buscarServico(tipo);
    }
    
    public void listaServicos() throws SQLException{ List<Servico> servicos = serv.listarServicos(); }
    
    public Servico getServico(){ return servico; }
    
    public void setServico(Servico s){ this.servico = s; }
    
}
