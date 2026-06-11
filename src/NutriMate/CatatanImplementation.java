package NutriMate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatatanImplementation implements CatatanInterface {

    private static List<CatatanMakanan> catatanDatabase = new ArrayList<>();
    private static int autoIncrementId = 1;
    private MakananInterface makananInterface;

    public CatatanImplementation(MakananInterface makananInterface) {
        this.makananInterface = makananInterface;
    }

    @Override
    public boolean tambahCatatan(CatatanMakanan catatan) {
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

        System.out.printf("[CatatanInterface] Catatan ditambahkan: %s (%.1f porsi = %.0f kkal)%n",
                makanan.getNamaMakanan(), catatan.getJumlahPorsi(), catatan.getTotalKalori());
        return true;
    }

    @Override
    public List<CatatanMakanan> getCatatanByTanggal(int userId, LocalDate tanggal) {
        return catatanDatabase.stream()
                .filter(c -> c.getUserId() == userId && c.getTanggal().equals(tanggal))
                .sorted((a, b) -> a.getWaktuMakan().compareTo(b.getWaktuMakan()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CatatanMakanan> getCatatanByRentang(int userId, LocalDate dari, LocalDate sampai) {
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
                .mapToDouble(CatatanMakanan::getTotalKalori)
                .sum();
    }

    @Override
    public boolean updateCatatan(CatatanMakanan catatan) {
        for (int i = 0; i < catatanDatabase.size(); i++) {
            if (catatanDatabase.get(i).getCatatanId() == catatan.getCatatanId()) {
                MakananEntity makanan = makananInterface.getMakananById(catatan.getMakananId());
                if (makanan != null) {
                    catatan.setTotalKalori(makanan.getKaloriPerPorsi() * catatan.getJumlahPorsi());
                    catatan.setTotalKarbohidrat(makanan.getKarbohidrat() * catatan.getJumlahPorsi());
                    catatan.setTotalProtein(makanan.getProtein() * catatan.getJumlahPorsi());
                    catatan.setTotalLemak(makanan.getLemak() * catatan.getJumlahPorsi());
                    catatan.setNamaMakanan(makanan.getNamaMakanan());
                }
                catatanDatabase.set(i, catatan);
                System.out.println("[CatatanInterface] Catatan ID=" + catatan.getCatatanId() + " berhasil diperbarui.");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hapusCatatan(int catatanId) {
        return catatanDatabase.removeIf(c -> {
            if (c.getCatatanId() == catatanId) {
                System.out.println("[CatatanInterface] Catatan ID=" + catatanId + " berhasil dihapus.");
                return true;
            }
            return false;
        });
    }
}
