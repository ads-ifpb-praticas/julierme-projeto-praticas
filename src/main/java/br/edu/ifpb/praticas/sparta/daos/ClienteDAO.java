package br.edu.ifpb.praticas.sparta.daos;

import br.edu.ifpb.praticas.sparta.interfaces.Conexao;
import com.datastax.driver.core.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.PersistenceContext;

@RequestScoped
public class ClienteDAO implements br.edu.ifpb.praticas.sparta.interfaces.ClienteDAO {

    @PersistenceContext()
    private Conexao conexao;
    private Session session;

    public ClienteDAO() throws SQLException{
        session = (Session) conexao.novaConexao();
    }

    public void cadastrarCliente(int id, String nome, String email) {
        try {
            conexao = (Conexao) new ClienteDAO();
            String cql = "INSERT INTO cliente (id, nome, email) VALUES (" + id + "," + nome + "," + email + ");";
            session.execute(cql);
            conexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerCliente(String email) {
        try {
            conexao = (Conexao) new ClienteDAO();
            String cql = "DELETE FROM cliente WHERE email = " + email + ";";
            session.execute(cql);
            conexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Row> buscarCliente(String nome) {
        try {
            conexao = (Conexao) new ClienteDAO();
            String cql = "SELECT * FROM cliente WHERE nome = " + nome + ";";
            List<Row> clientes = session.execute(cql).all();
            conexao.fecharConexao();
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }

}
