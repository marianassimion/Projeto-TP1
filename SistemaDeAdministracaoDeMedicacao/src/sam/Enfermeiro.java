package sam;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Enfermeiro extends Pessoa{
    
    public static Enfermeiro fromString(String linha) {
        System.out.println("Linha lida: " + linha);

        String[] partes = linha.split(";");
        String nome = partes[0].trim();
        String cpf = partes[1].trim();
        String dataNascimento = partes[2].trim();
        String coren = partes[3].trim();
        String setor = partes[4].trim();

        return new Enfermeiro(nome,cpf,dataNascimento, coren, setor);
    }
    
    private String coren;
    private String setor;
    private String senha;

    public Enfermeiro(String nome, String cpf, String dataDeNascimento, String coren, String setor) {
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
    
    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public String toString() {
        return super.toString() + coren + ";" +setor;
    }
}


