
package antikvarijat.view;

import antikvarijat.util.Tools;
import javax.swing.JOptionPane;

public class FrameIzbornik extends javax.swing.JFrame {

    public FrameIzbornik() {
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
        jMenu2 = new javax.swing.JMenu();
        menuItemOperateri = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuItemPromjenaLozinke = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuItemDrzave = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuItemGradovi = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuItemAutori = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuItemIzdavaci = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        menuItemPartneri = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        menuItemKnjige = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        menuItemNacinPlacanja = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuItemOtkup = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        menuItemProdaja = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        menuItemRezervacija = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuItemStanje = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 480));

        jToolBar1.setRollover(true);
        jToolBar1.add(lblOperater);

        jMenu2.setText("Servis");

        menuItemOperateri.setText("Operateri");
        menuItemOperateri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOperateriActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemOperateri);
        jMenu2.add(jSeparator1);

        menuItemPromjenaLozinke.setText("Promijeni lozinku");
        menuItemPromjenaLozinke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPromjenaLozinkeActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemPromjenaLozinke);
        jMenu2.add(jSeparator2);

        jMenuItem2.setText("Kraj rada");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Podaci");

        menuItemDrzave.setText("Države");
        menuItemDrzave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDrzaveActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemDrzave);
        jMenu1.add(jSeparator3);

        menuItemGradovi.setText("Gradovi");
        menuItemGradovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGradoviActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemGradovi);
        jMenu1.add(jSeparator4);

        menuItemAutori.setText("Autori");
        menuItemAutori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAutoriActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemAutori);
        jMenu1.add(jSeparator5);

        menuItemIzdavaci.setText("Izdavači");
        menuItemIzdavaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIzdavaciActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemIzdavaci);
        jMenu1.add(jSeparator6);

        menuItemPartneri.setText("Partneri");
        menuItemPartneri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPartneriActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemPartneri);
        jMenu1.add(jSeparator7);

        menuItemKnjige.setText("Knjige");
        menuItemKnjige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemKnjigeActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemKnjige);
        jMenu1.add(jSeparator8);

        menuItemNacinPlacanja.setText("Načini Plaćanja");
        menuItemNacinPlacanja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNacinPlacanjaActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemNacinPlacanja);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Dokumenti");

        menuItemOtkup.setText("Otkup Knjiga");
        menuItemOtkup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOtkupActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemOtkup);
        jMenu3.add(jSeparator9);

        menuItemProdaja.setText("Prodaja Knjiga");
        menuItemProdaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProdajaActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemProdaja);
        jMenu3.add(jSeparator10);

        menuItemRezervacija.setText("Rezervacije");
        menuItemRezervacija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRezervacijaActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemRezervacija);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Pregledi");

        menuItemStanje.setText("Stanje");
        menuItemStanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemStanjeActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemStanje);
        jMenu4.add(jSeparator11);

        jMenuItem1.setText("Kartice");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(366, Short.MAX_VALUE)
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

    private void menuItemOperateriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOperateriActionPerformed
        if (!Tools.OPERATER.getUloga().equals("administrator")) {
            JOptionPane.showMessageDialog(getRootPane(), "Pristup operaterima ograničen na administratora");            
            return;
        }         
        new FrameOperater().setVisible(true);
    }//GEN-LAST:event_menuItemOperateriActionPerformed

    private void menuItemPromjenaLozinkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPromjenaLozinkeActionPerformed
        new FramePromjenaLozinke().setVisible(true);
    }//GEN-LAST:event_menuItemPromjenaLozinkeActionPerformed

    private void menuItemOtkupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOtkupActionPerformed
        new FrameOtkup().setVisible(true);
    }//GEN-LAST:event_menuItemOtkupActionPerformed

    private void menuItemNacinPlacanjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNacinPlacanjaActionPerformed
        new FrameNacinPlacanja().setVisible(true);
    }//GEN-LAST:event_menuItemNacinPlacanjaActionPerformed

    private void menuItemProdajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProdajaActionPerformed
        new FrameProdaja().setVisible(true);
    }//GEN-LAST:event_menuItemProdajaActionPerformed

    private void menuItemRezervacijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRezervacijaActionPerformed
        new FrameRezervacija().setVisible(true);
    }//GEN-LAST:event_menuItemRezervacijaActionPerformed

    private void menuItemStanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemStanjeActionPerformed
        new FrameStanje().setVisible(true);
    }//GEN-LAST:event_menuItemStanjeActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new FrameKartica().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblOperater;
    private javax.swing.JMenuItem menuItemAutori;
    private javax.swing.JMenuItem menuItemDrzave;
    private javax.swing.JMenuItem menuItemGradovi;
    private javax.swing.JMenuItem menuItemIzdavaci;
    private javax.swing.JMenuItem menuItemKnjige;
    private javax.swing.JMenuItem menuItemNacinPlacanja;
    private javax.swing.JMenuItem menuItemOperateri;
    private javax.swing.JMenuItem menuItemOtkup;
    private javax.swing.JMenuItem menuItemPartneri;
    private javax.swing.JMenuItem menuItemProdaja;
    private javax.swing.JMenuItem menuItemPromjenaLozinke;
    private javax.swing.JMenuItem menuItemRezervacija;
    private javax.swing.JMenuItem menuItemStanje;
    // End of variables declaration//GEN-END:variables
}
