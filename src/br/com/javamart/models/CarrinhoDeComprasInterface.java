package br.com.javamart.models;

public interface CarrinhoDeComprasInterface {
    void adicionarAoCarrinho(Produto produto, int quantidade);
    void removerDoCarrinho(Produto produto);
    void verCarrinho();
    void finalizarCompra(Cliente cliente);
}
