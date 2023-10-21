package antikvarijat.view;

import antikvarijat.controller.ObradaIzdavac;
import antikvarijat.controller.ObradaKnjiga;
import antikvarijat.model.Izdavac;
import antikvarijat.model.Knjiga;
import antikvarijat.model.Autor;
import antikvarijat.util.SimpleException;
import antikvarijat.util.Tools;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class FrameKnjiga extends javax.swing.JFrame implements ViewInterface, OdabirAutor {

    private ObradaKnjiga obrada;

    private Izdavac izdavacTemp;
    
    private Autor odabraniAutor;           

    public FrameKnjiga() {
        initComponents();
        obrada = new ObradaKnjiga();                
        setTitle(Tools.NAZIV_APP + " | Knjige");
        ucitajIzdavace();
        ucitajVrsteUveza();
        ucitajDimenzije();
        ucitaj();
    }

    @Override
    public void ucitaj() {
        DefaultListModel<Knjiga> m = new DefaultListModel<>();
        m.addAll(obrada.read());
        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }

    private void ucitajIzdavace() {
        DefaultComboBoxModel<Izdavac> m = new DefaultComboBoxModel<>();

        izdavacTemp = new Izdavac();
        izdavacTemp.setId(0);
        izdavacTemp.setNazivIzdavaca("Odaberite izdavača");
        m.addElement(izdavacTemp);

        m.addAll(new ObradaIzdavac().read());

        cmbIzdavac.setModel(m);
        cmbIzdavac.repaint();
    }

    private void ucitajVrsteUveza() {
        DefaultComboBoxModel<String> m = new DefaultComboBoxModel<>();
        
        m.addElement(Tools.VRSTA_UVEZA_TEMP);

        List<Knjiga> knjige = obrada.read();
        List<String> vrsteUveza = new ArrayList<>();
        boolean dopustenUnos;

        for (Knjiga k : knjige) {
            dopustenUnos = true;
            for (String u : vrsteUveza) {
                if (k.getVrstaUveza().equals(u)) {
                    dopustenUnos = false;
                }
            }
            if (dopustenUnos) {
                vrsteUveza.add(k.getVrstaUveza());
            }
        }

        m.addAll(vrsteUveza);

        cmbVrstaUveza.setModel(m);
        cmbVrstaUveza.repaint();
    }

    private void ucitajDimenzije() {
        DefaultComboBoxModel<String> m = new DefaultComboBoxModel<>();
        
        m.addElement(Tools.DIMENZIJE_TEMP);

        List<Knjiga> knjige = obrada.read();
        List<String> dimenzije = new ArrayList<>();
        boolean dopustenUnos;

        for (Knjiga k : knjige) {
            dopustenUnos = true;
            for (String d : dimenzije) {
                if (k.getDimenzije().equals(d) || k.getDimenzije().equals("")) {
                    dopustenUnos = false;
                }
            }
            if (dopustenUnos) {
                dimenzije.add(k.getDimenzije());
            }
        }

        m.addAll(dimenzije);

        cmbDimenzije.setModel(m);
        cmbDimenzije.repaint();
    }
    
    @Override
    public void setAutor(Autor autor) {
        txtAutor.setText(autor.getNazivAutora());
        odabraniAutor = autor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNazivKnjige = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        btnOdustani = new javax.swing.JButton();
        txtTrazi = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtGodinaIzdanja = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtJezik = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBrojStranica = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        btnAutori = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmbIzdavac = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCijena = new javax.swing.JTextField();
        cmbVrstaUveza = new javax.swing.JComboBox<>();
        cmbDimenzije = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv knjige:");

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

        jLabel3.setText("Autor:");

        jLabel2.setText("Godina izdanja:");

        jLabel4.setText("Jezik:");

        jLabel5.setText("Broj stranica:");

        jLabel6.setText("Vrsta uveza:");

        txtAutor.setEditable(false);

        btnAutori.setText("...");
        btnAutori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoriActionPerformed(evt);
            }
        });

        jLabel7.setText("Izdavač:");

        jLabel8.setText("Dimenzije:");

        jLabel9.setText("Cijena:");

        cmbVrstaUveza.setEditable(true);

        cmbDimenzije.setEditable(true);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNazivKnjige)
                            .addComponent(txtAutor)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAutori)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbIzdavac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGodinaIzdanja, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtJezik, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBrojStranica, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCijena, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                            .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnOdustani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 17, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbVrstaUveza, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cmbDimenzije, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNazivKnjige, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAutori))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbIzdavac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGodinaIzdanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtJezik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBrojStranica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbVrstaUveza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDimenzije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCijena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
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
        odabraniAutor = obrada.getEntitet().getAutor();
        popuniView();
    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        obrada.setEntitet(new Knjiga());
        popuniModel();

        try {
            obrada.create();
            ucitaj();

            Knjiga dodaniEntitet = obrada.getEntitet();
            lstPodaci.setSelectedValue(dodaniEntitet, true);
            dodajVrstuUveza();
            dodajDimenziju();
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

            Knjiga promijenjeniEntitet = obrada.getEntitet();
            lstPodaci.setSelectedValue(promijenjeniEntitet, true);
            dodajVrstuUveza();
            dodajDimenziju();
        } catch (SimpleException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getMessage());
            obrada.refresh();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (lstPodaci.getSelectedValue() == null) {
            return;
        }

        var e = lstPodaci.getSelectedValue();

        if (JOptionPane.showConfirmDialog(getRootPane(), e.getNazivKnjige(), "Jeste li sigurni?",
                JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }

        obrada.setEntitet(e);

        try {
            obrada.refresh();
            obrada.delete();
            ucitaj();
            isprazniView();     
            odabraniAutor = null;
        } catch (SimpleException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        DefaultListModel<Knjiga> m = new DefaultListModel<>();
        m.addAll(obrada.read(txtTrazi.getText()));
        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void btnAutoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoriActionPerformed
        new FrameAutor(this).setVisible(true);
    }//GEN-LAST:event_btnAutoriActionPerformed

    @Override
    public void popuniView() {
        var e = obrada.getEntitet();

        txtNazivKnjige.setText(e.getNazivKnjige());
        txtAutor.setText(e.getAutor().getNazivAutora());
        cmbIzdavac.setSelectedItem(e.getIzdavac());
        try {
            txtGodinaIzdanja.setText(String.valueOf(e.getGodinaIzdanja()));
        } catch (Exception ex) {
            txtGodinaIzdanja.setText("");
        }
        txtJezik.setText(e.getJezik());
        try {
            txtBrojStranica.setText(String.valueOf(e.getBrojStranica()));
        } catch (Exception ex) {
            txtBrojStranica.setText("");
        }
        cmbVrstaUveza.setSelectedItem(e.getVrstaUveza());
        cmbDimenzije.setSelectedItem(e.getDimenzije());
        try {
            txtCijena.setText(Tools.DECIMAL_FORMAT.format(e.getCijena()));
        } catch (Exception ex) {
            txtCijena.setText(Tools.DECIMAL_FORMAT.format(0));
        }
    }

    public void popuniTxtAutor(String nazivAutora) {
        txtAutor.setText(nazivAutora);
    }

    @Override
    public void isprazniView() {
        txtNazivKnjige.setText("");
        txtAutor.setText("");
        cmbIzdavac.setSelectedItem(izdavacTemp);
        txtGodinaIzdanja.setText("");
        txtJezik.setText("");
        txtBrojStranica.setText("");
        cmbVrstaUveza.setSelectedItem(Tools.VRSTA_UVEZA_TEMP);
        cmbDimenzije.setSelectedItem(Tools.DIMENZIJE_TEMP);        
        txtCijena.setText("");
    }

    @Override
    public void popuniModel() {
        var e = obrada.getEntitet();

        e.setNazivKnjige(txtNazivKnjige.getText().trim());
        e.setAutor(odabraniAutor);
        e.setIzdavac((Izdavac) cmbIzdavac.getSelectedItem());
        try {
            e.setGodinaIzdanja(Integer.parseInt(txtGodinaIzdanja.getText()));
        } catch (NumberFormatException ex) {
            e.setGodinaIzdanja(0);
        }
        e.setJezik(txtJezik.getText().trim());
        try {
            e.setBrojStranica(Integer.parseInt(txtBrojStranica.getText()));
        } catch (NumberFormatException ex) {
            e.setBrojStranica(0);
        }
        String vrstaUvezaTemp = (String) cmbVrstaUveza.getSelectedItem();
        e.setVrstaUveza(vrstaUvezaTemp.trim());
        String dimenzijeTemp = (String) cmbDimenzije.getSelectedItem();
        e.setDimenzije(dimenzijeTemp.trim());
        try {
            e.setCijena(BigDecimal.valueOf(Tools.DECIMAL_FORMAT.parse(txtCijena.getText()).doubleValue()));
        } catch (ParseException ex) {
            e.setCijena(BigDecimal.ZERO);
        }
    }

    public void dodajVrstuUveza() {
        boolean mozeDalje = true;

        String novaVrstaUveza = (String) cmbVrstaUveza.getSelectedItem();

        ComboBoxModel<String> m = cmbVrstaUveza.getModel();

        for (int i = 0; i < m.getSize(); i++) {
            if (novaVrstaUveza.equals(m.getElementAt(i))) {
                mozeDalje = false;
            }
        }
        if (mozeDalje) {
            cmbVrstaUveza.addItem(novaVrstaUveza);
        }
    }

    public void dodajDimenziju() {
        boolean mozeDalje = true;

        String novaDimenzija = ((String) cmbDimenzije.getSelectedItem()).trim();
        
        if (novaDimenzija.equals("")) {
            return;            
        }
        
        ComboBoxModel<String> m = cmbDimenzije.getModel();

        for (int i = 0; i < m.getSize(); i++) {
            if (novaDimenzija.equals(m.getElementAt(i))) {
                mozeDalje = false;
            }
        }
        if (mozeDalje) {
            cmbDimenzije.addItem(novaDimenzija);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutori;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbDimenzije;
    private javax.swing.JComboBox<Izdavac> cmbIzdavac;
    private javax.swing.JComboBox<String> cmbVrstaUveza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Knjiga> lstPodaci;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtBrojStranica;
    private javax.swing.JTextField txtCijena;
    private javax.swing.JTextField txtGodinaIzdanja;
    private javax.swing.JTextField txtJezik;
    private javax.swing.JTextField txtNazivKnjige;
    private javax.swing.JTextField txtTrazi;
    // End of variables declaration//GEN-END:variables
    
}
