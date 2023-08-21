package com.example.appwebsenai.view;

import com.example.appwebsenai.controller.BancoController;
import com.example.appwebsenai.model.AccountType;
import com.example.appwebsenai.model.ContaCorrentePF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;                   //------------

import javax.websocket.server.PathParam;

@RestController
public class BancoView {

    @Autowired
    private BancoController bancoController;


    @PostMapping("/criarconta")
    public ContaCorrentePF criarConta(@PathParam("name") String name, @PathParam("type") String type) throws Exception {
        return bancoController.criarConta(name, type);
    }

    @DeleteMapping("/banco")                                                        //-------
    public void delete(@PathParam("name") String name){
        bancoController.delete(name);
    }

    @GetMapping("/type")
    public String listAccountType(){
        String text = AccountType.CONTA_CORRENTE + ", " + AccountType.CONTA_POUPANCA;
        return text;
    }

    @GetMapping("/consultarconta")
    public ContaCorrentePF consultaConta(@PathParam("name") String name) {
        return bancoController.consultaConta(name);
    }

    @PutMapping("/transferir")
    public String transferir(@PathParam("contaOrigem") Long contaOrigem, @PathParam("contaDestino") Long contaDestino, @PathParam("valor") Double valor){
        return bancoController.transferir(contaOrigem, contaDestino, valor);
    }

    @PutMapping("/depositar")
    public String depositar(@PathParam("conta") Long conta, @PathParam("valor") Double valor){
        return bancoController.depositar(valor, conta);
    }

    @PutMapping("/sacar")
    public String sacar(@PathParam("conta") Long conta, @PathParam("valor") Double valor){
        return bancoController.sacar(valor, conta);
    }

    @GetMapping("/extrato")
        public String consultarSaldo(@PathParam("conta") Long conta){
            return bancoController.consultarSaldo(conta);
        }
}

