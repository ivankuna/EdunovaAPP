package antikvarijat.view;

import antikvarijat.controller.ObradaPartner;
import antikvarijat.controller.ObradaRezervacija;
import antikvarijat.model.Knjiga;
import antikvarijat.model.Partner;
import antikvarijat.model.Rezervacija;
import antikvarijat.util.SimpleException;
import antikvarijat.util.Tools;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class FrameRezervacija extends javax.swing.JFrame implements ViewInterface, OdabirKnjiga {

    private ObradaRezervacija obrada;

    private Knjiga odabranaKnjiga;
    
    private Partner partner;

    public FrameRezervacija() {
        initComponents();
        obrada = new ObradaRezervacija();
        setTitle(Tools.NAZIV_APP + " | Rezervacije");
        ucitajPartnere();
        ucitaj();
    }

    @Override
    public void ucitaj() {
        DefaultListModel<Rezervacija> m = new DefaultListModel<>();
        m.addAll(obrada.read());
        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }
    
    private void ucitajPartnere() {
        DefaultComboBoxModel<Partner> m = new DefaultComboBoxModel<>();

        partner = new Partner();
        partner.setId(0);
        partner.setNazivPartnera("Odaberite partnera");
        m.addElement(partner);

        m.addAll(new ObradaPartner().read());

        cmbPartner.setModel(m);
        cmbPartner.repaint();
    }  

    @Override
    public void setKnjiga(Knjiga knjiga) {
        txtKnjiga.setText(knjiga.getNazivKnjige());
        odabranaKnjiga = knjiga;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        btnOdustani = new javax.swing.JButton();
        txtTrazi = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtKnjiga = new javax.swing.JTextField();
        btnKnjige = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbPartner = new javax.swing.JComboBox<>();
        cmbStanje = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        btnTrazi.setText("Traži");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        jLabel3.setText("Knjiga:");

        txtKnjiga.setEditable(false);

        btnKnjige.setText("...");
        btnKnjige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKnjigeActionPerformed(evt);
            }
        });

        jLabel4.setText("Partner:");

        jLabel1.setText("Stanje rezervacije:");

        cmbStanje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Odaberi stanje rezervacije", "Aktivno", "Otkazano", "Izvršeno" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(153, 153, 153))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbStanje, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbPartner, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtKnjiga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnKnjige, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnOdustani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrazi))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKnjiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKnjige))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbStanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17))
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
        odabranaKnjiga = obrada.getEntitet().getKnjiga();
        popuniView();
    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        obrada.setEntitet(new Rezervacija());
        popuniModel();
        try {
            obrada.create();
            ucitaj();

            Rezervacija dodaniEntitet = obrada.getEntitet();
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

            Rezervacija promijenjeniEntitet = obrada.getEntitet();
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

        if (JOptionPane.showConfirmDialog(getRootPane(), "ID: " + e.getId(), "Jeste li sigurni?",
                JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }

        obrada.setEntitet(e);

        try {
            obrada.refresh();
            obrada.delete();
            ucitaj();
            isprazniView();
            odabranaKnjiga = null;
        } catch (SimpleException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        int searchNumber;
        if (txtTrazi.getText().trim().equals("")) {
            ucitaj();
            return;
        }
        try {
            searchNumber = Integer.parseInt(txtTrazi.getText().trim());
        } catch (NumberFormatException ex) {
            return;
        }
        DefaultListModel<Rezervacija> m = new DefaultListModel<>();        
        m.addAll(obrada.read(searchNumber));
        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }//GEN-LAST:event_btnTraziActionPerformed
    
    private void btnKnjigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKnjigeActionPerformed
        new FrameKnjiga(this).setVisible(true);        
    }//GEN-LAST:event_btnKnjigeActionPerformed

    @Override
    public void popuniView() {
        var e = obrada.getEntitet();

        txtKnjiga.setText(e.getKnjiga().getNazivKnjige());
        cmbPartner.setSelectedItem(e.getPartner());
        cmbStanje.setSelectedItem(e.getStanje());        
    }   

    @Override
    public void isprazniView() {
        txtKnjiga.setText("");
        cmbPartner.setSelectedItem(partner);
        cmbStanje.setSelectedIndex(0);
    }

    @Override
    public void popuniModel() {
        var e = obrada.getEntitet();
        
        e.setOperater(Tools.OPERATER);
        e.setKnjiga(odabranaKnjiga);
        e.setPartner((Partner) cmbPartner.getSelectedItem());        
        e.setStanje((String) cmbStanje.getSelectedItem());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnKnjige;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Partner> cmbPartner;
    private javax.swing.JComboBox<String> cmbStanje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Rezervacija> lstPodaci;
    private javax.swing.JTextField txtKnjiga;
    private javax.swing.JTextField txtTrazi;
    // End of variables declaration//GEN-END:variables

}
