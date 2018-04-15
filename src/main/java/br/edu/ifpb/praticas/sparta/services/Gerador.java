/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.services;

import java.util.Random;

/**
 *
 * @author Sinbad Heinstein
 */
public class Gerador {
    
    private int id;
    private long cod;
    private int matricula;
    
    public long gerarCod(){
        Random random = new Random();
        cod = random.nextLong();
        return cod;
    }
    
    public int gerarID(){
        Random random = new Random();
        id = random.nextInt();
        return id;
    }
    
    public int gerarMatricula(){
        Random random = new Random();
        id = random.nextInt();
        matricula = random.nextInt(id);
        return matricula;
    }
}
