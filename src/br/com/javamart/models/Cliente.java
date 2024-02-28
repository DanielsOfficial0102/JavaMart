package br.com.javamart.models;

import java.time.LocalDate;
public class Cliente extends Pessoa implements ClienteInterface {
    private double saldo;

    public Cliente(String nome, String endereco, String telefone, String email, LocalDate dataNascimento, String senha) {
        super(nome, endereco, telefone, email, dataNascimento, senha);
        this.saldo = 100;
    }

    public void addSaldo(double saldo) {
        this.saldo += saldo;
    }
    public void removeSaldo(double saldo) { this.saldo -= saldo; }
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
