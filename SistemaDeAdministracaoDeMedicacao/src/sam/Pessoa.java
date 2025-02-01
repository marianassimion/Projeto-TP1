package sam;

import java.time.LocalDate;

abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected LocalDate dataNascimento;

    @Override
    public String toString() {
        return nome + ";" + cpf + ";" + dataNascimento + ';';
    }
    
    public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
}
