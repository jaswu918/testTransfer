package com.example.jerksara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    Button next, setTime;
    TextView displayTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker=findViewById(R.id.timePicker);
        displayTime=findViewById(R.id.displayTime);
        next=findViewById(R.id.next);
        setTime=findViewById(R.id.setTime);

        notificationChannel();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent=new Intent(MainActivity.this, pickDay.class);
                startActivity(intent);*/
                getTime();
            }
        });

        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*int getHour = timePicker.getCurrentHour();
                int getMinute = timePicker.getCurrentMinute();
                displayTime.setText(Integer.toString(getHour)+":"+Integer.toString(getMinute));*/
                notification("Android Studio", "Reminder APP");
            }
        });

    }
    public void notification(String title, String text){
        NotificationCompat.Builder notification= new NotificationCompat.Builder(MainActivity.this, "Noti");
        notification.setContentTitle(title);
        notification.setContentText(text);
        notification.setSmallIcon(R.drawable.ic_launcher_background);
        notification.setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat= NotificationManagerCompat.from(MainActivity.this);
        notificationManagerCompat.notify(1,notification.build());
    }
    private void notificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = ("Notification");
            String description = "For Reminders";
            NotificationChannel channel = new NotificationChannel("Noti", "Testing", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    public void getTime() {
        Calendar setTimer = Calendar.getInstance();
        setTimer.set(2022,3,07,3,31,10);
        long alarmStartTime = setTimer.getTimeInMillis();
    }
    public void setNotification(){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    }
}