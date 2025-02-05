package sam;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalculoDeDosagem {
    private ArrayList<Paciente> pacientes;
    
    
    public void addPaciente(float peso, float altura, int idade, String nome, String cpf, String dataNascimento, String alergia, Prescricao prescricao) {
        Paciente paciente = new Paciente(peso, altura, idade, nome, cpf, dataNascimento, alergia);
        paciente.setPrescricao(prescricao);
        pacientes.add(paciente);
        
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    public CalculoDeDosagem() {
        this.pacientes = new ArrayList<>();
        
        Prescricao prescricao1 = new Prescricao(100000, "UI", LocalDate.MIN, "obs");
        Penicilina penicilina = new Penicilina("Descrição", "UI", prescricao1);
        prescricao1.setMedicamento(penicilina);
        
        Prescricao prescricao2 = new Prescricao(800000, "UI", LocalDate.MIN, "obs");
        Benzetacil benzetacil = new Benzetacil("Descrição", prescricao2);
        prescricao2.setMedicamento(benzetacil);
        
        Prescricao prescricao3 = new Prescricao(16000, "UI", LocalDate.MIN, "obs");
        Heparina heparina = new Heparina("Descrição", prescricao3);
        prescricao3.setMedicamento(heparina);
        
        Prescricao prescricao4 = new Prescricao(50, "UI", LocalDate.MIN, "obs");
        Insulina insulina = new Insulina("Descrição", prescricao4);
        prescricao4.setMedicamento(insulina);
        
        addPaciente((float) 80.5, (float) 1.70, 35, "Penicilinoswaldo", "12345678900", "15/02/1956", "não", prescricao1);
        addPaciente((float) 65.5, (float) 1.64, 65, "Dona Benzentaciolina", "12345613200", "15/02/1956", "não", prescricao2);
        addPaciente((float) 74.65, (float) 1.72, 42, "Heparino Pereira da Silva", "78945678900", "15/02/1956", "não", prescricao3);
        addPaciente((float) 67.4, (float) 1.65, 52, "Tia Bete", "45674512311", "15/02/1956", "não", prescricao4);
        
    }
    
}

