package sam;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Historico {
    
    private static final String FILE_PATH = "historico.txt";
    
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

    public Historico() {
        this.historico = new ArrayList<>();
    }
    
    public void adicionarRegistro(RegistroDeAplicacao registroDeAplicacao) {
        historico.add(registroDeAplicacao);
        salvarRegistroNoArquivo(registroDeAplicacao);
    }
    
    private void salvarRegistroNoArquivo(RegistroDeAplicacao registroDeAplicacao) {
        File arquivo = new File(FILE_PATH);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(registroDeAplicacao.toString());
            writer.newLine();
            writer.flush();
            System.out.println("Registro salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao salvar registro: " + e.getMessage());
        }
    }
    
    public void carregarHistorico() {
        historico.clear();
        Path caminho = Paths.get(FILE_PATH);
        
        if (Files.exists(caminho)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    historico.add(RegistroDeAplicacao.fromString(linha));
                }
            } catch (IOException e) {
                System.err.println("Erro ao carregar histórico: " + e.getMessage());
            }
        }
    }
    
    public ArrayList<RegistroDeAplicacao> getHistorico() {
        return historico;
    }
    
}
