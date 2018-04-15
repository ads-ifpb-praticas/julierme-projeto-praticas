package br.edu.ifpb.praticas.sparta.daos;

import br.edu.ifpb.praticas.sparta.services.Gerador;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceContext;
import br.edu.ifpb.praticas.sparta.interfaces.Postgresql;

/**
 *
 * @author Sinbad Heinstein
 */
@Postgresql
public class AtendenteDAO implements br.edu.ifpb.praticas.sparta.interfaces.daos.AtendenteDAO{

    @PersistenceContext()
    private Statement stat;
    @PersistenceContext()
    private Postgres con;
    private Gerador gera;
    
    public AtendenteDAO() throws SQLException {
        stat = con.conexao().createStatement();
    }

    public void cadastrarAtendente(String nome, Date atendimento, Time hora_chegada, Time hora_saida) throws NullPointerException{
        try{
            int matricula = gera.gerarMatricula();
            String sql = "INSERT INTO Atendente (matricula,nome,atendimento,hora_chegada,hora_saida)"
                + " VALUES (" + matricula + "," + nome + "," + atendimento + "," + hora_chegada + "," + hora_saida + ");";
            stat.execute(sql);
            con.fecharConexao();
        } catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerAtendente(int matricula) throws NullPointerException{
        try{
            String sql = "DELETE FROM Atendente WHERE matricula = " + matricula + ";";
            stat.execute(sql);
            con.fecharConexao();
        } catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet buscarAtendente(String nome) throws NullPointerException{
        try{
            String sql = "SELECT * FROM Atendente WHERE nome = " + nome + ";";
            ResultSet atendentes = stat.executeQuery(sql);
            con.fecharConexao();
            return atendentes;
        } catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }
    
    public ResultSet atendentesCadastrados() throws NullPointerException{
        try{
            String sql = "SELECT * FROM Atendente;";
            ResultSet atendentes = stat.executeQuery(sql);
            con.fecharConexao();
            return atendentes;
        } catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }
    
}
