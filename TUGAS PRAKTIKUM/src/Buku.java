import java.io.*;
import java.util.Scanner;

public class Buku {
    private String judul;
    private String penulis;
    private String kategori;
    private String sinopsis;

    public Buku(String judul, String penulis, String kategori, String sinopsis) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.sinopsis = sinopsis;
    }
    public String getJudul(){ 
        return judul; 
    }
    public String getPenulis(){ 
        return penulis; 
    }
    public String getKategori(){ 
        return kategori; 
    }
    public String getSinopsis(){ 
        return sinopsis; 
    }
    public void setJudul(String judul){ 
        this.judul = judul; 
    }
    public void setPenulis(String penulis) { 
        this.penulis = penulis; 
    }
    public void setKategori(String kategori){ 
        this.kategori = kategori; 
    }
    public void setSinopsis(String sinopsis){ 
        this.sinopsis = sinopsis; 
    }
    public int hitungJumlahKata() {
        if (sinopsis == null || sinopsis.trim().isEmpty()) return 0;
        return sinopsis.trim().split("\\s+").length;
    }
    public int cekKesamaan(Buku bukuLain) {
        int sama = 0;
        int total = 4;
        if (this.judul.equals(bukuLain.judul))       sama++;
        if (this.penulis.equals(bukuLain.penulis))   sama++;
        if (this.kategori.equals(bukuLain.kategori)) sama++;
        if (this.sinopsis.equals(bukuLain.sinopsis)) sama++;
        return (sama * 100) / total;
    }
    public Buku copy() {
        return new Buku(this.judul, this.penulis, this.kategori, this.sinopsis);
    }
    public void tampilkan() {
        System.out.println("Judul    : " + judul);
        System.out.println("Penulis  : " + penulis);
        System.out.println("Kategori : " + kategori);
        System.out.println("Sinopsis : " + sinopsis);
        System.out.println();
    }
    public void bacaFile(String pathFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String baris = br.readLine();
            if (baris != null) {
                String[] data = baris.split(";");
                if (data.length >= 4) {
                    this.judul    = data[0].trim();
                    this.penulis  = data[1].trim();
                    this.kategori = data[2].trim();
                    this.sinopsis = data[3].trim();
                    System.out.println("Data berhasil dibaca dari file: " + pathFile);
                } else {
                    System.out.println("Format file tidak sesuai. Gunakan: judul;penulis;kategori;sinopsis");
                }
            }
        } catch (IOException e) {
            System.out.println("Error membaca file: " + e.getMessage());
        }
    }
    public void simpanFile(String namaFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile))) {
            bw.write(judul + ";" + penulis + ";" + kategori + ";" + sinopsis);
            System.out.println("Data berhasil disimpan ke file: " + namaFile);
        } catch (IOException e) {
            System.out.println("Error menyimpan file: " + e.getMessage());
        }
    }
    public double hitungRoyalti(double hargaBuku) {
        int jumlahTerjual = hitungJumlahKata();
        double totalPenjualan = hargaBuku * jumlahTerjual;
        return totalPenjualan * 0.10; 
    }
    public double hitungRoyalti(double hargaBuku, double persenRoyalti) {
        int jumlahTerjual = hitungJumlahKata();
        double totalPenjualan = hargaBuku * jumlahTerjual;
        return totalPenjualan * (persenRoyalti / 100.0);
    }
}