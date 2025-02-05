package sam;
import java.time.LocalDate;


/**
 * Classe generalista que representa os atributos e métodos em comum de classes do tipo medicamento
 *
 * @author Dionilton
 * @version 1.0
 */
public abstract class Medicamento {
    protected String nomeMedicamento;
    protected String descricao;
    protected Prescricao prescricao;

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prescricao getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(Prescricao prescricao) {
        this.prescricao = prescricao;
    }
    
    /** 
    * Construtor da classe
    */
    public Medicamento(String nomeMedicamento, String descricao, Prescricao prescricao) {
        this.nomeMedicamento = nomeMedicamento;
        this.descricao = descricao;
        this.prescricao = prescricao;
    }

    public String mostrarDescricao() {
        //todo: implementar lógica do método
        return this.descricao;
    }

    public float conversao() {
        //todo: implementar lógica do método
        return 1;
    }

    public boolean validarPrescricao() {
        return this.prescricao.getDataDeValidade().isBefore(LocalDate.now()) ? true: false;
    }

    public abstract float calculoDeDosagem(double dosagem);
}
