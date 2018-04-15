/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.testes.unitario;

import br.edu.ifpb.praticas.sparta.controladores.ControladorAtendente;
import br.edu.ifpb.praticas.sparta.controladores.ControladorServico;
import br.edu.ifpb.praticas.sparta.entidades.Categoria;
import br.edu.ifpb.praticas.sparta.entidades.Servico;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
/**
 *
 * @author Sinbad Heinstein
 */
public class TestarServicos {
    
    private ControladorServico a;
    private ControladorAtendente b;
    private Categoria c;
    
    @Test
    public void testarServicos() throws SQLException{
        Servico s = new Servico(1,15, c.BARBA);
        assertEquals("index?faces-redirect=true",a.cadastroServico());
    }
    
    public void testarServicosAtendente() throws SQLException{
        Servico s = new Servico(1,15, c.BARBA);
        assertEquals("index?faces-redirect=true",a.cadastroServico());
        s = new Servico(1,15, c.BARBA);
        assertNull(a.cadastroServico());
        s = new Servico(1,100, c.CORTEMASCULINO);
        assertEquals("index?faces-redirect=true",a.cadastroServico());
    }
    
}
