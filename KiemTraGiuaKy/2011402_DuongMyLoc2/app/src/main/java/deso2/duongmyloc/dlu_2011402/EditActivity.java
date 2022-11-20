package deso2.duongmyloc.dlu_2011402;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    Button btnEdit, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // Ánh xạ
        btnEdit = findViewById(R.id.btnLuu);
        EditText edTen = (EditText) findViewById(R.id.edTenVatTu);
        EditText edGia = (EditText) findViewById(R.id.edDonGia);
        EditText edDonViTinh = (EditText) findViewById(R.id.edDonVi);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        VatTu vt = (VatTu) bundle.getSerializable("DuLieuEdit");

        // Đổ dữ liệu vào
        edTen.setText(vt.get_tenVatTu());
        edGia.setText(String.format("%.0f", vt.get_donGia()));
        edDonViTinh.setText(vt.get_donViTinh());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy dữ liệu từ các EditText
                String ma = vt.get_maVatTu();
                String ten = edTen.getText().toString();
                double gia = Double.parseDouble(edGia.getText().toString());
                String donVi = edDonViTinh.getText().toString();
                int idHinh = vt.get_idHinhAnh();

                VatTu vatTuNew = new VatTu(ma, ten, donVi, gia, idHinh);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();

                bundle.putSerializable("data_update", vatTuNew);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}