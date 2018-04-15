/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.services;

import br.edu.ifpb.praticas.sparta.entidades.Categoria;
import br.edu.ifpb.praticas.sparta.entidades.Servico;
import br.edu.ifpb.praticas.sparta.interfaces.daos.ServicoDAO;
import br.edu.ifpb.praticas.sparta.interfaces.services.Servece;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sinbad Heinstein
 */
@Servece
public class Service {
    
    private ServicoDAO servicodao;
    
    public void cadastrarServico(int atendente, int duracao, String categoria)  throws SQLException{ servicodao.cadastrarServico(atendente,duracao, categoria); }
    public void removerServico(long codigo)  throws SQLException{ servicodao.removerServico(codigo); }
    public List<Servico> buscarServico(String tipo)  throws SQLException{
        ResultSet list = servicodao.buscarServico(tipo);
        List<Servico> servicos = new ArrayList();
        while(list.next()){
            long cod = list.getLong("codigo");
            int atendente = list.getInt("atendente");
            int duracao = list.getInt("duracao");
            Categoria cat = list.getObject("categoria", Categoria.class);
            Servico s = new Servico(cod,atendente,duracao,cat);
            servicos.add(s);
        }
        return servicos;
    }
    public List<Servico> listarServicos()  throws SQLException{
        ResultSet list = servicodao.servicosCadastrados();
        List<Servico> servicos = new ArrayList();
        while(list.next()){
            long cod = list.getLong("codigo");
            int atendente = list.getInt("atendente");
            int duracao = list.getInt("duracao");
            Categoria cat = list.getObject("categoria", Categoria.class);
            Servico s = new Servico(cod,atendente,duracao,cat);
            servicos.add(s);
        }
        return servicos;
    }
    
}
