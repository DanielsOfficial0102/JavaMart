package br.com.javamart.models;

import java.time.LocalDate;
import java.util.List;

public interface ControleInterface {
    static Cliente cadastrarCliente(String nome, String endereco, String telefone, String email, LocalDate dataNascimento, String senha) {
        return null;
    }
    static Produto cadastrarProduto(String nome, double preco, int quantidade) {
        return null;
    }
    static void visualizarClientes() {
    }
    static void visualizarProdutos() {
    }
    static void adicionarAoHistoricoDeVendas(Compra compra) {
    }
    static void verHistoricoDeCompras() {
    }
}
