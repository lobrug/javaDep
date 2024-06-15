package model;

import java.time.LocalDate;

public class Funcionario extends Pessoa implements Comparable<Funcionario> {
    private String cargo;
    private double salario;
    private String email;
    private int id;

    public Funcionario(String nome, String sobrenome, LocalDate dataNasc, String endereco, String cpf, String cargo,
            double salario, String email) {
        super(nome, sobrenome, dataNasc, endereco, cpf);
        this.cargo = cargo;
        this.salario = salario;
        this.email = email;

    }

    public static Funcionario criarFuncionario(String nome, String sobrenome, LocalDate dataNasc, String endereco, String cpf,
            String cargo, double salario, String email) {
        return new Funcionario(nome, sobrenome, dataNasc, endereco, cpf, cargo, salario, email);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String exibiPessoa() {
        return super.exibiPessoa() + " Email: " + email + ", Cargo: " + cargo + ", Salário: " + salario + ", ID: " + id
                + ".";
    }

    @Override
    public int compareTo(Funcionario o) {
        return Double.compare(o.salario, this.salario);
    }
}
