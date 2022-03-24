package com.example.koreantime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

public class MeetingMaking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_making);

        Button complete = findViewById(R.id.complete);
        MaterialCalendarView calendar = findViewById(R.id.calendar);

        calendar.addDecorators(
                new MySelectorDecorator(MeetingMaking.this),
                new SundayDecorator(),
                new SaturdayDecorator(),
                new OneDayDecorator()
        );


        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeetingMaking.this, GroupMeetings.class);
                startActivity(intent);
            }
        });
    }
}