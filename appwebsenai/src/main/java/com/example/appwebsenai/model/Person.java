package com.example.appwebsenai.model;


import javax.persistence.*;                   //--------

@Entity
public class Person {

    @Id
    private Integer id;

    private String name;

    private String sexo;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)             //------
    private ContaCorrentePF contaCorrentePF;

    public ContaCorrentePF getContaCorrentePF() {
        return contaCorrentePF;
    }

    public void setContaCorrentePF(ContaCorrentePF contaCorrentePF) {
        this.contaCorrentePF = contaCorrentePF;                           //-------
    }


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
