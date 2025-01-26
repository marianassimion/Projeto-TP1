package sam;

import java.time.LocalDate;
import java.util.ArrayList;

public class Enfermeiro extends Pessoa{
    private int coren;
    private String setor;

    public Enfermeiro(String nome, String cpf, LocalDate dataDeNascimento, int coren, String setor) {
        super(nome, cpf, dataDeNascimento);
        this.coren = coren;
        this.setor = setor;
    }

    public void cadastrarPaciente(String nome, String cpf, LocalDate dataNascimento, int coren, String setor){
        
    }
    
    public void atualizarPaciente(float peso, float altura, ArrayList alergias){
    
    }
    
    public void excluirPaciente(String cpfCliente){
    
    }
    
    public void editarPrescricao(String nomeMedicamento, String nomePaciente, float quantidade, float unidadeDeMedida, float concentracao){
        
    }
    
    public int getCoren() {
        return coren;
    }

    public void setCoren(int coren) {
        this.coren = coren;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
}
