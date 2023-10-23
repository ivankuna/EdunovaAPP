package antikvarijat.view;

import antikvarijat.controller.ObradaOtkupStavka;
import antikvarijat.model.Knjiga;
import antikvarijat.model.OtkupStavka;
import antikvarijat.model.OtkupZaglavlje;
import antikvarijat.util.SimpleException;
import antikvarijat.util.Tools;
import java.math.BigDecimal;
import java.text.ParseException;
import javax.swing.JOptionPane;

public class FrameOtkupStavka extends javax.swing.JFrame implements ViewInterface, OdabirKnjiga {

    private ObradaOtkupStavka obrada;

    private OtkupStavka otkupStavka;

    private OtkupZaglavlje otkupZaglavlje;

    private FrameOtkup frameOtkup;

    private Knjiga odabranaKnjiga;

    private boolean create;

    public FrameOtkupStavka(OtkupStavka otkupStavka, OtkupZaglavlje otkupZaglavlje, FrameOtkup frameOtkup) {
        initComponents();
        obrada = new ObradaOtkupStavka();
        this.otkupStavka = otkupStavka;
        this.otkupZaglavlje = otkupZaglavlje;
        this.frameOtkup = frameOtkup;
        this.create = false;
        setContext();
        setTitle(Tools.NAZIV_APP + " | Stavka otkupa");
    }

    @Override
    public void ucitaj() {
        // Metoda ucitaj() je u ovom slučaju suvišna       
    }

    @Override
    public void setKnjiga(Knjiga knjiga) {
        txtKnjiga.setText(knjiga.getNazivKnjige());
        odabranaKnjiga = knjiga;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPrihvati = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCijena = new javax.swing.JTextField();
        txtKnjiga = new javax.swing.JTextField();
        btnKnjiga = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnPrihvati.setText("Prihvati");
        btnPrihvati.setMaximumSize(new java.awt.Dimension(81, 23));
        btnPrihvati.setMinimumSize(new java.awt.Dimension(81, 23));
        btnPrihvati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrihvatiActionPerformed(evt);
            }
        });

        btnOdustani.setText("Odustani");
        btnOdustani.setMaximumSize(new java.awt.Dimension(81, 23));
        btnOdustani.setMinimumSize(new java.awt.Dimension(81, 23));
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        jLabel3.setText("Knjiga:");

        jLabel1.setText("Količina:");

        jLabel2.setText("Cijena:");

        txtKnjiga.setEditable(false);

        btnKnjiga.setText("...");
        btnKnjiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKnjigaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrihvati, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtKnjiga, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKolicina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCijena, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKnjiga)))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKnjiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKnjiga))
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCijena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrihvati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrihvatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrihvatiActionPerformed
        popuniModel();

        if (create) {
            try {
                obrada.create();
                frameOtkup.obradaZaglavlje.refresh();
                frameOtkup.ucitajStavke(frameOtkup.obradaZaglavlje.getEntitet());
                frameOtkup.setSelectedValueLstStavke(obrada.getEntitet());
                dispose();
            } catch (SimpleException ex) {
                JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
            }
        } else {
            try {
                obrada.update();
                frameOtkup.obradaZaglavlje.refresh();
                frameOtkup.ucitajStavke(frameOtkup.obradaZaglavlje.getEntitet());
                frameOtkup.setSelectedValueLstStavke(obrada.getEntitet());
                dispose();
            } catch (SimpleException ex) {
                JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
            }
        }
    }//GEN-LAST:event_btnPrihvatiActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnKnjigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKnjigaActionPerformed
        new FrameKnjiga(this).setVisible(true);
    }//GEN-LAST:event_btnKnjigaActionPerformed

    private void setContext() {
        if (otkupStavka != null) {
            obrada.setEntitet(otkupStavka);
            otkupZaglavlje = otkupStavka.getOtkupZaglavlje();
            odabranaKnjiga = otkupStavka.getKnjiga();
            popuniView();
        } else {
            obrada.setEntitet(new OtkupStavka());
            create = true;
        }
    }

    @Override
    public void popuniView() {
        var e = obrada.getEntitet();

        txtKnjiga.setText(e.getKnjiga().getNazivKnjige());
        try {
            txtKolicina.setText(String.valueOf(e.getKolicina()));
        } catch (Exception ex) {
            txtKolicina.setText("");
        }
        try {
            txtCijena.setText(Tools.DECIMAL_FORMAT.format(e.getCijenaOtkupaArtikla()));
        } catch (Exception ex) {
            txtCijena.setText(Tools.DECIMAL_FORMAT.format(0));
        }
    }

    @Override
    public void isprazniView() {
        txtKnjiga.setText("");
        txtKolicina.setText("");
        txtCijena.setText("");
    }

    @Override
    public void popuniModel() {
        var e = obrada.getEntitet();

        e.setOtkupZaglavlje(otkupZaglavlje);
        e.setKnjiga(odabranaKnjiga);
        try {
            e.setKolicina(Integer.valueOf(txtKolicina.getText()));
        } catch (NumberFormatException ex) {
            e.setKolicina(0);
        }
        try {
            e.setCijenaOtkupaArtikla(BigDecimal.valueOf(Tools.DECIMAL_FORMAT.parse(txtCijena.getText()).doubleValue()));
        } catch (ParseException ex) {
            e.setCijenaOtkupaArtikla(BigDecimal.ZERO);
        }
        BigDecimal kolicinaTemp = new BigDecimal(e.getKolicina());
        e.setCijenaOtkupa(e.getCijenaOtkupaArtikla().multiply(kolicinaTemp));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKnjiga;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnPrihvati;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCijena;
    private javax.swing.JTextField txtKnjiga;
    private javax.swing.JTextField txtKolicina;
    // End of variables declaration//GEN-END:variables

}
