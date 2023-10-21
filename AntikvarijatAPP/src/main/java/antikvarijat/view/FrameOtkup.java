package antikvarijat.view;

import antikvarijat.controller.ObradaOtkupStavka;
import antikvarijat.controller.ObradaOtkupZaglavlje;
import antikvarijat.model.OtkupStavka;
import antikvarijat.model.OtkupZaglavlje;
import antikvarijat.util.Tools;
import javax.swing.DefaultListModel;

public class FrameOtkup extends javax.swing.JFrame {

    private ObradaOtkupZaglavlje obradaZaglavlje;
    
    private ObradaOtkupStavka obradaStavka;

    public FrameOtkup() {
        initComponents();
        obradaZaglavlje = new ObradaOtkupZaglavlje();
        obradaStavka = new ObradaOtkupStavka();
        setTitle(Tools.NAZIV_APP + " | Otkup");
        ucitajZaglavlja();
    }
    
    public void ucitajZaglavlja() {
        DefaultListModel<OtkupZaglavlje> m = new DefaultListModel<>();
        m.addAll(obradaZaglavlje.read());
        lstZaglavlja.setModel(m);
        lstZaglavlja.repaint();
    }
    
    public void ucitajStavke() {
        DefaultListModel<OtkupStavka> m = new DefaultListModel<>();
        m.addAll(obradaZaglavlje.getEntitet().getOtkupi());
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

        btnPromijeniStavku.setText("Promijeni");

        lstZaglavlja.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstZaglavlja.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstZaglavljaValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstZaglavlja);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(398, 398, 398)
                .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnPromijeniZaglavlje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDodajZaglavlje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDodajStavku, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPromijeniStavku, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnObrisiStavku, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodajZaglavlje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPromijeniZaglavlje)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPromijeniStavku)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrisiStavku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        DefaultListModel<OtkupZaglavlje> m = new DefaultListModel<>();
        m.addAll(obradaZaglavlje.read(txtTrazi.getText()));
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
        ucitajStavke();
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
        new FrameOtkupZaglavlje(null).setVisible(true);
        
//        ucitajZaglavlja();
        lstZaglavlja.setSelectedIndex(lstZaglavlja.getModel().getSize());        
    }//GEN-LAST:event_btnDodajZaglavljeActionPerformed

    private void btnPromijeniZaglavljeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromijeniZaglavljeActionPerformed
        new FrameOtkupZaglavlje(obradaZaglavlje.getEntitet()).setVisible(true);
        
        OtkupZaglavlje promjenjeniEntitet = obradaZaglavlje.getEntitet();           
        lstZaglavlja.setSelectedValue(promjenjeniEntitet, true);
    }//GEN-LAST:event_btnPromijeniZaglavljeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnDodajZaglavlje;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnPromijeniStavku;
    private javax.swing.JButton btnPromijeniZaglavlje;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<OtkupStavka> lstStavke;
    private javax.swing.JList<OtkupZaglavlje> lstZaglavlja;
    private javax.swing.JTextField txtTrazi;
    // End of variables declaration//GEN-END:variables
    
}
