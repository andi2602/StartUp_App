package com.example.startup;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {

    private ImageButton eventInformation;
    private Button InfoButton;
    private Button SpeakersButton;
    private Button ScheduleButton;
    private DatabaseReference mDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("teachers_uploads");
        mDatabaseRef.keepSynced(true);

        ScheduleButton = findViewById(R.id.buttonSchedule);
        ScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, Schedule.class);
                startActivity(i);
            }
        });
        eventInformation = findViewById(R.id.eventInformation);
        eventInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });
        InfoButton = findViewById(R.id.buttonInfo);
        InfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, LoginForm.class);
                startActivity(i);
            }
        });
        SpeakersButton = findViewById(R.id.buttonSpeakers);
        SpeakersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, Speakers.class);
                startActivity(i);
            }
        });
    }
    public void openAbout()
    {
        Intent intent = new Intent(this,About.class);
        startActivity(intent);
    }
}
