package Telas;

import static Telas.CadastrarEnfermeiro.salvarNoArquivo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import sam.Enfermeiro;

public class TelaEditarEnfermeiro extends javax.swing.JFrame {
    private static final String BANCO_DADOS = "cadastro_enfermeiro.txt";
    
    public TelaEditarEnfermeiro(String nome,String cpf, String dataNascimento, String coren, String setor) {
        initComponents();
         setLocationRelativeTo(null); //muda o local de origem da tela

        txtNomeEditarEnfermeiro.setText(nome);
        txtCorenEditarEnfermeiro.setText(coren);
        txtCpfEditarEnfermeiro.setText(cpf);
        txtSetorEditarEnfermeiro.setText(setor);
        txtDataNascimentoEditarEnfermeiro.setText(dataNascimento);
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
    private void atualizarDados(int linhaEditada, String novoNome, String novoCpf, String novoDataNascimento, String novoCoren, String novoSetor){
            try {
                // Lê todas as linhas do arquivo
                BufferedReader reader = new BufferedReader(new FileReader(BANCO_DADOS));
                StringBuilder conteudo = new StringBuilder();
                String linha;
                int linhaAtual = 0;
                while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split(";");

                    if (linhaAtual == linhaEditada) {
                        // Atualiza a linha editada
                        partes[0] = novoNome;
                        partes[1] = novoCpf;
                        partes[2] = novoDataNascimento;
                        partes[3] = novoCoren;
                        partes[4] = novoSetor;
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
        labelnome = new javax.swing.JLabel();
        labelcpf = new javax.swing.JLabel();
        labelcoren = new javax.swing.JLabel();
        txtNomeEditarEnfermeiro = new javax.swing.JTextField();
        txtCorenEditarEnfermeiro = new javax.swing.JTextField();
        txtCpfEditarEnfermeiro = new javax.swing.JTextField();
        labeldata = new javax.swing.JLabel();
        labelsetor = new javax.swing.JLabel();
        txtDataNascimentoEditarEnfermeiro = new javax.swing.JTextField();
        txtSetorEditarEnfermeiro = new javax.swing.JTextField();
        btnSalvarEditarEnfermeiro = new javax.swing.JButton();
        btnLimparEditarEnfermeiro = new javax.swing.JButton();
        btnCancelarEditarEnfermeiro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        labelnome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelnome.setForeground(new java.awt.Color(0, 0, 0));
        labelnome.setText("Nome:*");

        labelcpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelcpf.setForeground(new java.awt.Color(0, 0, 0));
        labelcpf.setText("CPF:*");

        labelcoren.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelcoren.setForeground(new java.awt.Color(0, 0, 0));
        labelcoren.setText("COREN:*");

        labeldata.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labeldata.setForeground(new java.awt.Color(0, 0, 0));
        labeldata.setText("Data de Nasicmento:*");

        labelsetor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelsetor.setForeground(new java.awt.Color(0, 0, 0));
        labelsetor.setText("Setor*:");

        txtSetorEditarEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSetorEditarEnfermeiroActionPerformed(evt);
            }
        });

        btnSalvarEditarEnfermeiro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvarEditarEnfermeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvarPaciente 32px.png"))); // NOI18N
        btnSalvarEditarEnfermeiro.setText("Salvar");
        btnSalvarEditarEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarEditarEnfermeiroActionPerformed(evt);
            }
        });

        btnLimparEditarEnfermeiro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLimparEditarEnfermeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/limpar.png"))); // NOI18N
        btnLimparEditarEnfermeiro.setText("Limpar");
        btnLimparEditarEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparEditarEnfermeiroActionPerformed(evt);
            }
        });

        btnCancelarEditarEnfermeiro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCancelarEditarEnfermeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        btnCancelarEditarEnfermeiro.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelcoren)
                    .addComponent(labelcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelnome, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCpfEditarEnfermeiro, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(txtCorenEditarEnfermeiro))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labeldata)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDataNascimentoEditarEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelsetor)
                                .addGap(41, 41, 41)
                                .addComponent(txtSetorEditarEnfermeiro))))
                    .addComponent(txtNomeEditarEnfermeiro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addComponent(btnSalvarEditarEnfermeiro)
                .addGap(43, 43, 43)
                .addComponent(btnCancelarEditarEnfermeiro)
                .addGap(36, 36, 36)
                .addComponent(btnLimparEditarEnfermeiro)
                .addGap(161, 161, 161))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelnome)
                    .addComponent(txtNomeEditarEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelcpf)
                    .addComponent(labeldata)
                    .addComponent(txtCpfEditarEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNascimentoEditarEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelcoren)
                    .addComponent(txtCorenEditarEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelsetor)
                    .addComponent(txtSetorEditarEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarEditarEnfermeiro)
                    .addComponent(btnLimparEditarEnfermeiro)
                    .addComponent(btnCancelarEditarEnfermeiro))
                .addContainerGap(160, Short.MAX_VALUE))
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

    private void txtSetorEditarEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSetorEditarEnfermeiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSetorEditarEnfermeiroActionPerformed

    private void btnLimparEditarEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparEditarEnfermeiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparEditarEnfermeiroActionPerformed

    private void btnSalvarEditarEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarEditarEnfermeiroActionPerformed
        // TODO add your handling code here:
        if (txtNomeEditarEnfermeiro.getText().equals("") || txtCpfEditarEnfermeiro.getText().equals("") || txtCorenEditarEnfermeiro.getText().equals("") || txtSetorEditarEnfermeiro.getText().equals("") || txtDataNascimentoEditarEnfermeiro.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos", "Aviso", JOptionPane.PLAIN_MESSAGE);
            btnSalvarEditarEnfermeiro.setEnabled(true);

        }
        
        else{
            try{
                //Pegando os valores dos campos
                String novoNome = txtNomeEditarEnfermeiro.getText();
                String novoCpf = txtCpfEditarEnfermeiro.getText();
                String novoDataNascimentoStr = txtDataNascimentoEditarEnfermeiro.getText();
                String novoCoren = txtCorenEditarEnfermeiro.getText();
                String novoSetor = txtSetorEditarEnfermeiro.getText();
            
                //Formatando a data
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Definindo o formato da data
                LocalDate novoDataNascimento = LocalDate.parse(novoDataNascimentoStr, formatter);
                LocalDate hoje = LocalDate.now();
                
                //removendo caracteres do cpf
                novoCpf = novoCpf.replaceAll("[^0-9]", "");
                
                if (!isNomeValido(novoNome)){
                    JOptionPane.showMessageDialog(null, "O nome não deve conter números ou caracteres especiais", "Nome inválido", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                
                //verificando se a data de nascimento não é no futuro
                if (novoDataNascimento.isAfter(hoje)) {
                    JOptionPane.showMessageDialog(null, "A data de nascimento não pode ser no futuro.", "Erro de Data", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                
                //verificando se o cpf é válido
                if (!Enfermeiro.isCpfValido(novoCpf)) {
                    JOptionPane.showMessageDialog(null, "CPF inválido", "Erro de CPF", JOptionPane.ERROR_MESSAGE);
                        return;
                }

                //Verificando se o coren é válido
                if (!isCoren(novoCoren)){
                    JOptionPane.showMessageDialog(null, "Formato do COREN incorreto", "Erro de COREN", JOptionPane.ERROR_MESSAGE);
                    btnSalvarEditarEnfermeiro.setEnabled(true);
                    return;
                }
                
              
                JOptionPane.showMessageDialog(null, "Enfermeiro " + novoNome + " editado com sucesso no setor " + novoSetor, "Edição concluída", JOptionPane.INFORMATION_MESSAGE);

                txtNomeEditarEnfermeiro.setText("");
                txtSetorEditarEnfermeiro.setText("");
                txtCorenEditarEnfermeiro.setText("");
                txtDataNascimentoEditarEnfermeiro.setText("//");
                txtCpfEditarEnfermeiro.setText("");   
                dispose();
                
                atualizarDados(1, novoNome, novoCpf, novoDataNascimentoStr, novoCoren, novoSetor);
                this.dispose();
                TelaEnfermeiro tela = new TelaEnfermeiro();
                tela.setVisible(true);
            }
            
            catch(DateTimeParseException e){
                JOptionPane.showMessageDialog(null, "Formato de data inválido. Por favor, use o formato dd/MM/YYYY.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
                btnSalvarEditarEnfermeiro.setEnabled(true);


            }
        }
        
    }//GEN-LAST:event_btnSalvarEditarEnfermeiroActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEditarEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditarEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditarEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditarEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                /// dados ficticios para inicializar a tela
                String nome = "Edição de Enfermeiro";
                String cpf = "12345678901";
                String dataNascimento = "1980-02-20";
                String coren = "1234-UF";
                String setor = "Azul";
                TelaEditarEnfermeiro tela = new TelaEditarEnfermeiro(nome, cpf, dataNascimento, coren, setor);
                tela.setVisible(true); // Exibe a tela

                //new TelaEditarEnfermeiro(nome, cpf, dataNasicmento, core, setor).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarEditarEnfermeiro;
    private javax.swing.JButton btnLimparEditarEnfermeiro;
    private javax.swing.JButton btnSalvarEditarEnfermeiro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelcoren;
    private javax.swing.JLabel labelcpf;
    private javax.swing.JLabel labeldata;
    private javax.swing.JLabel labelnome;
    private javax.swing.JLabel labelsetor;
    private javax.swing.JTextField txtCorenEditarEnfermeiro;
    private javax.swing.JTextField txtCpfEditarEnfermeiro;
    private javax.swing.JTextField txtDataNascimentoEditarEnfermeiro;
    private javax.swing.JTextField txtNomeEditarEnfermeiro;
    private javax.swing.JTextField txtSetorEditarEnfermeiro;
    // End of variables declaration//GEN-END:variables
}
