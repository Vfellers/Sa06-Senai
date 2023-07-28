package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.Conta;
import com.example.appwebsenai.model.ContaCorrentePF;
import com.example.appwebsenai.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BancoController implements ContaCorrente{

    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private Controller controller;

    private Long number = 0L;

    @Override
    public Double sacar(Double quantidade, Conta conta) {
        return null;
    }


    public ContaCorrentePF criarConta(String name) throws Exception {
        ContaCorrentePF contaCorrentePF = new ContaCorrentePF();
        number++;
        contaCorrentePF.setNumeroConta(number);
        Person person = controller.findPerson(name);
        if (person != null){
            contaCorrentePF.setPerson(person);
            bancoRepository.save(contaCorrentePF);
        }else{
            throw new Exception("Pessoa não está cadastrada.");
        }
        return contaCorrentePF;
    }

    public ContaCorrentePF consultaConta(String name){

        List<ContaCorrentePF> contas = (List<ContaCorrentePF>) bancoRepository.findAll();
        for(ContaCorrentePF cc : contas){
            if(cc.getPerson() != null && cc.getPerson().getName().equals(name)){
                return cc;
            }
        }
        return null;
    }

    @Override
    public void depositar(Double quantidade, Conta conta) {
        Double total = conta.getSaldo() + quantidade;
        conta.setSaldo(total);
    }

    @Override
    public void transferir(Double quantidade, Conta conta) {

    }

    @Override
    public Double consultaSaldo(ContaCorrentePF conta) {
        return conta.getSaldo();
    }
}
