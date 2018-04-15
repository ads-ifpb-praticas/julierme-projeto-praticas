package br.edu.ifpb.praticas.sparta.daos;

import br.edu.ifpb.praticas.sparta.interfaces.Conexao;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.PersistenceContext;

@RequestScoped
public class ServicoDAO implements br.edu.ifpb.praticas.sparta.interfaces.ServicoDAO {

    @PersistenceContext()
    private Conexao conexao;
    private Session session;

    public ServicoDAO() throws SQLException{
        session = (Session) conexao.novaConexao();
    }

    public void cadastrarServico(int codigo, int duracao, String categoria) {
        try {
            conexao = (Conexao) new ServicoDAO();
            String cql = "INSERT INTO atendente (codigo,duracao,categoria)"
                    + " VALUES (" + codigo + "," + duracao + "," + categoria + ");";
            session.execute(cql);
            conexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerServico(int id) {
        try {
            conexao = (Conexao) new ServicoDAO();
            String cql = "DELETE FROM servico WHERE id = " + id + ";";
            session.execute(cql);
            conexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Row> buscarServico(String categoria) {
        try {
            conexao = (Conexao) new ServicoDAO();
            String cql = "SELECT * FROM servico WHERE tipo = " + categoria + ";";
            List<Row> servicos = session.execute(cql).all();
            return servicos;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }
    
}
