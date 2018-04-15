/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.testes.unitario;

import br.edu.ifpb.praticas.sparta.controladores.ControladorAtendente;
import br.edu.ifpb.praticas.sparta.controladores.ControladorCliente;
import br.edu.ifpb.praticas.sparta.entidades.Atendente;
import br.edu.ifpb.praticas.sparta.entidades.Cliente;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Sinbad Heinstein
 */
public class TestarCadastro {
    
    private ControladorAtendente a;
    private ControladorCliente b;
      
    @Test
    public void testeCadastroAtendente() throws SQLException{
        Atendente at = new Atendente("Fernando", Date.valueOf("2018-04-15"), Time.valueOf("08:00"), Time.valueOf("12:00"));
        assertEquals("index?faces-redirect=true", a.cadastroAtendente());
        
    }
    
    @Test
    public void testeCadastroCLiente() throws SQLException{
        Cliente cl = new Cliente("Justino", "justino@bol.com");
        assertEquals("index?faces-redirect=true", b.cadastroCliente());
    }
}
