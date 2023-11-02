package antikvarijat.view;

import antikvarijat.controller.ObradaNacinPlacanja;
import antikvarijat.controller.ObradaProdajaZaglavlje;
import antikvarijat.controller.ObradaPartner;
import antikvarijat.model.NacinPlacanja;
import antikvarijat.model.ProdajaZaglavlje;
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

public class FrameProdajaZaglavlje extends javax.swing.JFrame implements ViewInterface {

    private ObradaProdajaZaglavlje obrada;

    private FrameProdaja frameProdaja;

    private NacinPlacanja nacinPlacanja;
    
    private Partner partner;

    public FrameProdajaZaglavlje(ProdajaZaglavlje prodajaZaglavlje, FrameProdaja frameProdaja) {
        initComponents();
        obrada = new ObradaProdajaZaglavlje();
        obrada.setEntitet(prodajaZaglavlje);
        this.frameProdaja = frameProdaja;
        setTitle(Tools.NAZIV_APP + " | Prodaja");
        ucitajNacinePlacanja();
        ucitajPartnere();
        definirajDatumProdaje();
        if (prodajaZaglavlje != null) {
            popuniView();
        }        
    }

    @Override
    public void ucitaj() {
        // Metoda ucitaj() je u ovom slučaju suvišna       
    }
    
    private void ucitajNacinePlacanja() {
        DefaultComboBoxModel<NacinPlacanja> m = new DefaultComboBoxModel<>();

        nacinPlacanja = new NacinPlacanja();
        nacinPlacanja.setId(0);
        nacinPlacanja.setNazivNacinaPlacanja("Odaberite način plaćanja");
        m.addElement(nacinPlacanja);

        m.addAll(new ObradaNacinPlacanja().read());

        cmbNacinPlacanja.setModel(m);
        cmbNacinPlacanja.repaint();
    }

    private void ucitajPartnere() {
        DefaultComboBoxModel<Partner> m = new DefaultComboBoxModel<>();

        partner = new Partner();
        partner.setId(0);
        partner.setNazivPartnera("Odaberite partnera");
        m.addElement(partner);                

        m.addAll(new ObradaPartner().read());

        cmbPartner.setModel(m);
        cmbPartner.repaint();
    }        

    private void definirajDatumProdaje() {
        DatePickerSettings dps = new DatePickerSettings(Locale.of("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd. MM. YYYY.");
        dps.setTranslationClear("Očisti");
        dps.setTranslationToday("Danas");
        dtpDatumProdaje.datePicker.setSettings(dps);

        TimePickerSettings tps = dtpDatumProdaje.timePicker.getSettings();

        tps.setFormatForDisplayTime("HH:mm");
        tps.use24HourClockFormat();

        ArrayList<LocalTime> lista = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j = j + 10) {
                lista.add(LocalTime.of(i, j));
            }
        }

        tps.generatePotentialMenuTimes(lista);
                
        dtpDatumProdaje.datePicker.setDate(LocalDate.now());
        dtpDatumProdaje.timePicker.setTime(LocalTime.now());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnPrihvati = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();
        cmbPartner = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dtpDatumProdaje = new com.github.lgooddatepicker.components.DateTimePicker();
        lblId = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbNacinPlacanja = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Broj prodaje:");

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

        jLabel2.setText("Datum prodaje:");

        jLabel4.setText("Način plaćanja:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cmbNacinPlacanja, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpDatumProdaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbPartner, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrihvati, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dtpDatumProdaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addComponent(cmbNacinPlacanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(cmbPartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
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
        boolean mozeDalje = true;

        if (obrada.getEntitet() == null) {
            obrada.setEntitet(new ProdajaZaglavlje());
            jeLiCreate = true;
        }

        popuniModel();
        try {
            if (jeLiCreate) {
                obrada.create();
                frameProdaja.ucitajZaglavlja();
                frameProdaja.setSelectedValueLstZaglavlja(obrada.getEntitet());
            } else {
                obrada.update();
                frameProdaja.ucitajZaglavlja();
                frameProdaja.setSelectedValueLstZaglavlja(obrada.getEntitet());
            }
        } catch (SimpleException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
            mozeDalje = false;
        }
        if (mozeDalje) {
            dispose();
        }
    }//GEN-LAST:event_btnPrihvatiActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    @Override
    public void popuniView() {
        var e = obrada.getEntitet();

        lblId.setText(String.valueOf(e.getId()));

        if (e.getDatumProdaje()== null) {
            dtpDatumProdaje.datePicker.setDate(null);
            dtpDatumProdaje.timePicker.setTime(null);
        } else {
            LocalDate ld = e.getDatumProdaje().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            dtpDatumProdaje.datePicker.setDate(ld);

            LocalTime lt = e.getDatumProdaje().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalTime();
            dtpDatumProdaje.timePicker.setTime(lt);
        }
        
        cmbNacinPlacanja.setSelectedItem(e.getNacinPlacanja());
        cmbPartner.setSelectedItem(e.getPartner());
    }

    @Override
    public void isprazniView() {
        // Metoda isprazniView() je u ovom slučaju suvišna  
    }

    @Override
    public void popuniModel() {
        var e = obrada.getEntitet();

        if (dtpDatumProdaje.datePicker.getText().equals("") || dtpDatumProdaje.timePicker.getText().equals("")) {
            e.setDatumProdaje(null);
        } else {
            LocalDate ld = dtpDatumProdaje.datePicker.getDate();
            LocalTime lt = dtpDatumProdaje.timePicker.getTime();

            LocalDateTime ldt = LocalDateTime.of(ld, lt);
            e.setDatumProdaje(Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()));
        }

        e.setOperater(Tools.OPERATER);
        e.setNacinPlacanja((NacinPlacanja) cmbNacinPlacanja.getSelectedItem());
        e.setPartner((Partner) cmbPartner.getSelectedItem());        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnPrihvati;
    private javax.swing.JComboBox<NacinPlacanja> cmbNacinPlacanja;
    private javax.swing.JComboBox<Partner> cmbPartner;
    private com.github.lgooddatepicker.components.DateTimePicker dtpDatumProdaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblId;
    // End of variables declaration//GEN-END:variables

}
