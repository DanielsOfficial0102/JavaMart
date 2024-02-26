package br.com.javamart.app;

import br.com.javamart.models.CarrinhoDeCompras;
import br.com.javamart.models.Controle;
import br.com.javamart.models.Produto;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        Controle.cadastrarCliente("José",
                "Rua Itamonte, 365", "+5511997280552",
                "joseamaral@gmail.com", LocalDate.of(1980, 12, 13),
                "senha123");

        String teste = "Carregador Powerbank";
        Produto produto = Controle.buscarProduto(teste);
        System.out.println(produto);

        carrinhoDeCompras.adicionarAoCarrinho(produto, 2);
        carrinhoDeCompras.verCarrinho();

        produto = Controle.buscarProduto("Secador de cabelo");
        carrinhoDeCompras.adicionarAoCarrinho(produto, 3);

        carrinhoDeCompras.removerDoCarrinho(produto);
        carrinhoDeCompras.verCarrinho();

        System.out.println(produto);

    }
}
