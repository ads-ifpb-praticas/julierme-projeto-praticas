package br.edu.ifpb.praticas.sparta.dao;

import br.edu.ifpb.praticas.sparta.interfaces.Conexao;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.Session;
import java.sql.SQLException;

public class Cassandra implements Conexao {

    private Cluster cluster;

    public Session novaConexao() throws SQLException {
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        return cluster.connect("spartan");
/*        PoolingOptions poolingOptions = cluster.getConfiguration().getPoolingOptions().;
        return cluster.connect("spartan"); */
    }

    public void fecharConexao() throws SQLException { cluster.close(); }

}
