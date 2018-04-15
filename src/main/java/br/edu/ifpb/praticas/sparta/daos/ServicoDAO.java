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
public class ServicoDAO implements br.edu.ifpb.praticas.sparta.interfaces.daos.ServicoDAO {

    @PersistenceContext()
    private Postgres con;
    @PersistenceContext()
    private Statement stat;
    private Gerador gera;
    
    public ServicoDAO() throws SQLException{
        stat = con.conexao().createStatement();
    }

    public void cadastrarServico(int atendente, int duracao, String categoria) throws NullPointerException{
        try {
            long codigo = gera.gerarCod();
            String sql = "INSERT INTO Servico (codigo,atendente,duracao,categoria)"
                    + " VALUES (" + codigo + "," + atendente + "," + duracao + "," + categoria + ");";
            stat.execute(sql);
            con.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerServico(long codigo) throws NullPointerException{
        try {
            String sql = "DELETE FROM Servico WHERE codigo = " + codigo + ";";
            stat.execute(sql);
            con.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet buscarServico(String categoria) throws NullPointerException{
        try {
            String sql = "SELECT * FROM servico WHERE tipo = " + categoria + ";";
            ResultSet servicos = stat.executeQuery(sql);
            con.fecharConexao();
            return servicos;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }

    public ResultSet servicosCadastrados() throws NullPointerException{
        try {
            String sql = "SELECT * FROM Servico;";
            ResultSet servicos = stat.executeQuery(sql);
            con.fecharConexao();
            return servicos;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }
    
}
