package br.com.javamart.models;

import java.util.ArrayList;
import java.util.List;

public class Compra implements CompraInterface {
    private List<Produto> itensCompra = new ArrayList<>();
    private Cliente cliente;

    public Compra(List<Produto> itensCompra, Cliente cliente) {
        this.itensCompra.addAll(itensCompra);
        this.cliente = cliente;
    }

    public void listarProdutos() {
        for (Produto item : this.itensCompra) {
            System.out.println(item);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }
}
