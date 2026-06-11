package NutriMate;

public interface KaloriInterface {

    double hitungBMR(UserEntity user);

    double hitungKebutuhanKalori(double bmr, String aktivitas);

    double hitungTargetKalori(double kebutuhanKalori, String targetDiet);

    double hitungSisaKalori(double targetKalori, double kaloriMasuk);
}
