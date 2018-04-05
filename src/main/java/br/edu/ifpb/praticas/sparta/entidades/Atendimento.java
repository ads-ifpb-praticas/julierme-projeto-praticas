package br.edu.ifpb.praticas.sparta.entidades;

import java.sql.Date;
import java.sql.Time;

public class Atendimento {

    private int codigo;
    private int cliente;
    private String tipo;
    private Date data;
    private Time horario;
    private boolean confirmado;

    public Atendimento(){ }

    public Atendimento(int codigo, int cliente, String tipo, Date data, Time horario, boolean confirmado){
        this.codigo = codigo;
        this.cliente = cliente;
        this.tipo = tipo;
        this.data = data;
        this.horario = horario;
        this.confirmado = confirmado;
    }

    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    public int getCliente() {return cliente;}
    public void setCliente(int cliente) {this.cliente = cliente;}
    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}
    public Date getData() {return data;}
    public void setData(Date data) {this.data = data;}
    public Time getHorario() {return horario;}
    public void setHorario(Time horario) {this.horario = horario;}
    public boolean isConfirmado() {return confirmado;}
    public void setConfirmado(boolean confirmado) {this.confirmado = confirmado;}

}
