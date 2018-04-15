/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sinbad Heinstein
 */
public class Postgres {
    
    private String url = "jdbc:postgresql://127.0.0.1:5432/sparta";
    private String user = "postgres";
    private String password = "avantasia";
    private Connection conn;
    
    public Connection conexao() throws SQLException{
        System.out.println("Conexao");
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    
    public void fecharConexao() throws SQLException{
        conn.close();
    }
    
}
