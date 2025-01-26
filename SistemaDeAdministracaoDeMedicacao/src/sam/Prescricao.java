package sam;

import java.time.LocalDate;

public class Prescricao {
    
    // atributos
    private float dosagem;
    private String unidadeDeMedidada;
    private LocalDate dataDeValidade;
    private String Observacao;

    // construtor
    public Prescricao(float dosagem, String unidadeDeMedidada, LocalDate dataDeValidade, String Observacao) {
        this.dosagem = dosagem;
        this.unidadeDeMedidada = unidadeDeMedidada;
        this.dataDeValidade = dataDeValidade;
        this.Observacao = Observacao;
    }

    public float getDosagem() {
        return this.dosagem;
    }

    public String getUnidadeDeMedidada() {
        return this.unidadeDeMedidada;
    }

    public LocalDate getDataDeValidade() {
        return this.dataDeValidade;
    }

    public String getObservacao() {
        return this.Observacao;
    }

    public void setDosagem(float dosagem) {
        this.dosagem = dosagem;
    }

    public void setUnidadeDeMedidada(String unidadeDeMedidada) {
        this.unidadeDeMedidada = unidadeDeMedidada;
    }

    public void setDataDeValidade(LocalDate dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    
}
