package cz.czechitas.trideniTelefonuJFD;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import net.miginfocom.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labTelefonniSeznam;
    JLabel labVstupniSeznam;
    JScrollPane scrollPaneVstupní;
    JTextArea textAreaVstupniSeznam;
    JButton btnNacist;
    JLabel labVyslednySeznam;
    JScrollPane scrollPaneVystupniSeznam;
    JList lstVystupJmena;
    JScrollPane scrollPane1;
    JList lstVystupCisla;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;
    TelefonniSeznamService mujServis;
    DefaultListModel<Osoba> lstVystupModel;
    DefaultListModel lstTelefonyModel;
    Map<Osoba, Set<TelefonniCislo>> kontakty;

    public HlavniOkno() {
        initComponents();
        mujServis = new TelefonniSeznamService();
        lstVystupModel = new DefaultListModel<>();
    }

    private void btnNacistPriStiskuMysi(MouseEvent e) {

        String celyVstup = textAreaVstupniSeznam.getText();
        kontakty = mujServis.vycistiTelefonniCisla(celyVstup);

        for (Osoba jedenZaznam : kontakty.keySet()) {

            lstVystupModel.addElement(jedenZaznam);
        }

       lstVystupJmena.setModel(lstVystupModel);

    }

    private void priVyberuPolozky(ListSelectionEvent e) {
        int idx = lstVystupJmena.getLeadSelectionIndex();
        if (idx != -1) {
            lstTelefonyModel = new DefaultListModel();
            //Object zvoleneJmeno = lstVystupModel.getElementAt(idx);
            Osoba osoba = lstVystupModel.getElementAt(idx);
            Set<TelefonniCislo> telefony = kontakty.get(osoba);
            for (TelefonniCislo telefonniCislo : telefony) {
                lstTelefonyModel.addElement(telefonniCislo.getTelefonniCislo());
            }

            lstVystupCisla.setModel(lstTelefonyModel);
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labTelefonniSeznam = new JLabel();
        labVstupniSeznam = new JLabel();
        scrollPaneVstupní = new JScrollPane();
        textAreaVstupniSeznam = new JTextArea();
        btnNacist = new JButton();
        labVyslednySeznam = new JLabel();
        scrollPaneVystupniSeznam = new JScrollPane();
        lstVystupJmena = new JList();
        scrollPane1 = new JScrollPane();
        lstVystupCisla = new JList();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("trideniTelefonuJFD");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets rel,hidemode 3",
            // columns
            "[286,fill]" +
            "[fill]" +
            "[grow,fill]",
            // rows
            "[fill]" +
            "[32]" +
            "[95,grow]" +
            "[]" +
            "[]" +
            "[0]" +
            "[102,grow]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //---- labTelefonniSeznam ----
        labTelefonniSeznam.setText("Telefonn\u00ed seznam");
        labTelefonniSeznam.setFont(labTelefonniSeznam.getFont().deriveFont(labTelefonniSeznam.getFont().getSize() + 5f));
        contentPane.add(labTelefonniSeznam, "cell 0 0");

        //---- labVstupniSeznam ----
        labVstupniSeznam.setText("Vlo\u017ete vstupn\u00ed seznam:");
        contentPane.add(labVstupniSeznam, "cell 0 1");

        //======== scrollPaneVstupní ========
        {
            scrollPaneVstupní.setViewportView(textAreaVstupniSeznam);
        }
        contentPane.add(scrollPaneVstupní, "cell 0 2 3 1,growy");

        //---- btnNacist ----
        btnNacist.setText("Na\u010d\u00edst");
        btnNacist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnNacistPriStiskuMysi(e);
            }
        });
        contentPane.add(btnNacist, "cell 0 3 3 1,alignx center,growx 0");

        //---- labVyslednySeznam ----
        labVyslednySeznam.setText("V\u00fdsledn\u00fd seznam:");
        contentPane.add(labVyslednySeznam, "cell 0 5");

        //======== scrollPaneVystupniSeznam ========
        {

            //---- lstVystupJmena ----
            lstVystupJmena.addListSelectionListener(e -> priVyberuPolozky(e));
            scrollPaneVystupniSeznam.setViewportView(lstVystupJmena);
        }
        contentPane.add(scrollPaneVystupniSeznam, "cell 0 6,grow");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(lstVystupCisla);
        }
        contentPane.add(scrollPane1, "cell 2 6,grow");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
