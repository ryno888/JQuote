/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui;

import app.db.DB_person;
import core.com.db.ComDBDatabase;
import core.com.db.ComDBQueryBuilder;
import core.com.utils.ComClipboard;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ryno Laptop
 */
public class PersonList extends javax.swing.JFrame {

    /**
     * Creates new form PersonList
     */
    public PersonList() {
        initComponents();
        this.setTableContents();
        this.setPopupMenu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableMenu = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));

        jButton1.setText("Add Client");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Client List");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Account", "Client", "Email", "Active"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(204, 204, 255));
        jTable1.setSelectionBackground(new java.awt.Color(0, 153, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(887, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new AddClient().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger())
        {
            int row = jTable1.rowAtPoint( evt.getPoint() );
            int column = jTable1.columnAtPoint( evt.getPoint() );
            jTable1.requestFocus();
            jTable1.changeSelection(row,column,false, false);

            if (! jTable1.isRowSelected(row))
            jTable1.changeSelection(row, column, false, false);

            tableMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTable1MouseReleased

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
            java.util.logging.Logger.getLogger(PersonList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JPopupMenu tableMenu;
    // End of variables declaration//GEN-END:variables

    private void setTableContents() {
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.setRowHeight(20);
        
        try {
            ArrayList rowList = new ArrayList();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            ResultSet resultSet = this.getDbList();
            while (resultSet.next()) {
                rowList.add(new Object[]{
                    resultSet.getInt("per_id"), 
                    resultSet.getString("per_account_nr"),
                    resultSet.getString("per_firstname") + " " + resultSet.getString("per_lastname"),
                    resultSet.getString("per_email"), 
                    (resultSet.getString("per_is_active").equals("1"))
                });
            }
            rowList.forEach(e -> model.addRow((Object[]) e));
        } catch (SQLException ex) {
            Logger.getLogger(PriceList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //--------------------------------------------------------------------------
    private ResultSet getDbList() {
        
        ComDBQueryBuilder builder = new ComDBQueryBuilder();
        
        builder.select("per_id");
        builder.select("per_firstname");
        builder.select("per_lastname");
        builder.select("per_trading_name");
        builder.select("per_email");
        builder.select("per_account_nr");
        builder.select("per_is_active");
        builder.from("person");
        builder.orderBy("per_id ASC");
        
        return ComDBDatabase.query(builder.get_sql());
    }
    //--------------------------------------------------------------------------
    private int getId(){
        int d = Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString());
        return d;
    }
    //--------------------------------------------------------------------------

    private void setPopupMenu() {
        try {
            JMenuItem editItem = new JMenuItem("Edit Details");
            editItem.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/assets/icon/if_pen.png"))));
            JMenuItem createInvoiceItem = new JMenuItem("Create Invoice");
            createInvoiceItem.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/assets/icon/if_plus.png"))));
            JMenuItem deleteItem = new JMenuItem("Delete");
            deleteItem.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/assets/icon/if_trash.png"))));
            JMenuItem copyItem = new JMenuItem("Copy");
            JMenuItem cancelItem = new JMenuItem("Cancel");
            deleteItem.addActionListener(e -> {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item?", "Delete Entry", JOptionPane.YES_NO_OPTION);
                if(result == 0){
                    DB_person person = new DB_person(getId());
                    if(!person.is_empty()){
						person.delete();
						int selectedIndex = jTable1.getSelectedRow();
						while (selectedIndex >= 0) {
							int modelIndex = jTable1.convertRowIndexToModel(selectedIndex);
							DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
							model.removeRow(modelIndex);
							selectedIndex = jTable1.getSelectedRow();
						}
					}
                }
                
            });
            cancelItem.addActionListener(e -> {
                tableMenu.setVisible(false);
            });
            copyItem.addActionListener(e -> {
                ComClipboard.copy(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()).toString());
            });
            editItem.addActionListener(e -> {
                new EditClient(getId(), jTable1.getSelectedRow()).setVisible(true);
            });
            createInvoiceItem.addActionListener(e -> {
//                new CreateInvoice(getId()).setVisible(true);
            });
            tableMenu.add(editItem);
            tableMenu.add(createInvoiceItem);
            tableMenu.add(deleteItem);
            tableMenu.add(copyItem);
            tableMenu.add(cancelItem);
        } catch (IOException ex) {
            Logger.getLogger(PriceList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //--------------------------------------------------------------------------
}
