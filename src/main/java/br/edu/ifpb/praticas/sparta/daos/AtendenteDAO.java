package br.edu.ifpb.praticas.sparta.daos;

import br.edu.ifpb.praticas.sparta.interfaces.Conexao;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.PersistenceContext;

@RequestScoped
public class AtendenteDAO implements br.edu.ifpb.praticas.sparta.interfaces.AtendenteDAO{

    @PersistenceContext()
    private Conexao conexao;
    private Session session;

    public AtendenteDAO() throws SQLException {
        session = (Session) conexao.novaConexao();
    }

    public void cadastrarAtendente(int matricula, String nome, Date atendimento, Time hora_chegada, Time hora_saida) throws SQLException {
        try{
            conexao = (Conexao) new AtendenteDAO();
            String cql = "INSERT INTO atendente (matricula,nome,atendimento,hora_chegada,hora_saida)"
                + " VALUES (" + matricula + "," + nome + "," + atendimento + "," + hora_chegada + "," + hora_saida + ");";
            session.execute(cql);
            conexao.fecharConexao();
        } catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerAtendente(int matricula) throws SQLException {
        try{
            conexao = (Conexao) new AtendenteDAO();
            String cql = "DELETE FROM atendente WHERE matricula = " + matricula + ";";
            session.execute(cql);
            conexao.fecharConexao();
        } catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Row> buscarAtendente(String nome) throws SQLException {
        try{
            conexao = (Conexao) new AtendenteDAO();
            String cql = "SELECT * FROM atendente WHERE nome = " + nome + ";";
            List<Row> atendentes = session.execute(cql).all();
            conexao.fecharConexao();
            return atendentes;
        } catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }
    
}
