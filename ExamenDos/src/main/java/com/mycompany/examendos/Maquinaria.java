/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.examendos;
import org.bson.Document;
import javax.swing.table.DefaultTableModel;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author AbimelecG2
 */
public class Maquinaria extends javax.swing.JFrame {
    
    MongoCollection<Document> Maquinaria;

   
    DefaultTableModel modelMaquinaria;
    
    public Maquinaria() {
        initComponents();
   
        this.Maquinaria = Main.conexMongo.getDB().getCollection("Maquinaria");

    
        this.modelMaquinaria= new DefaultTableModel();
        this.modelMaquinaria.addColumn("Id");
        this.modelMaquinaria.addColumn("Modelo");
        this.modelMaquinaria.addColumn("Marca");
        
        
        this.llenarTabla();

        this.tbMaqui.getColumnModel().getColumn(0).setMinWidth(0);
        this.tbMaqui.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    private void llenarTabla(){
        this.tbMaqui.setModel(this.modelMaquinaria);

        MongoCursor<Document> cursor = Main.conexMongo.getDocuments(this.Maquinaria).iterator();
            while (cursor.hasNext()) {
                Document documento = cursor.next();
                System.out.println(documento);
                this.agregarRegistrosTabla(documento);
            }
    }

   private void agregarRegistrosTabla(Document fila){
       String id = fila.get("Id").toString();
       String modelo = fila.get("Modelo").toString();
       String marca=fila.get("Marca").toString();
     
       this.modelMaquinaria.addRow(new Object[]{id,modelo,marca});
 }

    public void insertarDatos(){
      Document datosObj = new Document("_id",new ObjectId())
            .append("id",txtID.getText().toString())
            .append("Modelo",txtModelo.getText().toString())
            .append("Marca",txtMarca.getText());
 
       if(Main.conexMongo.insertDocuments(this.Maquinaria,datosObj)){
           this.limpiarForm();
           this.agregarRegistrosTabla(datosObj);
        }
    }

    public void limpiarForm(){
        txtModelo.setText("");
        txtMarca.setText("");
        txtID.setText("");
        txtModelo.requestFocus();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMaqui = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(153, 255, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Modelo:");

        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Marca:");

        jLabel3.setText("Identificacion:");

        tbMaqui.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbMaqui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMaquiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMaqui);

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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setText("MAQUINARIA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(34, 34, 34))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btnModificar)
                                        .addGap(55, 55, 55)
                                        .addComponent(btnEliminar))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                        .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtModelo))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(jButton1)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.insertarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showOptionDialog(new JFrame(), "Esta seguro que desea eliminar el registro seleccionado?", 
                    "Confirmacion de eliminacion",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[] { "Si", "No" }, JOptionPane.YES_OPTION);

        JOptionPane.showMessageDialog(null, (res==JOptionPane.YES_OPTION && this.deleteTablePersonas())? "Registro eliminado con exito!":"Registro no pudo ser eliminado!");
      
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showOptionDialog(new JFrame(), "Esta seguro que desea actualizar el registro seleccionado?", 
                    "Confirmacion de actualizacion",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[] { "Si", "No" }, JOptionPane.YES_OPTION);

        int posicion = this.tbMaqui.getSelectedRow();
        if(posicion>=0 && res==JOptionPane.YES_OPTION ){
           int nCol = this.modelMaquinaria.getColumnCount();
           String[] dataTabla = new String[nCol];
           for(int i=0;i<nCol;i++){
            dataTabla[i]=this.modelMaquinaria.getValueAt(posicion, i).toString();
           }

           Document datosObj = new Document("nombre",this.txtModelo.getText())
            .append("sede",this.txtID.getText())
            .append("fundacion", Integer.parseInt(this.txtMarca.getText()));
           
           JOptionPane.showMessageDialog(null, Main.conexMongo.actualizarDocuments(this.Maquinaria,datosObj,dataTabla[0])?"Registro Actualizado con exito":"Registro no pudo ser actualizado");
          
           this.modelMaquinaria.setValueAt(this.txtModelo.getText(), posicion, 1);
           this.modelMaquinaria.setValueAt(this.txtID.getText(), posicion, 2);
           this.modelMaquinaria.setValueAt(this.txtMarca.getText(), posicion, 3);
           this.limpiarForm();
           this.tbMaqui.clearSelection();
      
        }else{
           JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void tbMaquiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMaquiMouseClicked
        // TODO add your handling code here:
        int posicion = this.tbMaqui.getSelectedRow();
        if(posicion>=0){
           int nCol = this.modelMaquinaria.getColumnCount();
           String[] dataTabla = new String[nCol];
           for(int i=0;i<nCol;i++){
            dataTabla[i]=this.modelMaquinaria.getValueAt(posicion, i).toString();
           }

           this.txtModelo.setText(dataTabla[1]);
           this.txtID.setText(dataTabla[2]);
           this.txtMarca.setText(dataTabla[3]);

        }else{
           JOptionPane.showMessageDialog(null, "Seleccione otro registro de la tabla");
        }
    }//GEN-LAST:event_tbMaquiMouseClicked

public boolean deleteTablePersonas(){
     int posicion = this.tbMaqui.getSelectedRow();
     if(posicion>=0){
        String id=this.modelMaquinaria.getValueAt(posicion, 0).toString();     
        this.modelMaquinaria.removeRow(posicion);
        Main.conexMongo.deleteDocuments(this.Maquinaria,id);
        return true;
     }else{
        return false;
     }
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
            java.util.logging.Logger.getLogger(Maquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Maquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Maquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Maquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Maquinaria().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMaqui;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
}
