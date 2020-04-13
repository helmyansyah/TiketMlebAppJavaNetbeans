/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import mitanew.Home;
import pelanggan.pelanggan;
import popup.popuppelanggan1;
import popup.popuptiketmuseum;

/**
 *
 * @author ASUS
 */
public class transaksi_tiket_museum extends javax.swing.JFrame {
private Connection conn =new koneksi().koneksi();
private DefaultTableModel tabmode;
public String tgl1;
SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
public String tgl2;
SimpleDateFormat format2= new SimpleDateFormat("yyyy-MM-dd");
 public String kode_pelanggan,nama,jenis_kelamin,nama_instasi,hp,nama_tiket,khusus,harga,stok;
    /**
     * Creates new form transaksi_tiket_museum
     */
    public transaksi_tiket_museum() {
          initComponents();
          setLocationRelativeTo(null);
          btn_mines.setEnabled(false);
          jumlahtiket();
          autonumber();
          datatable();
          aktif();
    }
    
      protected void kosong () {
        
        tgltransaksi.setDate(null);
        tglkunjungan.setDate(null);
        tkp.setText("");
        tnama.setText("");
        tnamainstasi.setText("");
        thp.setText("");
        tnamatiket.setText("");
        tkhusus.setText("");
        thargatiket.setText("");
        tjumlahtiket.setText("1");
        tdiskon.setText("0");
        ttotal.setText("");
        tuang.setText("");
        tkembali.setText("");
    }
     
    
     protected void autonumber(){
        try{
            String sql ="Select nomor_transaksi from transaksitiketmuseum order by nomor_transaksi asc";
            Statement stat = conn.createStatement();
            ResultSet rs= stat.executeQuery(sql);
            tnt.setText("TM0001");
            
            while(rs.next()){
                String kode = rs.getString("nomor_transaksi").substring(2);
                int nomor = Integer.parseInt(kode)+1;
                String nol ="";
                
                if(nomor<10)
                {nol = "000";}
                else if (nomor<100)
                {nol ="00";}
                else if (nomor<1000)
                {nol ="0";}
                
                tnt.setText("TM" + nol + nomor);
            }
        } 
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Penomoran Salah"+ e);
        }
     }
    
      public void itemTerpilih(){        
      popuppelanggan1 Pm = new popuppelanggan1();
      Pm.pelanggan = this;       
      tkp.setText(kode_pelanggan);        
      tnama.setText(nama);  
      if(jenis_kelamin.equals("Laki-laki")){rjk1.setSelected(true); rjk2.setSelected(false);}
      else {rjk1.setSelected(false); rjk2.setSelected(true);}    
       tnamainstasi.setText(nama_instasi);
        thp.setText(hp);  
    
    }
      
       public void itemTerpilihtiket(){        
      popuptiketmuseum Pm = new popuptiketmuseum();
      Pm.tiket = this;       
      tnamatiket.setText(nama_tiket);        
      tkhusus.setText(khusus);  
      thargatiket.setText(harga);     
    }
    
     protected void jumlahtiket(){ 
      tjumlahtiket.setText("1");
      tdiskon.setText("0");
      tnt.setEnabled(false);
      tkp.setEnabled(false);
   }
     
      protected void aktif(){    
      tnt.setEnabled(false);
      tkp.setEnabled(false);
   }
      
       protected void datatable(){
      Object[]Baris={"No.transaksi","tgl_transaksi","Kode_Pelanggan","Nama","Jenis_kelamin",
                     "Nama_instasi","Hp","Tgl_kunjungan","Tiket","Khusus","Harga","Jumlah","Diskon",
                     "Total","Uang","Kembali"};
      tabmode = new DefaultTableModel(null, Baris);
      tabeltransaksitiketmuseum.setModel (tabmode);
      String sql ="select * from transaksitiketmuseum";
      try {
          java.sql.Statement stat = conn.createStatement();
          ResultSet hasil = stat.executeQuery(sql);
          while(hasil.next()){
            String a = hasil.getString("nomor_transaksi");
            String b = hasil.getString("tgl_transaksi");
            String c = hasil.getString("kode_pelanggan");
            String d = hasil.getString("nama");
            String e = hasil.getString("jk");
            String f = hasil.getString("nama_instasi");
            String g = hasil.getString("hp");     
            String h = hasil.getString("tgl_kunjungan");
            String i = hasil.getString("nama_tiket");
            String j = hasil.getString("khusus");
            String k = hasil.getString("harga_satuan_tiket");
            String l = hasil.getString("jumlah_tiket");
            String m = hasil.getString("diskon");
            String n = hasil.getString("total");
            String o = hasil.getString("uang");
            String p = hasil.getString("kembali");
            
            String[] data={a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p};
            tabmode.addRow(data);
          }   
               }catch (Exception e) { 
      }
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tnt = new javax.swing.JTextField();
        tgltransaksi = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tkp = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rjk1 = new javax.swing.JRadioButton();
        rjk2 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tnamainstasi = new javax.swing.JTextField();
        thp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tnamatiket = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tkhusus = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        thargatiket = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tjumlahtiket = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tglkunjungan = new com.toedter.calendar.JDateChooser();
        tdiskon = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ttotal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tuang = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tkembali = new javax.swing.JTextField();
        btn_plus = new javax.swing.JButton();
        btn_mines = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeltransaksitiketmuseum = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Candy-House-icon.png"))); // NOI18N
        jButton14.setText("HOME");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("TRANSAKSI TIKET MUSEUM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(334, 334, 334)
                    .addComponent(jLabel23)
                    .addContainerGap(335, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel23)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Tanggal Transaksi");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Nomor Transaksi");

        tgltransaksi.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgltransaksiPropertyChange(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Kode Pelanggan");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Nama Pelanggan");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Jenis Kelamin");

        buttonGroup1.add(rjk1);
        rjk1.setText("Laki - Laki");

        buttonGroup1.add(rjk2);
        rjk2.setText("Perempuan");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Nama Instasi");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Nomor Telepon");

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Nama Tiket");

        jButton2.setText("Cari");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Khusus");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Harga / Tiket");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Jumlah Tiket");

        tjumlahtiket.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tjumlahtiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tjumlahtiketActionPerformed(evt);
            }
        });
        tjumlahtiket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tjumlahtiketKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Diskon");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Tanggal Kunjungan");

        tglkunjungan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglkunjunganPropertyChange(evt);
            }
        });

        tdiskon.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Total Harga");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Uang");

        tuang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuangActionPerformed(evt);
            }
        });
        tuang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tuangKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Kembali");

        btn_plus.setBackground(new java.awt.Color(255, 255, 255));
        btn_plus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add-icon.png"))); // NOI18N
        btn_plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_plusActionPerformed(evt);
            }
        });

        btn_mines.setBackground(new java.awt.Color(255, 255, 255));
        btn_mines.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Alarm-Minus-icon.png"))); // NOI18N
        btn_mines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minesActionPerformed(evt);
            }
        });

        jButton5.setText("Hitung");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("%");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("Rp");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("Rp");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setText("Rp");

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        jButton6.setText("SIMPAN");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear.png"))); // NOI18N
        jButton7.setText("BATAL");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rjk1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rjk2))
                    .addComponent(thp)
                    .addComponent(tnamainstasi)
                    .addComponent(tnama)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tkp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jButton7))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(18, 18, 18)
                            .addComponent(tglkunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel12))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                    .addComponent(jLabel20)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tkhusus)
                                .addComponent(tkembali)
                                .addComponent(thargatiket, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ttotal, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tuang, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(tnamatiket, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tdiskon)
                                        .addComponent(tjumlahtiket, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(btn_mines, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btn_plus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jLabel17))))
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(48, 48, 48))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(tglkunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(tnamatiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(tkhusus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(thargatiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_plus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_mines, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(tjumlahtiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(tkp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(rjk1)
                                    .addComponent(rjk2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(tnamainstasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(thp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tdiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGap(14, 14, 14)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(ttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        tabeltransaksitiketmuseum.setModel(new javax.swing.table.DefaultTableModel(
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
        tabeltransaksitiketmuseum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeltransaksitiketmuseumMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeltransaksitiketmuseum);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("CARI BERDASARKAN NOMOR TRANSAKSI");

        jButton8.setText("Cari");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Refresh");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/DELETE.png"))); // NOI18N
        jButton10.setText("HAPUS");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit-icon.png"))); // NOI18N
        jButton11.setText("EDIT");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Printer-icon.png"))); // NOI18N
        jButton12.setText("PRINT");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("PRINT BERDASARKAN NOMOR TRANSAKSI");

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Printer-icon.png"))); // NOI18N
        jButton13.setText("PRINT ALL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tnt)
                                            .addComponent(tgltransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton13)))
                                .addGap(125, 125, 125))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jButton8)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tgltransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tcari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8)
                        .addComponent(jButton9)
                        .addComponent(jLabel21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton10)
                        .addComponent(jButton11)
                        .addComponent(jButton12)
                        .addComponent(jButton13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 156, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tjumlahtiketKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tjumlahtiketKeyReleased
int xjml;
      xjml=Integer.parseInt(tjumlahtiket.getText());
      String xsubtotal=Integer.toString(xjml);
      tjumlahtiket.setText(xsubtotal);   

       if(xjml <2){
          btn_mines.setEnabled(false);
       }  else if(xjml >1){
            btn_mines.setEnabled(true);
       } 
       
        
    if( xjml > 0 && xjml <50){
        tdiskon.setText("0");
        }
      else if(xjml >49 && xjml <100){
        tdiskon.setText("5");
        }
        else if(xjml >99 && xjml <500){
        tdiskon.setText("10");
        }
     else if(xjml >499 ){
        tdiskon.setText("30");
        }
    
             // TODO add your handling code here:
    }//GEN-LAST:event_tjumlahtiketKeyReleased

    private void btn_plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_plusActionPerformed
    int xqty,xjml;
      xqty=Integer.parseInt(tjumlahtiket.getText());
      xjml=1+xqty;
      String xsubtotal=Integer.toString(xjml);
      tjumlahtiket.setText(xsubtotal);  
      
         if(xjml >1){
          btn_mines.setEnabled(true);
       }

  if( xjml > 0 && xjml <50){
        tdiskon.setText("0");
        }
      else if(xjml >49 && xjml <100){
        tdiskon.setText("5");
        }
        else if(xjml >99 && xjml <500){
        tdiskon.setText("10");
        }
     else if(xjml >499 ){
        tdiskon.setText("30");
        }// TODO add your handling code here:
    }//GEN-LAST:event_btn_plusActionPerformed

    private void btn_minesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minesActionPerformed
 int xqty,xjml;
      xqty=Integer.parseInt(tjumlahtiket.getText());
      xjml=xqty-1;
      String xsubtotal=Integer.toString(xjml);
      tjumlahtiket.setText(xsubtotal);   

       if(xjml <2){
          btn_mines.setEnabled(false);
       }
       
       if( xjml > 0 && xjml <50){
        tdiskon.setText("0");
        }
      else if(xjml >49 && xjml <100){
        tdiskon.setText("5");
        }
        else if(xjml >99 && xjml <500){
        tdiskon.setText("10");
        }
     else if(xjml >499 ){
        tdiskon.setText("30");
        }
      // TODO add your handling code here:
    }//GEN-LAST:event_btn_minesActionPerformed

    private void tuangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tuangActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    int xqty,xhrg,xdiskon,xjml,xtotal,xtotal2;
      
      xhrg=Integer.parseInt(thargatiket.getText());
      xqty=Integer.parseInt(tjumlahtiket.getText());
      xdiskon=Integer.parseInt(tdiskon.getText());
      
      xjml=xhrg*xqty;
      
      xtotal=(xdiskon*xjml)/100;
      xtotal2=xjml-xtotal;
      String xsubtotal=Integer.toString(xtotal2);
      ttotal.setText(xsubtotal);  // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tjumlahtiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tjumlahtiketActionPerformed
 
    }//GEN-LAST:event_tjumlahtiketActionPerformed

    private void tuangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tuangKeyReleased
   int xuang,xhrg,xkembali;
      xuang=Integer.parseInt(tuang.getText());
      xhrg=Integer.parseInt(ttotal.getText());
      xkembali=xuang-xhrg;
      String xsubtotal=Integer.toString(xkembali);
      tkembali.setText("Rp " +xsubtotal);          // TODO add your handling code here:
    }//GEN-LAST:event_tuangKeyReleased

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
 Home n = new Home();
        n.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 popuppelanggan1 Pm = new popuppelanggan1();         
  Pm.pelanggan = this;        
  Pm.setVisible(true);         
  Pm.setResizable(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
popuptiketmuseum Pm = new popuptiketmuseum();         
  Pm.tiket = this;        
  Pm.setVisible(true);         
  Pm.setResizable(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
String sql ="insert into transaksitiketmuseum values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,tnt.getText());                 
            stat.setString(2,tgl1);
            stat.setString(3,tkp.getText());                 
            stat.setString(4,tnama.getText());  
            String jk="";
            if (rjk1.isSelected()) jk="Laki-laki";
            else jk="Perempuan";
            stat.setString(5, jk);
            stat.setString(6,tnamainstasi.getText());                 
            stat.setString(7,thp.getText());  
            stat.setString(8,tgl2);                 
            stat.setString(9,tnamatiket.getText());  
            stat.setString(10,tkhusus.getText());                 
            stat.setString(11,thargatiket.getText()); 
            stat.setString(12,tjumlahtiket.getText());  
            stat.setString(13,tdiskon.getText());                 
            stat.setString(14,ttotal.getText()); 
            stat.setString(15,tuang.getText());                 
            stat.setString(16,tkembali.getText()); 
        
             stat.executeUpdate();
             JOptionPane.showMessageDialog (null,"Data Berhasil Disimpan");            
             datatable();
             kosong();
             transaksi_tiket_museum n = new  transaksi_tiket_museum();
             n.setVisible(true);
             this.setVisible(false);  
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan"+e);
        }            // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tgltransaksiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgltransaksiPropertyChange
if (tgltransaksi.getDate() !=null){
           tgl1=format.format(tgltransaksi.getDate());
       }           // TODO add your handling code here:
    }//GEN-LAST:event_tgltransaksiPropertyChange

    private void tglkunjunganPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglkunjunganPropertyChange
