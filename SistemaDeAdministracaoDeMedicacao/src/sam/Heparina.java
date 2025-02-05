package sam;

public class Heparina extends Medicamento{
    private int formulacao;
    private int dosagemPrescrita;
    private int dosagemDisponivel;
    private String unidadeDeMedida;

    public Heparina(String descricao, Prescricao prescricao) {
        super("Heparina", descricao, prescricao);
    }
    

    public int getFormulacao() {
        return formulacao;
    }

    public void setFormulacao(int formulacao) {
        this.formulacao = formulacao;
    }

    public int getDosagemPrescrita() {
        return dosagemPrescrita;
    }

    public void setDosagemPrescrita(int dosagemPrescrita) {
        this.dosagemPrescrita = dosagemPrescrita;
    }

    public int getDosagemDisponivel() {
        return dosagemDisponivel;
    }

    public void setDosagemDisponivel(int dosagemDisponivel) {
        this.dosagemDisponivel = dosagemDisponivel;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    @Override
    public float calculoDeDosagem(double dosagem) {
        return  Math.round(((float)(5 * dosagem) / 25000) * 10) / 10.0f;
    }
}
