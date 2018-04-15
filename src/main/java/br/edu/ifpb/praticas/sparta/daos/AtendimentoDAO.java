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
public class AtendimentoDAO implements br.edu.ifpb.praticas.sparta.interfaces.daos.AtendimentoDAO {

    @PersistenceContext()
    private Conexao conexao;
    @PersistenceContext()
    private Session session;
    private Gerador gera;

    public AtendimentoDAO() throws SQLException{
        session = (Session) conexao.novaConexao();
    }

    public int agendar(int atentente, int cliente, int tipo, Date data, Time horario) {
        try {
            conexao = (Conexao) new AtendimentoDAO();
            long codigo = gera.gerarCod();
            String cql = "INSERT INTO Atendimento (id, matricula,id,tipo,data,horario)"
                    + " VALUES (" + codigo + atentente + "," + cliente + "," + tipo + "," + data + "," + horario + ",true);";
            session.execute(cql);
            conexao.fecharConexao();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return 0;
    }
    
    public int cancelar(int cliente, Date data, Time horario) {
        try {
            conexao = (Conexao) new AtendimentoDAO();
            String cql = "Update Atendimento SET confirmado = false WHRE cliente = " + cliente + " AND data = " + data + " AND horario = " + horario +";";
            session.execute(cql);
            conexao.fecharConexao();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return 0;
    }
    
    public int confirmar(int cliente, Date data, Time horario){
        try {
            conexao = (Conexao) new AtendimentoDAO();
            String cql = "Update Atendimento SET confirmado = true WHRE cliente = " + cliente + " AND data = " + data + " AND horario = " + horario +";";
            session.execute(cql);
            conexao.fecharConexao();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return 0;
    }

    public List<Row> listarAgendamentos(int matricula) {
        try {
            conexao = (Conexao) new ClienteDAO();
            String cql = "SELECT cliente,tipo,data,horario FROM Atendimento a,Servico s " 
                    + "WHERE a.tipo = s.categoria AND a.atendente = " + matricula + " AND a.confirmado = true;";
            List<Row> clientes = session.execute(cql).all();
            conexao.fecharConexao();
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }

}
