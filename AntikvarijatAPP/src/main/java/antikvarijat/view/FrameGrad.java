package antikvarijat.view;

import antikvarijat.controller.ObradaDrzava;
import antikvarijat.controller.ObradaGrad;
import antikvarijat.model.Drzava;
import antikvarijat.model.Grad;
import antikvarijat.util.SimpleException;
import antikvarijat.util.Tools;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class FrameGrad extends javax.swing.JFrame implements ViewInterface {

    private ObradaGrad obrada;    
    
    private Drzava drzava;
    
    private OdabirGrad pozivatelj;

    public FrameGrad() {
        initComponents();
        btnOdaberi.setVisible(false);
        obrada = new ObradaGrad();                
        setTitle(Tools.NAZIV_APP + " | Gradovi");
        ucitajDrzave();
        ucitaj();
    }
    
    public FrameGrad(OdabirGrad odabirGrad) {
        this();
        pozivatelj = odabirGrad;
        btnOdaberi.setVisible(true);
        btnCreate.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    @Override
    public void ucitaj() {
        DefaultListModel<Grad> m = new DefaultListModel<>();
        m.addAll(obrada.read());
        lstPodaci.setModel(m);
        lstPodaci.repaint();        
    }
    
    private void ucitajDrzave() {
        DefaultComboBoxModel<Drzava> m = new DefaultComboBoxModel<>();
        
        drzava = new Drzava();
        drzava.setId(0);
        drzava.setNazivDrzave("Odaberite državu");
        m.addElement(drzava);
        
        m.addAll(new ObradaDrzava().read());
        
        cmbDrzava.setModel(m);
        cmbDrzava.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNazivGrada = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        btnOdustani = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPostanskiBroj = new javax.swing.JTextField();
        txtTrazi = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        cmbDrzava = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnOdaberi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv grada:");

        btnCreate.setText("Dodaj");
        btnCreate.setMaximumSize(new java.awt.Dimension(81, 23));
        btnCreate.setMinimumSize(new java.awt.Dimension(81, 23));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setText("Promijeni");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Obriši");
        btnDelete.setMaximumSize(new java.awt.Dimension(81, 23));
        btnDelete.setMinimumSize(new java.awt.Dimension(81, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lstPodaci.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        btnOdustani.setText("Odustani");
        btnOdustani.setMaximumSize(new java.awt.Dimension(81, 23));
        btnOdustani.setMinimumSize(new java.awt.Dimension(81, 23));
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        jLabel2.setText("Poštanski broj:");

        btnTrazi.setText("Traži");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        jLabel3.setText("Država:");

        btnOdaberi.setText("Odaberi");
        btnOdaberi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdaberiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOdustani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnOdaberi))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbDrzava, javax.swing.GroupLayout.Alignment.LEADING, 0, 168, Short.MAX_VALUE)
                        .addComponent(txtPostanskiBroj, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNazivGrada, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrazi))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNazivGrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPostanskiBroj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(7, 7, 7)
                        .addComponent(cmbDrzava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOdaberi)
                        .addGap(18, 18, 18))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstPodaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPodaciValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstPodaci.getSelectedValue() == null) {
            return;
        }
        obrada.setEntitet(lstPodaci.getSelectedValue());        
        popuniView();
    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        obrada.setEntitet(new Grad());
        popuniModel();
        try {
            obrada.create();
            ucitaj();
            
            Grad dodaniEntitet = obrada.getEntitet();           
            lstPodaci.setSelectedValue(dodaniEntitet, true);
        } catch (SimpleException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (lstPodaci.getSelectedValue() == null) {
            return;
        }
        var e = lstPodaci.getSelectedValue();

        obrada.setEntitet(e);
        popuniModel();

        try {            
            obrada.update();
            ucitaj();
            
            Grad promijenjeniEntitet = obrada.getEntitet();           
            lstPodaci.setSelectedValue(promijenjeniEntitet, true);
        } catch (SimpleException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getMessage());            
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (lstPodaci.getSelectedValue() == null) {
            return;
        }

        var e = lstPodaci.getSelectedValue();

        if (JOptionPane.showConfirmDialog(getRootPane(), e.getNazivGrada(), "Jeste li sigurni?",
                JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }

        obrada.setEntitet(e);

        try {
            obrada.refresh();
            obrada.delete();
            ucitaj();
            isprazniView();
        } catch (SimpleException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        DefaultListModel<Grad> m = new DefaultListModel<>();
        m.addAll(obrada.read(txtTrazi.getText()));
        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void btnOdaberiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdaberiActionPerformed
        if (pozivatelj != null && lstPodaci.getSelectedValue() != null) {
            pozivatelj.setGrad(lstPodaci.getSelectedValue());
            dispose();
        }
    }//GEN-LAST:event_btnOdaberiActionPerformed

    @Override
    public void popuniView() {
        var e = obrada.getEntitet();

        txtNazivGrada.setText(e.getNazivGrada());
        txtPostanskiBroj.setText(e.getPostanskiBroj());        
        cmbDrzava.setSelectedItem(e.getDrzava());
    }
    
    @Override
    public void isprazniView() {
        txtNazivGrada.setText("");
        txtPostanskiBroj.setText("");
        cmbDrzava.setSelectedItem(drzava);
    }


    @Override
    public void popuniModel() {
        var e = obrada.getEntitet();

        e.setNazivGrada(txtNazivGrada.getText().trim());
        e.setPostanskiBroj(txtPostanskiBroj.getText().trim());
        e.setDrzava((Drzava)cmbDrzava.getSelectedItem());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOdaberi;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Drzava> cmbDrzava;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Grad> lstPodaci;
    private javax.swing.JTextField txtNazivGrada;
    private javax.swing.JTextField txtPostanskiBroj;
    private javax.swing.JTextField txtTrazi;
    // End of variables declaration//GEN-END:variables
   
}
