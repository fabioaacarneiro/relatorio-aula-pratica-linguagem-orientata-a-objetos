/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.fabiocarneiro.gerenciabanco;

import com.fabiocarneiro.gerenciabanco.entities.Bank;
import java.util.Scanner;

/**
 *
 * @author Fabio Carneiro
 */
public class GerenciaBanco {

    public void showMenu() {

        System.out.println("Escolha entre as opções a baixo:");
        System.out.println("saque, deposito, movimentacao,\nsaldo, cadastrar, sair, ajuda");
        System.out.println("digite a opção desejada corretamente.");
    }

    public static void main(String[] args) {

        Bank bankMoney = new Bank();
        GerenciaBanco gb = new GerenciaBanco();
        String opc = "";
        Scanner sc = new Scanner(System.in);

        gb.showMenu();

        do {
            System.out.print("[comando]: ");
            opc = sc.nextLine();

            switch (opc) {
                case "saque" ->
                    bankMoney.fazerSaque();
                case "deposito" ->
                    bankMoney.fazerDeposito();
                case "movimentacao" ->
                    bankMoney.mostrarMovimentacao();
                case "saldo" ->
                    bankMoney.consultaSaldo();
                case "cadastrar" ->
                    bankMoney.registrarCliente();
                case "sair" ->
                    opc = bankMoney.finalizarSistema();
                case "ajuda" ->
                    gb.showMenu();
                default ->
                    System.out.println("Escolha uma opção correta.");
            }
        } while (opc != "sair");

        sc.close();
    }
}
