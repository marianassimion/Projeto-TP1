package sam;

import java.time.LocalDate;

public class Paciente extends Pessoa {

    // Atributos
    private float peso;
    private float altura;
    private int idade;
    private Prescricao prescricao;

    // Construtor
    public Paciente(float peso, float altura, int idade, String nome, String cpf, LocalDate datadeNascimento) {
        super(nome, cpf, datadeNascimento);
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.prescricao = null;  
    }

    // Getters e Setters
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Prescricao getPrescricao() {
        return prescricao;
    }
}
