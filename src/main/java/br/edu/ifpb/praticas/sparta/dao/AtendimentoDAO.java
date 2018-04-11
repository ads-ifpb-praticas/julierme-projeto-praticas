package br.edu.ifpb.praticas.sparta.dao;

import br.edu.ifpb.praticas.sparta.interfaces.Conexao;
import com.datastax.driver.core.Session;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtendimentoDAO implements br.edu.ifpb.praticas.sparta.interfaces.AtendimentoDAO {

    private Conexao conexao;
    private Session session;

    public AtendimentoDAO() throws SQLException{
        session = (Session) conexao.novaConexao();
    }

    public void agendar(int atentente, int cliente, String tipo, Date data, Time horario) {
        try {
            conexao = (Conexao) new AtendimentoDAO();
            String cql = "INSERT INTO agendamento (matricula,id,tipo,data,horario)"
                    + " VALUES (" + atentente + "," + cliente + "," + tipo + "," + data + "," + horario + ");";
            session.execute(cql);
            conexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cancelar(int cliente) {
        try {
            conexao = (Conexao) new AtendimentoDAO();
            String cql = "DELETE FROM agendamento WHERE id = " + cliente + ";";
            session.execute(cql);
            conexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
