package antikvarijat.view;

import antikvarijat.controller.ObradaGrad;
import antikvarijat.model.Grad;
import antikvarijat.util.Tools;
import javax.swing.DefaultListModel;

public class FrameGradOdabir<T> extends javax.swing.JFrame {
    
    private FrameIzdavac frameIzdavac;
    
    private FramePartner framePartner;
    
    private ObradaGrad obrada;
    
    public FrameGradOdabir(T genericObject, FrameIzdavac frameIzdavac, FramePartner framePartner) {
        initComponents();
        setTitle(Tools.NAZIV_APP + " | Unos grada");  
        obrada = new ObradaGrad();
        if (genericObject instanceof FrameIzdavac frameIzdavac1) {
            this.frameIzdavac = frameIzdavac1;
        } else {
            this.framePartner = (FramePartner) genericObject;
        }
        ucitaj();
    }
    
    public void ucitaj() {
        DefaultListModel<Grad> m = new DefaultListModel<>();
        m.addAll(obrada.read());
        lstGradovi.setModel(m);
        lstGradovi.repaint();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstGradovi = new javax.swing.JList<>();
        txtTrazi = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        btnOdaberi = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstGradovi.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstGradovi.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstGradoviValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstGradovi);

        btnTrazi.setText("Traži");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        btnOdaberi.setText("Odaberi");
        btnOdaberi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdaberiActionPerformed(evt);
            }
        });

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTrazi, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTrazi))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOdustani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOdaberi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOdaberi)
                        .addGap(18, 18, 18)
                        .addComponent(btnOdustani))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTrazi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdaberiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdaberiActionPerformed
        if (lstGradovi.getSelectedValue() == null) {
            return;
        }
        
        if (frameIzdavac != null) {
            frameIzdavac.setIdGrad(lstGradovi.getSelectedValue().getId());
            frameIzdavac.popuniTxtGrad(lstGradovi.getSelectedValue().getNazivGrada());
            dispose();
        } else {
            framePartner.setIdGrad(lstGradovi.getSelectedValue().getId());
            framePartner.popuniTxtGrad(lstGradovi.getSelectedValue().getNazivGrada());            
            dispose();
        }
    }//GEN-LAST:event_btnOdaberiActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        DefaultListModel<Grad> m = new DefaultListModel<>();
        m.addAll(obrada.read(txtTrazi.getText()));
        lstGradovi.setModel(m);
        lstGradovi.repaint();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void lstGradoviValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstGradoviValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstGradovi.getSelectedValue() == null) {
            return;
        }
        obrada.setEntitet(lstGradovi.getSelectedValue());  
    }//GEN-LAST:event_lstGradoviValueChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdaberi;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Grad> lstGradovi;
    private javax.swing.JTextField txtTrazi;
    // End of variables declaration//GEN-END:variables
    
}
