package Telas;
import java.io.*;
import javax.swing.JOptionPane;
public class Principal extends javax.swing.JFrame {

    private static final String BANCO_DADOS = "login.txt";
    public Principal() {
        initComponents();
    }

    public static boolean verificarCredenciais(String login, String senha){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(BANCO_DADOS));
            String linha;
            
            while ((linha = reader.readLine()) != null) {
                String[] credenciais = linha.split(";");
                if (credenciais.length == 2) {
                    String loginArquivo = credenciais[0];
                    String senhaArquivo = credenciais[1];
                    System.out.println("Login arquivo:" + loginArquivo);
                    System.out.println("Senha arquivo:" + senhaArquivo);

                    if (loginArquivo.equals(login) && senhaArquivo.equals(senha)) {
                        reader.close();
                        return true;
                    }
                }
                System.out.println("Login fornecido: "+ login);
                System.out.println("Senha fornecido:" + senha);
            }
            reader.close();
        }
        catch(IOException e){
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtLogin = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        txtSenha = new javax.swing.JLabel();
        labelSenha = new javax.swing.JTextField();
        labelUsuario = new javax.swing.JTextField();
        btEntrar = new javax.swing.JButton();

        jLabel2.setText("SAM - SISTEMA DE ADMINISTRAÇÃO DE MEDICAÇÃO");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Enfermeiro 32px.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel1.setText("Login Administrador");
        jLabel1.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SAM - SISTEMA DE ADMINISTRAÇÃO DE MEDICAÇÃO");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        txtLogin.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtLogin.setText("Login");

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUsuario.setText("Usuário");

        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSenha.setText("Senha");

        labelSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelSenhaActionPerformed(evt);
            }
        });

        labelUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelUsuarioActionPerformed(evt);
            }
        });

        btEntrar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btEntrar.setText("Entrar");
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUsuario)
                    .addComponent(txtSenha))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(272, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtLogin)
                        .addGap(347, 347, 347))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(348, 348, 348))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(txtLogin)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtUsuario)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtSenha)
                    .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelSenhaActionPerformed

    private void labelUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelUsuarioActionPerformed

    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        
        String login = labelUsuario.getText();
        String senha = labelSenha.getText();

        verificarCredenciais(login, senha);
        
        if (verificarCredenciais(login, senha)){
            this.setVisible(false);
            new TelaInicial().setVisible(true);
        } 
        
        else{
            JOptionPane.showMessageDialog(this, "Login ou senha incorretos.");
        }
        
    }//GEN-LAST:event_btEntrarActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField labelSenha;
    private javax.swing.JTextField labelUsuario;
    private javax.swing.JLabel txtLogin;
    private javax.swing.JLabel txtSenha;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
