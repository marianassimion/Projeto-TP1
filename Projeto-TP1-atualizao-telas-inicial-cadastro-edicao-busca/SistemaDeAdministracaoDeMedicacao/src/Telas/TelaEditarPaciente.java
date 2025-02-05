package Telas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import sam.Paciente;

public class TelaEditarPaciente extends javax.swing.JFrame {
    private static final String BANCO_DADOS = "cadastro_pacientes.txt";

    public TelaEditarPaciente(String nome, String cpf, String dataNascimento, float peso, float altura, int idade, String alergia) {
        initComponents();
        setLocationRelativeTo(null); //muda o local de origem da tela
        
        txtNomePacienteEditar.setText(nome);
        txtCpfPacienteEditar.setText(cpf);
        txtDataNascimentoPacienteEditar.setText(dataNascimento);
        txtPesoPacienteEditar.setText(String.valueOf(peso));
        txtAlturaPacienteEditar.setText(String.valueOf(altura));
        cbAlergiasPacienteEditar.setSelectedItem(alergia);
    }
    
    private static boolean isNomeValido(String nome) {
        for (int i = 0; i < nome.length(); i++){
            char c = nome.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false; // Se encontrar um caractere inválido, retorna falso
            }
        }
        return true;
    }

    private static int calcularIdade(LocalDate dataNascimento){
        LocalDate hoje = LocalDate.now();  // Data atual
        Period periodo = Period.between(dataNascimento, hoje); 
        int idade  = periodo.getYears();
            return idade;  // Retorna a quantidade de anos
    }
    
    //validação de cpf aqui
    private static boolean isCpf(String cpf){
        if ((cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || (cpf.length() != 11))){
            return(false);
        }
        else{
            return (true);
        }
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
    
    private void atualizarDados(int linhaEditada, String novoNome, String novoCpf, String novoDataNascimento, Float novoPeso, Float novoAltura, int novoIdade, String novoAlergia){
            try {
                // Lê todas as linhas do arquivo
                BufferedReader reader = new BufferedReader(new FileReader(BANCO_DADOS));
                StringBuilder conteudo = new StringBuilder();
                String linha;
                int linhaAtual = 0;
                
                while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split(";");

                    if (linhaAtual == linhaEditada) {
                        String idade = String.valueOf(novoIdade);
                        // Atualiza a linha editada
                        partes[0] = novoNome;
                        partes[1] = novoCpf;
                        partes[2] = novoDataNascimento;
                        partes[3] = String.valueOf(novoPeso);   
                        partes[4] = String.valueOf(novoAltura); 
                        partes[5] = idade;
                        partes[6] = novoAlergia;
                        linha = String.join(";", partes);
                    }

                    conteudo.append(linha).append("\n");
                    linhaAtual++;
                }

                reader.close();

                FileWriter writer = new FileWriter(BANCO_DADOS);
                writer.write(conteudo.toString());
                writer.close();

                System.out.println("Arquivo atualizado com sucesso!");

            } catch (IOException e) {
                System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
            }
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomePacienteEditar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCpfPacienteEditar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDataNascimentoPacienteEditar = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        cbAlergiasPacienteEditar = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtAlturaPacienteEditar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPesoPacienteEditar = new javax.swing.JTextField();
        btnSalvarPacienteEditar = new javax.swing.JButton();
        btnCancelarPacienteEditar = new javax.swing.JButton();
        btnLimparPacienteEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome*");

        txtNomePacienteEditar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtNomePacienteEditar.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CPF*");

        txtCpfPacienteEditar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtCpfPacienteEditar.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Data de Nascimento*");

        txtDataNascimentoPacienteEditar.setToolTipText("dd/mm/ano");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Alergias*");

        cbAlergiasPacienteEditar.setBackground(new java.awt.Color(255, 255, 255));
        cbAlergiasPacienteEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbAlergiasPacienteEditar.setForeground(new java.awt.Color(0, 0, 0));
        cbAlergiasPacienteEditar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Nenhuma", "Penicilina", "Benzetacil", "Dipirona", "Paracetamol", "Insulina", "Heparina", "Outro" }));
        cbAlergiasPacienteEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlergiasPacienteEditarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Altura*");

        txtAlturaPacienteEditar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtAlturaPacienteEditar.setForeground(new java.awt.Color(0, 0, 0));
        txtAlturaPacienteEditar.setToolTipText("altura em cm");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText(" Peso*");

        txtPesoPacienteEditar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtPesoPacienteEditar.setForeground(new java.awt.Color(0, 0, 0));
        txtPesoPacienteEditar.setToolTipText("peso em Kg");

        btnSalvarPacienteEditar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvarPacienteEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnSalvarPacienteEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvarPaciente 32px.png"))); // NOI18N
        btnSalvarPacienteEditar.setText("Salvar");
        btnSalvarPacienteEditar.setToolTipText("salvar paciente");
        btnSalvarPacienteEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPacienteEditarActionPerformed(evt);
            }
        });

        btnCancelarPacienteEditar.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnCancelarPacienteEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelarPacienteEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        btnCancelarPacienteEditar.setText("Cancelar");
        btnCancelarPacienteEditar.setToolTipText("cancelar cadastro");
        btnCancelarPacienteEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPacienteEditarActionPerformed(evt);
            }
        });

        btnLimparPacienteEditar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLimparPacienteEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimparPacienteEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/limpar.png"))); // NOI18N
        btnLimparPacienteEditar.setText("Limpar");
        btnLimparPacienteEditar.setToolTipText("limpar campos");
        btnLimparPacienteEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparPacienteEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbAlergiasPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtAlturaPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPesoPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDataNascimentoPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCpfPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomePacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(btnSalvarPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimparPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomePacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpfPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtDataNascimentoPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cbAlergiasPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPesoPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtAlturaPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparPacienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
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
    }// </editor-fold>//GEN-END:initComponents

    private void cbAlergiasPacienteEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlergiasPacienteEditarActionPerformed
    }//GEN-LAST:event_cbAlergiasPacienteEditarActionPerformed

    private void btnSalvarPacienteEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPacienteEditarActionPerformed
        // verificação de campo vazio

        if (txtDataNascimentoPacienteEditar.getText().equals("") || txtAlturaPacienteEditar.getText().equals("")|| txtCpfPacienteEditar.getText().equals("") ||txtNomePacienteEditar.getText().equals("") || txtPesoPacienteEditar.getText().equals("") || cbAlergiasPacienteEditar.getSelectedItem().equals("Selecione")){
            JOptionPane.showMessageDialog(null,"Todos os campos devem ser preenchidos", "Aviso", JOptionPane.PLAIN_MESSAGE);
        }

        else{
            try{
                String novoNome = txtNomePacienteEditar.getText();
                String novoCpf = txtCpfPacienteEditar.getText();
                String novoDataNascimentoStr = txtDataNascimentoPacienteEditar.getText();
                String novoAlergia = cbAlergiasPacienteEditar.getSelectedItem().toString();
                String novoPesoStr = txtPesoPacienteEditar.getText().replace(",", ".");
                String novoAlturaStr =txtAlturaPacienteEditar.getText().replace(",", ".");

                float novoPeso = Float.valueOf(novoPesoStr);
                float novoAltura = Float.valueOf(novoAlturaStr);
                

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Definindo o formato da data
                LocalDate dataNascimento = LocalDate.parse(novoDataNascimentoStr, formatter);
                LocalDate hoje = LocalDate.now();

                int idade = calcularIdade(dataNascimento);

                // Removendo caracteres não numéricos
                novoCpf = novoCpf.replaceAll("[^0-9]", "");

                if (!isNomeValido(novoNome)){
                    JOptionPane.showMessageDialog(null, "O nome não deve conter números ou caracteres especiais", "Nome inválido", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (dataNascimento.isAfter(hoje)) {
                    JOptionPane.showMessageDialog(null, "A data de nascimento não pode ser no futuro.", "Erro de Data", JOptionPane.ERROR_MESSAGE);
                    return;}

                if (isCpf(novoCpf) == false) {
                    JOptionPane.showMessageDialog(null, "Insira um CPF válido", "Erro de CPF", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (cpfJaCadastrado(novoCpf)) {
                    JOptionPane.showMessageDialog(this, "O CPF informado já está cadastrado!");
                    return;
                }
                
                JOptionPane.showMessageDialog(null, "Paciente "+ novoNome +" atualizado com sucesso", "Edição Concluida", JOptionPane.INFORMATION_MESSAGE);

                txtNomePacienteEditar.setText("");
                txtCpfPacienteEditar.setText("");
                txtDataNascimentoPacienteEditar.setText("");
                txtPesoPacienteEditar.setText("");
                txtAlturaPacienteEditar.setText("");
                cbAlergiasPacienteEditar.setSelectedItem("Selecione");
                dispose();
                
                atualizarDados(1, novoNome, novoCpf, novoDataNascimentoStr, novoPeso, novoAltura, idade, novoAlergia);
                this.dispose();
                TelaPacientes tela = new TelaPacientes();
                tela.setVisible(true);
            }

            catch (DateTimeParseException e){
                JOptionPane.showMessageDialog(null, "Formato de data inválido. Por favor, use o formato dd/MM/YYYY.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Os campos peso e altura devem conter apenas números e '.' ", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSalvarPacienteEditarActionPerformed

    private void btnCancelarPacienteEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPacienteEditarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarPacienteEditarActionPerformed

    private void btnLimparPacienteEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparPacienteEditarActionPerformed
        txtNomePacienteEditar.setText("");
        txtCpfPacienteEditar.setText("");
        txtDataNascimentoPacienteEditar.setText("");
        txtPesoPacienteEditar.setText("");
        txtAlturaPacienteEditar.setText("");
        cbAlergiasPacienteEditar.setSelectedItem("Selecione");
    }//GEN-LAST:event_btnLimparPacienteEditarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String nome = "Edição de Enfermeiro";
                String cpf = "12345678901";
                String dataNascimento = "02/02/0202";
                float peso = 1;
                float altura = 1;
                int idade = 1;
                String alergia = "A";
                new TelaEditarPaciente(nome, cpf, dataNascimento, peso, altura, idade, alergia).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarPacienteEditar;
    private javax.swing.JButton btnLimparPacienteEditar;
    private javax.swing.JButton btnSalvarPacienteEditar;
    private javax.swing.JComboBox<String> cbAlergiasPacienteEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAlturaPacienteEditar;
    private javax.swing.JTextField txtCpfPacienteEditar;
    private javax.swing.JFormattedTextField txtDataNascimentoPacienteEditar;
    private javax.swing.JTextField txtNomePacienteEditar;
    private javax.swing.JTextField txtPesoPacienteEditar;
    // End of variables declaration//GEN-END:variables
}
