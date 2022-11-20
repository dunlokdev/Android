package deso2.duongmyloc.dlu_2011402;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    ListView lvMain;
    List<VatTu> listVatTu = new ArrayList<VatTu>();
    AdapterVatTu adapter;
    ImageView imgEdit;
    FloatingActionButton fab;
    final int REQUEST_CODE_EDIT = 1;
    final int REQUEST_CODE_ADD = 2;
    final int REQUEST_CODE_DELETE = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgEdit = findViewById(R.id.imgEdit);
        fab = findViewById(R.id.fab);

        // Khoi tao danh sach vat tu
        listVatTu.add(new VatTu("1", "Cáp mạng", "met", 6000, R.drawable.cap_mang));
        listVatTu.add(new VatTu("2", "Đầu nối RJ45", "cái", 5000, R.drawable.dau_noi_rj45));
        listVatTu.add(new VatTu("3", "Giấy in A4", "ram", 80000, R.drawable.giay_in_a4));

        adapter = new AdapterVatTu(this, R.layout.vat_tu_item, listVatTu);
        lvMain = findViewById(R.id.lvMain);
        lvMain.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast toast = Toast.makeText(
//                        MainActivity.this,
//                        "Add new VatTu",
//                        Toast.LENGTH_SHORT
//                );
//                toast.show();
                Intent intent = new Intent(MainActivity.this, AddNewVatTu.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();

            VatTu vt = (VatTu) bundle.getSerializable("Data2");
            int index = IntStream.range(0, listVatTu.size())
                    .filter(i -> listVatTu.get(i).getMaVatTu().equals(vt.getMaVatTu()))
                    .findFirst()
                    .orElse(-1);
            Log.w("Show", String.valueOf(index));
            listVatTu.set(index, vt);
            adapter.notifyDataSetChanged();
        }
        if (requestCode == REQUEST_CODE_EDIT && resultCode == REQUEST_CODE_DELETE && data != null) {

            String id = data.getStringExtra("id");
            int index = IntStream.range(0, listVatTu.size())
                    .filter(i -> listVatTu.get(i).getMaVatTu().equals(id))
                    .findFirst()
                    .orElse(-1);
            Log.w("Show", String.valueOf(index));
            listVatTu.remove(index);
            adapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}