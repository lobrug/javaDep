package model;

import java.io.Serializable;

public class Pessoa implements Serializable{
    private String nome;
    private String sobrenome;
    private int idade;
    private String endereco;
    private String cpf;
    private boolean trabalhando;

    public Pessoa(String nome, String sobrenome, int idade, String endereco, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.endereco = endereco;
        this.cpf = cpf;
        this.trabalhando = false;
    }

    public static Pessoa criarPessoa(String nome, String sobrenome, int idade, String endereco, String cpf) {
        return new Pessoa(nome, sobrenome, idade, endereco, cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isTrabalhando() {
        return trabalhando;
    }

    public void setTrabalhando(boolean trabalhando) {
        this.trabalhando = trabalhando;
    }

    public String exibiPessoa() {
        return "Nome: " + nome + ", Sobrenome: " + sobrenome + ", Idade: " + idade + ", Endereço: " + endereco
                + ", CPF: " + cpf + ", Status de Trabalho: " + (trabalhando? "Ativa" : "Inativa") + ".";
    }
}