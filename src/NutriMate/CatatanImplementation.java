package NutriMate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatatanImplementation implements CatatanInterface {

    private static List<CatatanMakanann> catatanDatabase = CatatanDataStorage.bacaDariFile();
    private static int autoIncrementId = 1;
    private MakananInterface makananInterface;

    public CatatanImplementation(MakananInterface makananInterface) {
        this.makananInterface = makananInterface;

        if (!catatanDatabase.isEmpty()) {
            int maxId = catatanDatabase.stream()
                    .mapToInt(CatatanMakanann::getCatatanId)
                    .max()
                    .orElse(0);
            autoIncrementId = maxId + 1;
        }
    }

    @Override
    public boolean tambahCatatan(CatatanMakanann catatan) {
        MakananEntity makanan = makananInterface.getMakananById(catatan.getMakananId());
        if (makanan == null) {
            System.out.println("[CatatanInterface] Gagal tambah: makanan ID=" + catatan.getMakananId() + " tidak ditemukan.");
            return false;
        }

        catatan.setTotalKalori(makanan.getKaloriPerPorsi() * catatan.getJumlahPorsi());
        catatan.setTotalKarbohidrat(makanan.getKarbohidrat() * catatan.getJumlahPorsi());
        catatan.setTotalProtein(makanan.getProtein() * catatan.getJumlahPorsi());
        catatan.setTotalLemak(makanan.getLemak() * catatan.getJumlahPorsi());

        catatan.setNamaMakanan(makanan.getNamaMakanan());
        catatan.setKategoriMakanan(makanan.getKategori());

        catatan.setCatatanId(autoIncrementId++);
        catatanDatabase.add(catatan);

        CatatanDataStorage.simpanKeFile(catatanDatabase);

        System.out.printf("[CatatanInterface] Catatan ditambahkan: %s (%.1f porsi = %.0f kkal)%n",
                makanan.getNamaMakanan(), catatan.getJumlahPorsi(), catatan.getTotalKalori());
        return true;
    }

    @Override
    public List<CatatanMakanann> getCatatanByTanggal(int userId, LocalDate tanggal) {
        return catatanDatabase.stream()
                .filter(c -> c.getUserId() == userId && c.getTanggal().equals(tanggal))
                .sorted((a, b) -> a.getWaktuMakan().compareTo(b.getWaktuMakan()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CatatanMakanann> getCatatanByRentang(int userId, LocalDate dari, LocalDate sampai) {
        return catatanDatabase.stream()
                .filter(c -> c.getUserId() == userId
                && !c.getTanggal().isBefore(dari)
                && !c.getTanggal().isAfter(sampai))
                .collect(Collectors.toList());
    }

    @Override
    public double getTotalKaloriHarian(int userId, LocalDate tanggal) {
        return catatanDatabase.stream()
                .filter(c -> c.getUserId() == userId && c.getTanggal().equals(tanggal))
                .mapToDouble(CatatanMakanann::getTotalKalori)
                .sum();
    }

    @Override
    public boolean updateCatatan(CatatanMakanann catatan) {
        for (int i = 0; i < catatanDatabase.size(); i++) {
            if (catatanDatabase.get(i).getCatatanId() == catatan.getCatatanId()) {
                MakananEntity makanan = makananInterface.getMakananById(catatan.getMakananId());
                if (makanan != null) {
                    catatan.setTotalKalori(makanan.getKaloriPerPorsi() * catatan.getJumlahPorsi());
                    catatan.setTotalKarbohidrat(makanan.getKarbohidrat() * catatan.getJumlahPorsi());
                    catatan.setTotalProtein(makanan.getProtein() * catatan.getJumlahPorsi());
                    catatan.setTotalLemak(makanan.getLemak() * catatan.getJumlahPorsi());
                    catatan.setNamaMakanan(makanan.getNamaMakanan());
                    catatan.setKategoriMakanan(makanan.getKategori());
                }
                catatanDatabase.set(i, catatan);

                CatatanDataStorage.simpanKeFile(catatanDatabase);

                System.out.println("[CatatanInterface] Catatan ID=" + catatan.getCatatanId() + " berhasil diperbarui.");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hapusCatatan(int catatanId) {

        boolean apakahDihapus = catatanDatabase.removeIf(c -> c.getCatatanId() == catatanId);

        if (apakahDihapus) {

            CatatanDataStorage.simpanKeFile(catatanDatabase);
            System.out.println("[CatatanInterface] Catatan ID=" + catatanId + " berhasil dihapus.");
            return true;
        }
        return false;
    }
}
