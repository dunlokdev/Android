package deso2.duongmyloc.dlu_2011402;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    ListView lvMain;
    AdapterVatTu adapter;
    ImageView imgEdit;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mapping
        imgEdit = findViewById(R.id.imgEdit);
        fab = findViewById(R.id.fab);

        // Create data
        QuanLyVatTu.DanhSachVatTu.add(new VatTu(1, "Cáp mạng", "met", 6000, R.drawable.cap_mang));
        QuanLyVatTu.DanhSachVatTu.add(new VatTu(2, "Đầu nối RJ45", "cái", 5000, R.drawable.dau_noi_rj45));
        QuanLyVatTu.DanhSachVatTu.add(new VatTu(3, "Giấy in A4", "ram", 80000, R.drawable.giay_in_a4));

        adapter = new AdapterVatTu(this, R.layout.activity_vat_tu_row, QuanLyVatTu.DanhSachVatTu);
        lvMain = findViewById(R.id.lvMain);
        lvMain.setAdapter(adapter);

        // Handle event button add click
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNewVatTuActivity.class);
                startActivityForResult(intent, Values.ADD_NEW);
            }
        });
    }

    // Activity main listening data result from some others activity
    // Handle cases
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // TODO: RESULT FROM ACTIONS EDIT & REMOVE
        if (resultCode == Values.RELOAD_LIST_VIEW && requestCode == Values.EDIT_DELETE_CODE && data != null) {
            adapter.notifyDataSetChanged();
        }
        // TODO: RESULT FORM ACTION ADD NEW
        if (resultCode == Values.RELOAD_LIST_VIEW && requestCode == Values.ADD_NEW && data != null) {
            adapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
