package com.example.startup;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class WorkshopInformation extends AppCompatActivity {

    public TextView topicTextView,facilitatorTextView,companyTextView,timeTextView,currentlyEnrolledTextView,capacityOfWorkshopTextView;
    public ImageView workshopImageView;
    private Button sign_in_off;
    private void initializeWidgets(){
        facilitatorTextView= findViewById(R.id.facilitatorTextView);
        topicTextView = findViewById(R.id.topicTextView);
        timeTextView=findViewById(R.id.timeTextView);
        currentlyEnrolledTextView= findViewById(R.id.currentlyEnrolledTextView);
        capacityOfWorkshopTextView = findViewById(R.id.capacityOfWorkshopTextView);
        workshopImageView = findViewById(R.id.workshopImageView);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop_information);
        initializeWidgets();

        Intent i=this.getIntent();
        String name=i.getExtras().getString("NAME_KEY");
        String description=i.getExtras().getString("DESCRIPTION_KEY");
        String imageURL=i.getExtras().getString("IMAGE_KEY");
        String time=i.getExtras().getString("TIME_KEY");

        //SET RECEIVED DATA TO TEXTVIEWS AND IMAGEVIEWS
        facilitatorTextView.setText(name);
        topicTextView.setText(description);
        timeTextView.setText("Starts at: " + time);
        Picasso.with(this)
                .load(imageURL)
                .fit()
                .centerCrop()
                .into(workshopImageView);


        sign_in_off = findViewById(R.id.WorkshopButton);
        sign_in_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = sign_in_off.getText().toString();
                if(text.equalsIgnoreCase("Sign in"))
                {
                    sign_in_off.setText("Sign Out");
                    sign_in_off.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ic_vectornologostartupnaobratno,0,0,0);
                }
                else if(text.equalsIgnoreCase("Sign out"))
                {
                    sign_in_off.setText("Sign in");
                    sign_in_off.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ic_vectornologostartup,0,0,0);
                }
            }
        });
    }
}
