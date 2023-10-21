package antikvarijat.view;

import antikvarijat.controller.ObradaOperater;
import antikvarijat.util.Tools;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import org.apache.commons.validator.routines.EmailValidator;

public class FrameAutorizacija extends javax.swing.JFrame {

    private ObradaOperater obrada;

    public FrameAutorizacija() {
        initComponents();
        obrada = new ObradaOperater();
        setTitle(Tools.NAZIV_APP);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAutoriziraj = new javax.swing.JButton();
        lblEmailPoruka = new javax.swing.JLabel();
        txtLozinka = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Email:");

        txtEmail.setText("ikuna@edunova.com");
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        jLabel2.setText("Lozinka:");

        btnAutoriziraj.setText("Login");
        btnAutoriziraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorizirajActionPerformed(evt);
            }
        });

        txtLozinka.setText("123");
        txtLozinka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLozinkaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail)
                    .addComponent(lblEmailPoruka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnAutoriziraj, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmailPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnAutoriziraj, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAutorizirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorizirajActionPerformed
        reset();

        var email = txtEmail.getText().trim();

        if (email.isEmpty()) {
            lblEmailPoruka.setText("Email je obavezan");
            postaviGresku(txtEmail);
            return;
        }

        if (!EmailValidator.getInstance().isValid(email)) {
            lblEmailPoruka.setText("Upisani tekst nije email");
            postaviGresku(txtEmail);
            return;
        }

        if (txtLozinka.getPassword().length == 0) {
            postaviGresku(txtLozinka);
            return;
        }
        
        Tools.OPERATER = obrada.autoriziraj(email, new String(txtLozinka.getPassword()));

        if (Tools.OPERATER == null) {
            JOptionPane.showMessageDialog(getRootPane(),
                    "Neispravna kombinacija email i lozinka");
            return;
        }

        new FrameIzbornik().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAutorizirajActionPerformed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        if(txtEmail.getText().length()>0){
            txtEmail.setBackground(Color.WHITE);
        }        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnAutorizirajActionPerformed(null);
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtLozinkaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLozinkaKeyPressed
        if(txtLozinka.getPassword().length>0){
            txtLozinka.setBackground(Color.WHITE);
        }        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnAutorizirajActionPerformed(null);
        }
    }//GEN-LAST:event_txtLozinkaKeyPressed

    private void postaviGresku(JComponent c) {
        c.setBackground(Color.RED);
        c.requestFocus();
    }

    private void reset() {
        lblEmailPoruka.setText("");
        txtEmail.setBackground(Color.WHITE);
        txtLozinka.setBackground(Color.WHITE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutoriziraj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblEmailPoruka;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtLozinka;
    // End of variables declaration//GEN-END:variables
}
