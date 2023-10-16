
package antikvarijat.view;

import antikvarijat.util.Tools;

public class Izbornik extends javax.swing.JFrame {

    public Izbornik() {
        initComponents();
        setTitle(Tools.NAZIV_APP + " | Glavni izbornik");
        lblOperater.setText(Tools.getOperater());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        lblOperater = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemDrzave = new javax.swing.JMenuItem();
        menuItemGradovi = new javax.swing.JMenuItem();
        menuItemAutori = new javax.swing.JMenuItem();
        menuItemIzdavaci = new javax.swing.JMenuItem();
        menuItemPartneri = new javax.swing.JMenuItem();
        menuItemKnjige = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);
        jToolBar1.add(lblOperater);

        jMenu1.setText("Podaci");

        menuItemDrzave.setText("Države");
        menuItemDrzave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDrzaveActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemDrzave);

        menuItemGradovi.setText("Gradovi");
        menuItemGradovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGradoviActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemGradovi);

        menuItemAutori.setText("Autori");
        menuItemAutori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAutoriActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemAutori);

        menuItemIzdavaci.setText("Izdavači");
        menuItemIzdavaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIzdavaciActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemIzdavaci);

        menuItemPartneri.setText("Partneri");
        menuItemPartneri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPartneriActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemPartneri);

        menuItemKnjige.setText("Knjige");
        menuItemKnjige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemKnjigeActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemKnjige);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Servis");

        jMenuItem2.setText("Izlaz");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 252, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuItemDrzaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDrzaveActionPerformed
        new FrameDrzava().setVisible(true);
    }//GEN-LAST:event_menuItemDrzaveActionPerformed

    private void menuItemGradoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGradoviActionPerformed
        new FrameGrad().setVisible(true);
    }//GEN-LAST:event_menuItemGradoviActionPerformed

    private void menuItemAutoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAutoriActionPerformed
        new FrameAutor().setVisible(true);
    }//GEN-LAST:event_menuItemAutoriActionPerformed

    private void menuItemIzdavaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemIzdavaciActionPerformed
        new FrameIzdavac().setVisible(true);
    }//GEN-LAST:event_menuItemIzdavaciActionPerformed

    private void menuItemPartneriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPartneriActionPerformed
        new FramePartner().setVisible(true);
    }//GEN-LAST:event_menuItemPartneriActionPerformed

    private void menuItemKnjigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemKnjigeActionPerformed
        new FrameKnjiga().setVisible(true);
    }//GEN-LAST:event_menuItemKnjigeActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblOperater;
    private javax.swing.JMenuItem menuItemAutori;
    private javax.swing.JMenuItem menuItemDrzave;
    private javax.swing.JMenuItem menuItemGradovi;
    private javax.swing.JMenuItem menuItemIzdavaci;
    private javax.swing.JMenuItem menuItemKnjige;
    private javax.swing.JMenuItem menuItemPartneri;
    // End of variables declaration//GEN-END:variables
}
