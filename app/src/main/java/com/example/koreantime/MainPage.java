package com.example.koreantime;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {
    
    String[] orderList = {"생성순", "시간순"};
    boolean sidebarFlag = true;

    Animation translateLeft = AnimationUtils.loadAnimation(this,R.anim.translate_left);
    Animation translateRight = AnimationUtils.loadAnimation(this,R.anim.translate_right);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        LinearLayout sidebar = findViewById(R.id.sidebar);
        Button sidebarBtn = findViewById(R.id.sidebarBtn);


        sidebarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sidebarFlag){
                    sidebar.startAnimation(translateRight);
                    sidebar.setVisibility(View.VISIBLE);
                    sidebar.setBackground( new ColorDrawable(0xf000000));
                } else{
                    sidebar.startAnimation(translateLeft);
                    sidebar.setVisibility(View.INVISIBLE);
                    sidebar.setBackground( new ColorDrawable(0x7f000000));
                }
                sidebarFlag = !sidebarFlag;
            }
        });

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