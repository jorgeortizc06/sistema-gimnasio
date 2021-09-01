/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.casaortiz.dao.TypePersonDao;
import org.casaortiz.model.TypePerson;

/**
 * JPanel TypePersonView
 * Para manejar el CRUD de TypePerson
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class TypePersonView extends javax.swing.JPanel {

    private TypePersonDao typePersonDao;
    private TypePerson typePerson;
    public TypePersonView() {
        initComponents();
        typePersonDao = new TypePersonDao();
        loadTypePeople();
        btnSaveChanges.setVisible(false);
        btnDelete.setVisible(false);
        addImageButtons();
    }
    
    private void addImageButtons(){
        ImageIcon iconBtnDelete = createImageIcon("/icons/system/delete.png", "boton eliminar");
        ImageIcon iconBtnSave = createImageIcon("/icons/system/diskette.png", "boton guardar");
        ImageIcon iconBtnCleanForm = createImageIcon("/icons/system/clean.png", "boton CleanForm");
        ImageIcon iconBtnSaveChanges = createImageIcon("/icons/system/edit.png", "boton SaveChanges");
        ImageIcon iconLblBuscar = createImageIcon("/icons/system/search.png", "label lblBuscar");

        btnDelete.setIcon(iconBtnDelete);
        btnSave.setIcon(iconBtnSave);
        btnCleanForm.setIcon(iconBtnCleanForm);
        btnSaveChanges.setIcon(iconBtnSaveChanges);
        lblSearch.setIcon(iconLblBuscar);
    }
    
    protected ImageIcon createImageIcon(String path,
                                           String description) {
        URL imgURL = getClass().getResource(path);
        
        if (imgURL != null) {
            Image img = new ImageIcon(imgURL).getImage();
            System.out.println("imgURL = " + imgURL.getPath());
            return new ImageIcon(img.getScaledInstance(30, 30, Image.SCALE_SMOOTH), description);
        } else {
            System.err.println("Couldn't find file: " + path);
            System.out.println("imgURL = " + imgURL.getPath());
            return null;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tListTypePeople = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lblWarning = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        txtTypePerson = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        txtDescription = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnSaveChanges = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCleanForm = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 242, 245));
        setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "CATEGORIA"));

        tListTypePeople.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoría", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tListTypePeople.getTableHeader().setReorderingAllowed(false);
        tListTypePeople.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tListTypePeopleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tListTypePeople);
        if (tListTypePeople.getColumnModel().getColumnCount() > 0) {
            tListTypePeople.getColumnModel().getColumn(0).setResizable(false);
            tListTypePeople.getColumnModel().getColumn(0).setPreferredWidth(5);
            tListTypePeople.getColumnModel().getColumn(1).setResizable(false);
            tListTypePeople.getColumnModel().getColumn(1).setPreferredWidth(300);
            tListTypePeople.getColumnModel().getColumn(2).setResizable(false);
            tListTypePeople.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setPreferredSize(new java.awt.Dimension(30, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblWarning.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Advertencia"));

        jLabel1.setText("ID:");

        lblID.setPreferredSize(new java.awt.Dimension(5, 20));

        label1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label1.setText("Tipo de Cliente:");

        label2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label2.setText("Descripción:");

        btnSave.setBackground(new java.awt.Color(0, 128, 129));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnSaveChanges.setBackground(new java.awt.Color(53, 152, 219));
        btnSaveChanges.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveChanges.setText("Guardar Cambios");
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(212, 105, 89));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCleanForm.setBackground(new java.awt.Color(252, 246, 214));
        btnCleanForm.setText("Limpiar Formulario");
        btnCleanForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveChanges)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCleanForm))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTypePerson))))
                .addGap(38, 38, 38)
                .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTypePerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveChanges)
                    .addComponent(btnSave)
                    .addComponent(btnCleanForm)
                    .addComponent(btnDelete))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Call TypePersonDao.insert()
     * Envia datos para guardar una TypePerson
     * @param evt - ActionPerformed: Al hacer clic en btnSave
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        TypePerson cat = new TypePerson();
        cat.setName(txtTypePerson.getText());
        cat.setDescription(txtDescription.getText());
        
        try {
            if(!txtTypePerson.getText().equals("")){
                typePersonDao.insert(cat);
                JOptionPane.showMessageDialog(btnSave, "Guardado correctamente");
                cleanForm();
                loadTypePeople();
            }else{
                lblWarning.setText("TypePerson no puede estar vacio");
                lblWarning.setForeground(Color.red);
            }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(btnSave, "SQLException: Error al guardar: "+ex.toString());
        }catch(Exception e){
           JOptionPane.showMessageDialog(btnSave, "Exception: Error al guardar: "+e.getMessage()); 
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    
    /**
     * Call loadSearchTypePeople(txt)
     * Carga datos segun la busqueda
     * @param evt - KeyReleased: despues de escribir en el teclado busca
     */
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        loadSearchTypePeople(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyReleased
    
    private void tListTypePeopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tListTypePeopleMouseClicked
        // TODO add your handling code here:
        int fila = tListTypePeople.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            btnDelete.setVisible(true);
            btnSave.setVisible(false);
            btnSaveChanges.setVisible(true);
            try {
                typePerson = typePersonDao.getTypePerson(Integer.parseInt(tListTypePeople.getValueAt(fila, 0).toString()));
                lblID.setText(String.valueOf(typePerson.getId()));
                txtTypePerson.setText(typePerson.getName());
                txtDescription.setText(typePerson.getDescription());
            } catch (SQLException ex) {
                Logger.getLogger(TypePersonView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al eliminar: " +ex.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(TypePersonView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al eliminar: " +ex.getMessage());
            }
            
            
        }
    }//GEN-LAST:event_tListTypePeopleMouseClicked
    
    /**
     * Call TypePersonDao.update(TypePerson cat)
     * Envia datos para actualizar una TypePerson
     * @param evt - ActionPerformed: Al hacer clic en btnSaveChanges
     */
    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed
        // TODO add your handling code here:
        TypePerson cat = new TypePerson();
        cat.setId(Integer.parseInt(lblID.getText()));
        cat.setName(txtTypePerson.getText());
        cat.setDescription(txtDescription.getText());
        try {
            if(!txtTypePerson.getText().equals("")){
                typePersonDao.update(cat);
                JOptionPane.showMessageDialog(btnSave, "Cambios guardados correctamente");
                cleanForm();
                loadTypePeople();
            }else{
                lblWarning.setText("TypePerson no puede estar vacio");
                lblWarning.setForeground(Color.red);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TypePersonView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(btnSave, "Error al guardar los cambios: "+ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(TypePersonView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(btnSave, "Error al guardar los cambios: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnSaveChangesActionPerformed
    
   
    /**
     * Limpia el formulario del jPanel
     * @param evt - ActionPerformed: Click en btnCleanForm
     */
    private void btnCleanFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanFormActionPerformed
        // TODO add your handling code here:
        cleanForm();
    }//GEN-LAST:event_btnCleanFormActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int fila = tListTypePeople.getSelectedRow();
            if(fila == -1){
                JOptionPane.showConfirmDialog(tListTypePeople, "Debe seleccionar una fila");
            }else{
                int estadoEliminacionDialog = JOptionPane.showConfirmDialog(btnDelete, 
                        "Seguro que desea eliminar "+typePerson.getName()+" ?",
                        "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(estadoEliminacionDialog == 0){
                    typePersonDao.delete(typePerson.getId());
                    JOptionPane.showMessageDialog(btnDelete, "Se elimino correctamente la TypePerson: " + typePerson);
                    loadTypePeople();
                    cleanForm();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypePersonView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(btnDelete, "Error al eliminar la TypePerson: " + typePerson +" Error: "+ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(TypePersonView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(btnDelete, "Error al eliminar la TypePerson: " + typePerson +" Error: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
    
    /**
     * Vacia datos del jTable tListTypePeople
     */
    private void cleanTable(){
        DefaultTableModel modelo = (DefaultTableModel) tListTypePeople.getModel();
        modelo.setRowCount(0);
        tListTypePeople.setModel(modelo);
    }
    
    /**
     * Call TypePersonDao.getTypePeople()
     * Recupera datos TypePeople y lo carga al jTable
     */
    private void loadTypePeople(){
        try {
            loadTable(typePersonDao.getTypePeople());
        } catch (Exception ex) {
            Logger.getLogger(TypePersonView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al obtener datos de TypePerson: " +ex.getMessage());
        }
    }
    
    /**
     * Obtiene datos de TypePersonDao.searchTypePeople(text) y lo 
     * carga al jTable
     * @param text 
     */
    private void loadSearchTypePeople(String text){
        try {
            loadTable(typePersonDao.searchTypePeople(text));
        } catch (Exception ex) {
            Logger.getLogger(TypePersonView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al buscar: " +ex.getMessage());
        }
    }
    
    /**
     * Template para cargar datos al jTable tListTypePeople
     * @param List<TypePerson>
     */
    private void loadTable(List<TypePerson> typePeople){
        cleanTable();
        DefaultTableModel modelo = (DefaultTableModel) tListTypePeople.getModel();
        List<TypePerson> items = typePeople;
        Object rowData[] = new Object[3];
        for(TypePerson c: items){
            System.out.println(c);
            rowData[0] = c.getId();
            rowData[1] = c.getName();
            rowData[2] = c.getDescription();
            modelo.addRow(rowData);
        }
        tListTypePeople.setModel(modelo);
    }
    
    /**
     * Limpia todo el formulario del jPanel
     */
    private void cleanForm(){
        lblID.setText("");
        lblWarning.setText("");
        txtTypePerson.setText("");
        txtDescription.setText("");
        btnSave.setVisible(true);
        btnSaveChanges.setVisible(false);
        btnDelete.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCleanForm;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JTable tListTypePeople;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTypePerson;
    // End of variables declaration//GEN-END:variables
}
