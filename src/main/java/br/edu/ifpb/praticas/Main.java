/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas;

import br.edu.ifpb.praticas.sparta.daos.ClienteDAO;
import java.sql.SQLException;

/**
 *
 * @author Sinbad Heinstein
 */
public class Main {
        
    public static void main(String[] args) throws SQLException{
        ClienteDAO c = new ClienteDAO();
        c.cadastrarCliente("Julierme", "julierme@me.com");
    }
    
}
