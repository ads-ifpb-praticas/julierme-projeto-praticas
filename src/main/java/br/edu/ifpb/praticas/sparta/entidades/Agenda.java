/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.entidades;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Sinbad Heinstein
 */
public class Agenda {
    
    private String cliente;
    private Categoria tipo;
    private Date data;
    private Time horario;
    
    public Agenda(){ }
    
    public Agenda(String cliente, Categoria tipo, Date data, Time horario){
        this.cliente = cliente;
        this.tipo = tipo;
        this.data = data;
        this.horario = horario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Categoria getTipo() {
        return tipo;
    }

    public void setTipo(Categoria tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }
    
}
