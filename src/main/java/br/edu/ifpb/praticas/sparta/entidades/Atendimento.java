package br.edu.ifpb.praticas.sparta.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sinbad Heinstein
 */
@Entity
public class Atendimento implements Serializable {

    @Id
    @GeneratedValue
    private int codigo;
    @Column(nullable = false)
    private int cliente;
    @Column(nullable = false)
    private int atendente;
    @Column(nullable = false)
    private int tiposervico;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;
    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Time horario;
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean confirmado;

    public Atendimento(){ }

    public Atendimento(int codigo, int cliente, int atendente, int tiposervico, Date data, Time horario, boolean confirmado){
        this.codigo = codigo;
        this.cliente = cliente;
        this.atendente = atendente;
        this.tiposervico = tiposervico;
        this.data = data;
        this.horario = horario;
        this.confirmado = confirmado;
    }

    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    public int getCliente() {return cliente;}
    public void setCliente(int cliente) {this.cliente = cliente;}
    public int getAtendente() {return atendente;}
    public void setAtendente(int atendente) {this.atendente = atendente;}   
    public int getTipoServico() { return tiposervico; }
    public void setTipoServico(int tiposervico) { this.tiposervico = tiposervico; }
    public Date getData() {return data;}
    public void setData(Date data) {this.data = data;}
    public Time getHorario() {return horario;}
    public void setHorario(Time horario) {this.horario = horario;}
    public boolean isConfirmado() {return confirmado;}
    public void setConfirmado(boolean confirmado) {this.confirmado = confirmado;}

}
