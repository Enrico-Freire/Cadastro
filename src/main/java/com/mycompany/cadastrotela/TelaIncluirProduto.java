/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cadastrotela;
import com.mycompany.cadastrotela.Produto;
/**
 *
 * @author enric
 */
public class TelaIncluirProduto extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaIncluirProduto.class.getName());

    /**
     * Creates new form TelaIncluirProduto
     */
    public TelaIncluirProduto() {
        initComponents();
        
        // ===== PESO =====
    Pesoproduto.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE) {
                evt.consume();
            }
        }
        
        @Override
        public void keyReleased(java.awt.event.KeyEvent evt) {
            String textoAtual = Pesoproduto.getText();
            String corrigido = corrigirMascaraPeso(textoAtual);
            if (!corrigido.isEmpty() && !textoAtual.equals(corrigido)) {
                int dotAntigo = corrigido.indexOf('.');
                Pesoproduto.setText(corrigido);
                Pesoproduto.setCaretPosition(Math.min(dotAntigo, corrigido.length()));
            }
        }
    });
    
    Pesoproduto.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusLost(java.awt.event.FocusEvent evt) {
            restaurarPeso();
        }
    });
    
    // ===== PREÇO =====
    Precoproduto.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (Precoproduto.getText().trim().isEmpty()) {
                Precoproduto.setText("R$ ");
            }
            Precoproduto.setCaretPosition(Precoproduto.getText().length());
        }
        
        @Override
        public void focusLost(java.awt.event.FocusEvent evt) {
            restaurarPreco();
        }
    });
    
    Precoproduto.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE) {
                evt.consume();
            }
        }
        
        @Override
        public void keyReleased(java.awt.event.KeyEvent evt) {
            String textoAtual = Precoproduto.getText();
            String corrigido = corrigirMascaraPreco(textoAtual);
            if (!corrigido.equals("R$ ") && !textoAtual.equals(corrigido)) {
                int dotAntigo = corrigido.indexOf('.');
                Precoproduto.setText(corrigido);
                Precoproduto.setCaretPosition(Math.min(dotAntigo, corrigido.length()));
            }
        }
    });
}

private void restaurarPeso() {
    String texto = Pesoproduto.getText();
    if (!texto.trim().isEmpty()) {
        String corrigido = corrigirMascaraPeso(texto);
        if (corrigido.isEmpty()) {
            String digitos = texto.replaceAll("[^0-9]", "");
            corrigido = digitos.isEmpty() ? "" : digitos + ".00 g";
        }
        Pesoproduto.setText(corrigido);
    }
}

private void restaurarPreco() {
    String texto = Precoproduto.getText();
    if (!texto.trim().isEmpty() && !texto.equals("R$ ")) {
        String corrigido = corrigirMascaraPreco(texto);
        Precoproduto.setText(corrigido);
    }

    }
