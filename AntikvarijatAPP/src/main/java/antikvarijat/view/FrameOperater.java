package antikvarijat.view;

import antikvarijat.controller.ObradaOperater;
import antikvarijat.model.Operater;
import antikvarijat.util.SimpleException;
import antikvarijat.util.Tools;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.Arrays;

public class FrameOperater extends javax.swing.JFrame implements ViewInterface {

    private ObradaOperater obrada;

    public FrameOperater() {
        initComponents();
        obrada = new ObradaOperater();
        setTitle(Tools.NAZIV_APP + " | Operateri");
        ucitaj();
    }

    @Override
    public void ucitaj() {
        DefaultListModel<Operater> m = new DefaultListModel<>();
        m.addAll(obrada.read());
        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        btnIzlaz = new javax.swing.JButton();
        txtTrazi = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtOib = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbUloge = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtLozinka = new javax.swing.JPasswordField();
        txtLozinkaPotvrda = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ime:");

        btnCreate.setText("Dodaj");
        btnCreate.setMaximumSize(new java.awt.Dimension(81, 23));
        btnCreate.setMinimumSize(new java.awt.Dimension(81, 23));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setText("Promijeni");
        btnUpdate.setEnabled(false);

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

        btnIzlaz.setText("Izlaz");
        btnIzlaz.setMaximumSize(new java.awt.Dimension(81, 23));
        btnIzlaz.setMinimumSize(new java.awt.Dimension(81, 23));
        btnIzlaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzlazActionPerformed(evt);
            }
        });

        btnTrazi.setText("Traži");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        jLabel2.setText("Prezime:");

        jLabel3.setText("OIB:");

        jLabel5.setText("Email:");

        jLabel6.setText("Lozinka:");

        jLabel8.setText("Uloga:");

        cmbUloge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Odaberite ulogu", "administrator", "operater" }));

        jLabel7.setText("Potvrdi lozinku:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnIzlaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOib, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbUloge, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtLozinkaPotvrda, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrazi))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLozinkaPotvrda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbUloge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIzlaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
                .addContainerGap())
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
        obrada.setEntitet(new Operater());
        popuniModel();
        try {
            obrada.create();
            ucitaj();
            
            Operater dodaniEntitet = obrada.getEntitet();           
            lstPodaci.setSelectedValue(dodaniEntitet, true);            
        } catch (SimpleException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (lstPodaci.getSelectedValue() == null) {
            return;
        }

        var e = lstPodaci.getSelectedValue();

        if (JOptionPane.showConfirmDialog(getRootPane(), e.toString(), "Jeste li sigurni?",
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

    private void btnIzlazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzlazActionPerformed
        dispose();
    }//GEN-LAST:event_btnIzlazActionPerformed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        DefaultListModel<Operater> m = new DefaultListModel<>();
        m.addAll(obrada.read(txtTrazi.getText()));
        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }//GEN-LAST:event_btnTraziActionPerformed

    @Override
    public void popuniView() {
        var e = obrada.getEntitet();

        txtIme.setText(e.getIme());
        txtPrezime.setText(e.getPrezime());
        txtOib.setText(e.getOib());
        txtEmail.setText(e.getEmail());
        txtLozinka.setText("");
        txtLozinkaPotvrda.setText("");
        cmbUloge.setSelectedItem(e.getUloga());
    }
    
    @Override
    public void isprazniView() {
        txtIme.setText("");
        txtPrezime.setText("");
        txtOib.setText("");
        txtEmail.setText("");
        txtLozinka.setText("");
        txtLozinkaPotvrda.setText("");
        cmbUloge.setSelectedItem(Tools.ULOGA_TEMP);
    }

    @Override
    public void popuniModel() {
        var e = obrada.getEntitet();        
        String hash = "";
        StringBuilder sb = new StringBuilder();
        
        for (char c : txtLozinka.getPassword()) {
            sb.append(c);
        }        
        
        e.setIme(txtIme.getText().trim());
        e.setPrezime(txtPrezime.getText().trim());
        e.setOib(txtOib.getText().trim());
        e.setEmail(txtEmail.getText().trim());
        
        if (sb.toString().trim().equals("")) {
            e.setLozinka(hash);
        } else if (Arrays.equals(txtLozinka.getPassword(), txtLozinkaPotvrda.getPassword())) {
            Argon2 argon2 = Argon2Factory.create();
            hash = argon2.hash(10, 65536, 1, txtLozinka.getPassword());
            e.setLozinka(hash);
        } else {
            e.setLozinka(null);
        }               
        
        String ulogaTemp = (String) cmbUloge.getSelectedItem();        
        e.setUloga(ulogaTemp.trim());
    }   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnIzlaz;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbUloge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Operater> lstPodaci;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JPasswordField txtLozinka;
    private javax.swing.JPasswordField txtLozinkaPotvrda;
    private javax.swing.JTextField txtOib;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTrazi;
    // End of variables declaration//GEN-END:variables
    
}
