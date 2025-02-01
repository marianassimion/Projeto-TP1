package Telas;
import sam.Paciente;
import java.io.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TelaCadastroPaciente extends javax.swing.JFrame {
    
    //static ArrayList<Paciente> listaPacientes;
    private static final String BANCO_DADOS = "cadastro_pacientes.txt";
    
    public TelaCadastroPaciente() {
       // listaPacientes = new ArrayList(); //lista vazia de pacientes
        
        initComponents();
        setLocationRelativeTo(null); //muda o local de origem da tela
        
        //setando os botões e labels
        btnCancelarCadastroPaciente.setEnabled(true);
        btnSalvarCadastroPaciente.setEnabled(true);
        btnLimparDadosCadastroPaciente.setEnabled(true);
        
        txtNomePacienteCadastro.setText("");
        txtCpfPacienteCadastro.setText("");
        txtDataNascimentoPacienteCadastro.setText("//");
        txtPesoPacienteCadastro.setText("");
        txtAlturaPacienteCadastro.setText("");
        txtIdadePacienteCadastro.setText("");
        cbAlergiasPacienteCadastro.setSelectedItem("Selecione");
        listarArquivo();


    }
    public static void salvarNoArquivo(Paciente paciente){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BANCO_DADOS, true))){
                        
            writer.write(paciente.toString());
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
                float peso = Float.parseFloat(partes[3].trim());
                float altura = Float.parseFloat(partes[4].trim());
                int idade = Integer.parseInt(partes[5].trim());
                String alergia = partes[6].trim();
            }
        }
        catch (IOException e) {
            System.out.println("Erro ao ler os dados: " + e.getMessage());
        }}
    

    //validação de cpf aquii

    public static boolean isCpfValido(String cpf) {
        // Verificando se tem 11 dígitos
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // Cálculo do primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * (10 - i);
            }
            int primeiroDigito = 11 - (soma % 11);
            if (primeiroDigito >= 10) primeiroDigito = 0;

            // Cálculo do segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * (11 - i);
            }
            int segundoDigito = 11 - (soma % 11);
            if (segundoDigito >= 10) segundoDigito = 0;

            // Comparando com os dígitos informados
            return (cpf.charAt(9) - '0' == primeiroDigito) && (cpf.charAt(10) - '0' == segundoDigito);
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isCpf(String cpf){
        if ((cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || (cpf.length() != 11))){
            return(false);
        }
        else{
            return (true);
        }

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSalvarCadastroPaciente = new javax.swing.JButton();
        btnCancelarCadastroPaciente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbAlergiasPacienteCadastro = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNomePacienteCadastro = new javax.swing.JTextField();
        txtCpfPacienteCadastro = new javax.swing.JTextField();
        txtDataNascimentoPacienteCadastro = new javax.swing.JFormattedTextField();
        txtIdadePacienteCadastro = new javax.swing.JTextField();
        txtAlturaPacienteCadastro = new javax.swing.JTextField();
        txtPesoPacienteCadastro = new javax.swing.JTextField();
        btnLimparDadosCadastroPaciente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Pacientes");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        btnSalvarCadastroPaciente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvarCadastroPaciente.setForeground(new java.awt.Color(0, 0, 0));
        btnSalvarCadastroPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvarPaciente 32px.png"))); // NOI18N
        btnSalvarCadastroPaciente.setText("Salvar");
        btnSalvarCadastroPaciente.setToolTipText("salvar paciente");
        btnSalvarCadastroPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCadastroPacienteActionPerformed(evt);
            }
        });

        btnCancelarCadastroPaciente.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnCancelarCadastroPaciente.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelarCadastroPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        btnCancelarCadastroPaciente.setText("Cancelar");
        btnCancelarCadastroPaciente.setToolTipText("cancelar cadastro");
        btnCancelarCadastroPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastroPacienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Data de Nascimento*");

        cbAlergiasPacienteCadastro.setBackground(new java.awt.Color(255, 255, 255));
        cbAlergiasPacienteCadastro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbAlergiasPacienteCadastro.setForeground(new java.awt.Color(0, 0, 0));
        cbAlergiasPacienteCadastro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Nenhuma", "Penicilina", "Benzetacil", "Dipirona", "Paracetamol", "Insulina", "Heparina", "Outro" }));
        cbAlergiasPacienteCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlergiasPacienteCadastroActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText(" Peso*");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Altura*");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome*");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CPF*");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Alergias*");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Idade*");

        txtNomePacienteCadastro.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtNomePacienteCadastro.setForeground(new java.awt.Color(0, 0, 0));

        txtCpfPacienteCadastro.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtCpfPacienteCadastro.setForeground(new java.awt.Color(0, 0, 0));

        txtDataNascimentoPacienteCadastro.setToolTipText("dd/mm/ano");

        txtIdadePacienteCadastro.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtIdadePacienteCadastro.setForeground(new java.awt.Color(0, 0, 0));

        txtAlturaPacienteCadastro.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtAlturaPacienteCadastro.setForeground(new java.awt.Color(0, 0, 0));
        txtAlturaPacienteCadastro.setToolTipText("altura em cm");

        txtPesoPacienteCadastro.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtPesoPacienteCadastro.setForeground(new java.awt.Color(0, 0, 0));
        txtPesoPacienteCadastro.setToolTipText("peso em Kg");

        btnLimparDadosCadastroPaciente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLimparDadosCadastroPaciente.setForeground(new java.awt.Color(0, 0, 0));
        btnLimparDadosCadastroPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/limpar.png"))); // NOI18N
        btnLimparDadosCadastroPaciente.setText("Limpar");
        btnLimparDadosCadastroPaciente.setToolTipText("limpar campos");
        btnLimparDadosCadastroPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparDadosCadastroPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalvarCadastroPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtAlturaPacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPesoPacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDataNascimentoPacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarCadastroPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimparDadosCadastroPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbAlergiasPacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCpfPacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNomePacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIdadePacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomePacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpfPacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtDataNascimentoPacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdadePacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesoPacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtAlturaPacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbAlergiasPacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarCadastroPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarCadastroPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparDadosCadastroPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbAlergiasPacienteCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlergiasPacienteCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAlergiasPacienteCadastroActionPerformed

    private void btnLimparDadosCadastroPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparDadosCadastroPacienteActionPerformed
        txtNomePacienteCadastro.setText("");
        txtCpfPacienteCadastro.setText("");
        txtDataNascimentoPacienteCadastro.setText("");
        txtPesoPacienteCadastro.setText("");
        txtAlturaPacienteCadastro.setText("");
        txtIdadePacienteCadastro.setText("");
        cbAlergiasPacienteCadastro.setSelectedItem("Selecione");
    }//GEN-LAST:event_btnLimparDadosCadastroPacienteActionPerformed

    private void btnCancelarCadastroPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroPacienteActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarCadastroPacienteActionPerformed

    private void btnSalvarCadastroPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCadastroPacienteActionPerformed
        // verificação de campo vazio

        if (txtDataNascimentoPacienteCadastro.getText().equals("") || txtAlturaPacienteCadastro.getText().equals("")|| txtCpfPacienteCadastro.getText().equals("")|| txtIdadePacienteCadastro.getText().equals("") || txtNomePacienteCadastro.getText().equals("") || txtPesoPacienteCadastro.getText().equals("") || cbAlergiasPacienteCadastro.getSelectedItem().equals("Selecione")){
            JOptionPane.showMessageDialog(null,"Todos os campos devem ser preenchidos", "Aviso", JOptionPane.PLAIN_MESSAGE);
        }
        
        else{
            try{
                String nome = txtNomePacienteCadastro.getText();
                String cpf = txtCpfPacienteCadastro.getText();
                String dataNascimentoStr = txtDataNascimentoPacienteCadastro.getText();
                String alergia = cbAlergiasPacienteCadastro.getSelectedItem().toString();
                
                float peso = Float.valueOf(txtPesoPacienteCadastro.getText());
                float altura = Float.valueOf(txtAlturaPacienteCadastro.getText());
                int idade = Integer.parseInt(txtIdadePacienteCadastro.getText());
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Definindo o formato da data
                LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
                
                LocalDate hoje = LocalDate.now();

                // Removendo caracteres não numéricos
                cpf = cpf.replaceAll("[^0-9]", "");

                
                if (dataNascimento.isAfter(hoje)) {
                    JOptionPane.showMessageDialog(null, "A data de nascimento não pode ser no futuro.", "Erro de Data", JOptionPane.ERROR_MESSAGE);
                        return;}

                if (isCpf(cpf) == false) {
                    JOptionPane.showMessageDialog(null, "CPF deve conter exatamente 11 dígitos numéricos.", "Erro de CPF", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                
                if (isCpfValido(cpf) == false) {
                    JOptionPane.showMessageDialog(null, "Insira um CPF válido", "Erro de CPF", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                
                Paciente paciente = new Paciente (peso, altura, idade, nome, cpf, dataNascimento, alergia);
                salvarNoArquivo(paciente);
                
                JOptionPane.showMessageDialog(null, "Paciente "+ nome +" cadastrado com sucesso", "Cadastro Concluido", JOptionPane.INFORMATION_MESSAGE);
                
                txtNomePacienteCadastro.setText("");
                txtCpfPacienteCadastro.setText("");
                txtDataNascimentoPacienteCadastro.setText("");
                txtPesoPacienteCadastro.setText("");
                txtAlturaPacienteCadastro.setText("");
                txtIdadePacienteCadastro.setText("");
                cbAlergiasPacienteCadastro.setSelectedItem("Selecione");
                dispose();
                
            }
            
            catch (DateTimeParseException e){
                JOptionPane.showMessageDialog(null, "Formato de data inválido. Por favor, use o formato dd/MM/YYYY.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para peso, altura e idade.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            } 
        }
        listarArquivo();

    }//GEN-LAST:event_btnSalvarCadastroPacienteActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarCadastroPaciente;
    private javax.swing.JButton btnLimparDadosCadastroPaciente;
    private javax.swing.JButton btnSalvarCadastroPaciente;
    private javax.swing.JComboBox<String> cbAlergiasPacienteCadastro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAlturaPacienteCadastro;
    private javax.swing.JTextField txtCpfPacienteCadastro;
    private javax.swing.JFormattedTextField txtDataNascimentoPacienteCadastro;
    private javax.swing.JTextField txtIdadePacienteCadastro;
    private javax.swing.JTextField txtNomePacienteCadastro;
    private javax.swing.JTextField txtPesoPacienteCadastro;
    // End of variables declaration//GEN-END:variables
}
