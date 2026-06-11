package NutriMate;

import java.time.LocalDate;
import java.util.List;

public interface CatatanInterface {
    boolean tambahCatatan(CatatanMakanan catatan);
    List<CatatanMakanan> getCatatanByTanggal(int userId, LocalDate tanggal);
    List<CatatanMakanan> getCatatanByRentang(int userId, LocalDate dari, LocalDate sampai);
    double getTotalKaloriHarian(int userId, LocalDate tanggal);
    boolean updateCatatan(CatatanMakanan catatan);
    boolean hapusCatatan(int catatanId);
}