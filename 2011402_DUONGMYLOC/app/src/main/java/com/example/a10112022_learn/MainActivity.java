package com.example.a10112022_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btnShow, btnSearch;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initialize();
    }
    private void Initialize() {
        this.btnShow = (Button) findViewById(R.id.btnShow);
        this.editText = (EditText) findViewById(R.id.tvShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ShowInfoActiviti.class);
                intent.putExtra("value", editText.getText().toString());
                v.getContext().startActivity(intent);
            }
        });

        this.btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "straight hitting golf clubs");
                startActivity(intent);
            }
        });

        Button btnDialer = findViewById(R.id.btnPhoneDialer);
        EditText txtInput = findViewById(R.id.txtInput);
        btnDialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialerIntent = new Intent(Intent.ACTION_DIAL);
                dialerIntent.setData(Uri.parse("tel:" + txtInput.getText().toString()));
                startActivity(dialerIntent);
            }
        });

        Button btnSMS = findViewById(R.id.btnSMS);
        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.putExtra("sms_body", "default content");
                    sendIntent.setType("vnd.android-dir/mms-sms");
                    startActivity(sendIntent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again later!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        Button btnContract = findViewById(R.id.btnContract);
        btnContract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myData = "content://contacts/people/";
                Intent myActivity2 = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(myData));
                startActivity(myActivity2);
            }
        });

        Button btnSetting = findViewById(R.id.btnSetting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        android.provider.Settings.ACTION_SETTINGS);
                startActivity(intent);
            }
        });
    }




}