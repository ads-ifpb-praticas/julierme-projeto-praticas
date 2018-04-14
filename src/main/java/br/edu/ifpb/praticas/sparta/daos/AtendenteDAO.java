package br.edu.ifpb.praticas.sparta.daos;

import br.edu.ifpb.praticas.sparta.interfaces.Conexao;
import br.edu.ifpb.praticas.sparta.entidades.Atendente;
import com.datastax.driver.core.Session;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import javax.enterprise.context.RequestScoped;
import javax.persistence.PersistenceContext;

@RequestScoped
public class AtendenteDAO implements br.edu.ifpb.praticas.sparta.interfaces.AtendenteDAO{

    @PersistenceContext()
    private Conexao conexao;
    private Session session;

    public AtendenteDAO() throws SQLException {
        session = (Session) conexao.novaConexao();
    }

    public void cadastrarAtendente(int matricula, String nome, Date atendimento, Time hora_chegada, Time hora_saida) throws SQLException {
        conexao = (Conexao) new AtendenteDAO();
        String cql = "INSERT INTO atendente (matricula,nome,atendimento,hora_chegada,hora_saida)"
                + " VALUES (" + matricula + "," + nome + "," + atendimento + "," + hora_chegada + "," + hora_saida + ");";
        session.execute(cql);
        conexao.fecharConexao();
    }

    public void removerAtendente(int matricula) throws SQLException {
        conexao = (Conexao) new AtendenteDAO();
        String cql = "DELETE FROM atendente WHERE matricula = " + matricula + ";";
        session.execute(cql);
        conexao.fecharConexao();
    }

    public Atendente buscarAtendente(String nome) throws SQLException {
     conexao = (Conexao) new AtendenteDAO();
     /*   String cql = "SELECT * FROM atendente WHERE nome = " + nome + ";";

        List<Row> rs = session.execute(cql).all();
        for (Row r:rs { r. }
        int matricula = (int) rs.get(0);
        String nome = rs[1]; */
     conexao.fecharConexao();
     return null;
    }

}