if (tglkunjungan.getDate() !=null){
           tgl2=format2.format(tglkunjungan.getDate());
       }          // TODO add your handling code here:
    }//GEN-LAST:event_tglkunjunganPropertyChange

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
             transaksi_tiket_museum n = new  transaksi_tiket_museum();
             n.setVisible(true);
             this.setVisible(false);     // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tabeltransaksitiketmuseumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeltransaksitiketmuseumMouseClicked
 try{
    int bar =tabeltransaksitiketmuseum.getSelectedRow(); 
      String a = tabmode.getValueAt(bar,0).toString();
      String b = tabmode.getValueAt(bar,1).toString();
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      Date dt= sdf.parse(b);
      String c = tabmode.getValueAt(bar,2).toString();
      String d = tabmode.getValueAt(bar,3).toString();     
      String e = tabmode.getValueAt(bar,4).toString();        
      String f = tabmode.getValueAt(bar,5).toString();     
      String g = tabmode.getValueAt(bar,6).toString();
      
      String h = tabmode.getValueAt(bar,7).toString();
      SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
      Date dt2= sdf.parse(h);
      String i = tabmode.getValueAt(bar,8).toString();     
      String j = tabmode.getValueAt(bar,9).toString();        
      String k = tabmode.getValueAt(bar,10).toString();     
      String l = tabmode.getValueAt(bar,11).toString();
      String m = tabmode.getValueAt(bar,12).toString();
      String n = tabmode.getValueAt(bar,13).toString();     
      String o = tabmode.getValueAt(bar,14).toString();        
      String p = tabmode.getValueAt(bar,15).toString();     
     
         
        tnt.setText(a);
        tgltransaksi.setDate(dt);
        tkp.setText(c);
        tnama.setText(d);
        if(e.equals("Laki-laki")){rjk1.setSelected(true); rjk2.setSelected(false);}
        else {rjk1.setSelected(false); rjk2.setSelected(true);}       
        tnamainstasi.setText(f);
        thp.setText(g);
        tglkunjungan.setDate(dt2);
        tnamatiket.setText(i);
        tkhusus.setText(j);
        thargatiket.setText(k);
        tjumlahtiket.setText(l);
        tdiskon.setText(m);
        ttotal.setText(n);
        tuang.setText(o);
        tkembali.setText(p);
            
    }catch (Exception exc){}          // TODO add your handling code here:
    }//GEN-LAST:event_tabeltransaksitiketmuseumMouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try{
            String sql="update transaksitiketmuseum set tgl_transaksi=?,kode_pelanggan=?,nama=?,jk=?,"
                    + "nama_instasi=?,hp=?,tgl_kunjungan=?,nama_tiket=?,khusus=?,"
                    + "harga_satuan_tiket=?,jumlah_tiket=?,diskon=?,total=?,uang=?,"
                    + "kembali=? where nomor_transaksi=?";
            PreparedStatement stat = conn.prepareStatement(sql);          
           
                          
            stat.setString(1,tgl1);
            stat.setString(2,tkp.getText());                 
            stat.setString(3,tnama.getText());  
            String jk="";
            if (rjk1.isSelected()) jk="Laki-laki";
            else jk="Perempuan";
            stat.setString(4, jk);
            stat.setString(5,tnamainstasi.getText());                 
            stat.setString(6,thp.getText());  
            stat.setString(7,tgl2);                 
            stat.setString(8,tnamatiket.getText());  
            stat.setString(9,tkhusus.getText());                 
            stat.setString(10,thargatiket.getText()); 
            stat.setString(11,tjumlahtiket.getText());  
            stat.setString(12,tdiskon.getText());                 
            stat.setString(13,ttotal.getText()); 
            stat.setString(14,tuang.getText());   
            stat.setString(15,tkembali.getText()); 
            stat.setString(16,tnt.getText());                              
               
            stat.executeUpdate();
            JOptionPane.showMessageDialog (null,"Data Berhasil Diedit");
            datatable();
            transaksi_tiket_museum n = new  transaksi_tiket_museum();
            n.setVisible(true);
            this.setVisible(false);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Data Gagal Diedit"+e);
        }  
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
int ok =JOptionPane.showConfirmDialog(null,"delete","KOnfirmasi  Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok==0){
            String sql ="delete from transaksitiketmuseum where nomor_transaksi='"+tnt.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate(); 
                JOptionPane.showMessageDialog(null,"data berhasil di hapus");
                kosong();
                tnama.requestFocus();
                datatable();  
                transaksi_tiket_museum n = new  transaksi_tiket_museum();
                n.setVisible(true);
                this.setVisible(false);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal Dihapus"+e);
                
            } 
        }            // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
