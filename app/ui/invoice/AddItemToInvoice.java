/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.invoice;

import app.ui.quote.QuoteItemList;
import core.com.db.ComDBDatabase;
import core.com.db.ComDBQueryBuilder;
import core.com.string.ComString;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import static app.ui.quote.QuoteItemList.jTable1;

/**
 *
 * @author Ryno Laptop
 */
public class AddItemToInvoice extends javax.swing.JFrame {
    CreateInvoice invoicePanel;
    /**
     * Creates new form AddItemToInvoice
     * @param invoicePanel
     */
    public AddItemToInvoice(CreateInvoice invoicePanel) {
        this.invoicePanel = invoicePanel;
        initComponents();
        this.setTableContents();
        this.setActions();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        addItemInvoiceTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Item to Invoice");

        addItemInvoiceTable.setAutoCreateRowSorter(true);
        addItemInvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Quantity", "Price", "Unit Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        addItemInvoiceTable.setGridColor(new java.awt.Color(204, 204, 255));
        addItemInvoiceTable.setSelectionBackground(new java.awt.Color(0, 153, 255));
        addItemInvoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addItemInvoiceTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addItemInvoiceTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(addItemInvoiceTable);
        if (addItemInvoiceTable.getColumnModel().getColumnCount() > 0) {
            addItemInvoiceTable.getColumnModel().getColumn(0).setMinWidth(0);
            addItemInvoiceTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            addItemInvoiceTable.getColumnModel().getColumn(0).setMaxWidth(0);
            addItemInvoiceTable.getColumnModel().getColumn(2).setMinWidth(70);
            addItemInvoiceTable.getColumnModel().getColumn(2).setPreferredWidth(70);
            addItemInvoiceTable.getColumnModel().getColumn(2).setMaxWidth(70);
            addItemInvoiceTable.getColumnModel().getColumn(3).setMinWidth(70);
            addItemInvoiceTable.getColumnModel().getColumn(3).setPreferredWidth(70);
            addItemInvoiceTable.getColumnModel().getColumn(3).setMaxWidth(70);
            addItemInvoiceTable.getColumnModel().getColumn(4).setMinWidth(70);
            addItemInvoiceTable.getColumnModel().getColumn(4).setPreferredWidth(70);
            addItemInvoiceTable.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jButton1.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(524, 349));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addItemInvoiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItemInvoiceTableMouseClicked

    }//GEN-LAST:event_addItemInvoiceTableMouseClicked

    private void addItemInvoiceTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItemInvoiceTableMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
            int row = addItemInvoiceTable.rowAtPoint(evt.getPoint());
            int column = addItemInvoiceTable.columnAtPoint(evt.getPoint());
            addItemInvoiceTable.requestFocus();
            addItemInvoiceTable.changeSelection(row, column, false, false);

            if (!addItemInvoiceTable.isRowSelected(row)) {
                addItemInvoiceTable.changeSelection(row, column, false, false);
            }

            tableMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_addItemInvoiceTableMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable addItemInvoiceTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu tableMenu;
    // End of variables declaration//GEN-END:variables

    //--------------------------------------------------------------------------
    private void setTableContents() {
        addItemInvoiceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        addItemInvoiceTable.setDefaultEditor(Object.class, null);
        addItemInvoiceTable.setRowHeight(20);
        
        try {
            ArrayList rowList = new ArrayList();
            DefaultTableModel model = (DefaultTableModel) addItemInvoiceTable.getModel();
            ResultSet resultSet = this.getDbList();
            while (resultSet.next()) {
                rowList.add(new Object[]{
                    resultSet.getFloat("qut_id"), 
                    resultSet.getString("qut_name"), 
                    Math.round(resultSet.getFloat("qut_unit")),
                    ComString.format_currency(resultSet.getFloat("qut_price")), 
                    ComString.format_currency(resultSet.getFloat("qut_unit_price"))
                });
            }
            rowList.forEach(e -> model.addRow((Object[]) e));
        } catch (SQLException ex) {
            Logger.getLogger(QuoteItemList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //--------------------------------------------------------------------------
    private Long getId(){
        Double d = Double.parseDouble(addItemInvoiceTable.getModel().getValueAt(addItemInvoiceTable.getSelectedRow(), 0).toString());
        return Math.round(d);
    }
    //--------------------------------------------------------------------------
    private ResultSet getDbList() {
        
        ComDBQueryBuilder builder = new ComDBQueryBuilder();
        
        builder.select("qut_id");
        builder.select("qut_name");
        builder.select("qut_price");
        builder.select("qut_unit_price");
        builder.select("qut_unit");
        builder.from("quote_item");
        builder.orderBy("qut_id");
        
        return ComDBDatabase.query(builder.get_sql());
    }
    //--------------------------------------------------------------------------

    private void setActions() {
        addItemInvoiceTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    String qut_id = getId().toString(); 
                    String qut_name = table.getValueAt(row, 1).toString(); 
                    String qut_unit = table.getValueAt(row, 2).toString(); 
                    String qut_price = table.getValueAt(row, 3).toString(); 
                    String qut_unit_price = table.getValueAt(row, 4).toString(); 
                    invoicePanel.addItem(qut_id, qut_name, qut_unit, qut_price, qut_unit_price);
                }
            }
        });
    }
}
