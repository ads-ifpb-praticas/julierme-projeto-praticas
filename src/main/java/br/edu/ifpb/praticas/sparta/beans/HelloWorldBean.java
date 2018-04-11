/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.beans;

import java.io.Serializable;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Sinbad Heinstein
 */
@Named("hello")
@RequestScoped
public class HelloWorldBean implements Serializable {
    
    private String name = "JH";
    
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
}
