package sam;

public class Penicilina extends Medicamento{
    private static final int diluicao = 10;
    private String unidadeDeMedida;
    private int formulacao;
    private int quantidadeDeAgua;
    
    private String[] dominioFormulacao = {"5.000.000 UI","10.000.000 UI"};

    public Penicilina(String descricao, String unidadeDeMedida, Prescricao prescricao) {
        super("Penicilina", descricao, prescricao);
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public int getFormulacao() {
        return formulacao;
    }

    public void setFormulacao(int formulacao) {
        this.formulacao = formulacao;
    }

    public int getQuantidadeDeAgua() {
        return quantidadeDeAgua;
    }

    public void setQuantidadeDeAgua(int quantidadeDeAgua) {
        this.quantidadeDeAgua = quantidadeDeAgua;
    }

    @Override
    public float calculoDeDosagem(double dosagem) {
        return  Math.round(((float)((10*dosagem) / (double)formulacao)) * 10) / 10.0f;
    }
}
