public class KoleksiBuku {
    private String namaPemilik;
    private String nomorAnggota; // 10 digit: 2 digit awal = jenis
    private double saldo;
    private String pin;
    private boolean terblokir;
    private int percobaan;
    private static final double SALDO_MINIMAL = 10_000;

    public KoleksiBuku(String namaPemilik, String nomorAnggota, double saldoAwal, String pin) {
        this.namaPemilik   = namaPemilik;
        this.nomorAnggota  = nomorAnggota;
        this.saldo         = saldoAwal;
        this.pin           = pin;
        this.terblokir     = false;
        this.percobaan     = 0;
    }
    public String getNamaPemilik(){ 
        return namaPemilik; 
    }
    public String getNomorAnggota(){ 
        return nomorAnggota; 
    }
    public double getSaldo(){ 
        return saldo; 
    }
    public boolean isTerblokir(){ 
        return terblokir; 
    }
    public String getJenisAnggota(){
        String kode = nomorAnggota.substring(0, 2);
        switch (kode) {
            case "38": return "Silver";
            case "56": return "Gold";
            case "74": return "Platinum";
            default:   return "Reguler";
        }
    }
    private double hitungCashback(double jumlahBeli) {
        if (jumlahBeli <= 1_000_000) return 0;
        String jenis = getJenisAnggota();
        switch (jenis) {
            case "Silver":   return jumlahBeli * 0.05;
            case "Gold":     return jumlahBeli * 0.07;
            case "Platinum": return jumlahBeli * 0.10;
            default:         return 0;
        }
    }
    private boolean autentikasi(String pinInput) {
        if (terblokir) {
            System.out.println("Akun terblokir! Hubungi layanan pelanggan.");
            return false;
        }
        if (pin.equals(pinInput)) {
            percobaan = 0;
            return true;
        } else {
            percobaan++;
            System.out.println("PIN salah! Percobaan ke-" + percobaan);
            if (percobaan >= 3) {
                terblokir = true;
                System.out.println("Akun diblokir karena 3x salah PIN.");
            }
            return false;
        }
    }
    public boolean beliBuku(double hargaBuku, String pinInput) {
        if (!autentikasi(pinInput)) 
            return false;

        double cashback     = hitungCashback(hargaBuku);
        double tagihan      = hargaBuku - cashback;
        double sisaSaldo    = saldo - tagihan;

        if (sisaSaldo < SALDO_MINIMAL) {
            System.out.println("Transaksi gagal. Saldo tidak mencukupi (min Rp10.000).");
            return false;
        }
        saldo = sisaSaldo + cashback; 
        if (getJenisAnggota().equals("Silver")) {
            saldo = saldo - cashback; 
        }
        System.out.println("Pembelian berhasil!");
        System.out.println("Harga     : Rp" + hargaBuku);
        System.out.println("Cashback  : Rp" + cashback);
        System.out.println("Saldo kini: Rp" + saldo);
        return true;
    }
    public boolean topUp(double jumlah, String pinInput) {
        if (!autentikasi(pinInput)) return false;
        saldo += jumlah;
        System.out.println("Top up Rp" + jumlah + " berhasil. Saldo: Rp" + saldo);
        return true;
    }
    public void tampilkanInfo() {
        System.out.println("Nama    : " + namaPemilik);
        System.out.println("No      : " + nomorAnggota);
        System.out.println("Jenis   : " + getJenisAnggota());
        System.out.println("Saldo   : Rp" + saldo);
        System.out.println("Status  : " + (terblokir ? "TERBLOKIR" : "Aktif"));
        System.out.println();
    }
}