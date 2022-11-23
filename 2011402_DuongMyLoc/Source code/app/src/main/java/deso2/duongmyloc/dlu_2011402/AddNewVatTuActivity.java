package deso2.duongmyloc.dlu_2011402;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddNewVatTuActivity extends AppCompatActivity {

    ImageView imgAnh;
    Button btnAnh, btnAdd;
    EditText edTenVatTu, edDonGia, edDonVi;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vat_tu);

        // TODO: Ánh xạ:
        imgAnh = findViewById(R.id.imgAnh);
        btnAnh = findViewById(R.id.btnAnh);
        btnAdd = findViewById(R.id.btnAdd);
        edTenVatTu = findViewById(R.id.edTenVatTu);
        edDonGia = findViewById(R.id.edDonGia);
        edDonVi = findViewById(R.id.edDonVi);

        // TODO: Handle choose button image
        btnAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

        // TODO: Handle button add new VatTu
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                int id = QuanLyVatTu.generateIdVatTu();
                String ten = edTenVatTu.getText().toString();
                String gia = edDonGia.getText().toString();
                String donVi = edDonVi.getText().toString();
                int idHinh = R.drawable.ic_launcher_background;

                if (ten.equals("") ||
                        gia.equals("") ||
                        donVi.equals("")) {
                    Toast toast = Toast.makeText(
                            getApplicationContext(),
                            "Vui lòng nhập đầy đủ thông tin",
                            Toast.LENGTH_SHORT
                    );
                    toast.show();

                    return;
                }
                Double convertGia = Double.parseDouble(gia);
                VatTu vt;
                if (uri != null) {
                    vt = new VatTu(id, ten, donVi, convertGia, uri);
                } else {
                    vt = new VatTu(id, ten, donVi, convertGia, idHinh);
                }

                QuanLyVatTu.DanhSachVatTu.add(vt);

                Toast.makeText(getApplicationContext(), "Thêm vật tư thành công!", Toast.LENGTH_SHORT).show();
                setResult(Values.RELOAD_LIST_VIEW, intent);
                finish();
            }
        });


    }
    private void chooseImage() {
        Intent intent;

        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
        } else {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        }

        intent.setType("image/*");
        startActivityForResult(intent, Values.CHOOSE_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Values.CHOOSE_IMAGE) {
            if (data != null) {
                uri = data.getData();
                if (uri != null) {
                    imgAnh.setImageURI(uri);
                    // FIXME: 11/23/2022 stop app by API high
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        getApplicationContext().getContentResolver().takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    }
                }
            }
            return;
        }
    }
}