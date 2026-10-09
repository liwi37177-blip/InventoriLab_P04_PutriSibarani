package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Barang;



public class FormBarang extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private final List<Barang> daftarBarang = new ArrayList<Barang>();
    private DefaultTableModel modelTabel;
    
    public FormBarang() {
        initComponents();
        siapkanTabel();
        isiDataContoh();
        setLocationRelativeTo(null);
  
        
    }
private void siapkanTabel() {
    modelTabel = new DefaultTableModel(
            new Object[]{"Kode", "Nama Barang", "Tersedia"}, 0) {
        private static final long serialVersionUID = 1L;

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    tblBarang.setModel(modelTabel);
    tblBarang.setRowHeight(26);
    tblBarang.getTableHeader().setReorderingAllowed(false);
}

private void isiDataContoh() {
    daftarBarang.add(new Barang("BRG-001", "Keyboard USB", 10));
    daftarBarang.add(new Barang("BRG-002", "Mouse USB", 8));
    perbaruiTabel();
    lblStatus.setText("Siap. Dua data contoh dimuat di memori.");
}

private void perbaruiTabel() {
    modelTabel.setRowCount(0);
    for (Barang barang : daftarBarang) {
        modelTabel.addRow(new Object[]{
            barang.getKode(),
            barang.getNama(),
            barang.getJumlahTersedia()
        });
    }
}

private void bersihkanInput() {
    txtKode.setText("");
    txtNama.setText("");
    txtJumlah.setText("");
    txtKode.requestFocusInWindow();
}

private void tambahDemo() {
    String kode = txtKode.getText().trim();
    String nama = txtNama.getText().trim();
    String teksJumlah = txtJumlah.getText().trim();

    try {
        if (kode.isEmpty() || nama.isEmpty() || teksJumlah.isEmpty()) {
            throw new IllegalArgumentException(
                    "Kode, nama, dan jumlah wajib diisi.");
        }

        int jumlah = Integer.parseInt(teksJumlah);
        Barang barang = new Barang(kode, nama, jumlah);
        daftarBarang.add(barang);
        perbaruiTabel();
        bersihkanInput();
        lblStatus.setText("Barang " + barang.getNama()
                + " ditambahkan ke daftar sementara.");
    } catch (NumberFormatException e) {
        lblStatus.setText("Jumlah belum valid. Data tidak ditambahkan.");
        JOptionPane.showMessageDialog(this,
                "Jumlah harus bilangan bulat antara 0 dan 2147483647.",
                "Input jumlah", JOptionPane.WARNING_MESSAGE);
        txtJumlah.requestFocusInWindow();
        txtJumlah.selectAll();
    } catch (IllegalArgumentException e) {
        lblStatus.setText("Data tidak ditambahkan: " + e.getMessage());
        JOptionPane.showMessageDialog(this, e.getMessage(),
                "Periksa data barang", JOptionPane.WARNING_MESSAGE);
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        pnlInput = new javax.swing.JPanel();
        lblKode = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        lblNama = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnBersihkan = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventori Laboratorium - Data Barang");

        lblJudul.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lblJudul.setText("Inventori Laboratorium");

        lblInfo.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        lblInfo.setText("Latihan antarmuka - data tersimpan sementara");

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblBarang);

        pnlInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Barang"));
        pnlInput.setToolTipText("");
        pnlInput.setPreferredSize(new java.awt.Dimension(720, 210));

        lblKode.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        lblKode.setText("Kode barang ");

        lblNama.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        lblNama.setText("Nama Barang");

        lblJumlah.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        lblJumlah.setText("Jumlah Tersedia");

        btnTambah.setText("Tambah Demo");
        btnTambah.setToolTipText("Tambahkan barang ke daftar sementara");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnBersihkan.setText("Bersihkan Input");
        btnBersihkan.setToolTipText("Kosongkan input tanpa menghapus daftar");
        btnBersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihkanActionPerformed(evt);
            }
        });

        btnTutup.setText("Tutup");
        btnTutup.setToolTipText("Tutup jendela aplikasi");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInputLayout = new javax.swing.GroupLayout(pnlInput);
        pnlInput.setLayout(pnlInputLayout);
        pnlInputLayout.setHorizontalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKode)
                    .addComponent(lblNama)
                    .addComponent(lblJumlah))
                .addGap(32, 32, 32)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInputLayout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBersihkan)
                        .addGap(18, 18, 18)
                        .addComponent(btnTutup))
                    .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtKode, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                        .addComponent(txtNama)
                        .addComponent(txtJumlah)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        pnlInputLayout.setVerticalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKode)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNama))
                .addGap(18, 18, 18)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJumlah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnBersihkan)
                    .addComponent(btnTutup))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblStatus.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblStatus.setText("Siap. Isi data barang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJudul)
                            .addComponent(lblInfo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatus)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnlInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfo)
                .addGap(18, 18, 18)
                .addComponent(pnlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblStatus)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
      tambahDemo();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihkanActionPerformed
     bersihkanInput();
lblStatus.setText("Input dibersihkan. Daftar barang tetap.");
    }//GEN-LAST:event_btnBersihkanActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
      dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblKode;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
