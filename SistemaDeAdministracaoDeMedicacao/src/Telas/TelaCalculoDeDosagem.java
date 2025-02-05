/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import java.util.Optional;
import sam.Benzetacil;
import sam.CalculoDeDosagem;
import sam.Heparina;
import sam.Insulina;
import sam.Medicamento;
import sam.Paciente;
import sam.Penicilina;

/**
 *
 * @author dioni
 */
public class TelaCalculoDeDosagem extends javax.swing.JFrame {
    
    CalculoDeDosagem calculoDeDosagem = new CalculoDeDosagem();

    /**
     * Creates new form CalculoDeDosagem
     */
    public TelaCalculoDeDosagem() {
        initComponents();
        carregarListaPacientes();
        btnCalcular.setEnabled(false);
        lblCampo1.setVisible(false);
        lblCampo2.setVisible(false);
        lblCampo3.setVisible(false);
        lblCampo4.setVisible(false);
        txtCampo1.setVisible(false);
        txtCampo2.setVisible(false);
        txtCampo3.setVisible(false);
        cbox01.setVisible(false);
        lblObs.setVisible(false);
        
    }
    
    public void carregarListaPacientes() {
        for (Paciente p : calculoDeDosagem.getPacientes()) {
            cboxPacientes.addItem(p.getNome() + "," + p.getCpf());
        }
    }
    
