/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabiocarneiro.gerenciabanco.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Fabio Carneiro
 */
public class Bank {

    private Client client;
    private List<String> movimentacao = new ArrayList<>();
    private int saldoEmConta;
    private Scanner sc = new Scanner(System.in);

    public void registrarCliente() {
        System.out.print("Informe seu nome:\n[comando]: ");
        String nomeCliente = this.sc.nextLine();

        System.out.print("Informe o sobrenome:\n[comando]: ");
        String sobrenomeCliente = this.sc.nextLine();

        System.out.print("Informe o CPF:\n[comando]: ");
        String cpfCliente = this.sc.nextLine();

        try {
            this.client = new Client(nomeCliente, sobrenomeCliente, cpfCliente);

            System.out.printf(
                    "Cliente %s %s cadastrado com sucesso\n",
                    nomeCliente,
                    sobrenomeCliente);

            this.movimentacao.add("Cadastrou no sistema.");
        } catch (Exception e) {
            System.out.printf(
                    "Cliente %s %s não cadastrado.",
                    nomeCliente,
                    sobrenomeCliente);
        }
    }

    public void mostrarMovimentacao() {
        for (String movimento : this.movimentacao) {
            System.out.printf("Movimento: %s\n", movimento);
        }
    }

    public void fazerSaque() {
        System.out.print("Informe a quantia para fazer saque:\n[comando]: ");
        int quantiaSaque = sc.nextInt();

        if (quantiaSaque - this.saldoEmConta > 0) {
            System.out.println("Só pode fazer saque de quantias que você tem na conta");
            System.out.printf(
                    "Saldo atual: R$%d\n",
                    this.saldoEmConta);

        } else {
            this.saldoEmConta -= quantiaSaque;
            System.out.printf("Saque de %d efetuado com sucesso!\n", quantiaSaque);
            System.out.printf(
                    "saldo atual de R$%d\n",
                    this.saldoEmConta);

            this.movimentacao.add(String.format("Sacou da conta R$ %d.", quantiaSaque));
        }
    }

    public void consultaSaldo() {
        System.out.printf("Saldo atual de: R$%d\n", this.saldoEmConta);
        this.movimentacao.add("Realizou consulta de saldo");
    }

    public void fazerDeposito() {
        System.out.print("Informe a quantia para deposito:\n[comando]: ");
        int quantiaDeposito = sc.nextInt();
        if (quantiaDeposito <= 0) {
            System.out.println("A quantida de depósito precis ser maior que R$0.");
        } else {
            this.saldoEmConta += quantiaDeposito;
            System.out.printf("Desposito na quantia de R$%d realizado com sucesso\n", quantiaDeposito);
            this.movimentacao.add(String.format("Deposito na quantia de R$%d.", quantiaDeposito));
        }
    }

    public String finalizarSistema() {
        System.out.printf("Sistema finalizado, até breve %s!\n", this.client.getNome());
        return "sair";
    }

}
