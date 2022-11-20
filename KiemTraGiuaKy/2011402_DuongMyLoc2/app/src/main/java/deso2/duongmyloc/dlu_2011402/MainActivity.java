package deso2.duongmyloc.dlu_2011402;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    ListView lvMain;
    List<VatTu> vatTuList = new ArrayList<VatTu>();
    AdapterVatTu adapter;
    final int CODE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ
        lvMain = findViewById(R.id.lvMain);

        // Khoi tao danh sach vat tu
        vatTuList.add(new VatTu("1", "Cáp mạng", "met", 6000, R.drawable.cap_mang));
        vatTuList.add(new VatTu("2", "Đầu nối RJ45", "cái", 5000, R.drawable.dau_noi_rj45));
        vatTuList.add(new VatTu("3", "Giấy in A4", "ram", 80000, R.drawable.giay_in_a4));

        // Dùng Adapter chuyển dữ liệu vào ListView
        adapter = new AdapterVatTu(MainActivity.this, R.layout.activity_item_vat_tu, vatTuList);
        lvMain.setAdapter(adapter);
    }

    // Nhận kết quả từ ActivityEdit
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODE_REQUEST && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            VatTu vatTuNew = (VatTu) bundle.getSerializable("data_update");

            // Get index
            int index = IntStream.range(0, vatTuList.size())
                    .filter(i -> vatTuList.get(i).get_maVatTu().equals(vatTuNew.get_maVatTu()))
                    .findFirst()
                    .orElse(-1);
            Log.w("Show", String.valueOf(index));

            // Update vatTuList
            vatTuList.set(index, vatTuNew);
            // Load lại ListView
            adapter.notifyDataSetChanged();
        }
    }
}