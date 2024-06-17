package controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import model.Fornecedor;
import util.*;

public class FornecedorController {

    private List<Fornecedor> fornecedores;

    public FornecedorController() {
        this.fornecedores = CriarLista.criarListaFornecedor();

        try {
            carregarDados();
        } catch (Exception e) {
            System.out.println("Erro ao carregar dados");
        }
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public Optional<Fornecedor> buscaFornecedor(String nome){
        return fornecedores.stream()
                .filter(fornecedor -> fornecedor.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    private int criarId() {
        return fornecedores.stream().mapToInt(Fornecedor::getId).max().orElse(0) + 1;
    }

    public void editaFornecedor(String nome, String novoNome, String novoSobrenome, LocalDate novaDataNasc, String novoCpf, String novaEmpresa)
            throws Exception {
        Fornecedor fornecedor = buscaFornecedor(nome).orElseThrow(() -> new Exception("Fornecedor não encontrado"));
        fornecedor.setNome(novoNome);
        fornecedor.setSobrenome(novoSobrenome);
        fornecedor.setDataNasc(novaDataNasc);
        fornecedor.setCpf(novoCpf);
        fornecedor.setNomeEmpresa(novaEmpresa);
        Log.logAction("Fornecedor " + fornecedor.getNome() + " editado com sucesso");
        salvarDados();
    }

    public void adicionaFornecedor(Fornecedor fornecedor) throws Exception {
        if (buscaFornecedor(fornecedor.getNome()).isPresent()) throw new Exception("Fornecedor já cadastrado no sistema");
        fornecedores.add(fornecedor);
        fornecedor.setId(criarId());
        Log.logAction("Fornecedor " + fornecedor.getNome() + " cadastrado com sucesso");
        salvarDados();
    }

    public void removeFornecedor(String nome) throws Exception {
        Fornecedor fornecedor = buscaFornecedor(nome).orElseThrow(() -> new Exception("Fornecedor não encontrado"));
        fornecedores.remove(fornecedor);
        Log.logAction("Fornecedor " + fornecedor.getNome() + " removido com sucesso");
        salvarDados();
    }

    public void salvarDados() throws Exception {
        Ser.salvarFornecedor(fornecedores);
    }

    private void carregarDados() throws Exception {
        fornecedores = Ser.lerFornecedores();
    }
}