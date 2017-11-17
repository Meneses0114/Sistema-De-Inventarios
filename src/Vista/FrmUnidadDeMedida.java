/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ialonzo
 */
public class FrmUnidadDeMedida extends javax.swing.JFrame {

    /**
     * Creates new form FrmUnidadDeMedida
     */
      DefaultTableModel modelo = new  DefaultTableModel();
    public FrmUnidadDeMedida() {
        initComponents();
      String campo = txtUnidadDeMedida.getText();
        String where = "";
        
        if(!"".equals(campo)){
            
            where = "WHERE unidaddemedida = ' " + campo + "'";
            
        }
        
        
            try{
      
        jtUnidaddemedida.setModel(modelo);
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion ();
        Connection con = conn.getConexion();
        
        String sql = "SELECT UnidadDeMedida, Descripcion FROM unidadesmedida "
                + where;
        
        System.out.println(sql);
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        
        ResultSetMetaData rsMd = rs.getMetaData();
        int cantidadColumnas = rsMd.getColumnCount();
        
        modelo.addColumn("Unidad de Medida");
        modelo.addColumn("Descripcion");
        
        while(rs.next()){
            
            Object[]  filas = new Object[cantidadColumnas];
            
            for(int i=0; i < cantidadColumnas; i++){
                filas[i] = rs.getObject(i + 1);                       
            }
            modelo.addRow(filas);    
        }    
    }catch(SQLException ex){
        
       System.err.println(ex.toString()); 
        
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUnidadDeMedida = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUnidaddemedida = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("U.M.");

        jLabel2.setText("Descripción");

        btnBuscar.setText("Consulta");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jtUnidaddemedida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Unidad de Medida", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtUnidaddemedida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUnidaddemedidaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtUnidaddemedida);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(93, 93, 93)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUnidadDeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnModificar)
                                .addGap(55, 55, 55)
                                .addComponent(btnEliminar)
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUnidadDeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar)
                    .addComponent(btnGuardar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    String campo = txtUnidadDeMedida.getText();
        String where = "";
        if (!"".equals(campo)) {
            where = "WHERE UnidadDeMedida = '" + campo + "'";
        }

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jtUnidaddemedida.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT UnidadDeMedida, Descripcion FROM unidadesmedida " + where;
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Unidad de medida");
            modelo.addColumn("Descripcion");
           
            int[] anchos = {50, 200, 50, 50};
            for (int i = 0; i < jtUnidaddemedida.getColumnCount(); i++) {
                jtUnidaddemedida.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jtUnidaddemedidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUnidaddemedidaMouseClicked
     
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Conexion objcon = new Conexion();
            Connection conn = objcon.getConexion();
            
            int fila = jtUnidaddemedida.getSelectedRow();
            String UnidadDeMedida = jtUnidaddemedida.getValueAt( fila, 0).toString();
            
            ps= conn.prepareStatement("SELECT UnidadDeMedida, Descripcion FROM unidadesmedida Where UnidadDeMedida=?");
            ps.setString(1, UnidadDeMedida);
            rs = ps.executeQuery();
            
            while (rs.next()){
                txtUnidadDeMedida.setText(rs.getString("UnidadDeMedida"));
                txtDescripcion.setText(rs.getString("Descripcion"));
                
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        
    }//GEN-LAST:event_jtUnidaddemedidaMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        PreparedStatement ps = null;
        try{
           
         Conexion objcon = new Conexion();
         Connection conn = objcon.getConexion();
         ps = conn.prepareStatement("INSERT INTO unidadesmedida (UnidadDeMedida, Descripcion) VALUES(?,?)");
         
         ps.setString(1, txtUnidadDeMedida.getText());
         ps.setString(2, txtDescripcion.getText());
         
         ps.execute();
         
         JOptionPane.showMessageDialog(null, "Registro Guardado");
         Object[] fila = new Object[2];
         fila[0] = txtUnidadDeMedida.getText();
         fila[1] = txtDescripcion.getText();
         
         modelo.addRow(fila);
         
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al Guardar");
            System.out.println(ex);
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
int Fila = jtUnidaddemedida.getSelectedRow();

        PreparedStatement ps = null;
        try {
            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();
            ps = conn.prepareStatement("UPDATE unidadesmedida SET Descripcion=? WHERE UnidadDeMedida=?");

            ps.setString(1, txtUnidadDeMedida.getText());
            ps.setString(2, txtDescripcion.getText());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Producto Modificado");
            jtUnidaddemedida.setValueAt(txtUnidadDeMedida.getText(), Fila, 0);
            jtUnidaddemedida.setValueAt(txtDescripcion.getText(), Fila, 1);


            limpiar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Modificar Producto");
            System.out.println(ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
PreparedStatement ps = null;
        try {

            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();

            int Fila = jtUnidaddemedida.getSelectedRow();
            String UnidadDeMedida = jtUnidaddemedida.getValueAt(Fila, 0).toString();

            ps = conn.prepareStatement("DELETE FROM unidadesmedida WHERE UnidadDeMedida=?");
            ps.setString(1, UnidadDeMedida);
            ps.execute();

            modelo.removeRow(Fila);
            JOptionPane.showMessageDialog(null, "Producto Eliminado");
            limpiar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar Producto");
            System.out.println(ex.toString());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed
 private void limpiar() {
        txtUnidadDeMedida.setText("");
        txtDescripcion.setText("");
     
    }

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
            java.util.logging.Logger.getLogger(FrmUnidadDeMedida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUnidadDeMedida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUnidadDeMedida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUnidadDeMedida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUnidadDeMedida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtUnidaddemedida;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtUnidadDeMedida;
    // End of variables declaration//GEN-END:variables