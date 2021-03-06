/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.daos;

import br.edu.ifpb.praticas.sparta.interfaces.Conexao;
import br.edu.ifpb.praticas.sparta.interfaces.Cassandra;
import br.edu.ifpb.praticas.sparta.services.Gerador;
import com.datastax.driver.core.Session;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sinbad Heinstein
 */
@Cassandra
public class PesquisaDAO implements br.edu.ifpb.praticas.sparta.interfaces.daos.PesquisaDAO{
    
    @PersistenceContext()
    private Conexao conexao;
    @PersistenceContext()
    private Session session;
    private Gerador gera;

    public PesquisaDAO() throws SQLException{
        session = (Session) conexao.novaConexao();
    }

    public int realizarPesquisa(long atendimento, boolean respondido, float nota) {
        try {
            conexao = (Conexao) new PesquisaDAO();
            long id = gera.gerarCod();
            String cql = "INSERT INTO Pesquisa (id,atendimento,respondido,nota) VALUES (" + id + "," + atendimento + "," + respondido + "," + nota + ");";
            session.execute(cql);
            conexao.fecharConexao();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return 0;
    }
    
}
