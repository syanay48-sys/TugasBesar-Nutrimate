package NutriMate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LaporanImplementation implements LaporanInterface {

    private static List<LaporanEntity> laporanDatabase = new ArrayList<>();
    private static int autoIncrementId = 1;
    private CatatanInterface catatanInterface;
    private UserInterface userInterface;

    public LaporanImplementation(CatatanInterface catatanInterface, UserInterface userInterface) {
        this.catatanInterface = catatanInterface;
        this.userInterface = userInterface;
    }

    @Override
    public LaporanEntity buatLaporanHarian(int userId, LocalDate tanggal) {
        List<CatatanMakanan> catatan = catatanInterface.getCatatanByTanggal(userId, tanggal);
        if (catatan.isEmpty()) {
            System.out.println("[LaporanInterface] Tidak ada data catatan untuk tanggal " + tanggal);
            return null;
        }

        double totalKalori = 0, totalKarbo = 0, totalProtein = 0, totalLemak = 0;
        for (CatatanMakanan c : catatan) {
            totalKalori += c.getTotalKalori();
            totalKarbo += c.getTotalKarbohidrat();
            totalProtein += c.getTotalProtein();
            totalLemak += c.getTotalLemak();
        }

        double targetKalori = userInterface.getProfil(userId).getTargetKalori();

        LaporanEntity existing = getLaporanHarian(userId, tanggal);
        if (existing != null) {
            existing.setTotalKaloriMasuk(totalKalori);
            existing.setTotalKarbohidrat(totalKarbo);
            existing.setTotalProtein(totalProtein);
            existing.setTotalLemak(totalLemak);
            existing.setSisaKalori(targetKalori - totalKalori);
            System.out.println("[LaporanInterface] Laporan diperbarui untuk tanggal " + tanggal);
            return existing;
        }

        LaporanEntity laporan = new LaporanEntity(
                autoIncrementId++, userId, tanggal,
                totalKalori, totalKarbo, totalProtein, totalLemak, targetKalori
        );
        laporanDatabase.add(laporan);
        System.out.printf("[LaporanService] Laporan dibuat: %.0f/%.0f kkal (%s)%n", totalKalori, targetKalori, laporan.getStatusDiet());
        return laporan;
    }

    @Override
    public LaporanEntity getLaporanHarian(int userId, LocalDate tanggal) {
        return laporanDatabase.stream()
                .filter(l -> l.getUserId() == userId && l.getTanggal().equals(tanggal))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<LaporanEntity> getLaporan7Hari(int userId) {
        LocalDate sampai = LocalDate.now();
        LocalDate dari = sampai.minusDays(6);
        return getLaporanByRentang(userId, dari, sampai);
    }

    @Override
    public List<LaporanEntity> getLaporanByRentang(int userId, LocalDate dari, LocalDate sampai) {
        return laporanDatabase.stream()
                .filter(l -> l.getUserId() == userId
                && !l.getTanggal().isBefore(dari)
                && !l.getTanggal().isAfter(sampai))
                .sorted((a, b) -> a.getTanggal().compareTo(b.getTanggal()))
                .collect(Collectors.toList());
    }
}
