/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sinbad Heinstein
 */
@Entity
public class Agenda implements Serializable {
    
    @Id
    private int id;
    @Column(nullable = false)
    private String cliente;
    @Column(nullable = false)
    private Categoria tipo;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;
    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Time horario;
    
    public Agenda(){ }
    
    public Agenda(String cliente, Categoria tipo, Date data, Time horario){
        this.cliente = cliente;
        this.tipo = tipo;
        this.data = data;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
