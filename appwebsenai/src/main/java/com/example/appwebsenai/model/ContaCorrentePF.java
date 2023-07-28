package com.example.appwebsenai.model;

import javax.persistence.*;

@Entity
@Table(name = "conta")
public class ContaCorrentePF{

    @Id
    @Column(name="numero_conta")
    private Long numeroConta;

    //private Person pessoa;

    private Double saldo;

    @OneToOne
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    /*public Person getPessoa() {
        return pessoa;
    }

    public void setPessoa(Person pessoa) {
        this.pessoa = pessoa;
    }*/

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
