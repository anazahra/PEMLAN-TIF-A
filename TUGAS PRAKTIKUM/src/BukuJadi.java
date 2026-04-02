public class BukuJadi extends BukuAbstrak {
    private double jumlah;

    public BukuJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public double getJumlah(){ 
        return jumlah; 
    }
    public void setJumlah(double j){ 
        this.jumlah = j; 
    }

    @Override
    public double hitungHarga() {
        return getHarga() * jumlah * 2;
    }

    @Override
    public String toString() {
        return "[Buku Jadi]\n" + super.toString() + "\nJumlah: " + jumlah + " buah";
    }
}