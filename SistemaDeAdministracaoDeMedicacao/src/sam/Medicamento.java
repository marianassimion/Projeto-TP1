package sam;

import java.time.LocalDate;

public abstract class Medicamento {
    protected String nomeMedicamento;
    protected String descricao;
    protected Prescricao prescricao;


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

    public abstract float calculoDeDosagem();
}
