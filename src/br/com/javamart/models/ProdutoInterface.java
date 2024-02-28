package br.com.javamart.models;

public interface ProdutoInterface {
    double getPreco();
    String getNome();
    int getQuantidade();
    void diminuirQuantidade(double quantidade);
    void aumentarQuantidade(double quantidade);
    int getQuantidadeNoCarrinho();
    void diminuirQuantidadeCarrinho(double quantidade);
    void aumentarQuantidadeCarrinho(double quantidade);
    String toString();
}
