package nutrimate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDB {
    private static Connection koneksi;

    public static Connection getKoneksi() {
    try {
        String url = "jdbc:mysql://localhost:3306/nutrimate";
        String user = "root";
        String pass = ""; // Sesuaikan dengan password MySQL kalian jika ada
        return DriverManager.getConnection(url, user, pass);
    } catch (Exception e) {
        System.out.println("Koneksi Gagal: " + e.getMessage());
        return null;
    }

    }
}
