package com.example.jerksara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;

public class pickDay extends AppCompatActivity {

    CalendarView dayPicker;
    TextView displayDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_day);

        dayPicker=findViewById(R.id.dayPicker);
        displayDay=findViewById(R.id.displayDay);

        dayPicker.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                displayDay.setText(Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year));
            }
        });
    }
}