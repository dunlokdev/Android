package deso2.duongmyloc.dlu_2011402;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class EditVatTuActivity extends AppCompatActivity {

    EditText tenVatTu, donGia, donViTinh;
    Button btnLuu, btnXoa, btnAnh;
    ImageView imgAnh;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_vat_tu);

        // TODO: Ánh xạ
        tenVatTu = findViewById(R.id.edTenVatTu);
        donGia = findViewById(R.id.edDonGia);
        donViTinh = findViewById(R.id.edDonVi);
        btnLuu = findViewById(R.id.btnLuu);
        btnXoa = findViewById(R.id.btnXoa);
        imgAnh = findViewById(R.id.imgAnhEdit);
        btnAnh = findViewById(R.id.btnAnh);

        // TODO: Lấy dữ liệu từ Intent MainActivity
        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 0);
        VatTu vt = QuanLyVatTu.getVatTuById(id);

        if (vt != null) {
            tenVatTu.setText(vt.getTenVatTu());
            donGia.setText(String.format("%.0f", vt.getDonGia()));
            donViTinh.setText(vt.getDonViTinh());
            if (vt.getUriHinh() != null) {
                Log.d("Image", vt.getUriHinh().toString());
                Uri uriVt = vt.getUriHinh();
                imgAnh.setImageURI(uriVt);
//                imgAnh.setImageResource(R.drawable.ic_launcher_background);
            } else {
                imgAnh.setImageResource(vt.getIdHinh());
            }
        }

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = tenVatTu.getText().toString();
                String gia = donGia.getText().toString();
                String donVi = donViTinh.getText().toString();

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

                if (uri != null) {
                    vt.setUriHinh(uri);
                }

                vt.setTenVatTu(ten);
                vt.setDonGia(convertGia);
                vt.setDonViTinh(donVi);

                Toast.makeText(getApplicationContext(), "Cập nhật dữ liệu thành công!", Toast.LENGTH_SHORT).show();
                setResult(Values.RELOAD_LIST_VIEW, intent);
                finish();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuanLyVatTu.DanhSachVatTu.remove(vt);
                Toast.makeText(getApplicationContext(), "Xoá thành công!", Toast.LENGTH_SHORT).show();
                setResult(Values.RELOAD_LIST_VIEW, intent);
                finish();
            }
        });

        btnAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
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
                    // Fix bug stop app by API high
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        getApplicationContext().getContentResolver().takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    }
                }
            }
            return;
        }
    }
}