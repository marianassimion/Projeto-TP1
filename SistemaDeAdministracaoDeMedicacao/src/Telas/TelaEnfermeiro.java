package Telas;
import Telas.CadastrarEnfermeiro;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class TelaEnfermeiro extends javax.swing.JFrame {
    private static final String BANCO_DADOS = "cadastro_enfermeiro.txt";

    public TelaEnfermeiro() {

        initComponents();
        btNovo.setEnabled(true);
        btEditar.setEnabled(false);
        btExcluir.setEnabled(false);
        btBuscar.setEnabled(true);
        btPesquisar.setEnabled(false);

        lblPesquisarNome.setEnabled(false);
        lblPesquisarCoren.setEnabled(false);
        lblPesquisarSetor.setEnabled(false);
        
        carregarTabelaEnfermeiros();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPaneEnfermeiros = new javax.swing.JScrollPane();
        tblEnfermeiros = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblPesquisarNome = new javax.swing.JTextField();
        txtUNome = new javax.swing.JLabel();
        txtUNome2 = new javax.swing.JLabel();
        lblPesquisarCoren = new javax.swing.JTextField();
        txtUNome1 = new javax.swing.JLabel();
        lblPesquisarSetor = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        txtEnfermeiro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SAM - SISTEMA DE ADMINISTRAÇÃO DE MEDICAÇÃO");
        setBackground(new java.awt.Color(153, 153, 255));

        tblEnfermeiros.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblEnfermeiros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Data de Nascimento", "COREN", "Setor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            tblEnfermeiros.getColumnModel().getColumn(0).setResizable(false);
            tblEnfermeiros.getColumnModel().getColumn(1).setResizable(false);
            tblEnfermeiros.getColumnModel().getColumn(2).setResizable(false);
            tblEnfermeiros.getColumnModel().getColumn(3).setResizable(false);
            tblEnfermeiros.getColumnModel().getColumn(4).setResizable(false);
            tblEnfermeiros.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        btNovo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Enfermeiro 32px.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btEditar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar 32px.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/excluir 32px.png"))); // NOI18N
        btExcluir.setText("Excluir");

        btBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscaPaciente 32px.png"))); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        lblPesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblPesquisarNomeActionPerformed(evt);
            }
        });

        txtUNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtUNome.setForeground(new java.awt.Color(0, 0, 0));
        txtUNome.setText("Nome");

        txtUNome2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtUNome2.setForeground(new java.awt.Color(0, 0, 0));
        txtUNome2.setText("COREN");

        txtUNome1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtUNome1.setForeground(new java.awt.Color(0, 0, 0));
        txtUNome1.setText("Setor");

        btPesquisar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btPesquisar.setText("Pesquisar");

        txtEnfermeiro.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtEnfermeiro.setForeground(new java.awt.Color(0, 0, 0));
        txtEnfermeiro.setText("Enfermeiro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(txtEnfermeiro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUNome)
                    .addComponent(txtUNome1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPesquisarNome)
                    .addComponent(lblPesquisarSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUNome2)
                        .addGap(18, 18, 18)
                        .addComponent(lblPesquisarCoren, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btPesquisar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEnfermeiro)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUNome)
                    .addComponent(txtUNome2)
                    .addComponent(lblPesquisarCoren, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPesquisarSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUNome1)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btNovo)
                .addGap(27, 27, 27)
                .addComponent(btEditar)
                .addGap(26, 26, 26)
                .addComponent(btExcluir)
                .addGap(18, 18, 18)
                .addComponent(btBuscar)
                .addGap(142, 142, 142))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPaneEnfermeiros)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btEditar)
                    .addComponent(btExcluir)
                    .addComponent(btBuscar))
                .addGap(18, 18, 18)
                .addComponent(jPaneEnfermeiros, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarTabelaEnfermeiros() {
    DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome", "CPF", "Data de Nascimento", "COREN", "Setor"}, 0);
    
    try (BufferedReader reader = new BufferedReader(new FileReader(BANCO_DADOS))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            System.out.println("Linha lida: " + linha);
            String[] partes = linha.split(";");

            if (partes.length < 5) {
                System.out.println("Linha inválida, ignorando: " + linha);
                continue;
            }

            String nome = partes[0].trim();
            String cpf = partes[1].trim();
            String dataNascimento = partes[2].trim();
            String coren = partes[3].trim();
            String setor = partes[4].trim();
            
           
            modelo.addRow(new Object[]{nome, cpf, dataNascimento, coren, setor }); //cria uma linha nova na tabela
        }
    } catch (IOException e) {
        System.out.println("Erro ao ler os dados: " + e.getMessage());
    }

    tblEnfermeiros.setModel(modelo);
}

    
    private void tblEnfermeirosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEnfermeirosMouseClicked
        // a tabela de clientes, ao ser clicada:
        int i = tblEnfermeiros.getSelectedRow(); //pega o numero do indice da linha que esta selecionada
        
        String nome = (String) tblEnfermeiros.getValueAt(i, 0);
        String cpf = (String) tblEnfermeiros.getValueAt(i, 1);
        String dataNascimento = (String) tblEnfermeiros.getValueAt(i, 2);
        String coren = (String) tblEnfermeiros.getValueAt(i, 3);
        String setor = (String) tblEnfermeiros.getValueAt(i, 4);

        lblPesquisarNome.setText(nome);
        lblPesquisarCoren.setText(coren);
        lblPesquisarSetor.setText(setor);
        
        btEditar.setEnabled(true);
       
    }//GEN-LAST:event_tblEnfermeirosMouseClicked

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        new CadastrarEnfermeiro().setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_btNovoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        int i = tblEnfermeiros.getSelectedRow(); //pega o numero do indice da linha que esta selecionada
        
        if(i >= 0){
            String nome = (String) tblEnfermeiros.getValueAt(i, 0);
            String cpf = (String) tblEnfermeiros.getValueAt(i, 1);
            String dataNascimento = (String) tblEnfermeiros.getValueAt(i, 2);
            String coren = (String) tblEnfermeiros.getValueAt(i, 3);
            String setor = (String) tblEnfermeiros.getValueAt(i, 4);
            
            TelaEditarEnfermeiro tela = new TelaEditarEnfermeiro(nome, cpf, dataNascimento, coren, setor);
            tela.setVisible(true);
            
            // Obtém a referência ao JFrame pai
        }
        
        else{
            JOptionPane.showMessageDialog(this, "Selecione um enfermeiro para editar.");
        }
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
            java.util.logging.Logger.getLogger(TelaEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEnfermeiro().setVisible(true);

            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JScrollPane jPaneEnfermeiros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lblPesquisarCoren;
    private javax.swing.JTextField lblPesquisarNome;
    private javax.swing.JTextField lblPesquisarSetor;
    private javax.swing.JTable tblEnfermeiros;
    private javax.swing.JLabel txtEnfermeiro;
    private javax.swing.JLabel txtUNome;
    private javax.swing.JLabel txtUNome1;
    private javax.swing.JLabel txtUNome2;
    // End of variables declaration//GEN-END:variables

    private void DefaultTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
