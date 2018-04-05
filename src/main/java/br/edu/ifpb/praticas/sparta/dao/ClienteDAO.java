package br.edu.ifpb.praticas.sparta.dao;

import br.edu.ifpb.praticas.sparta.interfaces.Conexao;
import br.edu.ifpb.praticas.sparta.entidades.Cliente;
import com.datastax.driver.core.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements br.edu.ifpb.praticas.sparta.interfaces.ClienteDAO {

    private Conexao conexao;
    private Session session;

    public ClienteDAO() throws SQLException{
        session = (Session) conexao.novaConexao();
    }

    public void cadastrarCliente(int id, String nome) {
        try {
            conexao = (Conexao) new ClienteDAO();
            String cql = "INSERT INTO cliente (id, nome) VALUES (" + id + "," + nome + ");";
            session.execute(cql);
            conexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerCliente(int id) {
        try {
            conexao = (Conexao) new ClienteDAO();
            String cql = "DELETE FROM cliente WHERE id = " + id + ";";
            session.execute(cql);
            conexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente buscarCliente(String nome) {
    /*    conexao = (Conexao) new ClienteDAO();
        String cql = "SELECT * FROM cliente WHERE nome = " + nome + ";";
        List<Row> rs = session.execute(cql).all();
        int id = (int) rs.get(0);
        String nome = rs[1]; */
        return null;
    }

}