// ===== COLOQUE OS DOIS MÉTODOS AUXILIARES AQUI =====
    private String corrigirMascaraPeso(String texto) {
        String semSufixo = texto.replace(" g", "");
        int dotIndex = semSufixo.indexOf('.');
        String parteInteira;
        String parteDecimal;
        
        if (dotIndex == -1) {
            parteInteira = semSufixo.replaceAll("[^0-9]", "");
            parteDecimal = "00";
        } else {
            parteInteira = semSufixo.substring(0, dotIndex).replaceAll("[^0-9]", "");
            parteDecimal = semSufixo.substring(dotIndex + 1).replaceAll("[^0-9]", "");
            if (parteDecimal.length() > 2) parteDecimal = parteDecimal.substring(0, 2);
            while (parteDecimal.length() < 2) parteDecimal += "0";
        }
        
        if (parteInteira.isEmpty()) return "";
        return parteInteira + "." + parteDecimal + " g";
    }

    private String corrigirMascaraPreco(String texto) {
        String semPrefixo = texto.replace("R$ ", "");
        int dotIndex = semPrefixo.indexOf('.');
        String parteInteira;
        String parteDecimal;
        
        if (dotIndex == -1) {
            parteInteira = semPrefixo.replaceAll("[^0-9]", "");
            parteDecimal = "00";
        } else {
            parteInteira = semPrefixo.substring(0, dotIndex).replaceAll("[^0-9]", "");
            parteDecimal = semPrefixo.substring(dotIndex + 1).replaceAll("[^0-9]", "");
            if (parteDecimal.length() > 2) parteDecimal = parteDecimal.substring(0, 2);
            while (parteDecimal.length() < 2) parteDecimal += "0";
        }
        
        if (parteInteira.isEmpty()) return "R$ ";
        return "R$ " + parteInteira + "." + parteDecimal;
    }
    // ===== FIM DOS MÉTODOS AUXILIARES =====
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Fabricanteproduto = new javax.swing.JTextField();
        Nomeproduto = new javax.swing.JTextField();
        Pesoproduto = new javax.swing.JTextField();
        Precoproduto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("CADASTRO DO PRODUTO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("NOME");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("FABRICANTE");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("PESO(g)");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("PREÇO");

        Fabricanteproduto.addActionListener(this::FabricanteprodutoActionPerformed);

        Pesoproduto.addActionListener(this::PesoprodutoActionPerformed);

        jButton1.setText("Inserir");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Limpar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("Voltar");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fabricanteproduto)
                            .addComponent(Pesoproduto)
                            .addComponent(Precoproduto)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Nomeproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(56, 56, 56)))
                .addGap(155, 155, 155))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Nomeproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Fabricanteproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Pesoproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Precoproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PesoprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesoprodutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PesoprodutoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Nomeproduto.setText("");
        Fabricanteproduto.setText("");
        Pesoproduto.setText("");
        Precoproduto.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        new MenuPrincipal().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    restaurarPeso();
    restaurarPreco();
    
    try {
        // PASSO 1: Capturar os textos brutos das caixas de texto (Use os nomes das suas variáveis)
        String nome = Nomeproduto.getText();
        String fabricante_produto = Fabricanteproduto.getText();
        String peso_produto = Pesoproduto.getText().replace(" Kg", "");
        String preco_produto = Precoproduto.getText().replace("R$ ", "");
        
        
        
        
        // PASSO 2: Validar se o usuário deixou o campo de nome em branco
        if (nome.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, digite um nome válido.");
            return; // Interrompe a execução para não criar objeto com nome vazio
        }
        
        
        
        else if(Fabricanteproduto.getText().trim().isEmpty() && Pesoproduto.getText().trim().isEmpty() && Precoproduto.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            return; // Interrompe a execução para não criar objeto com cpf vazio
        }
        
        else if(Fabricanteproduto.getText().trim().isEmpty() || Pesoproduto.getText().trim().isEmpty() || Precoproduto.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            return; // Interrompe a execução para não criar objeto com cpf vazio
        }
        
        else{
            javax.swing.JOptionPane.showMessageDialog(this, "Cadastro do produto " + nome +" realizado com sucesso!!!");
            // PASSO 3: Substituir vírgula por ponto para não quebrar o Float
            peso_produto = peso_produto.replace(",", ".");
            preco_produto = preco_produto.replace("R$ ", "").replace(",", ".");
        
        // PASSO 4: Fazer as conversões (Parsing) de String para os tipos corretos
        float peso = Integer.parseInt(peso_produto);
        float preco = Float.parseFloat(preco_produto);
        
        // PASSO 5: Criar o objeto da sua classe comum
        // (Ajuste a ordem dos parâmetros de acordo com o construtor da sua classe Usuario)
        Produto novo_produto=new Produto(nome, fabricante_produto, peso, preco);

        }
    } catch (NumberFormatException e) {
        
        
        
    }
    Nomeproduto.setText("");
    Fabricanteproduto.setText("");
    Pesoproduto.setText("");
    Precoproduto.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void FabricanteprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FabricanteprodutoActionPerformed
        String fabricante = Fabricanteproduto.getText();
    }//GEN-LAST:event_FabricanteprodutoActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }
    public void TelaIncluirProduto(){
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Fabricanteproduto;
    private javax.swing.JTextField Nomeproduto;
    private javax.swing.JTextField Pesoproduto;
    private javax.swing.JTextField Precoproduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
