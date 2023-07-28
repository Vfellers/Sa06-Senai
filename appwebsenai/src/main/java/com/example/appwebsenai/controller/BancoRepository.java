package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.Conta;
import com.example.appwebsenai.model.ContaCorrentePF;
import org.springframework.data.repository.CrudRepository;

public interface BancoRepository extends CrudRepository <ContaCorrentePF, Long> {
}
