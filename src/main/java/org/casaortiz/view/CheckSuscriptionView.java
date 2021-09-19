/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view;

import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.casaortiz.dao.PersonDao;
import org.casaortiz.db.ConnectionDBPostgres;
import org.casaortiz.model.Person;
import org.casaortiz.model.TypePerson;
import org.casaortiz.view.components.ButtonsColors;
import org.casaortiz.view.components.TableModels;

/**
 *
 * @author jorge
 */
public class CheckSuscriptionView extends javax.swing.JPanel {

    private PersonDao personDao;
    private Person person;

    public CheckSuscriptionView() {
        initComponents();
        personDao = new PersonDao();
        person = new Person();
        addImageButtons();

    }

    private void addImageButtons() {
        btnGeneratorCard.setIcon(new ButtonsColors().addIconButton(FileLocation.pathIconBtnGenerator));
        btnAddSuscription.setIcon(new ButtonsColors().addIconButton(FileLocation.pathIconBtnAdd));
        btnSaveChanges.setIcon(new ButtonsColors().addIconButton(FileLocation.pathIconBtnEdit));
        lblSearch.setIcon(new ButtonsColors().addIconButton(FileLocation.pathIconBtnSearch));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblPhoto = new javax.swing.JLabel();
        lblWarning = new javax.swing.JLabel();
        lblNames = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblRemainingDays = new javax.swing.JLabel();
        btnAddSuscription = new javax.swing.JButton();
        btnSaveChanges = new javax.swing.JButton();
        btnGeneratorCard = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tListPeople = new javax.swing.JTable();

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Código Barras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11))); // NOI18N

        lblPhoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        lblPhoto.setPreferredSize(new java.awt.Dimension(400, 300));

        lblWarning.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarning.setPreferredSize(new java.awt.Dimension(700, 70));

        lblNames.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblNames.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNames.setPreferredSize(new java.awt.Dimension(700, 70));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Días Restantes:");

        lblRemainingDays.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        btnAddSuscription.setBackground(new java.awt.Color(194, 60, 61));
        btnAddSuscription.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnAddSuscription.setForeground(new java.awt.Color(255, 255, 255));
        btnAddSuscription.setText("AGREGAR SUSCRIPCIÓN");
        btnAddSuscription.setPreferredSize(new java.awt.Dimension(280, 39));

        btnSaveChanges.setBackground(new java.awt.Color(194, 60, 61));
        btnSaveChanges.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnSaveChanges.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveChanges.setText("EDITAR");
        btnSaveChanges.setPreferredSize(new java.awt.Dimension(280, 39));

        btnGeneratorCard.setBackground(new java.awt.Color(194, 60, 61));
        btnGeneratorCard.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnGeneratorCard.setForeground(new java.awt.Color(255, 255, 255));
        btnGeneratorCard.setText("GENERAR TARJETA");
        btnGeneratorCard.setPreferredSize(new java.awt.Dimension(280, 39));
        btnGeneratorCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratorCardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRemainingDays, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNames, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddSuscription, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGeneratorCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 162, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNames, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblRemainingDays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4)))
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddSuscription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGeneratorCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setPreferredSize(new java.awt.Dimension(30, 30));

        tListPeople.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tListPeople.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cédula", "Nombre", "Apellido", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tListPeople.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tListPeopleMouseClicked(evt);
            }
        });
        tListPeople.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tListPeopleKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tListPeople);
        if (tListPeople.getColumnModel().getColumnCount() > 0) {
            tListPeople.getColumnModel().getColumn(0).setMinWidth(0);
            tListPeople.getColumnModel().getColumn(0).setPreferredWidth(0);
            tListPeople.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1461, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        loadSearchPeople(txtSearch.getText());
        //Oculto mi column id que esta en la posicion 
        /*tListPeople.getColumnModel().getColumn(0).setMinWidth(0);
        tListPeople.getColumnModel().getColumn(0).setMaxWidth(0);
        tListPeople.getColumnModel().getColumn(0).setWidth(0);*/
    }//GEN-LAST:event_txtSearchKeyReleased

    private void loadSearchPeople(String text) {
        try {
            loadTable(personDao.searchList(text));
        } catch (Exception ex) {
            Logger.getLogger(CategoryView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al buscar: " + ex.getMessage());
        }
    }

    private void loadTable(List<Person> people) {

        tListPeople.setModel(TableModels.getModelPersonForCheckSuscription(tListPeople, people));
    }


    private void tListPeopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tListPeopleMouseClicked
        loadItemFromTable();
    }//GEN-LAST:event_tListPeopleMouseClicked

    public void loadItemFromTable(){
        // TODO add your handling code here:
        //seleccionarItemTabla();
        int fila = tListPeople.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        } else {
            try {
                person = personDao.get(Integer.parseInt(tListPeople.getValueAt(fila, 0).toString()));
                lblNames.setText(person.getFirstName() + " " + person.getLastName());
                System.out.println("Foto: " + person.getPhoto());
                loadPhotoPerson(person.getPhoto() + ".png");
            } catch (SQLException ex) {
                Logger.getLogger(CategoryView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + ex.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(CategoryView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + ex.getMessage());
            }
        }
    }
    
    private void loadPhotoPerson(String name) {
        lblPhoto.setIcon(Images.getImage(name));
        lblPhoto.validate();
        lblPhoto.repaint();
    }
    private void tListPeopleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tListPeopleKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
            loadItemFromTable();
        }
    }//GEN-LAST:event_tListPeopleKeyReleased

    private void btnGeneratorCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratorCardActionPerformed
        // TODO add your handling code here:
        int fila = tListPeople.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        } else {
            var reporte = new Reportes();
            reporte.generarTarjetaGimnasio(person);
        }

    }//GEN-LAST:event_btnGeneratorCardActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSuscription;
    private javax.swing.JButton btnGeneratorCard;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblNames;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblRemainingDays;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JTable tListPeople;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
