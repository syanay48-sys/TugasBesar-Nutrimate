package NutriMate;

import java.time.LocalDate;

public class LaporanEntity {
    private int laporanId;
    private int userId;
    private LocalDate tanggal;
    private double totalKaloriMasuk;
    private double totalKarbohidrat;   // gram
    private double totalProtein;       // gram
    private double totalLemak;         // gram
    private double targetKalori;
    private double sisaKalori;
    private String statusDiet;         // Kurang / Sesuai / Berlebih

    public LaporanEntity() {}

    public LaporanEntity(int laporanId, int userId, LocalDate tanggal,
                   double totalKaloriMasuk, double totalKarbohidrat,
                   double totalProtein, double totalLemak,
                   double targetKalori) {
        this.laporanId = laporanId;
        this.userId = userId;
        this.tanggal = tanggal;
        this.totalKaloriMasuk = totalKaloriMasuk;
        this.totalKarbohidrat = totalKarbohidrat;
        this.totalProtein = totalProtein;
        this.totalLemak = totalLemak;
        this.targetKalori = targetKalori;
        this.sisaKalori = targetKalori - totalKaloriMasuk;
        this.statusDiet = hitungStatus(totalKaloriMasuk, targetKalori);
    }

    private String hitungStatus(double kaloriMasuk, double target) {
        double selisih = Math.abs(kaloriMasuk - target);
        if (selisih <= 100) return "Sesuai";
        return (kaloriMasuk < target) ? "Kurang" : "Berlebih";
    }
 
    public int getLaporanId()                               { return laporanId; }
    public void setLaporanId(int id)                        { this.laporanId = id; }
    public int getUserId()                                  { return userId; }
    public void setUserId(int userId)                       { this.userId = userId; }
    public LocalDate getTanggal()                           { return tanggal; }
    public void setTanggal(LocalDate tanggal)               { this.tanggal = tanggal; }
    public double getTotalKaloriMasuk()                     { return totalKaloriMasuk; }
    public void setTotalKaloriMasuk(double kalori)          { this.totalKaloriMasuk = kalori; }
    public double getTotalKarbohidrat()                     { return totalKarbohidrat; }
    public void setTotalKarbohidrat(double karbo)           { this.totalKarbohidrat = karbo; }
    public double getTotalProtein()                         { return totalProtein; }
    public void setTotalProtein(double protein)             { this.totalProtein = protein; }
    public double getTotalLemak()                           { return totalLemak; }
    public void setTotalLemak(double lemak)                 { this.totalLemak = lemak; }
    public double getTargetKalori()                         { return targetKalori; }
    public void setTargetKalori(double target)              { this.targetKalori = target; }
    public double getSisaKalori()                           { return sisaKalori; }
    public void setSisaKalori(double sisa)                  { this.sisaKalori = sisa; }
    public String getStatusDiet()                           { return statusDiet; }
    public void setStatusDiet(String status)                { this.statusDiet = status; }

    @Override
    public String toString() {
        return "Laporan{id=" + laporanId + ", userId=" + userId + ", tanggal=" + tanggal +
               ", kaloriMasuk=" + totalKaloriMasuk + "kkal, karbo=" + totalKarbohidrat + 
               "g, protein=" + totalProtein + "g, lemak=" + totalLemak + "g, target=" + targetKalori +
               "kkal, sisa=" + sisaKalori + "kkal, status='" + statusDiet + "'}";
    }
}