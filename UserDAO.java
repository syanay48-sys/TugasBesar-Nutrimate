package nutrimate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public boolean loginUser(String username, String password) {
        String query = "SELECT * FROM User WHERE Username = ? AND Password = ?";
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next(); 
        } catch (Exception e) {
            System.out.println("Error Login: " + e.getMessage());
            return false;
        }
    }
}
