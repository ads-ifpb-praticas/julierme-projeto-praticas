package br.edu.ifpb.praticas.sparta.daos;

import br.edu.ifpb.praticas.sparta.interfaces.Conexao;
import br.edu.ifpb.praticas.sparta.interfaces.Cassandra;
import br.edu.ifpb.praticas.sparta.services.Gerador;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sinbad Heinstein
 */
@Cassandra
public class ServicoDAO implements br.edu.ifpb.praticas.sparta.interfaces.daos.ServicoDAO {

    @PersistenceContext()
    private Conexao conexao;
    @PersistenceContext()
    private Session session;
    private Gerador gera;
    
    public ServicoDAO() throws SQLException{
        session = (Session) conexao.novaConexao();
    }

    public void cadastrarServico(int atendente, int duracao, String categoria) {
        try {
            conexao = (Conexao) new ServicoDAO();
            long codigo = gera.gerarCod();
            String cql = "INSERT INTO Servico (codigo,atendente,duracao,categoria)"
                    + " VALUES (" + codigo + "," + atendente + "," + duracao + "," + categoria + ");";
            session.execute(cql);
            conexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerServico(long codigo) {
        try {
            conexao = (Conexao) new ServicoDAO();
            String cql = "DELETE FROM Servico WHERE codigo = " + codigo + ";";
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

    public List<Row> servicosCadastrados() {
        try {
            conexao = (Conexao) new ServicoDAO();
            String cql = "SELECT * FROM Servico;";
            List<Row> servicos = session.execute(cql).all();
            return servicos;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }
    
}
