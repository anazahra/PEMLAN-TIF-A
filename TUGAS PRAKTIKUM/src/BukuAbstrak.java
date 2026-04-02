public abstract class BukuAbstrak {
    private String nama;
    private double harga;

    public BukuAbstrak(String nama, double harga) {
        this.nama  = nama;
        this.harga = harga;
    }
    public String getNama(){ 
        return nama; 
    }
    public double getHarga(){ 
        return harga; 
    }
    public void setNama(String n){ 
        this.nama  = n; 
    }
    public void setHarga(double h){ 
        this.harga = h; 
    }
    public abstract double hitungHarga();

    @Override
    public String toString() {
        return "Nama  : " + nama + "\nHarga Akhir: Rp" + String.format("%,.2f", hitungHarga());
    }
}