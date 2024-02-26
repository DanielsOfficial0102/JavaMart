package br.com.javamart.models;

import java.time.LocalDate;

public abstract class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;
    private String senha;

    public Pessoa(String nome, String endereco, String telefone, String email, LocalDate dataNascimento, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "=====" +
                "\nNome: " + nome +
                "\nEndereço: " + endereco +
                "\nTelefone: " + telefone +
                "\nE-mail: " + email +
                "\nNascimento: " + dataNascimento;
    }
}
