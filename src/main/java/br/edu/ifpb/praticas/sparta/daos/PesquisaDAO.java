/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.daos;

import br.edu.ifpb.praticas.sparta.interfaces.Postgresql;
import br.edu.ifpb.praticas.sparta.services.Gerador;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sinbad Heinstein
 */
@Postgresql
public class PesquisaDAO implements br.edu.ifpb.praticas.sparta.interfaces.daos.PesquisaDAO{
    
    @PersistenceContext()
    private Postgres con;
    @PersistenceContext()
    private Statement stat;
    private Gerador gera;

    public PesquisaDAO() throws SQLException{
        stat = con.conexao().createStatement();
    }

    public int realizarPesquisa(long atendimento, boolean respondido, float nota) throws NullPointerException{
        try {
            long id = gera.gerarCod();
            String sql = "INSERT INTO Pesquisa (id,atendimento,respondido,nota) VALUES (" + id + "," + atendimento + "," + respondido + "," + nota + ");";
            stat.execute(sql);
            con.fecharConexao();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return 0;
    }
    
}
