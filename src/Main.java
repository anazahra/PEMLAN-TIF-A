class Buku {
    String judul;
    String penulis;
    String kategori;
    String sinopsis;

    // Constructor
    Buku(String judul, String penulis, String kategori, String sinopsis) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.sinopsis = sinopsis;
    }

    // Method hitung jumlah kata sinopsis
    int hitungJumlahKata() {
        String[] kata = sinopsis.split(" ");
        return kata.length;
    }

    // Method cek tingkat kesamaan
    int cekKesamaan(Buku bukuLain) {
        int sama = 0;
        int total = 4;

        if (this.judul.equals(bukuLain.judul)) sama++;
        if (this.penulis.equals(bukuLain.penulis)) sama++;
        if (this.kategori.equals(bukuLain.kategori)) sama++;
        if (this.sinopsis.equals(bukuLain.sinopsis)) sama++;

        return (sama * 100) / total;
    }

    // Method copy
    Buku copy() {
        return new Buku(this.judul, this.penulis, this.kategori, this.sinopsis);
    }

    void tampilkan() {
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Kategori: " + kategori);
        System.out.println("Sinopsis: " + sinopsis);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        Buku buku1 = new Buku(
                "AI Modern",
                "Budi Santoso",
                "Teknologi",
                "Buku ini membahas konsep kecerdasan buatan modern secara mendalam"
        );

        Buku buku2 = new Buku(
                "Spesialis Tanaman Obat & Kesehatan",
                "Budi Santoso",
                "Tanaman & Kesehatan",
                "Buku ini membahas konsep tanaman obat untuk kesehatan"
        );

        // Tampilkan data
        buku1.tampilkan();
        buku2.tampilkan();

        // Hitung jumlah kata
        System.out.println("Jumlah kata sinopsis: " + buku1.hitungJumlahKata());
        System.out.println("Jumlah kata sinopsis: " + buku2.hitungJumlahKata());

        // Cek kesamaan
        System.out.println("Tingkat kesamaan: " + buku1.cekKesamaan(buku2) + "%");
        System.out.println("Tingkat kesamaan: " + buku2.cekKesamaan(buku2) + "%");

        // Copy object
        Buku bukuCopy = buku1.copy();
        System.out.println("\nData hasil copy:");
        bukuCopy.tampilkan();
    }
}