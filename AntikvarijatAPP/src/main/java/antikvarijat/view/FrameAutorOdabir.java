package antikvarijat.view;

import antikvarijat.controller.ObradaAutor;
import antikvarijat.model.Autor;
import antikvarijat.util.Tools;
import javax.swing.DefaultListModel;

public class FrameAutorOdabir extends javax.swing.JFrame {
   
    private FrameKnjiga frameKnjiga;
    
    private ObradaAutor obrada;
    
    public FrameAutorOdabir(FrameKnjiga frameKnjiga) {
        initComponents();
        setTitle(Tools.NAZIV_APP + " | Unos autora");   
        obrada = new ObradaAutor();
        this.frameKnjiga = frameKnjiga;
        ucitaj();
    }
    
    public void ucitaj() {
        DefaultListModel<Autor> m = new DefaultListModel<>();
        m.addAll(obrada.read());
        lstAutori.setModel(m);
        lstAutori.repaint();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstAutori = new javax.swing.JList<>();
        txtTrazi = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        btnOdaberi = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstAutori.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstAutori.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAutoriValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstAutori);

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
        if (lstAutori.getSelectedValue() == null) {
            return;
        }
        
        frameKnjiga.setIdAutor(lstAutori.getSelectedValue().getId());
        frameKnjiga.popuniTxtAutor(lstAutori.getSelectedValue().getNazivAutora());
        dispose();
    }//GEN-LAST:event_btnOdaberiActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        DefaultListModel<Autor> m = new DefaultListModel<>();
        m.addAll(obrada.read(txtTrazi.getText()));
        lstAutori.setModel(m);
        lstAutori.repaint();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void lstAutoriValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAutoriValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstAutori.getSelectedValue() == null) {
            return;
        }
        obrada.setEntitet(lstAutori.getSelectedValue());  
    }//GEN-LAST:event_lstAutoriValueChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdaberi;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Autor> lstAutori;
    private javax.swing.JTextField txtTrazi;
    // End of variables declaration//GEN-END:variables
    
}
