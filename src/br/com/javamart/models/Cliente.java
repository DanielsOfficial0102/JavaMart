package br.com.javamart.models;

import java.time.LocalDate;
public class Cliente extends Pessoa {
    private double saldo;

    public Cliente(String nome, String endereco, String telefone, String email, LocalDate dataNascimento, String senha) {
        super(nome, endereco, telefone, email, dataNascimento, senha);
        this.saldo = 100;
    }

    public void addSaldo(double saldo) {
        saldo += saldo;
    }
    public void removeSaldo(double saldo) { saldo -= saldo; }
    public double getSaldo() {
        return this.saldo;
    }
}
