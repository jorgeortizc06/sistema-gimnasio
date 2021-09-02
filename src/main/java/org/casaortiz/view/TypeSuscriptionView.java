/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view;

import org.casaortiz.view.components.ButtonsColors;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.casaortiz.dao.TypeSuscriptionDao;
import org.casaortiz.model.TypeSuscription;
import org.casaortiz.view.components.TableModels;

/**
 * JPanel TypeSuscriptionView
 * Para manejar el CRUD de TypeSuscription
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class TypeSuscriptionView extends javax.swing.JPanel {

    private TypeSuscriptionDao typeSuscriptionDao;
    private TypeSuscription typeSuscription;
    public TypeSuscriptionView() {
        initComponents();
        typeSuscriptionDao = new TypeSuscriptionDao();
        loadTypeSuscription();
        btnSaveChanges.setVisible(false);
        btnDelete.setVisible(false);
        addImageButtons();
    }
    
    private void addImageButtons() {
        btnDelete.setIcon(new ButtonsColors().addImageButtons1(FileLocation.pathIconBtnDelete));
        btnSave.setIcon(new ButtonsColors().addImageButtons1(FileLocation.pathIconBtnSave));
        btnCleanForm.setIcon(new ButtonsColors().addImageButtons1(FileLocation.pathIconBtnClean));
        btnSaveChanges.setIcon(new ButtonsColors().addImageButtons1(FileLocation.pathIconBtnEdit));
        lblSearch.setIcon(new ButtonsColors().addImageButtons1(FileLocation.pathIconBtnSearch));
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
        tListTypeSuscriptions = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        txtTypeSuscription = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        txtDescription = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnSaveChanges = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCleanForm = new javax.swing.JButton();
        label3 = new java.awt.Label();
        txtNumDays = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        txtPrice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblWarning = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(240, 242, 245));
        setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "TIPO SUSCRIPCIÓN"));

        tListTypeSuscriptions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tipo de Suscripción", "No. días", "Precio", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tListTypeSuscriptions.getTableHeader().setReorderingAllowed(false);
        tListTypeSuscriptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tListTypeSuscriptionsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tListTypeSuscriptions);
        if (tListTypeSuscriptions.getColumnModel().getColumnCount() > 0) {
            tListTypeSuscriptions.getColumnModel().getColumn(0).setResizable(false);
            tListTypeSuscriptions.getColumnModel().getColumn(0).setPreferredWidth(5);
            tListTypeSuscriptions.getColumnModel().getColumn(1).setResizable(false);
            tListTypeSuscriptions.getColumnModel().getColumn(1).setPreferredWidth(300);
            tListTypeSuscriptions.getColumnModel().getColumn(4).setResizable(false);
            tListTypeSuscriptions.getColumnModel().getColumn(4).setPreferredWidth(300);
        }

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setPreferredSize(new java.awt.Dimension(30, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setText("ID:");

        lblID.setPreferredSize(new java.awt.Dimension(5, 20));

        label1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label1.setText("Tipo de Suscripción:");

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

        label3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label3.setText("Numero de días:");

        txtNumDays.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNumDays.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumDaysKeyReleased(evt);
            }
        });

        label4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label4.setText("Precio:");

        txtPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setText("$");

        lblWarning.setColumns(20);
        lblWarning.setLineWrap(true);
        lblWarning.setRows(5);
        lblWarning.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Advertencia"));
        jScrollPane2.setViewportView(lblWarning);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTypeSuscription, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                            .addComponent(txtNumDays, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 314, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(1, 1, 1)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTypeSuscription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveChanges)
                    .addComponent(btnSave)
                    .addComponent(btnCleanForm)
                    .addComponent(btnDelete)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
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
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Call TypeSuscriptionDao.insert()
     * Envia datos para guardar una TypeSuscription
     * @param evt - ActionPerformed: Al hacer clic en btnSave
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        try {
            if(!txtTypeSuscription.getText().equals("")){
                TypeSuscription ts = new TypeSuscription();
                ts.setName(txtTypeSuscription.getText());
                ts.setNum_days(Integer.parseInt(txtNumDays.getText()));
                ts.setPrice(Double.parseDouble(txtPrice.getText()));
                ts.setDescription(txtDescription.getText());
                typeSuscriptionDao.insert(ts);
                JOptionPane.showMessageDialog(btnSave, "Guardado correctamente");
                cleanForm();
                loadTypeSuscription();
            }else{
                lblWarning.setText("Tipo de Suscripción no puede estar vacio");
                lblWarning.setForeground(Color.red);
            }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(btnSave, "SQLException: Error al guardar: "+ex.toString());
        }catch(Exception e){
           JOptionPane.showMessageDialog(btnSave, "Exception: Error al guardar: "+e.getMessage()); 
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    
    /**
     * Call loadSearchTypeSuscriptions(txt)
     * Carga datos segun la busqueda
     * @param evt - KeyReleased: despues de escribir en el teclado busca
     */
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        loadSearchTypeSuscriptions(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyReleased
    
    private void tListTypeSuscriptionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tListTypeSuscriptionsMouseClicked
        // TODO add your handling code here:
        int fila = tListTypeSuscriptions.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            btnDelete.setVisible(true);
            btnSave.setVisible(false);
            btnSaveChanges.setVisible(true);
            try {
                typeSuscription = typeSuscriptionDao.get(Integer.parseInt(tListTypeSuscriptions.getValueAt(fila, 0).toString()));
                lblID.setText(String.valueOf(typeSuscription.getId()));
                txtTypeSuscription.setText(typeSuscription.getName());
                txtNumDays.setText(String.valueOf(typeSuscription.getNum_days()));
                txtPrice.setText(String.valueOf(typeSuscription.getPrice()));
                txtDescription.setText(typeSuscription.getDescription());
            } catch (SQLException ex) {
                Logger.getLogger(TypeSuscriptionView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al eliminar: " +ex.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(TypeSuscriptionView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al eliminar: " +ex.getMessage());
            }
            
            
        }
    }//GEN-LAST:event_tListTypeSuscriptionsMouseClicked
    
    /**
     * Call TypeSuscriptionDao.update(TypeSuscription cat)
     * Envia datos para actualizar una TypeSuscription
     * @param evt - ActionPerformed: Al hacer clic en btnSaveChanges
     */
    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed
        // TODO add your handling code here:
        try {
            if(!txtTypeSuscription.getText().equals("")){
                TypeSuscription ts = new TypeSuscription();
                ts.setId(Integer.parseInt(lblID.getText()));
                ts.setName(txtTypeSuscription.getText());
                ts.setNum_days(Integer.parseInt(txtNumDays.getText()));
                ts.setPrice(Double.parseDouble(txtPrice.getText()));
                ts.setDescription(txtDescription.getText());
                typeSuscriptionDao.update(ts);
                JOptionPane.showMessageDialog(btnSave, "Cambios guardados correctamente");
                cleanForm();
                loadTypeSuscription();
            }else{
                lblWarning.setText("Tipo de Suscripción no puede estar vacio");
                lblWarning.setForeground(Color.red);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TypeSuscriptionView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(btnSave, "Error al guardar los cambios: "+ex.getMessage());
            lblWarning.setText(ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(TypeSuscriptionView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(btnSave, "Error al guardar los cambios: "+ex.getMessage());
            lblWarning.setText("Numero de días y precio solo aceptan números: \n" +ex.getMessage());
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
            int fila = tListTypeSuscriptions.getSelectedRow();
            if(fila == -1){
                JOptionPane.showConfirmDialog(tListTypeSuscriptions, "Debe seleccionar una fila");
            }else{
                int estadoEliminacionDialog = JOptionPane.showConfirmDialog(btnDelete, 
                        "Seguro que desea eliminar "+typeSuscription.getName()+" ?",
                        "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(estadoEliminacionDialog == 0){
                    typeSuscriptionDao.delete(typeSuscription.getId());
                    JOptionPane.showMessageDialog(btnDelete, "Se elimino correctamente la TypeSuscription: " + typeSuscription);
                    loadTypeSuscription();
                    cleanForm();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeSuscriptionView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(btnDelete, "Error al eliminar la TypeSuscription: " + typeSuscription +" Error: "+ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(TypeSuscriptionView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(btnDelete, "Error al eliminar la TypeSuscription: " + typeSuscription +" Error: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtNumDaysKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumDaysKeyReleased
        // TODO add your handling code here:
        soloNumeros("Numero de días");
        
    }//GEN-LAST:event_txtNumDaysKeyReleased
    
    private void soloNumeros(String label){
        lblWarning.setText("");
        Pattern regexNumero = Pattern.compile("^[0-9]+([.][0-9]+)?$");
        Matcher mat;
        String texto = txtNumDays.getText();
        mat = regexNumero.matcher(texto);
        
        if(mat.matches()){
            
        }else{
            lblWarning.setText(label+": Solo acepta numeros");
        }
    }
    
    /**
     * Vacia datos del jTable tListTypeSuscription
     */
    private void cleanTable(){
        DefaultTableModel modelo = (DefaultTableModel) tListTypeSuscriptions.getModel();
        modelo.setRowCount(0);
        tListTypeSuscriptions.setModel(modelo);
    }
    
    /**
     * Call TypeSuscriptionDao.getTypeSuscription()
     * Recupera datos TypeSuscription y lo carga al jTable
     */
    public void loadTypeSuscription(){
        try {
            loadTable(typeSuscriptionDao.getList());
        } catch (Exception ex) {
            Logger.getLogger(TypeSuscriptionView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al obtener datos de TypeSuscription: " +ex.getMessage());
        }
    }
    
    /**
     * Obtiene datos de TypeSuscriptionDao.searchTypeSuscriptions(text) y lo 
     * carga al jTable
     * @param text 
     */
    private void loadSearchTypeSuscriptions(String text){
        try {
            loadTable(typeSuscriptionDao.searchList(text));
        } catch (Exception ex) {
            Logger.getLogger(TypeSuscriptionView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al buscar: " +ex.getMessage());
        }
    }
    
    /**
     * Template para cargar datos al jTable tListTypeSuscriptions
     * @param List<TypeSuscription>
     */
    private void loadTable(List<TypeSuscription> typeSuscriptions){
        
        tListTypeSuscriptions.setModel(TableModels.getModelTypeSuscription(tListTypeSuscriptions, typeSuscriptions));
    }
    
    /**
     * Limpia todo el formulario del jPanel
     */
    private void cleanForm(){
        lblID.setText("");
        lblWarning.setText("");
        txtTypeSuscription.setText("");
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTextArea lblWarning;
    private javax.swing.JTable tListTypeSuscriptions;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtNumDays;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTypeSuscription;
    // End of variables declaration//GEN-END:variables
}
