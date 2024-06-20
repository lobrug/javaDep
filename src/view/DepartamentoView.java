package view;

import controller.DepartamentoController;
import model.Departamento;

import java.util.Scanner;

public class DepartamentoView {

    public static void cadastroDepartamento(DepartamentoController depController, Scanner scanner) {
        System.out.print("Nome do Departamento: ");
        String nome = scanner.nextLine().trim();
    
        if (nome.isEmpty()) {
            System.out.println("Todos os campos devem ser preenchidos.");
            return;
        }
    
        Departamento d = Departamento.criarDepartamento(nome);
        try {
            depController.adicionaDepartamento(d);
            System.out.println("Departamento cadastrado com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    

    public static void removeDepartamento(DepartamentoController depController, Scanner scanner) {
        System.out.print("Nome do Departamento: ");
        String nome = scanner.nextLine();
        try {
            depController.removeDepartamento(nome);
            System.out.println("Departamento removido com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void buscaDepartamento(DepartamentoController depController, Scanner scanner) {

        System.out.print("Nome do Departamento: ");
        String nome = scanner.nextLine();

        try {
            depController.buscaDepartamento(nome).ifPresentOrElse(
                departamento -> System.out.println("Departamento encontrado: " + departamento),
                () -> System.out.println("Departamento não encontrado."));
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao buscar o departamento: " + e.getMessage());
        }
    }

    public static void editaDepartamento(DepartamentoController depController, Scanner scanner) {
        System.out.print("Nome do Departamento: ");
        String nome = scanner.nextLine();

        System.out.print("Novo nome do Departamento: ");
        String novoNome = scanner.nextLine();
        try {
            depController.editaDepartamento(nome, novoNome);
            System.out.println("Departamento editado com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}