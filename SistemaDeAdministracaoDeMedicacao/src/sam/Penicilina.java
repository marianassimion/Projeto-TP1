package sam;

public class Penicilina extends Medicamento{
    private static final int diluicao = 10;
    private String unidadeDeMedida;
    private int formulacao;
    private int quantidadeDeAgua;

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
    public float calculoDeDosagem() {
        //todo: implementar lógica do método
        return 1;
    }
}
