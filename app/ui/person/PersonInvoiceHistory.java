/*
 * Class 
 * @filename PersonInvoiceHistory 
 * @encoding UTF-8
 * @author Liquid Edge Solutions  * 
 * @copyright Copyright Liquid Edge Solutions. All rights reserved. * 
 * @programmer Ryno van Zyl * 
 * @date 01 Dec 2017 * 
 */
package app.ui.person;

import app.config.Constants;
import app.ui.invoice.CreateInvoice;
import core.com.date.ComDate;
import core.com.db.ComDBDatabase;
import core.com.db.ComDBQueryBuilder;
import core.com.string.ComString;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ryno
 */
public class PersonInvoiceHistory extends javax.swing.JPanel {
    private final int id;
    private final int jTableRow;
    
    /**
     * Creates new form PersonInvoiceHistory
     */
    public PersonInvoiceHistory(Object per_id, Object jTableRow) {
        initComponents();
        this.id = (int)per_id;
        this.jTableRow = (int)jTableRow;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Invoice Number", "Date Created", "Total (Excl VAT)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton1.setText("Create New Invoice");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new CreateInvoice(this.id).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    //--------------------------------------------------------------------------
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
                    resultSet.getFloat("inv_id"), 
                    resultSet.getString("inv_number"), 
                    ComDate.getDate(resultSet.getDate("inv_date_created"), Constants.DATE_CUSTOM_2), 
                    ComString.format_currency(resultSet.getFloat("inv_total_excl"))
                });
            }
            rowList.forEach(e -> model.addRow((Object[]) e));
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    //--------------------------------------------------------------------------
    private void setPopupMenu() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //--------------------------------------------------------------------------
    private ResultSet getDbList() {
        
        ComDBQueryBuilder builder = new ComDBQueryBuilder();
        
        builder.select("inv_id");
        builder.select("inv_date_created");
        builder.select("inv_number");
        builder.select("inv_total_excl");
        builder.from("invoice");
        builder.orderBy("inv_date_created DESC");
        
        return ComDBDatabase.query(builder.get_sql());
    }
}