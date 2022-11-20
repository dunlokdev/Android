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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterVatTu extends BaseAdapter {

    private Context context;
    private int layout;
    private List<VatTu> listVatTu = new ArrayList<VatTu>();
    final int REQUEST_CODE_EDIT = 1;

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

        // Ánh xạ view
        ImageView imgHinh = view.findViewById(R.id.imgVatTu);
        TextView txtTenVatTu = view.findViewById(R.id.txtTenVatTu);
        TextView txtGiaVatTu = view.findViewById(R.id.txtGia);
        ImageView imgEdit = view.findViewById(R.id.imgEdit);

        VatTu vatTu = listVatTu.get(i);
        String gia = vatTu.getDonGiaFormat() + "/" +  vatTu.getDonViTinh();

        // Gán giá trị
        imgHinh.setImageResource(vatTu.getIdHinh());
        txtTenVatTu.setText(String.format(vatTu.getTenVatTu()));
        txtGiaVatTu.setText(String.format(gia));

        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewGroup.getContext(),EditVatTu.class);

                Bundle bundle = new Bundle();
                VatTu vt = listVatTu.get(i);
                bundle.putSerializable("Data", vt);
                intent.putExtras(bundle);
                ((MainActivity)viewGroup.getContext()).startActivityForResult(intent, REQUEST_CODE_EDIT);
            }
        });
        return view;
    }
}
