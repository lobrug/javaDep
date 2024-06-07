package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.*;

public class Empresa extends CriarLista {
    private String nome;
    private List<Pessoa> pessoas;
    private List<Funcionario> funcionarios;
    private List<Departamento> departamentos;

    public Empresa(String nome) {
        this.nome = nome;
        this.pessoas = CriarLista.criarListaPessoa();
        this.funcionarios = CriarLista.criarListaFuncionario();
        this.departamentos = CriarLista.criarListaDepartamento();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }


    public void relatorioFolhaSalarial() {
        List<Funcionario> sortedFuncionarios = new ArrayList<>();
        sortedFuncionarios.addAll(funcionarios);
        Collections.sort(sortedFuncionarios);

        System.out.println("Relatório de Folha Salarial:");
        for (Funcionario f : sortedFuncionarios) {
            System.out.println(f.exibiPessoa());
        }
    }

    @Override
    public String toString() {
        return "Empresa [nome=" + nome + ", pessoas=" + pessoas + ", funcionarios=" + funcionarios + ", departamentos="
                + departamentos + "]";
    }

    
}
