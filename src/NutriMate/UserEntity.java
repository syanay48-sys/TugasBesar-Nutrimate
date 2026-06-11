package NutriMate;

public class UserEntity {

    private int userId;
    private String username;
    private String password;
    private String nama;
    private int umur;
    private String jenisKelamin;
    private double beratBadan;    
    private double tinggiBadan;   
    private String aktivitas;     
    private String targetDiet;    
    private double targetKalori;  

    public UserEntity() {
    }

    public UserEntity(int userId, String username, String password, String nama,
            int umur, String jenisKelamin, double beratBadan, double tinggiBadan,
            String aktivitas, String targetDiet, double targetKalori) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.umur = umur;
        this.jenisKelamin = jenisKelamin;
        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
        this.aktivitas = aktivitas;
        this.targetDiet = targetDiet;
        this.targetKalori = targetKalori;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jk) {
        this.jenisKelamin = jk;
    }

    public double getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(double bb) {
        this.beratBadan = bb;
    }

    public double getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(double tb) {
        this.tinggiBadan = tb;
    }

    public String getAktivitas() {
        return aktivitas;
    }

    public void setAktivitas(String aktivitas) {
        this.aktivitas = aktivitas;
    }

    public String getTargetDiet() {
        return targetDiet;
    }

    public void setTargetDiet(String targetDiet) {
        this.targetDiet = targetDiet;
    }

    public double getTargetKalori() {
        return targetKalori;
    }

    public void setTargetKalori(double tk) {
        this.targetKalori = tk;
    }

    @Override
    public String toString() {
        return "User{userId=" + userId + ", username='" + username + "', nama='" + nama
                + "', umur=" + umur + ", BB=" + beratBadan + "kg, TB=" + tinggiBadan
                + "cm, aktivitas='" + aktivitas + "', target='" + targetDiet + "'}";
    }
}
