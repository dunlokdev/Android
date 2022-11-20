package deso2.duongmyloc.dlu_2011402;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterVatTu extends BaseAdapter {

    private Context context;
    private int layout;
    private List<VatTu> vatTuList = new ArrayList<VatTu>();
    final int CODE_REQUEST = 1;


    // Contructor

    public AdapterVatTu(Context context, int layout, List<VatTu> vatTuList) {
        this.context = context;
        this.layout = layout;
        this.vatTuList = vatTuList;
    }

    // Số lượng item hiển thị ở ListView
    @Override
    public int getCount() {
        return vatTuList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Chuyển Layout XML -> View
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        // Ánh xạ
        ImageView imgHinh = view.findViewById(R.id.imgHinh);
        TextView txtTen = view.findViewById(R.id.txtTen);
        TextView txtGia = view.findViewById(R.id.txtGia);
        ImageView icEdit = view.findViewById(R.id.icEdit);

        // Đổ dữ liệu xuống giao diện
        VatTu vt = vatTuList.get(i);

        imgHinh.setImageResource(vt.get_idHinhAnh());
        txtTen.setText(vt.get_tenVatTu());
        String gia = vt.get_donGiaFormatVND() + "/" + vt.get_donViTinh();
        txtGia.setText(gia);

        // Khi người dùng click
        icEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewGroup.getContext(), EditActivity.class);
                // Đóng gói dữ liệu cần chuyển lên màn hình Edit
                Bundle bundle = new Bundle();
                bundle.putSerializable("DuLieuEdit", vt);
                intent.putExtras(bundle);
                ((MainActivity)viewGroup.getContext()).startActivityForResult(intent, CODE_REQUEST);
            }
        });

        return view;
    }
}
