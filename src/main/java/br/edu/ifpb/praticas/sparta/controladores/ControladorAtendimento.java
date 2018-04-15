/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.controladores;

import br.edu.ifpb.praticas.sparta.entidades.Agenda;
import br.edu.ifpb.praticas.sparta.entidades.Atendimento;
import br.edu.ifpb.praticas.sparta.interfaces.services.AtendimentoServece;
import br.edu.ifpb.praticas.sparta.services.AtendimentoService;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
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
public class ControladorAtendimento implements Serializable{
    
    @Inject
    @AtendimentoServece
    private AtendimentoService service;
    @Inject
    private Atendimento atend;
    
    public void agendamento() throws SQLException{
        long cod = atend.getCodigo();
        int cliente = atend.getCliente();
        int tipo = atend.getTipoServico();
        Date data = atend.getData();
        Time hora = atend.getHorario();
        service.agendar(cliente, cliente, tipo, data, hora);
    }
    
    public void cancelamento() throws SQLException{
        int cliente = atend.getCliente();
        Date data = atend.getData();
        Time hora = atend.getHorario();
        service.cancelar(cliente, data, hora);
    }
    
    public void agenda() throws SQLException{
        int atendente = atend.getAtendente();
        List<Agenda> agenda = service.listar(atendente);
    }
    
}
