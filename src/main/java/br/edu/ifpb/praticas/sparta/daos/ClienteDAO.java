package br.edu.ifpb.praticas.sparta.daos;

import br.edu.ifpb.praticas.sparta.interfaces.Postgresql;
import br.edu.ifpb.praticas.sparta.services.Gerador;
import java.sql.ResultSet;
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
public class ClienteDAO implements br.edu.ifpb.praticas.sparta.interfaces.daos.ClienteDAO {

    @PersistenceContext()
    private Postgres con;
    @PersistenceContext()
    private Statement stat;
    private Gerador gera;

    public ClienteDAO() throws SQLException{
        stat = con.conexao().createStatement();
    }

    public void cadastrarCliente(String nome, String email) throws NullPointerException{
        try {
            int id = gera.gerarID();
            String sql = "INSERT INTO Cliente (id, nome, email) VALUES (" + id + "," + nome + "," + email + ");";
            stat.execute(sql);
            con.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerCliente(String email) throws NullPointerException{
        try {
            String sql = "DELETE FROM Cliente WHERE email = " + email + ";";
            stat.execute(sql);
            con.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet buscarCliente(String nome) throws NullPointerException{
        try {
            String sql = "SELECT * FROM Cliente WHERE nome = " + nome + ";";
            ResultSet clientes = stat.executeQuery(sql);
            con.fecharConexao();
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }

    public ResultSet clientesCadastrados() throws NullPointerException{
        try {
            String sql = "SELECT * FROM Cliente;";
            ResultSet clientes = stat.executeQuery(sql);
            con.fecharConexao();
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }

}
