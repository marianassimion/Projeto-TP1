package sam;

import java.time.LocalDate;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected LocalDate datadeNascimento;
    
    public Pessoa(String nome, String cpf, LocalDate datadeNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.datadeNascimento = datadeNascimento;
    }
    
    protected boolean validarCpf(String cpf){
        return true;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDatadeNascimento() {
        return datadeNascimento;
    }

    public void setDatadeNascimento(LocalDate datadeNascimento) {
        this.datadeNascimento = datadeNascimento;
    }
    
    
}
