package br.edu.ifpb.praticas.sparta.daos;

import br.edu.ifpb.praticas.sparta.interfaces.Conexao;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import java.sql.SQLException;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Sinbad Heinstein
 */
public class Cassandra implements Conexao {

    private Cluster cluster;

    @Produces
    public Session novaConexao() throws SQLException {
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        return cluster.connect("spartan");
    }

    @Produces
    public void fecharConexao() throws SQLException { cluster.close(); }

}
