package antikvarijat.view;

import antikvarijat.util.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class SplashScreen extends javax.swing.JFrame {

    public SplashScreen() {
        initComponents();
        ucitaj();
    }

    private void ucitaj() {
        new Ucitanje().start();
    }

    private class Ucitanje extends Thread {

        @Override
        public void run() {
            Session s = HibernateUtil.getSession();
            if (s.getMetamodel().getEntities().isEmpty()) {
                JOptionPane.showMessageDialog(getRootPane(),
                        "Problem u radu s bazom");
                return;
            }
            new FrameAutorizacija().setVisible(true);
            dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setType(java.awt.Window.Type.POPUP);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/antikvarijat.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
