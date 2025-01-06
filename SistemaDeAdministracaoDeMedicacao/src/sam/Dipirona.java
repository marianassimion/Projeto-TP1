package source;

public class Dipirona extends Medicamento{
    private int dosagemPrescrita;
    private int dosagemDisponivel;

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

    @Override
    public float calculoDeDosagem() {
        //todo: implementar lógica do método
        return 1;
    }

    public float calculoDeDosagem(float pesoDoPaciente) {
        //todo: implementar lógica do método
        return 1+pesoDoPaciente;
    }
}
