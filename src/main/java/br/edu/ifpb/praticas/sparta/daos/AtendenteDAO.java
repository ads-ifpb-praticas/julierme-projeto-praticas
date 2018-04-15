package br.edu.ifpb.praticas.sparta.daos;

import br.edu.ifpb.praticas.sparta.interfaces.Conexao;
import br.edu.ifpb.praticas.sparta.interfaces.Cassandra;
import br.edu.ifpb.praticas.sparta.services.Gerador;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sinbad Heinstein
 */
@Cassandra
public class AtendenteDAO implements br.edu.ifpb.praticas.sparta.interfaces.daos.AtendenteDAO{

    @PersistenceContext()
    private Conexao conexao;
    @PersistenceContext()
    private Session session;
    private Gerador gera;
    
    public AtendenteDAO() throws SQLException {
        session = (Session) conexao.novaConexao();
    }

    public void cadastrarAtendente(String nome, Date atendimento, Time hora_chegada, Time hora_saida){
        try{
            conexao = (Conexao) new AtendenteDAO();
            int matricula = gera.gerarMatricula();
            String cql = "INSERT INTO Atendente (matricula,nome,atendimento,hora_chegada,hora_saida)"
                + " VALUES (" + matricula + "," + nome + "," + atendimento + "," + hora_chegada + "," + hora_saida + ");";
            session.execute(cql);
            conexao.fecharConexao();
        } catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerAtendente(int matricula){
        try{
            conexao = (Conexao) new AtendenteDAO();
            String cql = "DELETE FROM Atendente WHERE matricula = " + matricula + ";";
            session.execute(cql);
            conexao.fecharConexao();
        } catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Row> buscarAtendente(String nome){
        try{
            conexao = (Conexao) new AtendenteDAO();
            String cql = "SELECT * FROM Atendente WHERE nome = " + nome + ";";
            List<Row> atendentes = session.execute(cql).all();
            conexao.fecharConexao();
            return atendentes;
        } catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }
    
    public List<Row> atendentesCadastrados(){
        try{
            conexao = (Conexao) new AtendenteDAO();
            String cql = "SELECT * FROM Atendente;";
            List<Row> atendentes = session.execute(cql).all();
            conexao.fecharConexao();
            return atendentes;
        } catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }
    
}
