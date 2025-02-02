package sam;

import java.time.LocalDate;
import java.util.ArrayList;

public class Paciente extends Pessoa{
    private float peso;
    private float altura;
    private int idade;
    private ArrayList alergias;

    public Paciente(float peso, float altura, int idade, ArrayList alergias, String nome, String cpf, LocalDate datadeNascimento) {
        super(nome, cpf, datadeNascimento);
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.alergias = alergias;
    }
    
    public void cadastrarPrescricao(String nomeMedicacao, String nomePaciente, float quantidade, float unidadeDeMedida, float concentracao, LocalDate dataDeValidade){
    }
}
