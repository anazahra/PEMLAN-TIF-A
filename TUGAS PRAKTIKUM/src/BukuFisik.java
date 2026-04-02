public class BukuFisik extends Buku {
    private double beratGram;
    private int    jumlahHalaman;
    private String kondisi; 

    public BukuFisik(String judul, String penulis, String kategori, String sinopsis, double beratGram, int jumlahHalaman, String kondisi) {
        super(judul, penulis, kategori, sinopsis);
        this.beratGram     = beratGram;
        this.jumlahHalaman = jumlahHalaman;
        this.kondisi       = kondisi;
    }
    public double getBeratGram(){ 
        return beratGram; 
    }
    public int getJumlahHalaman(){ 
        return jumlahHalaman; 
    }
    public String getKondisi(){ 
        return kondisi; 
    }
    public void setBeratGram(double b){ 
        this.beratGram = b; 
    }
    public void setJumlahHalaman(int h){ 
        this.jumlahHalaman = h; 
    }
    public void setKondisi(String k){ 
        this.kondisi = k; 
    }
    public double hitungOngkosKirim(double tarifPerKg) {
        double kg = beratGram / 1000.0;
        return kg * tarifPerKg;
    }

    @Override
    public void tampilkan() {
        super.tampilkan();
        System.out.println("Berat      : " + beratGram + " gram");
        System.out.println("Halaman    : " + jumlahHalaman);
        System.out.println("Kondisi    : " + kondisi);
        System.out.println();
    }

    @Override
    public String toString() {
        return "[BukuFisik] " + getJudul() + " - " + getPenulis() + " | " + kondisi + " | " + jumlahHalaman + " hal";
    }
}