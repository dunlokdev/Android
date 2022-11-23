package deso2.duongmyloc.dlu_2011402;

import android.net.Uri;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class VatTu implements Serializable {
    private int maVatTu;
    private String tenVatTu;
    private String donViTinh;
    private double donGia;
    private int idHinh;
    private Uri uriHinh;

    public VatTu(int maVatTu, String tenVatTu, String donViTinh, double donGia, int idHinh) {
        this.maVatTu = maVatTu;
        this.tenVatTu = tenVatTu;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
        this.idHinh = idHinh;
    }

    public VatTu(int maVatTu, String tenVatTu, String donViTinh, double donGia, Uri uriHinh) {
        this.maVatTu = maVatTu;
        this.tenVatTu = tenVatTu;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
        this.uriHinh = uriHinh;
    }

    public String Format(double currencyAmount) {
        // Create a new Locale
        Locale vnd = new Locale("vi", "VN");
        // Create a Currency instance for the Locale
        Currency dollars = Currency.getInstance(vnd);
        // Create a formatter given the Locale
        NumberFormat vietnamFormat = NumberFormat.getCurrencyInstance(vnd);
        return vietnamFormat.format(currencyAmount);
    }

    // Getter & Setter
    public int getMaVatTu() {
        return maVatTu;
    }

    public void setMaVatTu(int maVatTu) {
        this.maVatTu = maVatTu;
    }

    public String getTenVatTu() {
        return tenVatTu;
    }

    public void setTenVatTu(String tenVatTu) {
        this.tenVatTu = tenVatTu;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getDonGiaFormat() {

        return Format(donGia);
    }

    public double getDonGia() {

        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getIdHinh() {
        return idHinh;
    }

    public void setIdHinh(int idHinh) {
        this.idHinh = idHinh;
    }

    public Uri getUriHinh() {
        return uriHinh;
    }

    public void setUriHinh(Uri uriHinh) {
        this.uriHinh = uriHinh;
    }
}
