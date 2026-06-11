package NutriMate;

public class MakananEntity {
    private int makananId;
    private String namaMakanan;
    private double kaloriPerPorsi;  // kkal
    private double karbohidrat;     // gram
    private double protein;         // gram
    private double lemak;           // gram
    private String kategori;        // Karbohidrat / Protein / Buah / Minuman / dll

    public MakananEntity() {}

    public MakananEntity(int makananId, String namaMakanan, double kaloriPerPorsi,
                   double karbohidrat, double protein, double lemak, String kategori) {
        this.makananId = makananId;
        this.namaMakanan = namaMakanan;
        this.kaloriPerPorsi = kaloriPerPorsi;
        this.karbohidrat = karbohidrat;
        this.protein = protein;
        this.lemak = lemak;
        this.kategori = kategori;
    }
 
    public int getMakananId()                         { return makananId; }
    public void setMakananId(int id)                  { this.makananId = id; }
    public String getNamaMakanan()                    { return namaMakanan; }
    public void setNamaMakanan(String nama)           { this.namaMakanan = nama; }
    public double getKaloriPerPorsi()                 { return kaloriPerPorsi; }
    public void setKaloriPerPorsi(double kalori)      { this.kaloriPerPorsi = kalori; }
    public double getKarbohidrat()                    { return karbohidrat; }
    public void setKarbohidrat(double karbo)          { this.karbohidrat = karbo; }
    public double getProtein()                        { return protein; }
    public void setProtein(double protein)            { this.protein = protein; }
    public double getLemak()                          { return lemak; }
    public void setLemak(double lemak)                { this.lemak = lemak; }
    public String getKategori()                       { return kategori; }
    public void setKategori(String kategori)          { this.kategori = kategori; }

    @Override
    public String toString() {
        return "Makanan{id=" + makananId + ", nama='" + namaMakanan + "', kalori=" +
               kaloriPerPorsi + "kkal, karbo=" + karbohidrat + "g, protein=" +
               protein + "g, lemak=" + lemak + "g, kategori='" + kategori + "'}";
    }
}