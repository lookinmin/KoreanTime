package com.example.koreantime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MakeNewGroup extends LinearLayout {
    public MakeNewGroup(Context context, tmpClass tmpClass) {
        super(context);
        init(context, tmpClass);
    }
    private void init(Context context, tmpClass tmpClass){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.make_new_group, this, true);

        ImageButton groupImg = findViewById(R.id.groupImg);
        TextView groupName = findViewById(R.id.groupName);
        TextView groupDate = findViewById(R.id.groupDate);
        TextView groupPeople = findViewById(R.id.groupPeople);

        groupName.setText(tmpClass.getGroupName());
        groupDate.setText(tmpClass.getGroupDate());
        groupPeople.setText(tmpClass.getGroupPeople());
    }

}
