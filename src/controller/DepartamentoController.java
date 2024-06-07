package controller;

import java.util.List;
import java.util.Optional;

import model.Departamento;
import util.*;

public class DepartamentoController {

    private List<Departamento> departamentos;

    public DepartamentoController(List<Departamento> departamentos) {
        this.departamentos = departamentos;

        try {
            carregarDados();
        } catch (Exception e) {
            System.out.println("Erro ao carregar dados");
        }
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public Optional<Departamento> buscaDepartamento(String nome) throws Exception {
        return departamentos.stream()
                .filter(d -> d.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    public void adicionaDepartamento(Departamento departamento) throws Exception {
        Departamento d = buscaDepartamento(departamento.getNome()).orElse(null);
        if (d == null) {
            departamentos.add(departamento);
            Log.logAction("Departamento cadastrado " + departamento.getNome() + " com sucesso");
        } 
        throw new Exception("Departamento já cadastrado no sistema");
    }

    public void editaDepartamento(String nome, String novoNome) throws Exception {
        Departamento d = buscaDepartamento(nome).orElse(null);
        if (d != null) {
            d.setNome(novoNome);
            Log.logAction("Departamento editado " + d.getNome() + " com sucesso");
        }
        throw new Exception("Departamento não encontrado");
    }

    public void removeDepartamento(String nome) throws Exception {
        Departamento d = buscaDepartamento(nome).orElse(null);
        if (d == null) {
            throw new Exception("Departamento não encontrado");
        }
        departamentos.remove(d);
        Log.logAction("Departamento removido " + d.getNome() + " com sucesso");   
    }

    public void salvarDados() throws Exception {
        Ser.salvarDepartamento(departamentos);
    }

    private void carregarDados() throws Exception {
        departamentos = Ser.lerDepartamentos();
    }
}
