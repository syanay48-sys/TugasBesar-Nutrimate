package NutriMate;

public class KaloriImplementation implements KaloriInterface {

    @Override
    public double hitungBMR(UserEntity user) {
        double bb = user.getBeratBadan();
        double tb = user.getTinggiBadan();
        int u = user.getUmur();
        double bmr;
        if ("Laki-laki".equalsIgnoreCase(user.getJenisKelamin())) {
            bmr = 88.362 + (13.397 * bb) + (4.799 * tb) - (5.677 * u);
        } else {
            bmr = 447.593 + (9.247 * bb) + (3.098 * tb) - (4.330 * u);
        }
        System.out.printf("[KaloriInterface] BMR %s (%.0fkg, %.0fcm, %dthn): %.2f kkal%n", user.getNama(), bb, tb, u, bmr);
        return Math.round(bmr * 100.0) / 100.0;
    }

    @Override
    public double hitungKebutuhanKalori(double bmr, String aktivitas) {
        double faktor;
        String level = aktivitas.toLowerCase();
        if (level.contains("ringan") || level.contains("1-2")) {
            faktor = 1.375;
        } else if (level.contains("sedang") || level.contains("3-5")) {
            faktor = 1.550;
        } else if (level.contains("berat") || level.contains("6-7")) {
            faktor = 1.725;
        } else {
            faktor = 1.200;
        }
        double kebutuhan = Math.round(bmr * faktor);
        System.out.printf("[KaloriInterface] Kebutuhan kalori (aktivitas: %s, faktor: %.3f): %.0f kkal%n", aktivitas, faktor, kebutuhan);
        return kebutuhan;
    }

    @Override
    public double hitungTargetKalori(double kebutuhanKalori, String targetDiet) {
        double target;
        String tujuan = targetDiet.toLowerCase();
        if (tujuan.contains("turun") || tujuan.contains("menurunkan")) {
            target = kebutuhanKalori - 500;
        } else if (tujuan.contains("naik") || tujuan.contains("menaikkan")) {
            target = kebutuhanKalori + 500;
        } else {
            target = kebutuhanKalori;
        }
        System.out.printf("[KaloriInterface] Target kalori (%s): %.0f kkal%n", targetDiet, target);
        return target;
    }

    @Override
    public double hitungSisaKalori(double targetKalori, double kaloriMasuk) {
        double sisa = targetKalori - kaloriMasuk;
        if (sisa < 0) {
            System.out.printf("[KaloriService] Peringatan! Kalori berlebih sebesar %.0f kkal.%n", Math.abs(sisa));
        }
        return sisa;
    }
}
