package sam;

import java.time.LocalDate;

public class Prescricao {
    
    // atributos
    private float dosagem;
    private String unidadeDeMedida;
    private LocalDate dataDeValidade;
    private String observacao;
    
    private String medicamento;

    // construtor
    public Prescricao(String medicamento, float dosagem, String unidadeDeMedida, LocalDate dataDeValidade, String observacao) {
        this.medicamento = medicamento;
        this.dosagem = dosagem;
        this.unidadeDeMedida = unidadeDeMedida;
        this.dataDeValidade = dataDeValidade;
        this.observacao = observacao;
        
    }

    public float getDosagem() {
        return dosagem;
    }

    public void setDosagem(float dosagem) {
        this.dosagem = dosagem;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedidada(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public LocalDate getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(LocalDate dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
