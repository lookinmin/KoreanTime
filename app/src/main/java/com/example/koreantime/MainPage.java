package com.example.koreantime;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {

    String[] orderList = {"생성순", "시간순"};
    boolean sidebarFlag = false;
    LinearLayout sidebar;


    Animation translateLeft;
    Animation translateRight;

    ArrayList<ImageButton> meetingMaking = new ArrayList<>();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        sidebar = findViewById(R.id.sidebar);
        Button sidebarBtn = findViewById(R.id.sidebarBtn);
        ImageButton group_making_btn = findViewById(R.id.group_making_btn);
        LinearLayout showGroups = findViewById(R.id.showGroups);

        meetingMaking.add(findViewById(R.id.meeting_making1));
        //이미지 버튼 arraylist에 add하면서 인덱스 맞춰서 호출
        meetingMaking.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, MeetingMaking.class);
                startActivity(intent);
            }
        });

        group_making_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainPage.this, "Asdf", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainPage.this, GroupMaking.class);
                startActivity(intent);
            }
        });
        //그룹 만드는 페이지로 intent
        
        Button tmpBtn = findViewById(R.id.tmpBtn);//임시버튼 -> 나중에 동적으로 레이아웃 생기도록
        tmpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmpClass tmp_class = new tmpClass("groupName1", "groupDate1", "groupPeople1");
                ArrayList<tmpClass> arrayList = new ArrayList<>();
                arrayList.add(tmp_class);
                MakeNewGroup makeNewGroup = new MakeNewGroup(getApplicationContext(), arrayList.get(0));
                showGroups.addView(makeNewGroup);
            }
        });
        //임시버튼 만들어서 누르면 동적으로 그룹 보여지는 레이아웃 생성
        //나중에 그룹명, 인원 등을 db에서 읽어서 tmpClass로 보낸 후 
        //MakeNewGroup에서 tmpClass를 담은 arraylist 인덱스 맞춰서
        //레이아웃 생성 -> tmpClass 이름 바꿔야함
        //tmpClass 안에 imageButton도 동적으로 바뀌게
        //동적으로 레이아웃 만들다 보면 group_making_btn를 가리는 거 해결

        translateLeft = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRight = AnimationUtils.loadAnimation(this, R.anim.translate_right);
        SlidingPageAnimationListener animationListner = new SlidingPageAnimationListener();
        translateLeft.setAnimationListener(animationListner);
        translateRight.setAnimationListener(animationListner);


        sidebarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sidebarFlag) {
                    sidebar.startAnimation(translateRight);
                    sidebar.setBackground(new ColorDrawable(0xf000000));
                } else {
                    sidebar.startAnimation(translateLeft);
                    sidebar.setVisibility(View.VISIBLE);
                    sidebar.setBackground(new ColorDrawable(0x7f000000));
                }
            }
        });
        //사이드바

        Spinner orderSpinner = findViewById(R.id.order);
        ArrayAdapter<String> orderAdapter = new ArrayAdapter<>(MainPage.this,
                android.R.layout.simple_spinner_dropdown_item, orderList);
        orderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orderSpinner.setAdapter(orderAdapter);
        orderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1) {
                    Toast.makeText(MainPage.this, "생성순", Toast.LENGTH_SHORT).show();
                } else if (i == 2) {
                    Toast.makeText(MainPage.this, "시간순", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //미팅 보여주는 spinner(생성순, 시간순)
    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (sidebarFlag) {
                sidebar.setVisibility(View.INVISIBLE);
            }
            sidebarFlag = !sidebarFlag;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}

