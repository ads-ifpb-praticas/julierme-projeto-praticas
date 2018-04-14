package br.edu.ifpb.praticas.sparta.entidades;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Atendimento {

    @Id
    @GeneratedValue
    private int codigo;
    private int cliente;
    private int tiposervico;
    private Date data;
    private Time horario;
    private boolean confirmado;

    public Atendimento(){ }

    public Atendimento(int codigo, int cliente, int tiposervico, Date data, Time horario, boolean confirmado){
        this.codigo = codigo;
        this.cliente = cliente;
        this.tiposervico = tiposervico;
        this.data = data;
        this.horario = horario;
        this.confirmado = confirmado;
    }

    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    public int getCliente() {return cliente;}
    public void setCliente(int cliente) {this.cliente = cliente;}
    public int getTipoServico() { return tiposervico; }
    public void setTipoServico(int tiposervico) { this.tiposervico = tiposervico; }
    public Date getData() {return data;}
    public void setData(Date data) {this.data = data;}
    public Time getHorario() {return horario;}
    public void setHorario(Time horario) {this.horario = horario;}
    public boolean isConfirmado() {return confirmado;}
    public void setConfirmado(boolean confirmado) {this.confirmado = confirmado;}

}
