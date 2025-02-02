package sam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroDeAplicacao {
    private String nomeEnfermeiro;
    private String nomePaciente;
    private String nomeMedicamento;
    private float dosagemAplicada;
    private String unidadeDeMedida;
    private LocalDateTime data;
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

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

    public RegistroDeAplicacao(String nomeEnfermeiro, String nomePaciente, String nomeMedicamento, float dosagemAplicada, String unidadeDeMedida, LocalDateTime data) {
        this.nomeEnfermeiro = nomeEnfermeiro;
        this.nomePaciente = nomePaciente;
        this.nomeMedicamento = nomeMedicamento;
        this.dosagemAplicada = dosagemAplicada;
        this.unidadeDeMedida = unidadeDeMedida;
        this.data = data;
    }
    
    public static RegistroDeAplicacao fromString(String linha) {
        String[] partes = linha.split(";");
        return new RegistroDeAplicacao(partes[0], partes[1], partes[2], Float.parseFloat(partes[3]), partes[4], LocalDateTime.parse(partes[5], FORMATTER));
    }
    
    @Override
    public String toString() {
        return nomeEnfermeiro + ";" + nomePaciente + ";" + nomeMedicamento + ";" + dosagemAplicada + ";" + unidadeDeMedida + ";" + data.format(FORMATTER);
    }
}
