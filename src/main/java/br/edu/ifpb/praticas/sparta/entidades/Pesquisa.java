package br.edu.ifpb.praticas.sparta.entidades;

public class Pesquisa {

    private int id;
    private boolean respondido;
    private float nota;

    public Pesquisa(){ }

    public Pesquisa(int id, boolean respondido, float nota){
        this.id = id;
        this.respondido = respondido;
        this.nota = nota;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public boolean isRespondido() {return respondido;}
    public void setRespondido(boolean respondido) {this.respondido = respondido;}
    public float getNota() {return nota;}
    public void setNota(float nota) {this.nota = nota;}

}
