package br.edu.ifpb.praticas.sparta.dao;

import br.edu.ifpb.praticas.sparta.interfaces.Conexao;
import br.edu.ifpb.praticas.sparta.entidades.Servico;
import com.datastax.driver.core.Session;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoDAO implements br.edu.ifpb.praticas.sparta.interfaces.ServicoDAO {

    private Conexao conexao;
    private Session session;

    public ServicoDAO() throws SQLException{
        session = (Session) conexao.novaConexao();
    }

    public void cadastrarServico(int codigo, String tipo, int duracao, String categoria) {
        try {
            conexao = (Conexao) new ServicoDAO();
            String cql = "INSERT INTO atendente (codigo,tipo,duracao,categoria)"
                    + " VALUES (" + codigo + "," + tipo + "," + duracao + "," + categoria + ");";
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

    public Servico buscarServico(String tipo) {
    /*    conexao = (Conexao) new ServicoDAO();
        String cql = "SELECT * FROM servico WHERE tipo = " + tipo + ";";
        List<Row> rs = session.execute(cql).all();
        int id = (int) rs.get(0);
        String nome = rs[1]; */
        return null;
    }
}
