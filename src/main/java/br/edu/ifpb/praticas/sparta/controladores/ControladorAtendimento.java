/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.controladores;

import br.edu.ifpb.praticas.sparta.entidades.Atendimento;
import br.edu.ifpb.praticas.sparta.services.AtendimentoService;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.inject.Named;

/**
 *
 * @author Sinbad Heinstein
 */
@Named
public class ControladorAtendimento implements Serializable{
    
    private AtendimentoService service;
    private Atendimento atend;
    
    public void agendamento(){
        int cod = atend.getCodigo();
        int cliente = atend.getCliente();
        int tipo = atend.getTipoServico();
        Date data = atend.getData();
        Time hora = atend.getHorario();
        service.agendar(cliente, cliente, tipo, data, hora);
    }
    
    public void cancelamento(){
        int cliente = atend.getCliente();
        Date data = atend.getData();
        Time hora = atend.getHorario();
        service.cancelar(cliente, data, hora);
    }
    
}
