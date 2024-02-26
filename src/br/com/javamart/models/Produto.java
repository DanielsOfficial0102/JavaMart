package br.com.javamart.models;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private int quantidadeNoCarrinho;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void diminuirQuantidade(double quantidade) {
        this.quantidade -= quantidade;
    }

    public void aumentarQuantidade(double quantidade) {
        this.quantidade += quantidade;
    }

    public int getQuantidadeNoCarrinho() { return quantidadeNoCarrinho; }

    public void diminuirQuantidadeCarrinho(double quantidade) {
        this.quantidadeNoCarrinho -= quantidade;
    }

    public void aumentarQuantidadeCarrinho(double quantidade) {
        this.quantidadeNoCarrinho += quantidade;
    }

    @Override
    public String toString() {
        return "=====" +
                "\nNome: " + nome +
                "\nPreço: " + preco +
                "\nQuantidade Estoque: " + quantidade +
                "\nQuantidade no Carrinho: " + quantidadeNoCarrinho;
    }
}
