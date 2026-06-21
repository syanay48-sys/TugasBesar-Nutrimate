package NutriMate;

import java.time.LocalDate;
import java.time.LocalTime;

public class CatatanMakanann {

    private int catatanId;
    private int userId;
    private int makananId;
    private LocalDate tanggal;
    private LocalTime waktuMakan;
    private double jumlahPorsi;
    private double totalKalori;
    private double totalKarbohidrat;
    private double totalProtein;
    private double totalLemak;
    private String namaMakanan;
    private String kategoriMakanan;

    public CatatanMakanann() {
    }

    public CatatanMakanann(int catatanId, int userId, int makananId,
            LocalDate tanggal, LocalTime waktuMakan,
            double jumlahPorsi, double totalKalori) {
        this.catatanId = catatanId;
        this.userId = userId;
        this.makananId = makananId;
        this.tanggal = tanggal;
        this.waktuMakan = waktuMakan;
        this.jumlahPorsi = jumlahPorsi;
        this.totalKalori = totalKalori;
    }

    public int getCatatanId() {
        return catatanId;
    }

    public void setCatatanId(int id) {
        this.catatanId = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMakananId() {
        return makananId;
    }

    public void setMakananId(int makananId) {
        this.makananId = makananId;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public LocalTime getWaktuMakan() {
        return waktuMakan;
    }

    public void setWaktuMakan(LocalTime waktu) {
        this.waktuMakan = waktu;
    }

    public double getJumlahPorsi() {
        return jumlahPorsi;
    }

    public void setJumlahPorsi(double porsi) {
        this.jumlahPorsi = porsi;
    }

    public double getTotalKalori() {
        return totalKalori;
    }

    public void setTotalKalori(double kalori) {
        this.totalKalori = kalori;
    }

    public double getTotalKarbohidrat() {
        return totalKarbohidrat;
    }

    public void setTotalKarbohidrat(double karbo) {
        this.totalKarbohidrat = karbo;
    }

    public double getTotalProtein() {
        return totalProtein;
    }

    public void setTotalProtein(double protein) {
        this.totalProtein = protein;
    }

    public double getTotalLemak() {
        return totalLemak;
    }

    public void setTotalLemak(double lemak) {
        this.totalLemak = lemak;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public void setNamaMakanan(String nama) {
        this.namaMakanan = nama;
    }

    public String getKategoriMakanan() {
        return kategoriMakanan;
    }

    public void setKategoriMakanan(String kategori) {
        this.kategoriMakanan = kategori;
    }

    @Override
    public String toString() {
        return "CatatanMakanan{id=" + catatanId + ", userId=" + userId
                + ", makanan='" + namaMakanan + "', tanggal=" + tanggal
                + ", waktu=" + waktuMakan + ", porsi=" + jumlahPorsi
                + ", totalKalori=" + totalKalori + "kkal}";
    }
}
