package sam;

public class Insulina extends Medicamento{
    private String tipoDeSeringa;
    private int dosagemPrescrita;
    private int frascoDisponivel;
    private String unidadeDeMedida;

    public String getTipoDeSeringa() {
        return tipoDeSeringa;
    }

    public void setTipoDeSeringa(String tipoDeSeringa) {
        this.tipoDeSeringa = tipoDeSeringa;
    }

    public int getDosagemPrescrita() {
        return dosagemPrescrita;
    }

    public void setDosagemPrescrita(int dosagemPrescrita) {
        this.dosagemPrescrita = dosagemPrescrita;
    }

    public int getFrascoDisponivel() {
        return frascoDisponivel;
    }

    public void setFrascoDisponivel(int frascoDisponivel) {
        this.frascoDisponivel = frascoDisponivel;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    @Override
    public float calculoDeDosagem() {
        //todo: implementar lógica do método
        return 1;
    }
}
