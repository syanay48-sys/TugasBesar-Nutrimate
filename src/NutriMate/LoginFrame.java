package NutriMate;

public class LoginFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginFrame.class.getName());

    public LoginFrame() {
        initComponents();
        this.setLocationRelativeTo(null);  
 
        java.util.prefs.Preferences prefs = java.util.prefs.Preferences.userNodeForPackage(LoginFrame.class);
        boolean remember = prefs.getBoolean("remember", false);
        if (remember) {
            txtUsername.setText(prefs.get("saved_user", ""));
            txtPassword.setText(prefs.get("saved_pass", ""));
            chbIngatSaya.setSelected(true);  
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    int ukuranMata = 22;

                    java.net.URL imgCloseURL = getClass().getResource("/NutriMate/eyeClose.png");
                    if (imgCloseURL != null) {
                        javax.swing.ImageIcon iconClose = new javax.swing.ImageIcon(imgCloseURL);
                        java.awt.Image imgScaled = iconClose.getImage().getScaledInstance(ukuranMata, ukuranMata, java.awt.Image.SCALE_SMOOTH);
                        btnMata.setIcon(new javax.swing.ImageIcon(imgScaled));
                    }

                    java.net.URL imgOpenURL = getClass().getResource("/NutriMate/eyeOpen.png");
                    if (imgOpenURL != null) {
                        javax.swing.ImageIcon iconOpen = new javax.swing.ImageIcon(imgOpenURL);
                        java.awt.Image imgScaled = iconOpen.getImage().getScaledInstance(ukuranMata, ukuranMata, java.awt.Image.SCALE_SMOOTH);
                        btnMata.setPressedIcon(new javax.swing.ImageIcon(imgScaled));
                        btnMata.setSelectedIcon(new javax.swing.ImageIcon(imgScaled));
                    }

                    btnMata.setBorderPainted(false);
                    btnMata.setContentAreaFilled(false);
                    btnMata.setFocusPainted(false);
                    btnMata.setText("");

                    btnMata.revalidate();
                    btnMata.repaint();

                } catch (Exception e) {
                    System.out.println("Gagal resize ikon mata: " + e.getMessage());
                }
            }
        });

        this.getContentPane().setBackground(java.awt.Color.WHITE);
        this.setPreferredSize(new java.awt.Dimension(390, 690));
        this.setMinimumSize(new java.awt.Dimension(390, 690));
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLoginUtama = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        chbIngatSaya = new javax.swing.JCheckBox();
        btnMata = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nutrimate - Login");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(400, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NutriMate/logo_nutrimate.png"))); // NOI18N
        lblLogo.setText(" ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("NutriMate");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Catat Makananmu, Capai Target Dietmu!");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("Username");

        txtUsername.setText(" ");
        txtUsername.setPreferredSize(new java.awt.Dimension(64, 25));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("Password");

        txtPassword.setEchoChar('\u25cf');
        txtPassword.setPreferredSize(new java.awt.Dimension(90, 25));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        btnLoginUtama.setBackground(new java.awt.Color(102, 0, 204));
        btnLoginUtama.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnLoginUtama.setForeground(new java.awt.Color(255, 255, 255));
        btnLoginUtama.setText("Login");
        btnLoginUtama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginUtamaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Belum punya akun?");

        jLabel6.setForeground(new java.awt.Color(0, 204, 255));
        jLabel6.setText("Daftar di sini");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        chbIngatSaya.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        chbIngatSaya.setText("Ingat saya");

        btnMata.setText(" ");
        btnMata.setBorderPainted(false);
        btnMata.setContentAreaFilled(false);
        btnMata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMata.setRequestFocusEnabled(false);
        btnMata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMataMouseClicked(evt);
            }
        });
        btnMata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMata, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chbIngatSaya)
                            .addComponent(btnLoginUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)))
                .addGap(87, 87, 87))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMata, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbIngatSaya)
                .addGap(49, 49, 49)
                .addComponent(btnLoginUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(447, 447, 447))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -243;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        RegisterFrame registerForm = new RegisterFrame();

        registerForm.setVisible(true);

        this.dispose();

    }//GEN-LAST:event_jLabel6MouseClicked

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnMataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMataMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMataMouseClicked

    private void btnMataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMataActionPerformed
        if (txtPassword.getEchoChar() == '●') {
            txtPassword.setEchoChar((char) 0);

            java.net.URL imgOpenURL = getClass().getResource("/NutriMate/eyeOpen.png");
            if (imgOpenURL != null) {
                java.awt.Image img = new javax.swing.ImageIcon(imgOpenURL).getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH);
                btnMata.setIcon(new javax.swing.ImageIcon(img));
            }
        } else {
            txtPassword.setEchoChar('●');

            java.net.URL imgCloseURL = getClass().getResource("/NutriMate/eyeClose.png");
            if (imgCloseURL != null) {
                java.awt.Image img = new javax.swing.ImageIcon(imgCloseURL).getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH);
                btnMata.setIcon(new javax.swing.ImageIcon(img));
            }
        }


    }//GEN-LAST:event_btnMataActionPerformed

    private void btnLoginUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginUtamaActionPerformed
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Username dan Password tidak boleh kosong!", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            java.sql.Connection conn = Koneksi.getKoneksi();
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Ambil data user asli dari database dan taruh di Session
                NutriMate.UserDataSession.namaUser = rs.getString("nama_user");
                NutriMate.UserDataSession.targetKalori = rs.getDouble("target_kalori");
                NutriMate.UserDataSession.beratBadan = rs.getDouble("berat_badan");

                // Logika Fitur "Ingat Saya" (Ganti 'chbIngatSaya' sesuai variabel JCheckBox kamu)
                java.util.prefs.Preferences prefs = java.util.prefs.Preferences.userNodeForPackage(LoginFrame.class);
                if (chbIngatSaya.isSelected()) {
                    prefs.put("saved_user", username);
                    prefs.put("saved_pass", password);
                    prefs.putBoolean("remember", true);
                } else {
                    prefs.remove("saved_user");
                    prefs.remove("saved_pass");
                    prefs.putBoolean("remember", false);
                }

                javax.swing.JOptionPane.showMessageDialog(this, "Login Berhasil! Selamat Datang " + NutriMate.UserDataSession.namaUser);

                // Buka Dashboard Utama
                new Dashboard().setVisible(true);
                this.dispose();

            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Username atau Password salah!", "Login Gagal", javax.swing.JOptionPane.ERROR_MESSAGE);
            }

        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Koneksi database bermasalah: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnLoginUtamaActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new LoginFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginUtama;
    private javax.swing.JToggleButton btnMata;
    private javax.swing.JCheckBox chbIngatSaya;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
