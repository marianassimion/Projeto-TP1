package sam;

/**
 * Classe especialista de Medicamento que implementa as especificidades do medicamento Benzetacil
 *
 * @author Dionilton
 * @version 1.0
 */
public class Benzetacil extends Medicamento{
    private static final int diluicao = 4;
    private int dosagemPrescrita;
    private int dosagemDisponivel;
    private String unidadeDeMedida;
    
    /** 
    * Construtor da classe
    */
    public Benzetacil(String descricao, Prescricao prescricao) {
        super("Benzetacil", descricao, prescricao);
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
        return Math.round(((float)(diluicao * dosagem) / (float)dosagemDisponivel) * 10) / 10.0f;
    }
}
