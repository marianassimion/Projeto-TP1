package Telas;
public class TelaPesquisarEnfermeiro extends javax.swing.JFrame {
    public TelaPesquisarEnfermeiro() {
        initComponents();
        btNovo.setEnabled(true);
        btEditar.setEnabled(false);
        btExcluir.setEnabled(false);
        btBuscar.setEnabled(true);
        btPesquisar.setEnabled(false);

        
        lblPesquisarNome.setEnabled(false);
        lblPesquisarCoren.setEnabled(false);
        lblPesquisarSetor.setEnabled(false);


    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEnfermeiro = new javax.swing.JLabel();
        jPaneEnfermeiros = new javax.swing.JScrollPane();
        tblEnfermeiros = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        icnEnfermeiro = new javax.swing.JLabel();
        txtNomeLogado = new javax.swing.JLabel();
        txtNumeroLogado = new javax.swing.JLabel();
        icnSair = new javax.swing.JLabel();
        txtSair = new javax.swing.JLabel();
        lblPesquisarCoren = new javax.swing.JTextField();
        lblPesquisarSetor = new javax.swing.JTextField();
        lblPesquisarNome = new javax.swing.JTextField();
        txtUNome = new javax.swing.JLabel();
        txtUNome1 = new javax.swing.JLabel();
        txtUNome2 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SAM - SISTEMA DE ADMINISTRAÇÃO DE MEDICAÇÃO");
        setBackground(new java.awt.Color(153, 153, 255));
        setPreferredSize(new java.awt.Dimension(800, 500));

        txtEnfermeiro.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtEnfermeiro.setText("Enfermeiro");

        tblEnfermeiros.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblEnfermeiros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "COREN", "Setor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEnfermeiros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEnfermeirosMouseClicked(evt);
            }
        });
        jPaneEnfermeiros.setViewportView(tblEnfermeiros);
        if (tblEnfermeiros.getColumnModel().getColumnCount() > 0) {
            tblEnfermeiros.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Enfermeiro 32px.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar 32px.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/excluir 32px.png"))); // NOI18N
        btExcluir.setText("Excluir");

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar 32px.png"))); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setForeground(new java.awt.Color(153, 153, 255));

        icnEnfermeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Enfermeiro 32px.png"))); // NOI18N

        txtNomeLogado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNomeLogado.setText("Nome logado");

        txtNumeroLogado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNumeroLogado.setText("123456789");

        icnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sair 32px.png"))); // NOI18N

        txtSair.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtSair.setText("SAIR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icnEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeLogado)
                    .addComponent(txtNumeroLogado))
                .addGap(589, 589, 589)
                .addComponent(icnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(txtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(icnSair)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(txtSair)))
                    .addComponent(icnEnfermeiro)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNomeLogado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroLogado)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lblPesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblPesquisarNomeActionPerformed(evt);
            }
        });

        txtUNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUNome.setText("Nome");

        txtUNome1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUNome1.setText("Setor");

        txtUNome2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUNome2.setText("COREN");

        btPesquisar.setText("Pesquisar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtUNome)
                        .addGap(739, 739, 739))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(566, 566, 566))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addGap(27, 27, 27)
                        .addComponent(btEditar)
                        .addGap(26, 26, 26)
                        .addComponent(btExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btBuscar)
                        .addGap(161, 161, 161))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPesquisarCoren, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUNome2))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUNome1)
                            .addComponent(lblPesquisarSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPesquisar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(347, 347, 347)
                            .addComponent(txtEnfermeiro))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jPaneEnfermeiros, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEnfermeiro)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtUNome1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPesquisarSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btNovo)
                            .addComponent(btEditar)
                            .addComponent(btExcluir)
                            .addComponent(btBuscar))
                        .addGap(18, 18, 18)
                        .addComponent(jPaneEnfermeiros, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUNome2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPesquisarCoren, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblEnfermeirosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEnfermeirosMouseClicked
        // a tabela de clientes, ao ser clicada:
        //int i = tblEnfermeiros.getSelectedRow(); //pega o numero do indice da linha que esta selecionada
        
        // aula interface grafica 6B
        //if (i >= 0 && i<listaClientes.size()){
        //    Cliente cli = listaClientes.get(i);
        //    fieldCpfCliente.setText(String.valueOf(cli.getCpf()));
        //    fieldNomeCliente.setText(String.valueOf(cli.getNome()));
        //    fieldTelefoneCliente.setText(String.valueOf(cli.getTelefone()));
        //    botaoExcluirCliente.setEnabled(true);
        //    botaoEditarCliente.setEnabled(true);
        // }
       
    }//GEN-LAST:event_tblEnfermeirosMouseClicked

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        new CadastrarEnfermeiro().setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_btNovoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btEditarActionPerformed

    private void lblPesquisarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblPesquisarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblPesquisarNomeActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        btNovo.setEnabled(false);
        btEditar.setEnabled(false);
        btExcluir.setEnabled(false);
        btBuscar.setEnabled(true);
        btPesquisar.setEnabled(true);

        
        lblPesquisarNome.setEnabled(true);
        lblPesquisarCoren.setEnabled(true);
        lblPesquisarSetor.setEnabled(true);
    }//GEN-LAST:event_btBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaPesquisarEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPesquisarEnfermeiro().setVisible(true);

            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JLabel icnEnfermeiro;
    private javax.swing.JLabel icnSair;
    private javax.swing.JScrollPane jPaneEnfermeiros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lblPesquisarCoren;
    private javax.swing.JTextField lblPesquisarNome;
    private javax.swing.JTextField lblPesquisarSetor;
    private javax.swing.JTable tblEnfermeiros;
    private javax.swing.JLabel txtEnfermeiro;
    private javax.swing.JLabel txtNomeLogado;
    private javax.swing.JLabel txtNumeroLogado;
    private javax.swing.JLabel txtSair;
    private javax.swing.JLabel txtUNome;
    private javax.swing.JLabel txtUNome1;
    private javax.swing.JLabel txtUNome2;
    // End of variables declaration//GEN-END:variables
}
