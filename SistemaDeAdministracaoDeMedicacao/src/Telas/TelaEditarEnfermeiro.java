package Telas;
public class TelaEditarEnfermeiro extends javax.swing.JFrame {

    public TelaEditarEnfermeiro(String nome,String cpf, String dataNascimento, String coren, String setor) {
        initComponents();
        txtNomeEditarEnfermeiro.setText(nome);
        txtCorenEditarEnfermeiro.setText(coren);
        txtCpfEditarEnfermeiro.setText(cpf);
        txtSetorEditarEnfermeiro.setText(setor);
        txtDataNascimentoEditarEnfermeiro.setText(dataNascimento);
        
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
                String nome = "João Silva";
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