datatable();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
 Object[]Baris={"No.transaksi","tgl_transaksi","Kode_Pelanggan","Nama","Jenis_kelamin",
                     "Nama_instasi","Hp","Tgl_kunjungan","Tiket","Khusus","Harga","Jumlah","Diskon",
                     "Total","Uang","Kembali"};
      tabmode = new DefaultTableModel(null, Baris);
      tabeltransaksitiketmuseum.setModel (tabmode);
      String sql ="select * from transaksitiketmuseum where nomor_transaksi like '%"+tcari.getText()+"%'";
      try {
          java.sql.Statement stat = conn.createStatement();
          ResultSet hasil = stat.executeQuery(sql);
          while(hasil.next()){
            String a = hasil.getString("nomor_transaksi");
            String b = hasil.getString("tgl_transaksi");
            String c = hasil.getString("kode_pelanggan");
            String d = hasil.getString("nama");
            String e = hasil.getString("jk");
            String f = hasil.getString("nama_instasi");
            String g = hasil.getString("hp");     
            String h = hasil.getString("tgl_kunjungan");
            String i = hasil.getString("nama_tiket");
            String j = hasil.getString("khusus");
            String k = hasil.getString("harga_satuan_tiket");
            String l = hasil.getString("jumlah_tiket");
            String m = hasil.getString("diskon");
            String n = hasil.getString("total");
            String o = hasil.getString("uang");
            String p = hasil.getString("kembali");
            
            String[] data={a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p};
            tabmode.addRow(data);
          }   
               }catch (Exception e) { 
      }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(transaksi_tiket_museum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi_tiket_museum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi_tiket_museum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi_tiket_museum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi_tiket_museum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mines;
    private javax.swing.JButton btn_plus;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JRadioButton rjk1;
    private javax.swing.JRadioButton rjk2;
    private javax.swing.JTable tabeltransaksitiketmuseum;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tdiskon;
    private com.toedter.calendar.JDateChooser tglkunjungan;
    private com.toedter.calendar.JDateChooser tgltransaksi;
    private javax.swing.JTextField thargatiket;
    private javax.swing.JTextField thp;
    private javax.swing.JTextField tjumlahtiket;
    private javax.swing.JTextField tkembali;
    private javax.swing.JTextField tkhusus;
    private javax.swing.JTextField tkp;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tnamainstasi;
    private javax.swing.JTextField tnamatiket;
    private javax.swing.JTextField tnt;
    private javax.swing.JTextField ttotal;
    private javax.swing.JTextField tuang;
    // End of variables declaration//GEN-END:variables
}
