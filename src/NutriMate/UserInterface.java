package NutriMate;

public interface UserInterface {
    boolean registrasi(UserEntity user);
    UserEntity login(String username, String password);
    UserEntity getProfil(int userId);
    boolean updateProfil(UserEntity user);
    boolean hapusAkun(int userId);
}