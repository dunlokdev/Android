package deso2.duongmyloc.dlu_2011402;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditVatTu extends AppCompatActivity {

    EditText tenVatTu, donGia, donViTinh;
    Button btnLuu, btnXoa;
    final int REQUEST_CODE_DELETE = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_vat_tu);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        tenVatTu = findViewById(R.id.edTenVatTu);
        donGia = findViewById(R.id.edDonGia);
        donViTinh = findViewById(R.id.edDonVi);
        btnLuu = findViewById(R.id.btnLuu);
        btnXoa = findViewById(R.id.btnXoa);

        if (bundle != null) {
            VatTu vt = (VatTu) bundle.getSerializable("Data");
            tenVatTu.setText(vt.getTenVatTu());
            donGia.setText(String.format("%.0f" , vt.getDonGia()));
            donViTinh.setText(vt.getDonViTinh());

            btnLuu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Id = vt.getMaVatTu();
                    String ten = tenVatTu.getText().toString();
                    Double gia = Double.parseDouble(donGia.getText().toString());
                    int idHinh = vt.getIdHinh();
                    String donVi = donViTinh.getText().toString();

                    VatTu vatTu = new VatTu(Id, ten, donVi, gia, idHinh);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();

                    bundle.putSerializable("Data2", vatTu);
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
            btnXoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("id", vt.getMaVatTu());
                    setResult(REQUEST_CODE_DELETE, intent);
                    finish();
                }
            });
        }
    }
}