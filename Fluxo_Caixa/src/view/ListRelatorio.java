
package view;

import dao.EntradaDAO;
import dao.SaidaDAO;
import java.util.Calendar;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Entrada;
import model.Saida;


public class ListRelatorio extends javax.swing.JInternalFrame {
    
    private JDesktopPane jdpTelaInicial;
    private static final int TABELA_ENTRADA = 1;
    private static final int TABELA_SAIDA = 2;
    private int tabelaSelecionada = 0;

    
    public ListRelatorio() {
        initComponents();
        carregarTabelaEntrada();
        this.jdpTelaInicial = jdpTelaInicial;
        
    }
    
    public void carregarTabelaEntrada(){
        List<Entrada> listaEnt = EntradaDAO.getEntrada();
        DefaultTableModel model = new DefaultTableModel();
        String[] colunaEnt = {"Codigo", "Descrição", "Valor", "Data"};
        model.setColumnIdentifiers(colunaEnt);
        
        for (Entrada ent : listaEnt){
            Calendar dataEnt = ent.getData();
            String data = "" +
                      dataEnt.get( Calendar.DAY_OF_MONTH) +
                "/" +(dataEnt.get( Calendar.MONTH )+1) +
                "/" + dataEnt.get( Calendar.YEAR );
                    
            Object[] linha = {
                ent.getCodigo(),
                ent.getDescricao(),
                ent.getValor(),
                dataEnt
            };
            model.addRow(linha);
    };
    tableEnt.setModel(model);
    }
     
    public void carregarTabelaSaida(){
        List<Saida> listaSai = SaidaDAO.getSaida();
        DefaultTableModel model = new DefaultTableModel();
        String[] colunaSai = {"Codigo", "Descrição", "Valor", "Data"};
        model.setColumnIdentifiers(colunaSai);
        
        for (Saida sai : listaSai){
            Calendar dataSai = sai.getData();
            String data = "" +
                      dataSai.get( Calendar.DAY_OF_MONTH) +
                "/" +(dataSai.get( Calendar.MONTH )+1) +
                "/" + dataSai.get( Calendar.YEAR );
                    
            Object[] linha = {
                sai.getCodigo(),
                sai.getDescricao(),
                sai.getValor(),
                dataSai
            };
            model.addRow(linha);
    };
    tableEnt.setModel(model);
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEnt = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JFormattedTextField();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSai = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Relatório");

        jLabel2.setText("Entradas");

        jLabel3.setText("Saídas");

        tableEnt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Valor", "Data"
            }
        ));
        tableEnt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEntMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEnt);

        jLabel4.setText("Total");

        txtTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tableSai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Valor", "Data"
            }
        ));
        tableSai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableSai);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel2)
                .addGap(249, 249, 249)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(73, 73, 73))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTotal)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar)
                            .addComponent(btnExcluir))
                        .addContainerGap(89, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnEditar)
                        .addGap(30, 30, 30)
                        .addComponent(btnExcluir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tabelaSelecionada == TABELA_ENTRADA){
            int linha = tableEnt.getSelectedRow();
            if(linha<0){
                JOptionPane.showMessageDialog(this, "Uma entrada deve ser selecionada");
            }else{
                int codigo = (int)tableEnt.getValueAt(linha, 0);
                Entradas telaEnt = new Entradas(codigo, this);
                jdpTelaInicial.add(telaEnt);
                telaEnt.setVisible(true);
                
            }
        }
        
        if (tabelaSelecionada == TABELA_SAIDA){
            int linha = tableSai.getSelectedRow();
            if(linha<0){
                JOptionPane.showMessageDialog(this, "Uma saída deve ser selecionada");
            }else{
                int codigo = (int)tableSai.getValueAt(linha, 0);
                Entradas telaSai = new Entradas(codigo, this);
                jdpTelaInicial.add(telaSai);
                telaSai.setVisible(true);
                
            }
            
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tableEntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEntMouseClicked
       tabelaSelecionada = TABELA_ENTRADA;
       
    }//GEN-LAST:event_tableEntMouseClicked

    private void tableSaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSaiMouseClicked
        tabelaSelecionada = TABELA_SAIDA;
    }//GEN-LAST:event_tableSaiMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tabelaSelecionada == TABELA_ENTRADA){ 
            int linha = tableEnt.getSelectedRow();
            if(linha<0){
                JOptionPane.showMessageDialog(this, "Uma entrada deve ser selecionada");
            }else{
                
               int codigo = (int)tableEnt.getValueAt(linha, 0);
               Entrada entrada = EntradaDAO.getEntradaByCodigo(codigo);
               
               int resposta = JOptionPane.showConfirmDialog(this, "Confirma a exclusão da entrada "+ entrada.getDescricao()+"?", "Excluir entrada", JOptionPane.YES_NO_OPTION);
            
               if(resposta==JOptionPane.YES_OPTION){
                   EntradaDAO.excluir(entrada);
                   carregarTabelaEntrada();
               }
            }
                    
        }
        
         if (tabelaSelecionada == TABELA_SAIDA){
            int linha = tableSai.getSelectedRow();
            if(linha<0){
                JOptionPane.showMessageDialog(this, "Uma saída deve ser selecionada");
            }else{
                
               int codigo = (int)tableSai.getValueAt(linha, 0);
               Saida saida = SaidaDAO.getSaidaByCodigo(codigo);
               
               int resposta = JOptionPane.showConfirmDialog(this, "Confirma a exclusão da saída "+ saida.getDescricao()+"?", "Excluir saída", JOptionPane.YES_NO_OPTION);
            
               if(resposta==JOptionPane.YES_OPTION){
                   SaidaDAO.excluir(saida);
                   carregarTabelaSaida();
               }
            }
             
         }
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableEnt;
    private javax.swing.JTable tableSai;
    private javax.swing.JFormattedTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
