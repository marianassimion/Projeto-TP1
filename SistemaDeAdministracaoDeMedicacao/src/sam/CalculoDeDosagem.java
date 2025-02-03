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
        
        Prescricao prescricao1 = new Prescricao(10000, "UI", LocalDate.MIN, "obs");
        Penicilina penicilina = new Penicilina("Descrição", "UI", prescricao1);
        prescricao1.setMedicamento(penicilina);
        
        addPaciente((float) 80.5, (float) 1.70, 0, "Penicilinoswaldo", "12345678900", "15/02/1956", "não", prescricao1);
        
    }
    
}

