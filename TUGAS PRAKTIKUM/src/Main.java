public class Main {

    public static void main(String[] args) {

        garis("=", 60);
        System.out.println("  DEMO PROGRAM PEMROGRAMAN LANJUT - BAB 1 s/d BAB 7");
        garis("=", 60);
        garis("-", 60);
        System.out.println("BAB 1 & 2 - Kelas Dasar Buku");
        garis("-", 60);

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

        buku1.tampilkan();
        buku2.tampilkan();

        System.out.println("Jumlah kata sinopsis buku1 : " + buku1.hitungJumlahKata());
        System.out.println("Jumlah kata sinopsis buku2 : " + buku2.hitungJumlahKata());
        System.out.println("Tingkat kesamaan buku1-buku2: " + buku1.cekKesamaan(buku2) + "%");
        System.out.println("Tingkat kesamaan buku2-buku2: " + buku2.cekKesamaan(buku2) + "%");

        Buku bukuCopy = buku1.copy();
        System.out.println("\nData hasil copy:");
        bukuCopy.tampilkan();

        garis("-", 60);
        System.out.println("BAB 3 - Overloading Method");
        garis("-", 60);

        // Simpan buku1 ke file
        buku1.simpanFile("buku1.txt");

        // Baca file ke objek baru
        Buku bukuDariFile = new Buku("", "", "", "");
        bukuDariFile.bacaFile("buku1.txt");
        System.out.println("Data dari file:");
        bukuDariFile.tampilkan();

        // hitungRoyalti - 1 parameter (10% dari total penjualan)
        double royalti1 = buku1.hitungRoyalti(75_000);
        System.out.printf("Royalti buku1 (10%% default) : Rp%,.2f%n", royalti1);

        // hitungRoyalti - 2 parameter (persentase custom)
        double royalti2 = buku1.hitungRoyalti(75_000, 15.0);
        System.out.printf("Royalti buku1 (15%% custom)  : Rp%,.2f%n", royalti2);

        garis("-", 60);
        System.out.println("BAB 4 - Encapsulation (Sistem Anggota Perpustakaan)");
        garis("-", 60);

        KoleksiBuku anggota1 = new KoleksiBuku("Andi", "5600000001", 500_000, "1234");
        KoleksiBuku anggota2 = new KoleksiBuku("Sari", "7400000002", 2_000_000, "4321");

        anggota1.tampilkanInfo();
        anggota2.tampilkanInfo();

        System.out.println(">> Anggota Gold (Andi) membeli buku seharga Rp1.500.000:");
        anggota1.beliBuku(1_500_000, "1234");

        System.out.println("\n>> Anggota Platinum (Sari) membeli buku seharga Rp1.200.000:");
        anggota2.beliBuku(1_200_000, "4321");

        System.out.println("\n>> Andi top up Rp200.000:");
        anggota1.topUp(200_000, "1234");

        System.out.println("\n>> Tes PIN salah 3x (akun akan terblokir):");
        anggota1.beliBuku(50_000, "0000");
        anggota1.beliBuku(50_000, "0000");
        anggota1.beliBuku(50_000, "0000");

        garis("-", 60);
        System.out.println("BAB 5 - Static Modifier & Konstanta Final");
        garis("-", 60);

        // Static method - panggil langsung melalui nama class
        System.out.println(">> Penjumlahan (static):");
        KalkulatorBuku.penjumlahan(150_000, 75_000);

        System.out.println(">> Pengurangan (static):");
        KalkulatorBuku.pengurangan(500_000, 125_000);

        // Non-static method - perlu buat objek dulu
        KalkulatorBuku kalk = new KalkulatorBuku();

        System.out.println(">> Perkalian (non-static):");
        kalk.perkalian(75_000, 3);

        System.out.println(">> Pembagian (non-static):");
        kalk.pembagian(300_000, 4);

        System.out.println(">> Sederhana pecahan 12/8:");
        kalk.sederhana(12, 8);

        System.out.println(">> Sederhana pecahan 100/25:");
        kalk.sederhana(100, 25);

        garis("-", 60);
        System.out.println("BAB 6 - Inheritance");
        garis("-", 60);

        BukuFisik bf = new BukuFisik(
                "Clean Code", "Robert C. Martin", "Pemrograman",
                "Panduan menulis kode yang bersih dan mudah dipahami",
                450, 431, "Baru"
        );

        BukuDigital bd = new BukuDigital(
                "Design Patterns", "Gang of Four", "Pemrograman",
                "23 pola desain yang sering digunakan dalam OOP",
                12.5, "PDF", "https://example.com/design-patterns.pdf"
        );

        bf.tampilkan();
        System.out.printf("Ongkos kirim (Rp15.000/kg) : Rp%,.2f%n%n",
                bf.hitungOngkosKirim(15_000));

        bd.tampilkan();
        System.out.printf("Estimasi unduh (10 Mbps)   : %.1f detik%n%n",
                bd.estimasiWaktuUnduh(10));

        // toString polymorphism
        Buku[] daftarBuku = { bf, bd };
        System.out.println("Daftar buku (via array Buku[]):");
        for (Buku b : daftarBuku) {
            System.out.println("  " + b);
        }

        garis("-", 60);
        System.out.println("BAB 7 - Polimorfisme (Abstract Class)");
        garis("-", 60);

        // Buat array 20 buku (campuran BukuPesanan dan BukuJadi)
        BukuAbstrak[] koleksi = new BukuAbstrak[20];

        // Isi dengan data variatif
        String[] namaBuku = {
            "Novel Laskar Pelangi", "Bumi Manusia", "Negeri 5 Menara",
            "Perahu Kertas", "Dilan 1990", "Supernova", "Saman",
            "Ronggeng Dukuh Paruk", "Tenggelamnya Kapal Van der Wijck",
            "Atheis", "Python Programming", "Java OOP", "Data Science 101",
            "Machine Learning", "Web Development", "Cloud Computing",
            "Cyber Security", "Algoritma Dasar", "Database Design", "UI/UX Handbook"
        };
        double[] hargaDasar = {
            50000, 55000, 48000, 52000, 45000, 60000, 47000,
            53000, 51000, 49000, 85000, 90000, 95000,
            110000, 80000, 100000, 92000, 75000, 88000, 105000
        };

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                // BukuPesanan: berat antara 0.3 - 1.5 kg
                double berat = 0.3 + (i % 5) * 0.3;
                koleksi[i] = new BukuPesanan(namaBuku[i], hargaDasar[i], berat);
            } else {
                // BukuJadi: jumlah antara 1 - 5
                double jumlah = 1 + (i % 5);
                koleksi[i] = new BukuJadi(namaBuku[i], hargaDasar[i], jumlah);
            }
        }

        // a. Tampilkan semua kue + jenisnya
        System.out.println("\na) Daftar semua buku (dengan jenisnya):");
        garis("-", 55);
        for (BukuAbstrak ba : koleksi) {
            String jenis = (ba instanceof BukuPesanan) ? "PESANAN" : "JADI";
            System.out.printf("  [%-7s] %-35s Rp%,.0f%n",
                    jenis, ba.getNama(), ba.hitungHarga());
        }

        // b. Total harga semua buku
        double totalSemua = 0;
        for (BukuAbstrak ba : koleksi) totalSemua += ba.hitungHarga();
        System.out.printf("%nb) Total harga semua buku    : Rp%,.2f%n", totalSemua);

        // c. Total harga dan total berat BukuPesanan
        double totalHargaPesanan = 0, totalBerat = 0;
        for (BukuAbstrak ba : koleksi) {
            if (ba instanceof BukuPesanan) {
                BukuPesanan bp = (BukuPesanan) ba;
                totalHargaPesanan += bp.hitungHarga();
                totalBerat        += bp.getBerat();
            }
        }
        System.out.printf("c) Total harga BukuPesanan   : Rp%,.2f%n", totalHargaPesanan);
        System.out.printf("   Total berat BukuPesanan   : %.1f kg%n", totalBerat);

        // d. Total harga dan total jumlah BukuJadi
        double totalHargaJadi = 0, totalJumlah = 0;
        for (BukuAbstrak ba : koleksi) {
            if (ba instanceof BukuJadi) {
                BukuJadi bj = (BukuJadi) ba;
                totalHargaJadi += bj.hitungHarga();
                totalJumlah    += bj.getJumlah();
            }
        }
        System.out.printf("d) Total harga BukuJadi      : Rp%,.2f%n", totalHargaJadi);
        System.out.printf("   Total jumlah BukuJadi     : %.0f buah%n", totalJumlah);

        // e. Buku dengan harga akhir terbesar
        BukuAbstrak terbesar = koleksi[0];
        for (BukuAbstrak ba : koleksi) {
            if (ba.hitungHarga() > terbesar.hitungHarga()) terbesar = ba;
        }
        System.out.println("\ne) Buku dengan harga terbesar:");
        System.out.println("   " + terbesar);

        garis("=", 60);
        System.out.println("  SELESAI");
        garis("=", 60);
    }

    // Helper: cetak garis separator
    static void garis(String simbol, int panjang) {
        System.out.println(simbol.repeat(panjang));
    }
}