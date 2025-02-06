package sam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Administrador extends Pessoa{
    private static final String BANCO_LOGIN = "login_adm.txt";
    private String login;
    private String senha;
    
    
    public Administrador(String nome, String cpf, String dataNascimento) {
        super(nome, cpf, dataNascimento);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = "login";
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = "senha";
    }
    
     public static void salvarLoginNoArquivo(String coren ,String senha){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BANCO_LOGIN, true))){
            String resul = coren +";"+ senha;
            
            writer.write(resul);
            writer.newLine();
        }
        catch (IOException e){
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }
}
