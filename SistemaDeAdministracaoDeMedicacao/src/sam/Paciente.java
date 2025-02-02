package sam;

import java.time.LocalDate;

public class Paciente extends Pessoa {

    public static Paciente fromString(String linha) {
        System.out.println("Linha lida: " + linha); 

        String[] partes = linha.split(";");
        String nome = partes[0].trim();
        String cpf = partes[1].trim();
        String dataNascimento = partes[2].trim();
        float peso = Float.parseFloat(partes[3].trim());
        float altura = Float.parseFloat(partes[4].trim());
        int idade = Integer.parseInt(partes[5].trim());
        String alergia = partes[6].trim();

        return new Paciente(peso, altura, idade, nome, cpf, dataNascimento, alergia);
    }

    // Atributos
    private float peso;
    private float altura;
    private int idade;
    private String alergia;
    private Prescricao prescricao;

    // Construtor
    public Paciente(float peso, float altura, int idade, String nome, String cpf, String dataNascimento, String alergia) {
        super(nome, cpf, dataNascimento);
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.prescricao = null; 
        this.alergia = alergia;
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

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }
    
    @Override
    public String toString() {
        return super.toString() + peso + ";" + altura + ";" + idade + ";" + alergia;
    }
    
    
}

