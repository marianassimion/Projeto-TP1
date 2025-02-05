package sam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroDeAplicacao {
    private String nomeEnfermeiro;
    private String coren;
    private String nomePaciente;
    private String cpfPaciente;
    private String nomeMedicamento;
    private float dosagemAplicada;
    private String unidadeDeMedida;
    private LocalDateTime data;
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String getNomeEnfermeiro() {
        return nomeEnfermeiro;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public float getDosagemAplicada() {
        return dosagemAplicada;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public RegistroDeAplicacao(String nomeEnfermeiro, String coren, String nomePaciente, String cpfPaciente, String nomeMedicamento, float dosagemAplicada, String unidadeDeMedida, LocalDateTime data) {
        this.nomeEnfermeiro = nomeEnfermeiro;
        this.coren = coren;
        this.nomePaciente = nomePaciente;
        this.cpfPaciente = cpfPaciente;
        this.nomeMedicamento = nomeMedicamento;
        this.dosagemAplicada = dosagemAplicada;
        this.unidadeDeMedida = unidadeDeMedida;
        this.data = data;
    }
    
    
    
    public static RegistroDeAplicacao fromString(String linha) {
        String[] partes = linha.split(",");
        
        return new RegistroDeAplicacao(
        partes[0], // nomeEnfermeiro
        partes[1], // coren
        partes[2], // nomePaciente
        partes[3], // cpfPaciente
        partes[4], // nomeMedicamento
        Float.parseFloat(partes[5]), // dosagemAplicada
        partes[6], // unidadeDeMedida
        LocalDateTime.parse(partes[7], FORMATTER) // data
        );
       
    }
    
    @Override
    public String toString() {
        return nomeEnfermeiro + "," + coren + "," + nomePaciente + "," + cpfPaciente + "," + 
           nomeMedicamento + "," + dosagemAplicada + "," + unidadeDeMedida + "," + 
           data.format(FORMATTER);   
    }
}
