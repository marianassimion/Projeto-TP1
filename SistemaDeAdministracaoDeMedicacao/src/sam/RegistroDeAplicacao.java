package sam;

import java.time.LocalDateTime;

public class RegistroDeAplicacao {
    private String nomeEnfermeiro;
    private String nomePaciente;
    private String nomeMedicamento;
    private float dosagemAplicada;
    private String unidadeDeMedida;
    private LocalDateTime data;

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
}
