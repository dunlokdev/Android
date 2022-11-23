package deso2.duongmyloc.dlu_2011402;

import java.util.ArrayList;
import java.util.List;

public class QuanLyVatTu {
    public static List<VatTu> DanhSachVatTu = new ArrayList<VatTu>();

    public static VatTu getVatTuById(int id) {
        for (VatTu vatTu : DanhSachVatTu) {
            if (vatTu.getMaVatTu() == id) {
                return vatTu;
            }
        }
        return null;
    }

    public static int generateIdVatTu() {
        if (DanhSachVatTu.size() > 0) {
            return DanhSachVatTu.get(DanhSachVatTu.size() - 1).getMaVatTu() + 1;
        }
        return -1;
    }
}
