package br.com.javamart.app;

import br.com.javamart.models.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Cliente usuarioCliente;
        Pessoa usuarioAtual = Controle.cadastrarCliente("Default", "Default", "(11)90000-0000",
                "default@default.com", LocalDate.of(2000, 12, 12), "default");
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        Produto produto;
        String senhaFornecida, nomeProduto;
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("""
                        ===== JavaMart =====
                        Selecione uma opção:
                        \t0. SAIR
                        \t1. Logar
                        \t2. Cadastro de usuário
                        \t3. Cadastro de produto
                        \t4. Carteira
                        \t5. Ver Estoque
                        \t6. Menu Carrinho
                        \t7. Ver histórico de vendas
                        \t8. Adicionar saldo
                        \t9. Ver usuários
                        """);
                System.out.print("=> ");
                int opcao = sc.nextInt();

                switch (opcao) {
                    case 0:
                        System.out.println("Obrigado por testar!\nFeito por grupo 9.");
                        continuar = false;
                        break;
                    case 1:
                        sc.nextLine();
                        System.out.println("Insira seu username:");
                        String nome = sc.nextLine();
                        System.out.println("Insira sua senha:");
                        String senha = sc.nextLine();

                        Pessoa login = Controle.logar(nome, senha);
                        if (login != null) {
                            System.out.println("Logado com sucesso!");
                            usuarioAtual = login;
                        } else {
                            System.out.println("Informações incorretas! Tente novamente.");
                        }
                        System.out.println(usuarioAtual);
                        break;

                    case 2:
                        sc.nextLine();
                        System.out.println("Seja bem-vindo ao Sistema de Registro");
                        System.out.println("Insira as informações que se pedem abaixo:\n");

                        System.out.println("Nome:");
                        String nomeRegistro = sc.nextLine();
                        System.out.println("Endereço:");
                        String endereco = sc.nextLine();

                        String telefone;
                        while (true) {
                            System.out.println("Telefone (Formato: XX XXXXX-XXXX):");
                            telefone = sc.nextLine().replaceAll(" ", "");
                            if (telefone.length() > 12 || telefone.length() < 9) {
                                continue;
                            } else {
                                break;
                            }
                        }

                        String email;
                        while (true) {
                            System.out.println("E-mail:");
                            email = sc.nextLine();
                            if (!email.contains("@")) {
                                continue;
                            } else {
                                break;
                            }
                        }

                        int ano;
                        int mes;
                        int dia;
                        while (true) {
                            System.out.println("Data de nascimento (Formato: Dia/Mês/Ano):");
                            System.out.println("Dia:");
                            dia = sc.nextInt();
                            System.out.println("Mês:");
                            mes = sc.nextInt();
                            System.out.println("Ano:");
                            ano = sc.nextInt();

                            if (dia < 32 && dia > 0 && mes < 13 && mes > 0 && ano > 1930 && ano < 2010) {
                                break;
                            } else {
                                continue;
                            }
                        }

                        sc.nextLine();
                        String senhaRegistro;
                        while (true) {
                            System.out.println("Senha:");
                            senhaRegistro = sc.nextLine();
                            if (senhaRegistro.length() < 7) {
                                System.out.println("Tente escolher uma senha maior!");
                                continue;
                            } else {
                                break;
                            }
                        }

                        usuarioAtual = Controle.cadastrarCliente(nomeRegistro, endereco, telefone, email,
                                LocalDate.of(ano, mes, dia), senhaRegistro);
                        System.out.println("Usuário criado com sucesso!");
                        break;

                    case 3:
                        sc.nextLine();
                        System.out.println("Cadastro de produto:");
                        System.out.println("Digite a senha de administrador:");
                        senhaFornecida = sc.nextLine();
                        if (senhaFornecida.equals(Admin.getSenhaAdmin())) {
                            while (true) {
                                System.out.println("Qual o nome do produto que deseja cadastrar?");
                                nomeProduto = sc.nextLine();
                                System.out.println("Qual o preço?");
                                double precoProduto = sc.nextDouble();
                                System.out.println("Qual a quantidade disponível em estoque?");
                                int quantidadeProduto = sc.nextInt();

                                Controle.cadastrarProduto(
                                        nomeProduto,
                                        precoProduto,
                                        quantidadeProduto
                                );

                                System.out.println("Produto cadastrado com sucesso!");
                                sc.nextLine();
                                System.out.println("Digite 'fim' para parar, caso contrário digite 'con'.");
                                String fim = sc.nextLine();

                                if (fim.equalsIgnoreCase("fim")) {
                                    break;
                                }
                            }

                        } else {
                            System.out.println("A senha fornecida está incorreta!");
                        }
                        break;

                    case 4:
                        usuarioCliente = (Cliente) usuarioAtual;
                        System.out.println("===== CARTEIRA =====");
                        System.out.println("\tNome: " + usuarioCliente.getNome());
                        System.out.println("\tSaldo: " + usuarioCliente.getSaldo());
                        break;

                    case 5:
                        System.out.println("===== PRODUTOS =====");
                        Controle.visualizarProdutos();
                        System.out.println("===== FIM =====");
                        break;
                    case 6:
                        int opcaoMenuCarrinho = -1;

                        while (opcaoMenuCarrinho != 0) {
                            System.out.println("===== MENU CARRINHO =====");
                            System.out.println("O que deseja fazer?");
                            System.out.println("\t[0] Sair do carrinho");
                            System.out.println("\t[1] Adicionar ao carrinho");
                            System.out.println("\t[2] Remover do carrinho");
                            System.out.println("\t[3] Ver carrinho");
                            System.out.println("\t[4] Finalizar compra");
                            opcaoMenuCarrinho = sc.nextInt();
                            switch (opcaoMenuCarrinho) {
                                case 1:
                                    sc.nextLine();
                                    System.out.println("Digite o nome do produto:");
                                    nomeProduto = sc.nextLine();
                                    System.out.println("Digite a quantidade que deseja:");
                                    int quantidadeProduto = sc.nextInt();

                                    produto = Controle.buscarProduto(nomeProduto);
                                    if (produto != null) {
                                        carrinhoDeCompras.adicionarAoCarrinho(produto, quantidadeProduto);
                                    } else {
                                        System.out.println("Este item não foi encontrado.");
                                    }
                                    break;

                                case 2:
                                    sc.nextLine();
                                    System.out.println("Digite o nome do produto:");
                                    nomeProduto = sc.nextLine();

                                    produto = Controle.buscarProduto(nomeProduto);
                                    if (produto != null) {
                                        carrinhoDeCompras.removerDoCarrinho(produto);
                                    } else {
                                        System.out.println("Este item não foi encontrado.");
                                    }

                                    break;

                                case 3:
                                    usuarioCliente = (Cliente) usuarioAtual;

                                    System.out.println("===== CARRINHO =====");
                                    carrinhoDeCompras.verCarrinho();
                                    System.out.println("Saldo: " + usuarioCliente.getSaldo());
                                    System.out.println("===== FIM =====");

                                    break;

                                case 4:
                                    sc.nextLine();
                                    usuarioCliente = (Cliente) usuarioAtual;

                                    System.out.println("===== FINALIZAR COMPRA =====");
                                    System.out.println("Deseja realmente finalizar a compra? (s/n):");
                                    String continuarFinalizarCompra = sc.nextLine();
                                    if (continuarFinalizarCompra.equalsIgnoreCase("s")) {
                                        carrinhoDeCompras.finalizarCompra(usuarioCliente);
                                    } else {
                                        System.out.println("Certo! Pode continuar olhando os produtos.");
                                    }
                                    break;

                                default:
                                    System.out.println("Opção inválida. Tente novamente!");
                            }
                        }
                        break;

                    case 7:
                        sc.nextLine();
                        System.out.println("Digite a senha de administrador:");
                        senhaFornecida = sc.nextLine();
                        if (senhaFornecida.equals(Admin.getSenhaAdmin())) {
                            System.out.println("===== HISTÓRICO DE VENDAS =====");
                            Controle.verHistoricoDeVendas();
                        }
                        break;
                    case 8:
                        usuarioCliente = (Cliente) usuarioAtual;
                        sc.nextLine();

                        System.out.println("Digite a senha de administrador:");
                        senhaFornecida = sc.nextLine();
                        if (senhaFornecida.equals(Admin.getSenhaAdmin())) {
                            System.out.println("Adicionar saldo:");
                            double valor = sc.nextDouble();
                            usuarioCliente.addSaldo(valor);
                            System.out.println("Saldo adicionado em sua conta!");

                        } else {
                            System.out.println("A senha fornecida está incorreta!");
                        }
                        break;
                    case 9:
                        System.out.println("===== CLIENTES =====");
                        Controle.visualizarClientes();
                        System.out.println("===== FIM =====");

                        break;

                    default:
                        System.out.println("Opção inválida. Tente outra!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opa! Você não colocou a informação que se pede.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Opa! Ocorreu um erro durante a execução.\nMensagem de erro: " + Arrays.toString(e.getStackTrace()));
            }
        }
    }
}
