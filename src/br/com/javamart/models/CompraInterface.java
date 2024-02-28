package br.com.javamart.models;

import java.util.List;

public interface CompraInterface {
    List<Produto> getItensCompra();
    String listarProdutos();
    Cliente getCliente();
    String toString();
}
