/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.FuncionarioDAO;
import java.util.Calendar;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;

/**
 *
 * @author 181710077
 */
public class ListFuncionario extends javax.swing.JInternalFrame {

        private JDesktopPane jdpTelaInicial;
        public ListFuncionario(JDesktopPane jdpTelaInicial) {
        initComponents();
        carregarTabela();
        this.jdpTelaInicial = jdpTelaInicial;
    }
    /**
     * Creates new form ListFuncionario
     */
    public ListFuncionario() {
        initComponents();
       carregarTabela();
    }
    
      public void carregarTabela() {
        List<Funcionario> lista = FuncionarioDAO.getFuncionario();
        String[] colunas = {"Código", "Nome", "Setor"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(colunas);

        for (Funcionario funcionario : lista) {
            


            Object[] dados = {
                funcionario.getCodigo(),
                funcionario.getNome(),
                funcionario.getSetor()};
                
                model.addRow(dados);
        }
            tableFunc.setModel(model);

    }
    

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableFunc = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        tableFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nome", "Setor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableFunc);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int linha = tableFunc.getSelectedRow();
        if(linha < 0){
            JOptionPane.showMessageDialog(this,"Um cliente deve ser selecionado!");
        }else{
            int codigo = (int) tableFunc.getValueAt(linha,0);
            Funcionario funcionario = FuncionarioDAO.getFuncionarioByCodigo(codigo);
            
            int resposta = JOptionPane.showConfirmDialog
              (this,
                      "Confirma a exclusão do funcionario  "+funcionario.getNome()+
                              "?", "Excluir Funcionario",
                              JOptionPane.YES_NO_OPTION);
            if(resposta == JOptionPane.YES_OPTION){       
            FuncionarioDAO.excluir(funcionario);
            carregarTabela();
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int linha = tableFunc.getSelectedRow();
        if(linha < 0){
            JOptionPane.showMessageDialog(this, "Um cliente deve ser selecionado!");
        }else{
        int codigo = (int) tableFunc.getValueAt(linha, 0); 
        FrmFuncionario tela = new FrmFuncionario();
        jdpTelaInicial.add(tela);
        tela.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableFunc;
    // End of variables declaration//GEN-END:variables
}
