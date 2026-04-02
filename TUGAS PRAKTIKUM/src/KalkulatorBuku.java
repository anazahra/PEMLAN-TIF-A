public class KalkulatorBuku {
    public static double penjumlahan(double a, double b) {
        double hasil = a + b;
        System.out.println(a + " + " + b + " = " + hasil);
        return hasil;
    }
    public static double pengurangan(double a, double b) {
        double hasil = a - b;
        System.out.println(a + " - " + b + " = " + hasil);
        return hasil;
    }
    public double perkalian(double a, double b) {
        double hasil = a * b;
        System.out.println(a + " × " + b + " = " + hasil);
        return hasil;
    }
    public double pembagian(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Tidak bisa membagi dengan 0!");
            return 0;
        }
        double hasil = a / b;
        System.out.println(a + " ÷ " + b + " = " + hasil);
        return hasil;
    }
    public String sederhana(int pembilang, int penyebut) {
        if (penyebut == 0) return "Penyebut tidak boleh 0";
        int fpb = cariKPB(Math.abs(pembilang), Math.abs(penyebut));
        int p = pembilang / fpb;
        int q = penyebut  / fpb;
        if (q < 0) { p = -p; q = -q; } // pastikan penyebut positif
        if (q == 1) return p + "";
        System.out.println(pembilang + "/" + penyebut + " disederhanakan menjadi: " + p + "/" + q);
        return p + "/" + q;
    }
    private int cariKPB(int a, int b) {
        while (b != 0) {
            int sisa = a % b;
            a = b;
            b = sisa;
        }
        return a;
    }
}