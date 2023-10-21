package antikvarijat.view;

import antikvarijat.controller.ObradaOtkupZaglavlje;
import antikvarijat.controller.ObradaPartner;
import antikvarijat.model.OtkupZaglavlje;
import antikvarijat.model.Partner;
import antikvarijat.util.SimpleException;
import antikvarijat.util.Tools;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class FrameOtkupZaglavlje extends javax.swing.JFrame implements ViewInterface {

    private ObradaOtkupZaglavlje obrada;      
    
    private Partner partner;        

    public FrameOtkupZaglavlje(OtkupZaglavlje otkupZaglavlje) {
        initComponents();                
        obrada = new ObradaOtkupZaglavlje();
        obrada.setEntitet(otkupZaglavlje);
        setTitle(Tools.NAZIV_APP + " | OtkupZaglavljeovi");
        if (otkupZaglavlje != null) {
            popuniView();
        }
        ucitajDrzave();   
        definirajDatumOtkupa();
    }
       
    @Override
    public void ucitaj() {
        // Metoda ucitaj() je u ovom slučaju suvišna       
    }
    
    private void ucitajDrzave() {
        DefaultComboBoxModel<Partner> m = new DefaultComboBoxModel<>();
        
        partner = new Partner();
        partner.setId(0);
        partner.setNazivPartnera("Odaberite partnera");
        m.addElement(partner);
        
        m.addAll(new ObradaPartner().read());
        
        cmbPartner.setModel(m);
        cmbPartner.repaint();
    }
    
    private void definirajDatumOtkupa() {
         DatePickerSettings dps = new DatePickerSettings(Locale.of("hr","HR"));
         dps.setFormatForDatesCommonEra("dd. MM. YYYY.");
         dps.setTranslationClear("Očisti");
         dps.setTranslationToday("Danas");
         dtpDatumOtkupa.datePicker.setSettings(dps);
         
         TimePickerSettings tps = dtpDatumOtkupa.timePicker.getSettings();
    
         tps.setFormatForDisplayTime("HH:mm");
         tps.use24HourClockFormat();
         
         ArrayList<LocalTime> lista = new ArrayList<>();
         for(int i =0;i<24;i++){
             for(int j = 0;j<60;j=j+10){
                 lista.add(LocalTime.of(i,j));
             }
         }
         
         tps.generatePotentialMenuTimes(lista);                           
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBrojOtkupa = new javax.swing.JTextField();
        btnPrihvati = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();
        cmbPartner = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dtpDatumOtkupa = new com.github.lgooddatepicker.components.DateTimePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Broj otkupa:");

        txtBrojOtkupa.setEditable(false);

        btnPrihvati.setText("Prihvati");
        btnPrihvati.setMaximumSize(new java.awt.Dimension(81, 23));
        btnPrihvati.setMinimumSize(new java.awt.Dimension(81, 23));
        btnPrihvati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrihvatiActionPerformed(evt);
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

        jLabel3.setText("Partner:");

        jLabel2.setText("Datum otkupa:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtpDatumOtkupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(cmbPartner, 0, 168, Short.MAX_VALUE)
                        .addComponent(txtBrojOtkupa))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrihvati, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBrojOtkupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dtpDatumOtkupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(cmbPartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrihvati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrihvatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrihvatiActionPerformed
        boolean jeLiCreate = false;        
        
        if (obrada.getEntitet() == null) {
            obrada.setEntitet(new OtkupZaglavlje());
            jeLiCreate = true;
        }
        
        popuniModel();
        try {
            if (jeLiCreate) {
                obrada.create();                
            } else {
                obrada.update();
            }            
        } catch (SimpleException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
        dispose();
    }//GEN-LAST:event_btnPrihvatiActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    @Override
    public void popuniView() {
        var e = obrada.getEntitet();

        txtBrojOtkupa.setText(String.valueOf(e.getId()));
                
        if (e.getDatumOtkupa() == null){
            dtpDatumOtkupa.datePicker.setDate(null);
            dtpDatumOtkupa.timePicker.setTime(null);
        } else {
            LocalDate ld = e.getDatumOtkupa().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            dtpDatumOtkupa.datePicker.setDate(ld);
            
            LocalTime lt = e.getDatumOtkupa().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalTime();
            dtpDatumOtkupa.timePicker.setTime(lt);
        }
                
        cmbPartner.setSelectedItem(e.getPartner());
    }
    
    @Override
    public void isprazniView() {
        txtBrojOtkupa.setText("");
        dtpDatumOtkupa.getDatePicker().setText("");
        dtpDatumOtkupa.getTimePicker().setText("");
        cmbPartner.setSelectedItem(partner);
    }


    @Override
    public void popuniModel() {
        var e = obrada.getEntitet();
       
        LocalDate ld = dtpDatumOtkupa.datePicker.getDate();
        LocalTime lt = dtpDatumOtkupa.timePicker.getTime();
        
        LocalDateTime ldt = LocalDateTime.of(ld,lt);        
        e.setDatumOtkupa(Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()));
        
        e.setOperater(Tools.OPERATER);
        e.setPartner((Partner) cmbPartner.getSelectedItem());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnPrihvati;
    private javax.swing.JComboBox<Partner> cmbPartner;
    private com.github.lgooddatepicker.components.DateTimePicker dtpDatumOtkupa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtBrojOtkupa;
    // End of variables declaration//GEN-END:variables
   
}
