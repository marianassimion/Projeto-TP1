package sam;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Classe que administrar e representa o histórico de aplicações, bem como lida com a persistência dos dados em arquivo .txt
 *
 * @author Dionilton
 * @version 1.0
 */
public class Historico {
    
    private static final String FILE_PATH = "historico.txt";
    
    private ArrayList<RegistroDeAplicacao> historico;
    
    /**
     * Método de busca genérica no histórico que realizar filtros a partir de qualquer combinação dos atributos da classe Registro de Aplicação.
     *
     * @return retorna uma lista de RegistroDeAplicacao com as ocorrências encontradas a partir dos filtros.
     */
    public ArrayList<RegistroDeAplicacao> filtrarRegistro(String nomeEnfermeiro, String coren, String nomePaciente, String cpfPaciente, String nomeMedicamento, LocalDate dataEspecifica) {
        return (ArrayList<RegistroDeAplicacao>) historico.stream()
        .filter(r -> (nomeEnfermeiro == null || r.getNomeEnfermeiro().equalsIgnoreCase(nomeEnfermeiro)))
        .filter(r -> (coren == null || r.getCoren().equalsIgnoreCase(coren)))
        .filter(r -> (nomePaciente == null || r.getNomePaciente().equalsIgnoreCase(nomePaciente)))
        .filter(r -> (cpfPaciente == null || r.getCpfPaciente().equals(cpfPaciente)))
        .filter(r -> (nomeMedicamento == null || r.getNomeMedicamento().equalsIgnoreCase(nomeMedicamento)))
        .filter(r -> (dataEspecifica == null || r.getData().toLocalDate().equals(dataEspecifica)))
        .collect(Collectors.toList());
    }

    /**
     * Adciona um novo RegistroDeAplicacao ao atributo private ArrayList<RegistroDeAplicacao> historico;
     *
     * @param RegistroDeAplicacao registroDeAplicacao representa o registro a ser adicionado.
     */
    public void cadastrarNovoRegistro (RegistroDeAplicacao registroDeAplicacao) {
        this.historico.add(registroDeAplicacao);
    }
    
    /** 
    * Construtor da classe
    */
    public Historico() {
        this.historico = new ArrayList<>();
    }
    
    /**
     * Adciona um novo RegistroDeAplicacao ao arquivo private ArrayList<RegistroDeAplicacao> historico e salva o novo registro no arquivo .txt de persitência dos dados.
     *
     * @param RegistroDeAplicacao registroDeAplicacao representa o registro a ser adicionado no arquivo de persistência.
     */
    public void adicionarRegistro(RegistroDeAplicacao registroDeAplicacao) {
        historico.add(registroDeAplicacao);
        salvarRegistroNoArquivo(registroDeAplicacao);
    }
    
    /**
     * Adciona um novo RegistroDeAplicacao ao arquivo .txt de persitência dos dados.
     *
     * @param RegistroDeAplicacao registroDeAplicacao representa o registro a ser adicionado no arquivo de persistência.
     */
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
    
    /**
     * Carregar o histórico do arquivo .txt no atributo private ArrayList<RegistroDeAplicacao> historico;
     *
     */
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
