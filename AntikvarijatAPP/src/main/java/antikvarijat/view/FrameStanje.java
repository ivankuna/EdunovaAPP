package antikvarijat.view;

import antikvarijat.controller.ObradaKnjiga;
import antikvarijat.model.Knjiga;
import antikvarijat.model.OtkupStavka;
import antikvarijat.model.ProdajaStavka;
import antikvarijat.model.Rezervacija;
import antikvarijat.util.Tools;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class FrameStanje extends javax.swing.JFrame {

    private ObradaKnjiga obradaKnjiga;

    public FrameStanje() {
        initComponents();
        obradaKnjiga = new ObradaKnjiga();
        setTitle(Tools.NAZIV_APP + " | Stanje");
        ucitajStanje();
    }

    private void ucitajStanje() {
        DefaultTableModel model = (DefaultTableModel) tblStanje.getModel();

        List<Knjiga> knjigaList = obradaKnjiga.read();

        for (Knjiga k : knjigaList) {
            int ulaz = 0;
            int izlaz = 0;
            int rezervacija = 0;
            int naStanju;
            int raspolozivo;

            for (OtkupStavka os : k.getOtkupi()) {
                if (k.equals(os.getKnjiga())) {
                    ulaz += os.getKolicina();
                }
            }
            for (ProdajaStavka ps : k.getProdaje()) {
                if (k.equals(ps.getKnjiga())) {
                    izlaz += ps.getKolicina();
                }
            }
            for (Rezervacija r : k.getRezervacije()) {
                if (k.equals(r.getKnjiga()) && r.getStanje().equals("Aktivno")) {
                    rezervacija += 1;
                }
            }
            naStanju = ulaz - izlaz;
            raspolozivo = naStanju - rezervacija;
            model.addRow(new Object[]{k.getId(), k.getAutor().getNazivAutora(), k.getNazivKnjige(), ulaz, izlaz, rezervacija, naStanju, raspolozivo});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStanje = new javax.swing.JTable();
        btnIzlaz = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblStanje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Autor", "Knjiga", "Ulaz", "Izlaz", "Rezervacija", "Na stanju", "Raspoloživo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStanje);

        btnIzlaz.setText("Izlaz");
        btnIzlaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzlazActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnIzlaz)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIzlaz)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzlazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzlazActionPerformed
        dispose();
    }//GEN-LAST:event_btnIzlazActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzlaz;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStanje;
    // End of variables declaration//GEN-END:variables
}
