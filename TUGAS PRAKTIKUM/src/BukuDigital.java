public class BukuDigital extends Buku {
    private double ukuranFileMB;
    private String format;    
    private String urlUnduh;

    public BukuDigital(String judul, String penulis, String kategori, String sinopsis, double ukuranFileMB, String format, String urlUnduh) {
        super(judul, penulis, kategori, sinopsis);
        this.ukuranFileMB = ukuranFileMB;
        this.format       = format;
        this.urlUnduh     = urlUnduh;
    }
    public double getUkuranFileMB(){ 
        return ukuranFileMB; 
    }
    public String getFormat(){ 
        return format; 
    }
    public String getUrlUnduh(){ 
        return urlUnduh; 
    }
    public void setUkuranFileMB(double u){ 
        this.ukuranFileMB = u; 
    }
    public void setFormat(String f){ 
        this.format = f; 
    }
    public void setUrlUnduh(String u){ 
        this.urlUnduh = u; 
    }
    public double estimasiWaktuUnduh(double kecepatanMbps) {
        return (ukuranFileMB * 8) / kecepatanMbps; 
    }

    @Override
    public void tampilkan() {
        super.tampilkan();
        System.out.println("Format     : " + format);
        System.out.println("Ukuran     : " + ukuranFileMB + " MB");
        System.out.println("URL Unduh  : " + urlUnduh);
        System.out.println();
    }

    @Override
    public String toString() {
        return "[BukuDigital] " + getJudul() + " - " + getPenulis()
                + " | " + format + " | " + ukuranFileMB + " MB";
    }
}