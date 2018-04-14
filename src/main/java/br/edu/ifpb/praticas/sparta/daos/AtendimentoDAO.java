package br.edu.ifpb.praticas.sparta.daos;

import br.edu.ifpb.praticas.sparta.interfaces.Conexao;
import com.datastax.driver.core.Session;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.PersistenceContext;

@RequestScoped
public class AtendimentoDAO implements br.edu.ifpb.praticas.sparta.interfaces.AtendimentoDAO {

    @PersistenceContext()
    private Conexao conexao;
    private Session session;

    public AtendimentoDAO() throws SQLException{
        session = (Session) conexao.novaConexao();
    }

    public int agendar(int atentente, int cliente, int tipo, Date data, Time horario) {
        try {
            conexao = (Conexao) new AtendimentoDAO();
            String cql = "INSERT INTO agendamento (matricula,id,tipo,data,horario)"
                    + " VALUES (" + atentente + "," + cliente + "," + tipo + "," + data + "," + horario + ");";
            session.execute(cql);
            conexao.fecharConexao();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return 0;
    }

    public int cancelar(int cliente, Date data, Time horario) {
        try {
            conexao = (Conexao) new AtendimentoDAO();
            String cql = "DELETE FROM agendamento WHERE id = " + cliente + " AND data = " + data + "AND horario = " + horario + ";";
            session.execute(cql);
            conexao.fecharConexao();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return 0;
    }

}
