package NutriMate;

import java.util.List;

public interface MakananInterface {

    boolean tambahMakanan(MakananEntity makanan);

    List<MakananEntity> getDaftarMakanan();

    List<MakananEntity> cariMakanan(String keyword);

    MakananEntity getMakananById(int makananId);

    List<MakananEntity> getMakananByKategori(String kategori);

    boolean updateMakanan(MakananEntity makanan);

    boolean hapusMakanan(int makananId);
}
