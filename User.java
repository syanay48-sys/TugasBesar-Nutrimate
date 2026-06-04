package nutrimate;

public class User {
    private int userId;
    private String username;
    private String nama;
    private int umur;
    private String jenisKelamin;
    private double beratBadan;
    private int tinggiBadan;
    private String aktivitas;
    private String targetDiet;

    public User(int userId, String username, String nama, int umur, String jenisKelamin, double beratBadan, int tinggiBadan, String aktivitas, String targetDiet) {
        this.userId = userId;
        this.username = username;
        this.nama = nama;
        this.umur = umur;
        this.jenisKelamin = jenisKelamin;
        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
        this.aktivitas = aktivitas;
        this.targetDiet = targetDiet;
    }

    public double hitungBMR() {
        if (jenisKelamin.equalsIgnoreCase("Laki-laki")) {
            return 66.5 + (13.75 * beratBadan) + (5.003 * tinggiBadan) - (6.75 * umur);
        } else {
            return 655.1 + (9.563 * beratBadan) + (1.85 * tinggiBadan) - (4.676 * umur);
        }
    }

    public int hitungKebutuhanKalori() {
        double bmr = hitungBMR();
        double faktorAktivitas = 1.2;
        if (aktivitas.contains("Sedang")) faktorAktivitas = 1.55;
        else if (aktivitas.contains("Berat")) faktorAktivitas = 1.725;
        
        double kaloriMaintanance = bmr * faktorAktivitas;
        
        if (targetDiet.contains("Menurunkan")) return (int) (kaloriMaintanance - 500);
        else if (targetDiet.contains("Naik")) return (int) (kaloriMaintanance + 500);
        
        return (int) kaloriMaintanance;
    }

    public int getUserId() { return userId; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public double getBeratBadan() { return beratBadan; }
    public void setBeratBadan(double beratBadan) { this.beratBadan = beratBadan; }
}