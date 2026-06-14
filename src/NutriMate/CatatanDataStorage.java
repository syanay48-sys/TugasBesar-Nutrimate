package NutriMate;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CatatanDataStorage {
    private static final String FILE_PATH = "catatan_makanan.txt";
 
    public static void simpanKeFile(List<CatatanMakanann> daftarCatatan) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (CatatanMakanann c : daftarCatatan) {
                String barisData = c.getCatatanId() + "|"
                        + c.getUserId() + "|"
                        + c.getMakananId() + "|"
                        + c.getTanggal() + "|"
                        + c.getWaktuMakan() + "|"
                        + c.getJumlahPorsi() + "|"
                        + c.getTotalKalori() + "|"
                        + c.getNamaMakanan() + "|"
                        + c.getKategoriMakanan();
                
                writer.write(barisData);
                writer.newLine();
            }
            System.out.println("[CatatanDataStorage] Data dicadangkan.");
        } catch (IOException e) {
            System.err.println("[CatatanDataStorage] Gagal menulis: " + e.getMessage());
        }
    }
 
    public static List<CatatanMakanann> bacaDariFile() {
        List<CatatanMakanann> daftarCatatan = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return daftarCatatan;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                String[] data = baris.split("\\|");
                if (data.length >= 9) {
                    CatatanMakanann c = new CatatanMakanann();
                    c.setCatatanId(Integer.parseInt(data[0]));
                    c.setUserId(Integer.parseInt(data[1]));
                    c.setMakananId(Integer.parseInt(data[2]));
                    c.setTanggal(LocalDate.parse(data[3]));
                    c.setWaktuMakan(LocalTime.parse(data[4]));
                    c.setJumlahPorsi(Double.parseDouble(data[5]));
                    c.setTotalKalori(Double.parseDouble(data[6]));
                    c.setNamaMakanan(data[7]);
                    c.setKategoriMakanan(data[8]);
                    
                    daftarCatatan.add(c);
                }
            }
            System.out.println("[CatatanDataStorage] Data dimuat.");
        } catch (IOException | RuntimeException e) {
            System.err.println("[CatatanDataStorage] Gagal membaca: " + e.getMessage());
        }
        return daftarCatatan;
    }
}