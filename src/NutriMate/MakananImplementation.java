package NutriMate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MakananImplementation implements MakananInterface {
    private static List<MakananEntity> makananDatabase = new ArrayList<>();
    private static int autoIncrementId = 1;

    static {
        makananDatabase.add(new MakananEntity(autoIncrementId++, "Nasi Putih",      200, 45.0, 4.0,  0.5, "Karbohidrat"));
        makananDatabase.add(new MakananEntity(autoIncrementId++, "Telur Dadar",     150, 1.0,  10.0, 12.0, "Protein"));
        makananDatabase.add(new MakananEntity(autoIncrementId++, "Ayam Panggang",   250, 0.0,  30.0, 14.0, "Protein"));
        makananDatabase.add(new MakananEntity(autoIncrementId++, "Oatmeal",         180, 32.0, 6.0,  3.0, "Karbohidrat"));
        makananDatabase.add(new MakananEntity(autoIncrementId++, "Apel",             80, 21.0, 0.4,  0.2, "Buah"));
        makananDatabase.add(new MakananEntity(autoIncrementId++, "Susu Low Fat",    120, 12.0, 8.0,  2.5, "Minuman"));
        makananDatabase.add(new MakananEntity(autoIncrementId++, "Nasi + Ayam + Sayur", 600, 70.0, 35.0, 15.0, "Paket"));
    }

    @Override
    public boolean tambahMakanan(MakananEntity makanan) {
        makanan.setMakananId(autoIncrementId++);
        makananDatabase.add(makanan);
        System.out.println("[MakananService] Makanan '" + makanan.getNamaMakanan() + "' berhasil ditambahkan.");
        return true;
    }

    @Override
    public List<MakananEntity> getDaftarMakanan() {
        return new ArrayList<>(makananDatabase);
    }

    @Override
    public List<MakananEntity> cariMakanan(String keyword) {
        String lower = keyword.toLowerCase();
        List<MakananEntity> hasil = makananDatabase.stream()
                .filter(m -> m.getNamaMakanan().toLowerCase().contains(lower))
                .collect(Collectors.toList());
        System.out.println("[MakananService] Ditemukan " + hasil.size() + " makanan untuk keyword '" + keyword + "'.");
        return hasil;
    }

    @Override
    public MakananEntity getMakananById(int makananId) {
        return makananDatabase.stream()
                .filter(m -> m.getMakananId() == makananId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<MakananEntity> getMakananByKategori(String kategori) {
        return makananDatabase.stream()
                .filter(m -> m.getKategori().equalsIgnoreCase(kategori))
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateMakanan(MakananEntity makanan) {
        for (int i = 0; i < makananDatabase.size(); i++) {
            if (makananDatabase.get(i).getMakananId() == makanan.getMakananId()) {
                makananDatabase.set(i, makanan);
                System.out.println("[MakananService] Makanan '" + makanan.getNamaMakanan() + "' berhasil diperbarui.");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hapusMakanan(int makananId) {
        return makananDatabase.removeIf(m -> {
            if (m.getMakananId() == makananId) {
                System.out.println("[MakananService] Makanan ID=" + makananId + " berhasil dihapus.");
                return true;
            }
            return false;
        });
    }
}