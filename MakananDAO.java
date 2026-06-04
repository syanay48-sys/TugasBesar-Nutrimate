package nutrimate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MakananDAO {
    public List<Makanan> getAllMakanan() {
    List<Makanan> list = new ArrayList<>();
    String query = "SELECT * FROM Makanan";
    
    // Pastikan KoneksiDB.getKoneksi() dipanggil langsung di dalam kurung try seperti ini
    try (Connection conn = KoneksiDB.getKoneksi();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        
        while (rs.next()) {
            int id = rs.getInt("MakananID");
            String nama = rs.getString("Nama_Makanan");
            double kalori = rs.getDouble("Kalori");
            double protein = rs.getDouble("Protein");
            double karbohidrat = rs.getDouble("Karbohidrat");
            double lemak = rs.getDouble("Lemak");
            String kategori = rs.getString("Kategori");
            
            list.add(new Makanan(id, nama, kalori, protein, karbohidrat, lemak, kategori));
        }
    } catch (Exception e) {
        // Teks ini yang tadi memunculkan pesan error closed di console kamu
        System.out.println("Error Load Makanan: " + e.getMessage()); 
    }
    return list;
}
}