    public void setarCamposEspecializados(Paciente paciente) {
        switch (paciente.getPrescricao().getMedicamento().getNomeMedicamento()) {
            case "Penicilina":
                lblCampo1.setVisible(true);
                lblCampo1.setText("Selecione tipo de frasco:");
                
                cbox01.addItem("5.000.000 UI");
                cbox01.addItem("10.000.000 UI");
                cbox01.setVisible(true);
                
                btnConfirmarPaciente.setEnabled(false);
                
                lblCampo2.setVisible(true);
                lblCampo2.setText("Valor prescrito:");
                txtCampo1.setVisible(true);
                txtCampo1.setText(String.valueOf(paciente.getPrescricao().getDosagem()));
                                
                btnCalcular.setEnabled(true);
                break;
            case "Benzetacil":
                lblCampo1.setVisible(true);
                lblCampo1.setText("Selecione tipo de frasco:");
                
                cbox01.addItem("300.000 UI");
                cbox01.addItem("600.000 UI");
                cbox01.addItem("1.200.000 UI");
                cbox01.addItem("2.400.000 UI");
                cbox01.setVisible(true);
                
                btnConfirmarPaciente.setEnabled(false);
                
                lblCampo2.setVisible(true);
                lblCampo2.setText("Valor prescrito:");
                txtCampo1.setVisible(true);
                txtCampo1.setText(String.valueOf(paciente.getPrescricao().getDosagem()));
                
                btnCalcular.setEnabled(true);
                break;
            case "Heparina":
                lblCampo1.setVisible(true);
                lblCampo1.setText("Selecione o tipo disponível:");
                
                
                cbox01.addItem("25.000 UI - FRASCO");
                cbox01.addItem("5.000 UI / 0.25 ml - AMPOLA");
                cbox01.setVisible(true);
                
                btnConfirmarPaciente.setEnabled(false);
                
                
                lblCampo2.setVisible(true);
                lblCampo2.setText("Valor prescrito:");
                txtCampo1.setVisible(true);
                txtCampo1.setText(String.valueOf(paciente.getPrescricao().getDosagem()));
                
                btnCalcular.setEnabled(true);
                break;
            case "Insulina":
                lblCampo1.setVisible(true);
                lblCampo1.setText("Selecione o tipo:");
                
                btnConfirmarPaciente.setEnabled(false);
                
                cbox01.addItem("FRASCO - 100 UI");
                cbox01.addItem("FRASCO - 40 UI");
                cbox01.addItem("SERINGA GRADUADA - 10 UI");
                cbox01.addItem("SERINGA GRADUADA - 20 UI");
                cbox01.addItem("SERINGA GRADUADA - 30 UI");
                cbox01.addItem("SERINGA GRADUADA - 40 UI");
                cbox01.addItem("SERINGA GRADUADA - 50 UI");
                cbox01.addItem("SERINGA GRADUADA - 60 UI");
                cbox01.addItem("SERINGA GRADUADA - 70 UI");
                cbox01.addItem("SERINGA GRADUADA - 80 UI");
                cbox01.addItem("SERINGA GRADUADA - 90 UI");
                cbox01.addItem("SERINGA GRADUADA - 100 UI");
                cbox01.setVisible(true);
                
                lblObs.setText("<html>Obs: No caso seringa graduada,<br>é considerado o fraso de 40 UI,<br>pois o cálculo com frasco de 100 UI<br>e seringa graduada é intuitivo.</html>");
                lblObs.setVisible(true);
                
                btnCalcular.setEnabled(true);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cboxPacientes = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        pnlDadosCalculo = new javax.swing.JPanel();
        lblCampo1 = new javax.swing.JLabel();
        lblCampo2 = new javax.swing.JLabel();
        lblCampo3 = new javax.swing.JLabel();
        lblCampo4 = new javax.swing.JLabel();
        txtCampo1 = new javax.swing.JTextField();
        txtCampo2 = new javax.swing.JTextField();
        txtCampo3 = new javax.swing.JTextField();
        cbox01 = new javax.swing.JComboBox<>();
        lblObs = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        lblValorCalculado = new javax.swing.JLabel();
        lblResultadoCalculo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMedicamento = new javax.swing.JTextField();
        btnConfirmarPaciente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SAM - Cálculo de Dosagem");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 204));
        jTextField1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("SAM - Sistema de Administração de Medicamentos");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Medicamento:");

        cboxPacientes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cboxPacientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "vazio" }));
        cboxPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboxPacientesMouseClicked(evt);
            }
        });
        cboxPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxPacientesActionPerformed(evt);
            }
        });

        pnlDadosCalculo.setBorder(javax.swing.BorderFactory.createTitledBorder("Daods para realização do cálculo"));

        lblCampo1.setText("diluição:");

        lblCampo2.setText("unidade de medida:");

        lblCampo3.setText("formulação:");

        lblCampo4.setText("quantidade de água em ml:");

        txtCampo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampo1ActionPerformed(evt);
            }
        });

        txtCampo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampo3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDadosCalculoLayout = new javax.swing.GroupLayout(pnlDadosCalculo);
        pnlDadosCalculo.setLayout(pnlDadosCalculoLayout);
        pnlDadosCalculoLayout.setHorizontalGroup(
            pnlDadosCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosCalculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCampo1)
                    .addComponent(lblCampo4)
                    .addComponent(lblCampo3)
                    .addComponent(lblCampo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObs, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDadosCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCampo2)
                        .addComponent(txtCampo1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbox01, javax.swing.GroupLayout.Alignment.LEADING, 0, 251, Short.MAX_VALUE)
                        .addComponent(txtCampo3)))
                .addContainerGap(387, Short.MAX_VALUE))
        );
        pnlDadosCalculoLayout.setVerticalGroup(
            pnlDadosCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosCalculoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlDadosCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCampo1)
                    .addComponent(cbox01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCampo2)
                    .addComponent(txtCampo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCampo3)
                    .addComponent(txtCampo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCampo4)
                    .addComponent(txtCampo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblObs, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        lblValorCalculado.setText("VALOR CALCULADO:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Paciente:");

        txtMedicamento.setEditable(false);
        txtMedicamento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        btnConfirmarPaciente.setText("Confirmar Paciente");
        btnConfirmarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(pnlDadosCalculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(102, 102, 102)
                                        .addComponent(lblValorCalculado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblResultadoCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboxPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnConfirmarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 101, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfirmarPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlDadosCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular)
                    .addComponent(lblValorCalculado)
                    .addComponent(lblResultadoCalculo))
                .addGap(235, 235, 235))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void cboxPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxPacientesActionPerformed
         // Obtém o nome selecionado
    }//GEN-LAST:event_cboxPacientesActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
        String cpf = ((String)cboxPacientes.getSelectedItem()).split(",")[1];
        
        Paciente paciente = calculoDeDosagem.getPacientes().stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
        
        String nomeMedicamento = paciente.getPrescricao().getMedicamento().getNomeMedicamento();
        
        switch (nomeMedicamento) {
            case "Penicilina":
                Penicilina penicilina = (Penicilina) paciente.getPrescricao().getMedicamento();
                penicilina.setFormulacao( "5.000.000 UI".equals(cbox01.getSelectedItem()) ? 5000000 : 10000000);
                lblResultadoCalculo.setText(String.valueOf(paciente.getPrescricao().getMedicamento().calculoDeDosagem(paciente.getPrescricao().getDosagem())) + "ml");
                break;
            case "Benzetacil":
                int formulacao = Integer.parseInt(((String)cbox01.getSelectedItem()).split(" ")[0].replace(".", ""));
                Benzetacil benzetacil = (Benzetacil) paciente.getPrescricao().getMedicamento();
                benzetacil.setDosagemDisponivel(formulacao);
                
                lblResultadoCalculo.setText(paciente.getPrescricao().getMedicamento().calculoDeDosagem(paciente.getPrescricao().getDosagem()) + "ml");
                break;
            case "Heparina":
                int tipo = cbox01.getSelectedIndex();
                Heparina heparina = (Heparina) paciente.getPrescricao().getMedicamento();
                heparina.setFormulacao(tipo);
                
                lblResultadoCalculo.setText(paciente.getPrescricao().getMedicamento().calculoDeDosagem(paciente.getPrescricao().getDosagem()) + "ml");
                break;
            case "Insulina":
                Insulina insulina = (Insulina) paciente.getPrescricao().getMedicamento();
                insulina.setTipoCalculo(cbox01.getSelectedIndex());
                
                if(cbox01.getSelectedIndex() <= 1) {
                    insulina.setFrascoDisponivel(Integer.parseInt(((String)cbox01.getSelectedItem()).split(" ")[2]));
                    insulina.setTipoCalculo(1);
                    lblResultadoCalculo.setText(paciente.getPrescricao().getMedicamento().calculoDeDosagem(paciente.getPrescricao().getDosagem()) + "ml");
                } else {
                    insulina.setTipoDeSeringa((Integer.parseInt(((String)cbox01.getSelectedItem()).split(" ")[3])));
                    insulina.setTipoCalculo(2);
                    lblResultadoCalculo.setText(paciente.getPrescricao().getMedicamento().calculoDeDosagem(paciente.getPrescricao().getDosagem()) + " UI");
                }
                
                break;
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void txtCampo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampo1ActionPerformed

    private void txtCampo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampo3ActionPerformed

    private void cboxPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboxPacientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxPacientesMouseClicked

    private void btnConfirmarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPacienteActionPerformed
        String cpf = ((String)cboxPacientes.getSelectedItem()).split(",")[1];
        
        Paciente paciente = calculoDeDosagem.getPacientes().stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
        
        System.out.println("log1");
        txtMedicamento.setText(paciente.getPrescricao().getMedicamento().getNomeMedicamento());
        System.out.println("log2");
        
        setarCamposEspecializados(paciente);
    }//GEN-LAST:event_btnConfirmarPacienteActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCalculoDeDosagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCalculoDeDosagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCalculoDeDosagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCalculoDeDosagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaCalculoDeDosagem().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnConfirmarPaciente;
    private javax.swing.JComboBox<String> cbox01;
    private javax.swing.JComboBox<String> cboxPacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCampo1;
    private javax.swing.JLabel lblCampo2;
    private javax.swing.JLabel lblCampo3;
    private javax.swing.JLabel lblCampo4;
    private javax.swing.JLabel lblObs;
    private javax.swing.JLabel lblResultadoCalculo;
    private javax.swing.JLabel lblValorCalculado;
    private javax.swing.JPanel pnlDadosCalculo;
    private javax.swing.JTextField txtCampo1;
    private javax.swing.JTextField txtCampo2;
    private javax.swing.JTextField txtCampo3;
    private javax.swing.JTextField txtMedicamento;
    // End of variables declaration//GEN-END:variables
}
