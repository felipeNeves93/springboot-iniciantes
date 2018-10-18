package com.example.demo.Pessoa;

public class Pessoa {

    private Integer id;
    private String nome;
    private String sobrenome;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa(Integer id, String nome, String sobrenome) {
        super();
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Pessoa(){
        super();
    }
}
