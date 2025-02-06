package Telas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaPacientes extends javax.swing.JFrame {
    private static final String BANCO_DADOS = "cadastro_pacientes.txt";
    public TelaPacientes() {
        initComponents();
        setLocationRelativeTo(null);
        
        carregarTabelaPaciente();

        btNovo.setEnabled(true);
        btEditar.setEnabled(false);
        btExcluir.setEnabled(false);
        btBuscar.setEnabled(true);
        btLimpar.setEnabled(false);
        btPesquisar.setEnabled(false);

        lblPesquisarNome.setEnabled(false);
        lblPesquisarCpf.setEnabled(false);
    }
    
    public  List<String> pesquisaPaciente(String nome, String cpf){
        List<String> resultados = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader (new FileReader(BANCO_DADOS))){
            String linha;
            
            while ((linha = reader.readLine()) != null){
                String [] campos = linha.split(";");
                String nomeArquivo = campos[0].toLowerCase();
                String corenArquivo = campos[3].toLowerCase();
                String setorArquivo = campos[4].toLowerCase();
                
                boolean nomeMatch = nome.isEmpty() || nomeArquivo.contains(nome.toLowerCase());
                boolean corenMatch = cpf.isEmpty() || corenArquivo.contains(cpf.toLowerCase());
                
                if (nomeMatch || corenMatch){
                    resultados.add(linha);
                }
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + e.getMessage());
        }
        return resultados;
    }
    private void carregarTabelaPaciente() {
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome", "CPF", "Data de Nascimento", "Peso", "Altura", "Idade", "Alergia"}, 0);

        try (BufferedReader reader = new BufferedReader(new FileReader(BANCO_DADOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println("Linha lida: " + linha);
                String[] partes = linha.split(";");

                if (partes.length < 7) {
                    System.out.println("Linha inválida, ignorando: " + linha);
                    continue;
                }
                String nome = partes[0].trim();
                String cpf = partes[1].trim();
                String dataNascimentoStr = partes[2].trim();
                String peso = partes[3].trim();
                String altura = partes[4].trim();
                String idade = partes[5].trim();
                String alergia = partes[6].trim();
                String dataFormatada = "";

                System.out.println(dataNascimentoStr);
                System.out.println(dataFormatada);
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
                System.out.println("Carregou a tabela");
                System.out.println("Dentro do try:" + dataNascimento);
                dataFormatada = dataNascimento.format(formatter);
                System.out.println("Formatada: "+dataFormatada);
                modelo.addRow(new Object[]{nome, cpf, dataFormatada, peso, altura, idade, alergia }); //cria uma linha nova na tabela
            }
            
        } catch (IOException e) {
            System.out.println("Erro ao ler os dados: " + e.getMessage());
        }

        tabelaPaciente.setModel(modelo);
}
    
    private void carregarTabelaPesquisar(String filtroNome, String filtroCpf){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome", "CPF", "Data de Nascimento"}, 0);
        boolean dadosEncontrados = false; // Flag para verificar se algum dado foi encontrado

        try (BufferedReader reader = new BufferedReader(new FileReader(BANCO_DADOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println("Linha lida: " + linha);
                String[] partes = linha.split(";");

                if (partes.length < 7) {
                    System.out.println("Linha inválida, ignorando: " + linha);
                    continue;
                }

                String nome = partes[0].trim();
                String cpf = partes[1].trim();
                String dataNascimentoStr = partes[2].trim();
                String peso = partes[3].trim();
                String altura = partes[4].trim();
                String idade = partes[5].trim();
                String alergia = partes[6].trim();
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
                String dataFormatada = dataNascimento.format(formatter);
                
                boolean nomeCorresponde = filtroNome.isEmpty() || nome.toLowerCase().contains(filtroNome.toLowerCase());
                boolean corenCorresponde = filtroCpf.isEmpty() || cpf.toLowerCase().contains(filtroCpf.toLowerCase());

                if (nomeCorresponde && corenCorresponde) {
                    modelo.addRow(new Object[]{nome, cpf, dataNascimento, peso, altura, idade, alergia}); // Adiciona linha filtrada
                    dadosEncontrados = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler os dados: " + e.getMessage());
        }

        if (!dadosEncontrados) {
            JOptionPane.showMessageDialog(null, "Nenhum dado correspondente", "Enfermeiro não encontrado", JOptionPane.INFORMATION_MESSAGE);
        }

        tabelaPaciente.setModel(modelo);
}
    
    private void excluirLinhaDoArquivo(String nome, String cpf) {
        File arquivoOriginal = new File(BANCO_DADOS);
        File arquivoTemp = new File("temp.txt"); // Arquivo temporário

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoOriginal));
             BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTemp))) {

            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length >= 5) {
                    String nomeArquivo = partes[0].trim();
                    String cpfArquivo = partes[3].trim();

                    if (nomeArquivo.equals(nome) && cpfArquivo.equals(cpf)) {
                        continue;
                    }
                }
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir a linha: " + e.getMessage());
        }

        // Substitui o arquivo original pelo temporário
        if (arquivoOriginal.delete()) {
            arquivoTemp.renameTo(arquivoOriginal);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar o arquivo!");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUNome = new javax.swing.JLabel();
        lblPesquisarNome = new javax.swing.JTextField();
        txtEnfermeiro = new javax.swing.JLabel();
        txtCpf = new javax.swing.JLabel();
        lblPesquisarCpf = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        tbVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPaciente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        txtUNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtUNome.setForeground(new java.awt.Color(0, 0, 0));
        txtUNome.setText("Nome");

        lblPesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblPesquisarNomeActionPerformed(evt);
            }
        });

        txtEnfermeiro.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtEnfermeiro.setForeground(new java.awt.Color(0, 0, 0));
        txtEnfermeiro.setText("Pacientes");

        txtCpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCpf.setForeground(new java.awt.Color(0, 0, 0));
        txtCpf.setText("CPF");

        btPesquisar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        btLimpar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtUNome)
                .addGap(18, 18, 18)
                .addComponent(lblPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCpf)
                        .addGap(18, 18, 18)
                        .addComponent(lblPesquisarCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btLimpar)))
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(txtEnfermeiro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(txtCpf)
                    .addComponent(lblPesquisarCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

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
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscaPaciente 32px.png"))); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        tbVoltar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tbVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sair 32px.png"))); // NOI18N
        tbVoltar.setText("Voltar");
        tbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbVoltarActionPerformed(evt);
            }
        });

        tabelaPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Data de Nascimento", "Peso", "Altura", "Idade", "Alergia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPaciente);
        if (tabelaPaciente.getColumnModel().getColumnCount() > 0) {
            tabelaPaciente.getColumnModel().getColumn(0).setResizable(false);
            tabelaPaciente.getColumnModel().getColumn(1).setResizable(false);
            tabelaPaciente.getColumnModel().getColumn(2).setResizable(false);
            tabelaPaciente.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btNovo)
                .addGap(27, 27, 27)
                .addComponent(btEditar)
                .addGap(26, 26, 26)
                .addComponent(btExcluir)
                .addGap(18, 18, 18)
                .addComponent(btBuscar)
                .addGap(18, 18, 18)
                .addComponent(tbVoltar)
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btEditar)
                    .addComponent(btExcluir)
                    .addComponent(btBuscar)
                    .addComponent(tbVoltar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblPesquisarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblPesquisarNomeActionPerformed

    }//GEN-LAST:event_lblPesquisarNomeActionPerformed

    
    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        // TODO add your handling code here:
        String nome = lblPesquisarNome.getText().trim();  // Campo de texto para o nome
        String cpf = lblPesquisarCpf.getText().trim(); // Campo de texto para o COREN

        carregarTabelaPesquisar(nome, cpf);
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        // TODO add your handling code here:
        lblPesquisarNome.setText("");
        lblPesquisarCpf.setText("");
        
        String nome = lblPesquisarNome.getText().trim();  // Campo de texto para o nome
        String cpf = lblPesquisarCpf.getText().trim(); // Campo de texto para o COREN

        carregarTabelaPesquisar(nome, cpf);
    }//GEN-LAST:event_btLimparActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        System.out.println("Acionou o botão novo");
        dispose();
        new TelaCadastroPaciente().setVisible(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed

        int i = tabelaPaciente.getSelectedRow(); //pega o numero do indice da linha que esta selecionada

        if(i >= 0){
            String nome = (String) tabelaPaciente.getValueAt(i, 0);
            String cpf = (String) tabelaPaciente.getValueAt(i, 1);
            String dataNascimento = (String) tabelaPaciente.getValueAt(i, 2);
            
            float peso = Float.parseFloat(tabelaPaciente.getValueAt(i, 3).toString());
            float altura = Float.parseFloat(tabelaPaciente.getValueAt(i, 4).toString());
            int idade = Integer.parseInt(tabelaPaciente.getValueAt(i, 5).toString());
            String alergia = (String) tabelaPaciente.getValueAt(i, 6);
           
            
            TelaEditarPaciente tela = new TelaEditarPaciente(nome, cpf, dataNascimento, peso, altura, idade, alergia);
            
            excluirLinhaDoArquivo(nome, cpf); // Método para excluir no arquivo
            carregarTabelaPaciente();
            tela.setVisible(true);
            dispose();
        }

        else{
            JOptionPane.showMessageDialog(this, "Selecione um paciente para editar.");
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        int linhaSelecionada = tabelaPaciente.getSelectedRow();

        if(linhaSelecionada == -1){
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha para excluit");
            return;
        }

        String nome = tabelaPaciente.getValueAt(linhaSelecionada, 0).toString();
        String cpf = tabelaPaciente.getValueAt(linhaSelecionada, 3).toString();

        // Confirmação de exclusão
        int confirmacao = JOptionPane.showConfirmDialog(this,
            "Tem certeza que deseja excluir o paciente " + nome + "?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            excluirLinhaDoArquivo(nome, cpf); // Método para excluir no arquivo
            carregarTabelaPaciente(); // Recarrega a tabela
            JOptionPane.showMessageDialog(this, "Paciente " + nome + " excluído com sucesso!");
        }
        carregarTabelaPaciente();

    }//GEN-LAST:event_btExcluirActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed

        btPesquisar.setEnabled(true);
        btLimpar.setEnabled(true);

        lblPesquisarNome.setEnabled(true);
        lblPesquisarCpf.setEnabled(true);
    }//GEN-LAST:event_btBuscarActionPerformed

    private void tbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbVoltarActionPerformed
        // TODO add your handling code here:
        dispose();
        TelaInicial tela = new TelaInicial();

        tela.setVisible(true);
    }//GEN-LAST:event_tbVoltarActionPerformed

    private void tabelaPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPacienteMouseClicked
        // TODO add your handling code here:
        System.out.println("Clique detectado na tabela!");

        int i = tabelaPaciente.getSelectedRow(); //pega o numero do indice da linha que esta selecionada
        
        String nome = (String) tabelaPaciente.getValueAt(i, 0);
        String cpf = (String) tabelaPaciente.getValueAt(i, 1);
        String dataNascimento = (String) tabelaPaciente.getValueAt(i, 2);
        //float peso = Float.parseFloat(tabelaPaciente.getValueAt(i, 3).toString());
        //String altura = tabelaPaciente.getValueAt(i, 4).toString();
        //int idade = Integer.parseInt(tabelaPaciente.getValueAt(i, 5).toString());
        //String alergia = (String) tabelaPaciente.getValueAt(i, 6);
           
        lblPesquisarNome.setText(nome);
        lblPesquisarCpf.setText(cpf);
        
        btEditar.setEnabled(true);
        btExcluir.setEnabled(true);
    }//GEN-LAST:event_tabelaPacienteMouseClicked

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
            java.util.logging.Logger.getLogger(TelaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lblPesquisarCpf;
    private javax.swing.JTextField lblPesquisarNome;
    private javax.swing.JTable tabelaPaciente;
    private javax.swing.JButton tbVoltar;
    private javax.swing.JLabel txtCpf;
    private javax.swing.JLabel txtEnfermeiro;
    private javax.swing.JLabel txtUNome;
    // End of variables declaration//GEN-END:variables
}
