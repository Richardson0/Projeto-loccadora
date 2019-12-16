
package locacao;

import DAO.*;
import Modelo.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;



public class ConsultarDevolucao extends javax.swing.JFrame {
   
    public ConsultaDevolucao() {
        initComponents();
        AtualizaCombo();
        AtualizaTable();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(this);
    }
        
    
   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jCB_Cliente = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Cliente");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cliente", "DVD", "Horario", "Locação", "Devolução"
            }
        ));
        jScrollPane2.setViewportView(jTable);

        jCB_Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCB_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_ClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCB_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCB_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCB_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_ClienteActionPerformed
       Connection con = Conexao.AbrirConexao();
        AluguelDAO sql = new AluguelDAO(con);
        List<Cliente> listac = new ArrayList<>();
        String nome = jCB_Cliente.getSelectedItem().toString();
        if (nome.equals("Todos") || nome.equals("")){
        
        List<Aluguel> lista = new ArrayList<>();
        lista = sql.ListarAluguel();
        DefaultTableModel tbm =
                (DefaultTableModel) jCB_Cliente.getModel();
        while (tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }
        int i = 0;
        for (Aluguel tab : lista) {
            tbm.addRow(new String[i]);
            jCB_Cliente.setValueAt(tab.getCod(), i, 0);
            jCB_Cliente.setValueAt(tab.getCoddvd(), i, 1);
            jCB_Cliente.setValueAt(tab.getCodcliente(), i, 2);
            jCB_Cliente.setValueAt(tab.getHorario(), i, 3);
            jCB_Cliente.setValueAt(tab.getData_aluguel(), i, 4);
            jCB_Cliente.setValueAt(tab.getData_devolucao(), i, 5);
            i++;
        }
        } else {
        listac = sql.ConsultaCodigoCliente(nome);
        
        for (Cliente b : listac) {
            int cod = b.getCodigo();
            int codt = cod;
            List<Aluguel> lista = new ArrayList<>();
        lista = sql.Pesquisar_Aluguel_Cliente(codt);
        DefaultTableModel tbm =
                (DefaultTableModel) jCB_Cliente.getModel();
        while (tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }            
        int i = 0;
        for (Aluguel tab : lista) {
            tbm.addRow(new String[i]);
            jCB_Cliente.setValueAt(tab.getCod(), i, 0);
            jCB_Cliente.setValueAt(tab.getCodcliente(), i, 1);
            jCB_Cliente.setValueAt(tab.getCoddvd(), i, 2);
            jCB_Cliente.setValueAt(tab.getHorario(), i, 3);
            jCB_Cliente.setValueAt(tab.getData_aluguel(), i, 4);
            jCB_Cliente.setValueAt(tab.getData_devolucao(), i, 5);
            i++;
        }
        }
        }
        Conexao.FecharConexao(con);
    }//GEN-LAST:event_jCB_ClienteActionPerformed

    
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
            java.util.logging.Logger.getLogger(ConsultarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarDevolucao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCB_Cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
