package NutriMate;

import java.time.LocalDate;
import java.util.List;

public interface LaporanInterface {
    LaporanEntity buatLaporanHarian(int userId, LocalDate tanggal);
    LaporanEntity getLaporanHarian(int userId, LocalDate tanggal);
    List<LaporanEntity> getLaporan7Hari(int userId);
    List<LaporanEntity> getLaporanByRentang(int userId, LocalDate dari, LocalDate sampai);
}