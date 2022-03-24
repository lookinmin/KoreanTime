package com.example.koreantime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {
    
    String[] orderList = {"생성순", "시간순"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Spinner orderSpinner = findViewById(R.id.order);
        ArrayAdapter<String> orderAdapter = new ArrayAdapter<>(MainPage.this,
                android.R.layout.simple_spinner_dropdown_item, orderList);
        orderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orderSpinner.setAdapter(orderAdapter);
        orderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 1){
                    Toast.makeText(MainPage.this, "생성순", Toast.LENGTH_SHORT).show();
                } else if (i == 2){
                    Toast.makeText(MainPage.this, "시간순", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}