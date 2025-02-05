package sam;

/**
 * Classe especialista de Medicamento que implementa as especificidades do medicamento Insulina
 *
 * @author Dionilton
 * @version 1.0
 */
public class Insulina extends Medicamento{
    private int tipoDeSeringa;
    private int dosagemPrescrita;
    private int frascoDisponivel;
    private String unidadeDeMedida;
    private int tipoCalculo;
    
    /** 
    * Construtor da classe
    */
    public Insulina(String descricao, Prescricao prescricao) {
        super("Insulina", descricao, prescricao);
    }

    public int getTipoDeSeringa() {
        return tipoDeSeringa;
    }

    public void setTipoDeSeringa(int tipoDeSeringa) {
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

    public int getTipoCalculo() {
        return tipoCalculo;
    }

    public void setTipoCalculo(int tipoCalculo) {
        this.tipoCalculo = tipoCalculo;
    }
    
    /**
     * Sobscrever o método de calculo de dosagem de forma mais especifica ao medicamento em si.
     *
     * @param dosagem float representando a dosagem prescrita
     * @return retorna o valor de dosagem para ser administrado na aplicação
     */
    @Override
    public float calculoDeDosagem(double dosagem) {
        if(tipoCalculo == 1) {
            return Math.round(((float)dosagem/(float)frascoDisponivel) * 10) / 10.0f;
        } else {
            return Math.round(((float)(dosagem * tipoDeSeringa) / 40) * 10) /10.0f;
        }
    }
}
