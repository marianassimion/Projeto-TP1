package sam;

/**
 * Classe especialista de Medicamento que implementa as especificidades do medicamento Paracetamol
 *
 * @author Dionilton
 * @version 1.0
 */
public class Paracetamol extends Medicamento{
    private int dosagemPrescrita;
    private int dosagemDisponivel;
    
    /** 
    * Construtor da classe
    */
    public Paracetamol(String nomeMedicamento, String descricao, Prescricao prescricao) {
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
    
    /**
     * Sobscrever o método de calculo de dosagem de forma mais especifica ao medicamento em si.
     *
     * @param dosagem float representando a dosagem prescrita
     * @return retorna o valor de dosagem para ser administrado na aplicação
     */
    @Override
    public float calculoDeDosagem(double dosagem) {
        //todo: implementar lógica do método
        return 1;
    }

    public float calculoDeDosagem(float pesoDoPaciente) {
        //todo: implementar lógica do método
        return 1+pesoDoPaciente;
    }
}
