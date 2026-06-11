package NutriMate;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    private static UserInterface userInterface;
    private static MakananInterface makananInterface;
    private static CatatanInterface catatanInterface;
    private static KaloriInterface kaloriInterface;
    private static LaporanInterface laporanInterface;

    public static void main(String[] args) {
        System.out.println(" ╔════════════════════════════════════════════╗ ");
        System.out.println(" ║  NutriMate - Sistem Manajemen Nutrisi      ║ ");
        System.out.println(" ╚════════════════════════════════════════════╝ ");
        System.out.println();

        makananInterface = new MakananImplementation();
        userInterface = new UserImplementation();
        kaloriInterface = new KaloriImplementation();
        catatanInterface = new CatatanImplementation(makananInterface);
        laporanInterface = new LaporanImplementation(catatanInterface, userInterface);

        separator("REGISTRASI PENGGUNA BARU");
        UserEntity userBaru = new UserEntity();
        userBaru.setUsername("viravira");
        userBaru.setPassword("vira123");
        userBaru.setNama("Vira");
        userBaru.setUmur(28);
        userBaru.setJenisKelamin("Perempuan");
        userBaru.setBeratBadan(60.0);
        userBaru.setTinggiBadan(158.0);
        userBaru.setAktivitas("Ringan (1-2 hari/minggu)");
        userBaru.setTargetDiet("Menurunkan Berat Badan");
        boolean regBerhasil = userInterface.registrasi(userBaru);
        System.out.println("Status Registrasi: " + (regBerhasil ? "BERHASIL ✓" : "GAGAL  ✗ "));
        System.out.println();

        separator("LOGIN");
        UserEntity loginUser = userInterface.login("andi", "andi123");
        if (loginUser != null) {
            System.out.println("User Login: " + loginUser);
        }
        System.out.println();

        separator("KALKULATOR KALORI - " + loginUser.getNama().toUpperCase());
        double bmr = kaloriInterface.hitungBMR(loginUser);
        double kebutuhanKalori = kaloriInterface.hitungKebutuhanKalori(bmr, loginUser.getAktivitas());
        double targetKalori = kaloriInterface.hitungTargetKalori(kebutuhanKalori, loginUser.getTargetDiet());
        loginUser.setTargetKalori(targetKalori);
        userInterface.updateProfil(loginUser);
        System.out.printf("  BMR             : %.2f kkal%n", bmr);
        System.out.printf("  Kebutuhan TDEE  : %.0f kkal%n", kebutuhanKalori);
        System.out.printf("  Target Kalori   : %.0f kkal/hari%n", targetKalori);
        System.out.println();

        separator("DAFTAR MAKANAN");
        System.out.printf("  %-5s %-30s %10s %12s%n", "No", "Nama Makanan", "Kalori", "Kategori");
        System.out.println("  " + "-".repeat(60));
        int no = 1;
        for (MakananEntity m : makananInterface.getDaftarMakanan()) {
            System.out.printf("  %-5d %-30s %7.0f kkal %12s%n",
                    no++, m.getNamaMakanan(), m.getKaloriPerPorsi(), m.getKategori());
        }
        System.out.println();

        separator("CATATAN MAKANAN HARI INI - " + LocalDate.now());
        tambahCatatanDemo(loginUser.getUserId(), 1, LocalTime.of(7, 30), 1.0);  // Nasi Putih
        tambahCatatanDemo(loginUser.getUserId(), 2, LocalTime.of(7, 30), 1.0);  // Telur Dadar
        tambahCatatanDemo(loginUser.getUserId(), 7, LocalTime.of(12, 30), 1.0);  // Nasi+Ayam+Sayur
        tambahCatatanDemo(loginUser.getUserId(), 5, LocalTime.of(16, 30), 1.5);  // Apel
        tambahCatatanDemo(loginUser.getUserId(), 4, LocalTime.of(19, 0), 1.0);  // Oatmeal
        System.out.println();

        separator("RINGKASAN SEBELUM EVALUASI");
        double kaloriMasuk = catatanInterface.getTotalKaloriHarian(loginUser.getUserId(), LocalDate.now());
        double sisaKalori = kaloriInterface.hitungSisaKalori(loginUser.getTargetKalori(), kaloriMasuk);
        double persentase = (kaloriMasuk / loginUser.getTargetKalori()) * 100;
        System.out.printf("  Kalori Masuk  : %.0f kkal%n", kaloriMasuk);
        System.out.printf("  Target Kalori : %.0f kkal%n", loginUser.getTargetKalori());
        System.out.printf("  Sisa Kalori   : %.0f kkal%n", sisaKalori);
        System.out.printf("  Progress      : %.1f%%%n", persentase);
        System.out.println();

        separator("LAPORAN HARIAN (SUDAH DIROMBAK)");
        LaporanEntity laporan = laporanInterface.buatLaporanHarian(loginUser.getUserId(), LocalDate.now());
        if (laporan != null) {
            System.out.println("  " + laporan);
            System.out.println("  Status Pemenuhan Diet : " + laporan.getStatusDiet());
        }
        System.out.println();

        separator("PENCARIAN MAKANAN: 'nasi'");
        for (MakananEntity m : makananInterface.cariMakanan("nasi")) {
            System.out.printf("  → %-30s %.0f kkal (%s)%n", m.getNamaMakanan(), m.getKaloriPerPorsi(), m.getKategori());
        }
        System.out.println();

        separator("UPDATE PROFIL");
        loginUser.setBeratBadan(69.5);
        loginUser.setAktivitas("Berat (6-7 hari/minggu)");
        userInterface.updateProfil(loginUser);
        System.out.println("  Profil terkini: " + userInterface.getProfil(loginUser.getUserId()));
        System.out.println();

        System.out.println(" ╔════════════════════════════════════════════╗ ");
        System.out.println(" ║       NutriMate siap digunakan!   ✓        ║ ");
        System.out.println(" ╚════════════════════════════════════════════╝ ");
    }

    private static void tambahCatatanDemo(int userId, int makananId, LocalTime waktu, double porsi) {
        CatatanMakanan catatan = new CatatanMakanan();
        catatan.setUserId(userId);
        catatan.setMakananId(makananId);
        catatan.setTanggal(LocalDate.now());
        catatan.setWaktuMakan(waktu);
        catatan.setJumlahPorsi(porsi);
        catatanInterface.tambahCatatan(catatan);
    }

    private static void separator(String judul) {
        System.out.println("──────────────────────────────────────────────");
        System.out.println("  " + judul);
        System.out.println("──────────────────────────────────────────────");
    }
}
