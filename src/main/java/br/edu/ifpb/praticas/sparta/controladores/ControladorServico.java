/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.controladores;

import br.edu.ifpb.praticas.sparta.entidades.Servico;
import br.edu.ifpb.praticas.sparta.services.Service;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Named;

/**
 *
 * @author Sinbad Heinstein
 */
@Named
public class ControladorServico implements Serializable{
    
    private Servico servico;
    private Service serv;
    
    public void cadastroServico() throws SQLException{
        int cod = servico.getCodigo();
        int dur = servico.getDuracao();
        String cat = servico.getCategoria().toString();
        serv.cadastrarServico(cod, dur, cat);
    }
        
    public void excluiServico() throws SQLException{
        int cod = servico.getCodigo();
        serv.removerServico(cod);
    }
    
    public void buscaServico() throws SQLException{
        String tipo = servico.getCategoria().toString();
        List<Servico> servicos = serv.buscarServico(tipo);
    }
    
}
