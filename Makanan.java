package nutrimate;

public class Makanan {
    private int makananId;
    private String namaMakanan;
    private double kalori;
    private double protein;     // Tambahan variabel gizi
    private double karbohidrat;  // Tambahan variabel gizi
    private double lemak;       // Tambahan variabel gizi
    private String kategori;

    // Constructor Baru yang Lengkap
    public Makanan(int makananId, String namaMakanan, double kalori, double protein, double karbohidrat, double lemak, String kategori) {
        this.makananId = makananId;
        this.namaMakanan = namaMakanan;
        this.kalori = kalori;
        this.protein = protein;
        this.karbohidrat = karbohidrat;
        this.lemak = lemak;
        this.kategori = kategori;
    }

    // Pasang Getter dan Setter yang Sesuai dengan Panggilan Tabel
    public int getIdMakanan() { 
        return makananId; 
    }

    public String getNamaMakanan() { 
        return namaMakanan; 
    }

    public double getKalori() { 
        return kalori; 
    }

    public double getProtein() { 
        return protein; 
    }

    public double getKarbohidrat() { 
        return karbohidrat; 
    }

    public double getLemak() { 
        return lemak; 
    }

    public String getKategori() { 
        return kategori; 
    }
}