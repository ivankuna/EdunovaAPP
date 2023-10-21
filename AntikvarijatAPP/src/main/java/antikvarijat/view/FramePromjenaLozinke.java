package antikvarijat.view;

import antikvarijat.controller.ObradaOperater;
import antikvarijat.model.Operater;
import antikvarijat.util.SimpleException;
import antikvarijat.util.Tools;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import javax.swing.JOptionPane;

public class FramePromjenaLozinke extends javax.swing.JFrame {

    private ObradaOperater obrada;

    private StringBuilder sb = new StringBuilder();

    private Argon2 argon2 = Argon2Factory.create();

    private String staraLozinka = "";

    private String novaLozinka = "";

    private String lozinkaPotvrda = "";

    public FramePromjenaLozinke() {
        initComponents();
        obrada = new ObradaOperater();
        setTitle("Promjena lozinke");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnPotvrda = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtStaraLozinka = new javax.swing.JPasswordField();
        txtNovaLozinka = new javax.swing.JPasswordField();
        txtLozinkaPotvrda = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Stara lozinka:");

        btnPotvrda.setText("Potvrdi");
        btnPotvrda.setMaximumSize(new java.awt.Dimension(81, 23));
        btnPotvrda.setMinimumSize(new java.awt.Dimension(81, 23));
        btnPotvrda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPotvrdaActionPerformed(evt);
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

        jLabel2.setText("Nova lozinka:");

        jLabel3.setText("Potvrdi lozinku:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPotvrda, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtStaraLozinka)
                    .addComponent(txtNovaLozinka)
                    .addComponent(txtLozinkaPotvrda))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStaraLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNovaLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLozinkaPotvrda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPotvrda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPotvrdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPotvrdaActionPerformed
        obrada.setEntitet(Tools.OPERATER);

        try {
            kontrolaPopunjavanja();
        } catch (SimpleException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
            return;
        }

        try {
            kontrolaStareLozinke(obrada.getEntitet(), staraLozinka);
        } catch (SimpleException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
            return;
        }

        try {
            kontrolaPotvrdeLozinke();
        } catch (SimpleException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
            return;
        }
        isprazniView();
        JOptionPane.showMessageDialog(getRootPane(), "Uspješna promjena lozinke");
        dispose();
    }//GEN-LAST:event_btnPotvrdaActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void kontrolaPopunjavanja() throws SimpleException {
        for (char c : txtStaraLozinka.getPassword()) {
            sb.append(c);
        }

        staraLozinka = sb.toString().trim();
        sb.setLength(0);

        for (char c : txtNovaLozinka.getPassword()) {
            sb.append(c);
        }

        novaLozinka = sb.toString().trim();
        sb.setLength(0);

        for (char c : txtLozinkaPotvrda.getPassword()) {
            sb.append(c);
        }

        lozinkaPotvrda = sb.toString().trim();
        sb.setLength(0);

        if (staraLozinka.equals("") || novaLozinka.equals("") || lozinkaPotvrda.equals("")) {
            throw new SimpleException("Popunite sva polja");
        }
    }

    public void kontrolaStareLozinke(Operater o, String lozinka) throws SimpleException {
        if (!argon2.verify(o.getLozinka(), lozinka.toCharArray())) {
            throw new SimpleException("Neispravan unos stare lozinke");
        }
    }

    private void kontrolaPotvrdeLozinke() throws SimpleException {
        if (novaLozinka.equals(lozinkaPotvrda)) {
            obrada.getEntitet().setLozinka(argon2.hash(10, 65536, 1, txtNovaLozinka.getPassword()));
            obrada.update();
        } else {
            throw new SimpleException("Lozinke se ne podudaraju");
        }
    }

    private void isprazniView() {
        txtStaraLozinka.setText("");
        txtNovaLozinka.setText("");
        txtLozinkaPotvrda.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnPotvrda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtLozinkaPotvrda;
    private javax.swing.JPasswordField txtNovaLozinka;
    private javax.swing.JPasswordField txtStaraLozinka;
    // End of variables declaration//GEN-END:variables

}
