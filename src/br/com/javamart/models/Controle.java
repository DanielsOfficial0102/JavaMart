package br.com.javamart.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Controle {
    private static List<Cliente> listaClientes = new ArrayList<>();
    private static List<Produto> listaProdutos = new ArrayList<>();

    public static Cliente cadastrarCliente(String nome, String endereco, String telefone, String email, LocalDate dataNascimento, String senha) {
        Cliente cliente = new Cliente(nome, endereco, telefone, email, dataNascimento, senha);
        listaClientes.add(cliente);
        return cliente;
    }

    public static Produto cadastrarProduto(String nome, double preco, int quantidade) {
        Produto produto = new Produto(nome, preco, quantidade);
        listaProdutos.add(produto);
        return produto;
    }

    public static void visualizarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
            return;
        }

        for (Pessoa cliente : listaClientes) {
            System.out.println(cliente);
        }
    }
    public static void visualizarProdutos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
            return;
        }
        for (Produto produto : listaProdutos) {
            System.out.println(produto);
        }
    }

    public static List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public static Produto buscarProduto(String nome) {
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }
}