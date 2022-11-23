package deso2.duongmyloc.dlu_2011402;

import android.app.Activity;
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
    private List<VatTu> listVatTu = new ArrayList<VatTu>();

    public AdapterVatTu(Context context, int layout, List<VatTu> listVatTu) {
        this.context = context;
        this.layout = layout;
        this.listVatTu = listVatTu;
    }

    @Override
    public int getCount() {
        // Số lượng item hiển thị lên listview
        return listVatTu.size();
    }

    @Override
    public Object getItem(int i) {
        return listVatTu.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // layout: chính là item list view custom
        view = inflater.inflate(layout, null);

        // Mapping view
        ImageView imgHinh = view.findViewById(R.id.imgVatTu);
        TextView txtTenVatTu = view.findViewById(R.id.txtTenVatTu);
        TextView txtGiaVatTu = view.findViewById(R.id.txtGia);
        ImageView btnEdit = view.findViewById(R.id.imgEdit);

        // Get item VatTu in List by index
        VatTu vatTu = listVatTu.get(i);
        String gia = vatTu.getDonGiaFormat() + "/" +  vatTu.getDonViTinh();

        // Gán giá trị
        if (vatTu.getUriHinh() != null) {
            imgHinh.setImageURI(vatTu.getUriHinh());
        } else {
            imgHinh.setImageResource(vatTu.getIdHinh());
        }
        txtTenVatTu.setText(String.format(vatTu.getTenVatTu()));
        txtGiaVatTu.setText(String.format(gia));

        // TODO: HANDLE EVENT ON CLICK BUTTON EDIT
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewGroup.getContext(), EditVatTuActivity.class);
                intent.putExtra("ID", vatTu.getMaVatTu());
                ((MainActivity)viewGroup.getContext()).startActivityForResult(intent, Values.EDIT_DELETE_CODE);
            }
        });
        return view;
    }
}
