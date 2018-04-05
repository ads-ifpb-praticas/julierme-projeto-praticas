package br.edu.ifpb.praticas.sparta.interfaces;

import com.datastax.driver.core.Session;
import java.sql.SQLException;

public interface Conexao {

    public Session novaConexao() throws SQLException;
    public void fecharConexao() throws SQLException;

}
