package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.Conta;
import com.example.appwebsenai.model.ContaCorrentePF;

public interface ContaCorrente {

    Double sacar(Double quantidade, Conta conta);

    void depositar(Double quantidade, Conta conta);

    void transferir(Double quantidade, Conta conta);

    Double consultaSaldo(ContaCorrentePF conta);
}
