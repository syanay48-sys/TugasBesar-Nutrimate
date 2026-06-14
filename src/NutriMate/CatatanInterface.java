package NutriMate;

import java.time.LocalDate;
import java.util.List;

public interface CatatanInterface {

    boolean tambahCatatan(CatatanMakanann catatan);

    List<CatatanMakanann> getCatatanByTanggal(int userId, LocalDate tanggal);

    List<CatatanMakanann> getCatatanByRentang(int userId, LocalDate dari, LocalDate sampai);

    double getTotalKaloriHarian(int userId, LocalDate tanggal);

    boolean updateCatatan(CatatanMakanann catatan);

    boolean hapusCatatan(int catatanId);
}
