public class BukuPesanan extends BukuAbstrak {
    private double berat; // dalam kg

    public BukuPesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }
    public double getBerat(){ 
        return berat; 
    }
    public void setBerat(double b){ 
        this.berat = b; 
    }

    @Override
    public double hitungHarga() {
        return getHarga() * berat;
    }

    @Override
    public String toString() {
        return "[Buku Pesanan]\n" + super.toString() + "\nBerat : " + berat + " kg";
    }
}