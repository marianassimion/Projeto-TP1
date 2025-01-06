package source;

import java.time.LocalDate;
import java.util.ArrayList;

public class Historico {

    private ArrayList<RegistroDeAplicacao> historico;

    public ArrayList<RegistroDeAplicacao> buscarPorPaciente (String cpfPaciente) {
        //todo: implementar lógica do método
        return this.historico;
    }

    public ArrayList<RegistroDeAplicacao> buscarPorDia (LocalDate data) {
        //todo: implementar lógica do método
        return this.historico;
    }

    public void listarHistorico() {
        //todo: implementar lógica do método
        System.out.println(this.historico);
    }

    public void cadastrarNovoRegistro (RegistroDeAplicacao registroDeAplicacao) {
        this.historico.add(registroDeAplicacao);
    }
}
