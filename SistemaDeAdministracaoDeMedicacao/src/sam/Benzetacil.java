package sam;

public class Benzetacil extends Medicamento{
    private static final int diluicao = 4;
    private int dosagemPrescrita;
    private int dosagemDisponivel;
    private String unidadeDeMedida;

    public Benzetacil(String nomeMedicamento, String descricao, Prescricao prescricao) {
        super(nomeMedicamento, descricao, prescricao);
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
        //todo: implementar lógica do método
        return 1;
    }
}
