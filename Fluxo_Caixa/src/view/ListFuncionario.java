/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Calendar;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 181710077
 */
public class ListFuncionario extends javax.swing.JInternalFrame {

        private JDesktopPane jdpTelaInicial;
        public ListFuncionario(JDesktopPane jdpTelaInicial) {
        initComponents();
        //carregarTabela();
        this.jdpTelaInicial = jdpTelaInicial;
    }
    /**
     * Creates new form ListFuncionario
     */
    public ListFuncionario() {
        initComponents();
       // carregarTabela();
    }
    
      public void carregarTabela() {
        List<Funcionario> lista = FuncionarioDAO.getFuncionario();
        String[] colunas = {"Código", "Nome", "Setor"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(colunas);

        for (Funcionario funcionario : lista) {
            

            
            String casado = "Não";
            if (funcionario.isCasado()) {
                casado = "Sim";
            }
            String filhos = "Não";
            if (funcionario.isTemfilhos()) {
                filhos = "Sim";
            }
            String sexo = "";
            if (funcionario.getSexo().equals("f")) {
                sexo = "Feminino";
            }
            if (funcionario.getSexo().equals("m")) {
                sexo = "Masculino";
            }

            Object[] dados = {
                funcionario.getCodigo(),
                funcionario.getNome(),
                funcionario.getSetor(),
                
            model.addRow(dados);
        }
       // tableClientes.setModel(model);

    }
    

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Editar");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Excluir");

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
