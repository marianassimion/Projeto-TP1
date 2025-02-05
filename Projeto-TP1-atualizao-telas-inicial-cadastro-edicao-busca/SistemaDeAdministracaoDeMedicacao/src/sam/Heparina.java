package sam;

/**
 * Classe especialista de Medicamento que implementa as especificidades do medicamento Heparina
 *
 * @author Dionilton
 * @version 1.0
 */
public class Heparina extends Medicamento{
    private int formulacao;
    private int dosagemPrescrita;
    private int dosagemDisponivel;
    private String unidadeDeMedida;
    
    /** 
    * Construtor da classe
    */
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
    
    /**
     * Sobscrever o método de calculo de dosagem de forma mais especifica ao medicamento em si.
     *
     * @param dosagem float representando a dosagem prescrita
     * @return retorna o valor de dosagem para ser administrado na aplicação
     */
    @Override
    public float calculoDeDosagem(double dosagem) {
        if(formulacao == 0) {
            return  Math.round(((float)(5 * dosagem) / 25000) * 10) / 10.0f;
        } else {
            return  Math.round(((float)(0.25 * dosagem) / 5000) * 10) / 10.0f;
        }
    }
}
