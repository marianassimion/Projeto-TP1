package Telas;
import sam.Enfermeiro;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class CadastrarEnfermeiro extends javax.swing.JFrame {
    private static final String BANCO_LOGIN = "login.txt";

    private static final String BANCO_DADOS = "cadastro_enfermeiro.txt";
    
    public CadastrarEnfermeiro() { // inicio da tela 
        initComponents();
        setLocationRelativeTo(null);
        btnCancelarCadastroEnfermeiro.setEnabled(true);
        btnSalvarCadastroEnfermeiro.setEnabled(true);
        btnLimparCadastroEnfermeiro.setEnabled(true);
        
        
        txtNomeCadastroEnfermeiro.setText("");
        txtSetorCadastroEnfermeiro.setText("");
        txtCorenCadastroEnfermeiro.setText("");
        txtDataNascimentoCadastroEnfermeiro.setText("//");
        txtCpfCadastroEnfermeiro.setText("");   
    }
    
    public static void salvarNoArquivo(Enfermeiro enfermeiro){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BANCO_DADOS, true))){
                        
            writer.write(enfermeiro.toString());
            writer.newLine();
        }
        catch (IOException e){
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
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
    
     public static void listarArquivo(){
        try (BufferedReader reader = new BufferedReader(new FileReader(BANCO_DADOS))){
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println("Linha lida: "+ linha);

                String[] partes = linha.split(";");
                String nome = partes[0].trim();
                String cpf = partes[1].trim();
                LocalDate dataNascimento = LocalDate.parse(partes[2].trim());
                String coren = partes[3].trim();
                String setor = partes[4].trim();
            }
        }
        catch (IOException e) {
            System.out.println("Erro ao ler os dados: " + e.getMessage());
        }}
    
    private static boolean isNomeValido(String nome) {
        for (int i = 0; i < nome.length(); i++){
            char c = nome.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false; // Se encontrar um caractere inválido, retorna falso
            }
        }
        return true;
    }


    private static boolean isCoren(String coren){
        // Verificando se o formato é de 4 a 6 dígitos seguidos por um hífen e duas letras maiúsculas

        if (!coren.matches("\\d{4,6}-[A-Z]{2}")){
            return false;
        }
        
        String numeroCoren = coren.split("-")[0];
        
        // Se o COREN começar com 0 ou 9, não é válido

        if(numeroCoren.matches("0{4,6}") || numeroCoren.matches("9{4,6}")){
            return false;
        }
        
        return true;
    }
    private boolean cpfJaCadastrado(String cpf) {
    try (BufferedReader reader = new BufferedReader(new FileReader(BANCO_DADOS))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] partes = linha.split(";");
            if (partes.length >= 2) {
                String cpfArquivo = partes[1].trim();
                if (cpfArquivo.equals(cpf)) {
                    return true; // CPF já cadastrado
                }
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erro ao verificar CPF: " + e.getMessage());
    }
    return false; // CPF não encontrado
    }
    
    private boolean corenJaCadastrado(String coren) {
    try (BufferedReader reader = new BufferedReader(new FileReader(BANCO_DADOS))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] partes = linha.split(";");
            if (partes.length >= 2) {
                String corenArquivo = partes[3].trim();
                if (corenArquivo.equals(coren)) {
                    return true; // COREN já cadastrado
                }
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erro ao verificar COREN: " + e.getMessage());
    }
    return false; // COREN não encontrado
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        btnSalvarCadastroEnfermeiro = new javax.swing.JToggleButton();
        btnCancelarCadastroEnfermeiro = new javax.swing.JButton();
        btnLimparCadastroEnfermeiro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNomeCadastroEnfermeiro = new javax.swing.JTextField();
        txtSetorCadastroEnfermeiro = new javax.swing.JTextField();
        txtCorenCadastroEnfermeiro = new javax.swing.JFormattedTextField();
        txtCpfCadastroEnfermeiro = new javax.swing.JFormattedTextField();
        txtDataNascimentoCadastroEnfermeiro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SAM - SISTEMA DE ADMINISTRAÇÃO DE MEDICAÇÃO");

        jPanel.setBackground(new java.awt.Color(153, 153, 255));

        btnSalvarCadastroEnfermeiro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvarCadastroEnfermeiro.setForeground(new java.awt.Color(0, 0, 0));
        btnSalvarCadastroEnfermeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvarPaciente 32px.png"))); // NOI18N
        btnSalvarCadastroEnfermeiro.setText("Salvar");
        btnSalvarCadastroEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCadastroEnfermeiroActionPerformed(evt);
            }
        });

        btnCancelarCadastroEnfermeiro.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnCancelarCadastroEnfermeiro.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelarCadastroEnfermeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        btnCancelarCadastroEnfermeiro.setText("Cancelar");
        btnCancelarCadastroEnfermeiro.setToolTipText("cancelar cadastro");
        btnCancelarCadastroEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastroEnfermeiroActionPerformed(evt);
            }
        });

        btnLimparCadastroEnfermeiro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLimparCadastroEnfermeiro.setForeground(new java.awt.Color(0, 0, 0));
        btnLimparCadastroEnfermeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/limpar.png"))); // NOI18N
        btnLimparCadastroEnfermeiro.setText("Limpar");
        btnLimparCadastroEnfermeiro.setToolTipText("limpar campos");
        btnLimparCadastroEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCadastroEnfermeiroActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("COREN*");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nome*");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Data de Nascimento*");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CPF*");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Setor*");

        txtNomeCadastroEnfermeiro.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtNomeCadastroEnfermeiro.setForeground(new java.awt.Color(0, 0, 0));

        txtSetorCadastroEnfermeiro.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtSetorCadastroEnfermeiro.setForeground(new java.awt.Color(0, 0, 0));

        txtCorenCadastroEnfermeiro.setToolTipText("dd/mm/ano");

        txtCpfCadastroEnfermeiro.setToolTipText("dd/mm/ano");

        txtDataNascimentoCadastroEnfermeiro.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtDataNascimentoCadastroEnfermeiro.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnSalvarCadastroEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarCadastroEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimparCadastroEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(9, 9, 9)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCorenCadastroEnfermeiro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCpfCadastroEnfermeiro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDataNascimentoCadastroEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(278, 278, 278))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                            .addGap(74, 74, 74)
                                            .addComponent(txtSetorCadastroEnfermeiro, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)))))
                            .addComponent(txtNomeCadastroEnfermeiro))))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(698, Short.MAX_VALUE)))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(txtNomeCadastroEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(txtCpfCadastroEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNascimentoCadastroEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(35, 35, 35)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtSetorCadastroEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtCorenCadastroEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarCadastroEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvarCadastroEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparCadastroEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jLabel3)
                    .addContainerGap(426, Short.MAX_VALUE)))
        );

        txtCorenCadastroEnfermeiro.getAccessibleContext().setAccessibleName("");
        txtCorenCadastroEnfermeiro.getAccessibleContext().setAccessibleDescription("12345-UF");
        txtCpfCadastroEnfermeiro.getAccessibleContext().setAccessibleDescription("123.456.789-10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarCadastroEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCadastroEnfermeiroActionPerformed
        if (txtNomeCadastroEnfermeiro.getText().equals("") || txtCpfCadastroEnfermeiro.getText().equals("") || txtCorenCadastroEnfermeiro.getText().equals("") || txtDataNascimentoCadastroEnfermeiro.getText().equals("") ||  txtSetorCadastroEnfermeiro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos", "Aviso", JOptionPane.PLAIN_MESSAGE);
            //btnSalvarCadastroEnfermeiro.setEnabled(true);
    } else {
        // Pegando os valores dos campos
        String nome = txtNomeCadastroEnfermeiro.getText();
        String cpf = txtCpfCadastroEnfermeiro.getText();
        String coren = txtCorenCadastroEnfermeiro.getText();
        String dataNascimentoStr = txtDataNascimentoCadastroEnfermeiro.getText();
        String setor = txtSetorCadastroEnfermeiro.getText();

        // Definindo o formato da data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Verificando se o formato da data é correto
        if (!dataNascimentoStr.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido. Por favor, use o formato dd/MM/yyyy.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tentando converter a data
        LocalDate dataNascimento = null;
        try {
            dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido. Por favor, use o formato dd/MM/yyyy.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificando se a data de nascimento não é no futuro
        LocalDate hoje = LocalDate.now();
        if (dataNascimento.isAfter(hoje)) {
            JOptionPane.showMessageDialog(null, "A data de nascimento não pode ser no futuro.", "Erro de Data", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Formatando a data para o formato desejado
        String dataFormatada = dataNascimento.format(formatter);

        // Removendo caracteres do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        if (!isNomeValido(nome)) {
            JOptionPane.showMessageDialog(null, "O nome não deve conter números ou caracteres especiais", "Nome inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cpfJaCadastrado(cpf)) {
            JOptionPane.showMessageDialog(this, "O CPF informado já está cadastrado!");
            return;
        }

        if (corenJaCadastrado(coren)) {
            JOptionPane.showMessageDialog(this, "O COREN informado já está cadastrado!");
            return;
        }

        // Verificando se o CPF é válido
        if (!Enfermeiro.isCpfValido(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF inválido", "Erro de CPF", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificando se o coren é válido
        if (!isCoren(coren)) {
            JOptionPane.showMessageDialog(null, "Formato do COREN incorreto", "Erro de COREN", JOptionPane.ERROR_MESSAGE);
            btnSalvarCadastroEnfermeiro.setEnabled(true);
            return;
        }

        // Gerando login do enfermeiro
        String[] partes = coren.split("-");
        String corenStr = partes[0].trim();

        String senhaEnfermeiro = nome.substring(0, 1).toUpperCase() + cpf;

        // Criando o objeto Enfermeiro com a data formatada
        Enfermeiro enfermeiro = new Enfermeiro(nome, cpf, dataFormatada, coren, setor);
        salvarNoArquivo(enfermeiro);
        salvarLoginNoArquivo(corenStr, senhaEnfermeiro);
        
        JOptionPane.showMessageDialog(null, "Enfermeiro " + nome + " cadastrado com sucesso no setor " + setor, "Cadastro concluído.", JOptionPane.INFORMATION_MESSAGE);

        // Limpando os campos após o cadastro
        txtNomeCadastroEnfermeiro.setText("");
        txtSetorCadastroEnfermeiro.setText("");
        txtCorenCadastroEnfermeiro.setText("");
        txtDataNascimentoCadastroEnfermeiro.setText("//");
        txtCpfCadastroEnfermeiro.setText("");   
        dispose();
        TelaEnfermeiro tela = new TelaEnfermeiro();
        tela.setVisible(true);
    }
    }//GEN-LAST:event_btnSalvarCadastroEnfermeiroActionPerformed

    private void btnCancelarCadastroEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroEnfermeiroActionPerformed
        txtNomeCadastroEnfermeiro.setText("");
        txtSetorCadastroEnfermeiro.setText("");
        txtCorenCadastroEnfermeiro.setText("");
        txtDataNascimentoCadastroEnfermeiro.setText("");
        txtCpfCadastroEnfermeiro.setText("");        
        dispose();
        TelaEnfermeiro tela = new TelaEnfermeiro();
        tela.setVisible(true);
    }//GEN-LAST:event_btnCancelarCadastroEnfermeiroActionPerformed

    private void btnLimparCadastroEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCadastroEnfermeiroActionPerformed
        txtNomeCadastroEnfermeiro.setText("");
        txtSetorCadastroEnfermeiro.setText("");
        txtCorenCadastroEnfermeiro.setText("");
        txtDataNascimentoCadastroEnfermeiro.setText("");
        txtCpfCadastroEnfermeiro.setText("");
    }//GEN-LAST:event_btnLimparCadastroEnfermeiroActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarEnfermeiro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarCadastroEnfermeiro;
    private javax.swing.JButton btnLimparCadastroEnfermeiro;
    private javax.swing.JToggleButton btnSalvarCadastroEnfermeiro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel;
    private javax.swing.JFormattedTextField txtCorenCadastroEnfermeiro;
    private javax.swing.JFormattedTextField txtCpfCadastroEnfermeiro;
    private javax.swing.JTextField txtDataNascimentoCadastroEnfermeiro;
    private javax.swing.JTextField txtNomeCadastroEnfermeiro;
    private javax.swing.JTextField txtSetorCadastroEnfermeiro;
    // End of variables declaration//GEN-END:variables
}
