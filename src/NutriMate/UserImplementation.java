package NutriMate;

import java.util.ArrayList;
import java.util.List;

public class UserImplementation implements UserInterface {
    private static List<UserEntity> userDatabase = new ArrayList<>();
    private static int autoIncrementId = 1;

    static {
        UserEntity demoUser = new UserEntity(
            autoIncrementId++, "andi", "andi123", "Andi",
            25, "Laki-laki", 70.0, 170.0,
            "Sedang (3-5 hari/minggu)", "Menurunkan Berat Badan", 2000.0
        );
        userDatabase.add(demoUser);
    }

    @Override
    public boolean registrasi(UserEntity user) {
        for (UserEntity u : userDatabase) {
            if (u.getUsername().equalsIgnoreCase(user.getUsername())) {
                System.out.println("[UserService] Registrasi gagal: username '" + user.getUsername() + "' sudah digunakan.");
                return false;
            }
        }
        user.setUserId(autoIncrementId++);
        userDatabase.add(user);
        System.out.println("[UserService] Registrasi berhasil: " + user.getNama());
        return true;
    }

    @Override
    public UserEntity login(String username, String password) {
        for (UserEntity u : userDatabase) {
            if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
                System.out.println("[UserService] Login berhasil: Selamat datang, " + u.getNama() + "!");
                return u;
            }
        }
        System.out.println("[UserService] Login gagal: username atau password salah.");
        return null;
    }

    @Override
    public UserEntity getProfil(int userId) {
        for (UserEntity u : userDatabase) {
            if (u.getUserId() == userId) return u;
        }
        System.out.println("[UserService] Pengguna dengan ID " + userId + " tidak ditemukan.");
        return null;
    }

    @Override
    public boolean updateProfil(UserEntity user) {
        for (int i = 0; i < userDatabase.size(); i++) {
            if (userDatabase.get(i).getUserId() == user.getUserId()) {
                userDatabase.set(i, user);
                System.out.println("[UserService] Profil " + user.getNama() + " berhasil diperbarui.");
                return true;
            }
        }
        System.out.println("[UserService] Gagal update: pengguna tidak ditemukan.");
        return false;
    }

    @Override
    public boolean hapusAkun(int userId) {
        return userDatabase.removeIf(u -> {
            if (u.getUserId() == userId) {
                System.out.println("[UserService] Akun userId=" + userId + " berhasil dihapus.");
                return true;
            }
            return false;
        });
    }
}