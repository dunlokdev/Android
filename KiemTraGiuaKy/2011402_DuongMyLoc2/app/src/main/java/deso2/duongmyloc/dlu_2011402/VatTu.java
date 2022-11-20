package deso2.duongmyloc.dlu_2011402;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class VatTu implements Serializable {
    //  Mã vật tư, tên vật tư, đơn vị tính, đơn giá, hình.
    private String _maVatTu;
    private String _tenVatTu;
    private String _donViTinh;
    private double _donGia;
    private int _idHinhAnh;

    // Constructor: Alt + Ins

    public VatTu(String _maVatTu, String _tenVatTu, String _donViTinh, double _donGia, int _idHinhAnh) {
        this._maVatTu = _maVatTu;
        this._tenVatTu = _tenVatTu;
        this._donViTinh = _donViTinh;
        this._donGia = _donGia;
        this._idHinhAnh = _idHinhAnh;
    }

    // Getter & Setter

    public String get_maVatTu() {
        return _maVatTu;
    }

    public void set_maVatTu(String _maVatTu) {
        this._maVatTu = _maVatTu;
    }

    public String get_tenVatTu() {
        return _tenVatTu;
    }

    public void set_tenVatTu(String _tenVatTu) {
        this._tenVatTu = _tenVatTu;
    }

    public String get_donViTinh() {
        return _donViTinh;
    }

    public void set_donViTinh(String _donViTinh) {
        this._donViTinh = _donViTinh;
    }

    public double get_donGia() {
        return _donGia;
    }

    public void set_donGia(double _donGia) {
        this._donGia = _donGia;
    }

    public int get_idHinhAnh() {
        return _idHinhAnh;
    }

    public void set_idHinhAnh(int _idHinhAnh) {
        this._idHinhAnh = _idHinhAnh;
    }

    // Get giá đã format theo chuẩn tiền Việt Nam
    public String get_donGiaFormatVND() {
        return Format(_donGia);
    }
    // Format tiền
    public String Format(double currencyAmount) {
        // Create a new Locale
        Locale vnd = new Locale("vi", "VN");
        // Create a Currency instance for the Locale
        Currency dollars = Currency.getInstance(vnd);
        // Create a formatter given the Locale
        NumberFormat vietnamFormat = NumberFormat.getCurrencyInstance(vnd);
        return vietnamFormat.format(currencyAmount);
    }
}
