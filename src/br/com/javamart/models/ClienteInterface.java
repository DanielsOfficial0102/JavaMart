package br.com.javamart.models;

public interface ClienteInterface {
    void addSaldo(double saldo);
    void removeSaldo(double saldo);
    double getSaldo();
    String toString();
}
