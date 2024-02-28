package br.com.javamart.models;

import java.util.ArrayList;
import java.util.List;

public class Compra implements CompraInterface {
    private List<Produto> itensCompra = new ArrayList<>();
    private Cliente cliente;

    public Compra(List<Produto> itensCompra, Cliente cliente) {
        this.itensCompra = itensCompra;
        this.cliente = cliente;
    }

    public List<Produto> getItensCompra() {
        return itensCompra;
    }

    public String listarProdutos() {
        for (Produto item : itensCompra) {
            System.out.println(item);
        }
        return null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "===== VENDA =====" +
                "Cliente: " + cliente.getNome() +
                "\nVendido: " + listarProdutos() +
                "===== FIM =====";
    }
}
