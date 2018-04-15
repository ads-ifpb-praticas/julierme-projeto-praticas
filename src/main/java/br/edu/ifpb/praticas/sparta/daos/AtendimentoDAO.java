package br.edu.ifpb.praticas.sparta.daos;

import br.edu.ifpb.praticas.sparta.interfaces.Postgresql;
import br.edu.ifpb.praticas.sparta.services.Gerador;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sinbad Heinstein
 */
@Postgresql
public class AtendimentoDAO implements br.edu.ifpb.praticas.sparta.interfaces.daos.AtendimentoDAO {

    @PersistenceContext()
    private Postgres con;
    @PersistenceContext()
    private Statement stat;
    private Gerador gera;

    public AtendimentoDAO() throws SQLException{
        stat = con.conexao().createStatement();
    }

    public int agendar(int atentente, int cliente, int tipo, Date data, Time horario) throws NullPointerException{
        try {
            long codigo = gera.gerarCod();
            String sql = "INSERT INTO Atendimento (id, matricula,id,tipo,data,horario)"
                    + " VALUES (" + codigo + atentente + "," + cliente + "," + tipo + "," + data + "," + horario + ",true);";
            stat.execute(sql);
            con.fecharConexao();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return 0;
    }
    
    public int cancelar(int cliente, Date data, Time horario) throws NullPointerException{
        try {
            String sql = "Update Atendimento SET confirmado = false WHRE cliente = " + cliente + " AND data = " + data + " AND horario = " + horario +";";
            stat.execute(sql);
            con.fecharConexao();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return 0;
    }
    
    public int confirmar(int cliente, Date data, Time horario) throws NullPointerException{
        try {
            String sql = "Update Atendimento SET confirmado = true WHRE cliente = " + cliente + " AND data = " + data + " AND horario = " + horario +";";
            stat.executeUpdate(sql);
            con.fecharConexao();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return 0;
    }

    public ResultSet listarAgendamentos(int matricula) throws NullPointerException{
        try {
            String sql = "SELECT cliente,tipo,data,horario FROM Atendimento a,Servico s " 
                    + "WHERE a.tipo = s.categoria AND a.atendente = " + matricula + " AND a.confirmado = true;";
            ResultSet clientes = stat.executeQuery(sql);
            con.fecharConexao();
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }

}
