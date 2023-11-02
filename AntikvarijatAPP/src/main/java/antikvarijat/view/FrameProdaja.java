package antikvarijat.view;

import antikvarijat.controller.ObradaProdajaStavka;
import antikvarijat.controller.ObradaProdajaZaglavlje;
import antikvarijat.model.ProdajaStavka;
import antikvarijat.model.ProdajaZaglavlje;
import antikvarijat.util.SimpleException;
import antikvarijat.util.Tools;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class FrameProdaja extends javax.swing.JFrame {

    protected ObradaProdajaZaglavlje obradaZaglavlje;

    private ObradaProdajaStavka obradaStavka;

    public FrameProdaja() {
        initComponents();
        obradaZaglavlje = new ObradaProdajaZaglavlje();
        obradaStavka = new ObradaProdajaStavka();
        setTitle(Tools.NAZIV_APP + " | Prodaja");
        ucitajZaglavlja();
    }

    public void ucitajZaglavlja() {
        DefaultListModel<ProdajaZaglavlje> m = new DefaultListModel<>();
        m.addAll(obradaZaglavlje.read());
        lstZaglavlja.setModel(m);
        lstZaglavlja.repaint();
    }

    public void ucitajStavke(ProdajaZaglavlje prodajaZaglavlje) {
        DefaultListModel<ProdajaStavka> m = new DefaultListModel<>();
        m.addAll(obradaStavka.read(prodajaZaglavlje));
        lstStavke.setModel(m);
        lstStavke.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDodajZaglavlje = new javax.swing.JButton();
        btnPromijeniZaglavlje = new javax.swing.JButton();
        btnObrisiStavku = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstStavke = new javax.swing.JList<>();
        btnOdustani = new javax.swing.JButton();
        txtTrazi = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        btnDodajStavku = new javax.swing.JButton();
        btnPromijeniStavku = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstZaglavlja = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnDodajZaglavlje.setText("Dodaj");
        btnDodajZaglavlje.setMaximumSize(new java.awt.Dimension(81, 23));
        btnDodajZaglavlje.setMinimumSize(new java.awt.Dimension(81, 23));
        btnDodajZaglavlje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajZaglavljeActionPerformed(evt);
            }
        });

        btnPromijeniZaglavlje.setText("Promijeni");
        btnPromijeniZaglavlje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromijeniZaglavljeActionPerformed(evt);
            }
        });

        btnObrisiStavku.setText("Obriši");
        btnObrisiStavku.setMaximumSize(new java.awt.Dimension(81, 23));
        btnObrisiStavku.setMinimumSize(new java.awt.Dimension(81, 23));
        btnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiStavkuActionPerformed(evt);
            }
        });

        lstStavke.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstStavke.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstStavkeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstStavke);

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

        btnDodajStavku.setText("Dodaj");
        btnDodajStavku.setMaximumSize(new java.awt.Dimension(81, 23));
        btnDodajStavku.setMinimumSize(new java.awt.Dimension(81, 23));
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        btnPromijeniStavku.setText("Promijeni");
        btnPromijeniStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromijeniStavkuActionPerformed(evt);
            }
        });

        lstZaglavlja.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstZaglavlja.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstZaglavljaValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstZaglavlja);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Zaglavlje");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Stavke");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnPromijeniZaglavlje, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addComponent(btnDodajZaglavlje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnDodajStavku, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPromijeniStavku, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisiStavku, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrazi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDodajZaglavlje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPromijeniZaglavlje)
                        .addGap(4, 4, 4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPromijeniStavku)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrisiStavku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        int searchNumber;
        if (txtTrazi.getText().trim().equals("")) {
            ucitajZaglavlja();
            return;
        }
        try {
            searchNumber = Integer.parseInt(txtTrazi.getText().trim());
        } catch (NumberFormatException ex) {
            return;
        }
        DefaultListModel<ProdajaZaglavlje> m = new DefaultListModel<>();        
        m.addAll(obradaZaglavlje.read(searchNumber));
        lstZaglavlja.setModel(m);
        lstZaglavlja.repaint();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void lstZaglavljaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstZaglavljaValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstZaglavlja.getSelectedValue() == null) {
            return;
        }
        obradaZaglavlje.setEntitet(lstZaglavlja.getSelectedValue());
        ucitajStavke(obradaZaglavlje.getEntitet());
    }//GEN-LAST:event_lstZaglavljaValueChanged

    private void lstStavkeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstStavkeValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstStavke.getSelectedValue() == null) {
            return;
        }
        obradaStavka.setEntitet(lstStavke.getSelectedValue());
    }//GEN-LAST:event_lstStavkeValueChanged

    private void btnDodajZaglavljeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajZaglavljeActionPerformed
        new FrameProdajaZaglavlje(null, this).setVisible(true);
    }//GEN-LAST:event_btnDodajZaglavljeActionPerformed

    private void btnPromijeniZaglavljeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromijeniZaglavljeActionPerformed
        if (lstZaglavlja.getSelectedValue() == null) {
            return;
        }
        new FrameProdajaZaglavlje(obradaZaglavlje.getEntitet(), this).setVisible(true);
    }//GEN-LAST:event_btnPromijeniZaglavljeActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        if (lstZaglavlja.getSelectedValue() == null) {
            return;
        }
        new FrameProdajaStavka(null, obradaZaglavlje.getEntitet(), this).setVisible(true);
    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void btnPromijeniStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromijeniStavkuActionPerformed
        if (lstStavke.getSelectedValue() == null) {
            return;
        }
        new FrameProdajaStavka(obradaStavka.getEntitet(), null, this).setVisible(true);
    }//GEN-LAST:event_btnPromijeniStavkuActionPerformed
        
    private void btnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiStavkuActionPerformed
        if (lstStavke.getSelectedValue() == null) {
            return;
        }

        var e = lstStavke.getSelectedValue();

        if (JOptionPane.showConfirmDialog(getRootPane(), "ID: " + e.getId(), "Jeste li sigurni?",
                JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }

        obradaStavka.setEntitet(e);

        try {            
            obradaStavka.refresh();
            obradaStavka.delete();            
            ucitajStavke(obradaStavka.getEntitet().getProdajaZaglavlje());            
        } catch (SimpleException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiStavkuActionPerformed
    public void setSelectedValueLstZaglavlja(ProdajaZaglavlje pz) {
        lstZaglavlja.setSelectedValue(pz, true);
    }

    public void setSelectedValueLstStavke(ProdajaStavka ps) {
        lstStavke.setSelectedValue(ps, true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnDodajZaglavlje;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnPromijeniStavku;
    private javax.swing.JButton btnPromijeniZaglavlje;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<ProdajaStavka> lstStavke;
    private javax.swing.JList<ProdajaZaglavlje> lstZaglavlja;
    private javax.swing.JTextField txtTrazi;
    // End of variables declaration//GEN-END:variables

}
