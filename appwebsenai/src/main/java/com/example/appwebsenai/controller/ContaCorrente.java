package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.Conta;
import com.example.appwebsenai.model.ContaCorrentePF;

public interface ContaCorrente {

    String sacar(Double valor, Long conta);

    String depositar(Double valor, Long conta);

    String transferir(Long contaOrigem, Long contaDestino, Double valor);

    String consultarSaldo(Long conta);

    String render(Double valor, Long conta);
}
