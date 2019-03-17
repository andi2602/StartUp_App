package com.example.startup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class SpeakersInformation extends AppCompatActivity {


    TextView nameDetailTextView,descriptionDetailTextView,dateDetailTextView;
    ImageView teacherDetailImageView;

    private void initializeWidgets(){
        nameDetailTextView= findViewById(R.id.nameDetailTextView);
        descriptionDetailTextView= findViewById(R.id.descriptionDetailTextView);
        teacherDetailImageView=findViewById(R.id.teacherDetailImageView);
        dateDetailTextView= findViewById(R.id.dateDetailTextView);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers_information);

        initializeWidgets();

        //RECEIVE DATA FROM ITEMSACTIVITY VIA INTENT
        Intent i=this.getIntent();
        String name=i.getExtras().getString("NAME_KEY");
        String description=i.getExtras().getString("DESCRIPTION_KEY");
        String imageURL=i.getExtras().getString("IMAGE_KEY");
        String time=i.getExtras().getString("TIME_KEY");
        descriptionDetailTextView.setMovementMethod(new ScrollingMovementMethod());

        //SET RECEIVED DATA TO TEXTVIEWS AND IMAGEVIEWS
        nameDetailTextView.setText(name);
        descriptionDetailTextView.setText(description);
        dateDetailTextView.setText("Starts at: " + time);
        Picasso.with(this)
                .load(imageURL)
                .fit()
                .centerCrop()
                .into(teacherDetailImageView);

    }

}
