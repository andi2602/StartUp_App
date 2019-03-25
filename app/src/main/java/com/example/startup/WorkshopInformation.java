package com.example.startup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class WorkshopInformation extends AppCompatActivity {

    TextView facilitatorDetailTextView,dateDetailTextView,workshopdetailtopic,currentlyEnrolledDetailTextView,capacityOfWorkshopDetailTextView,descriptionWorkshopsDetailTextView,afterButtonClick,room;
    ImageView workshopDetailImageView;
    Button sign_in_off;
    private void initializeWidgets(){
        facilitatorDetailTextView = findViewById(R.id.facilitatorDetailTextView);
        dateDetailTextView = findViewById(R.id.dateDetailTextView);
        workshopdetailtopic = findViewById(R.id.workshopDetailTopic);
        currentlyEnrolledDetailTextView = findViewById(R.id.currentlyEnrolledDetailTextView);
        capacityOfWorkshopDetailTextView = findViewById(R.id.capacityOfWorkshopDetailTextView);
        workshopDetailImageView = findViewById(R.id.workshopDetailImageView);
        descriptionWorkshopsDetailTextView = findViewById(R.id.descriptionWorkshopsDetailTextView);
        afterButtonClick = findViewById(R.id.afterbuttonclick);
        room = findViewById(R.id.room);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop_information);
        initializeWidgets();
        sign_in_off = findViewById(R.id.WorkshopButton);
        final String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        Intent i=this. getIntent();
        String imageURL=i.getExtras().getString("IMAGE_KEY");
        String topic=i.getExtras().getString("TOPIC_KEY");
        String facilitator=i.getExtras().getString("FACILITATOR_KEY");
        String time=i.getExtras().getString("TIME_KEY");
        String capacity = i.getExtras().getString("CAPACITY_KEY");
        final int position = i.getExtras().getInt("position");
        descriptionWorkshopsDetailTextView.setMovementMethod(new ScrollingMovementMethod());
        switch (position)
        {
            case 0:
                FirebaseDatabase.getInstance().getReference().child("Rooms").child("Room1").child("room").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String rooms = dataSnapshot.getValue().toString();
                        room.setText(rooms);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 1:
                FirebaseDatabase.getInstance().getReference().child("Rooms").child("Room2").child("room").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String rooms = dataSnapshot.getValue().toString();
                        room.setText(rooms);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 2:
                FirebaseDatabase.getInstance().getReference().child("Rooms").child("Room3").child("room").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String rooms = dataSnapshot.getValue().toString();
                        room.setText(rooms);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 3:
                FirebaseDatabase.getInstance().getReference().child("Rooms").child("Room4").child("room").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String rooms = dataSnapshot.getValue().toString();
                        room.setText(rooms);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 4:
                FirebaseDatabase.getInstance().getReference().child("Rooms").child("Room5").child("room").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String rooms = dataSnapshot.getValue().toString();
                        room.setText(rooms);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 5:
                FirebaseDatabase.getInstance().getReference().child("Rooms").child("Room6").child("room").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String rooms = dataSnapshot.getValue().toString();
                        room.setText(rooms);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
        }
        switch (position)
        {
            case 0:
                FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop1").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(uid)){
                            sign_in_off.setText("Sign Out");
                            sign_in_off.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_vectornologostartupnaobratno,0,0,0);
                            afterButtonClick.setText("You are signed in!");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 1:
                FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop2").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(uid)){
                            sign_in_off.setText("Sign Out");
                            sign_in_off.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_vectornologostartupnaobratno,0,0,0);
                            afterButtonClick.setText("You are signed in!");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 2:
                FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop3").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(uid)){
                            sign_in_off.setText("Sign Out");
                            sign_in_off.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_vectornologostartupnaobratno,0,0,0);
                            afterButtonClick.setText("You are signed in!");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 3:
                FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop4").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(uid)){
                            sign_in_off.setText("Sign Out");
                            sign_in_off.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_vectornologostartupnaobratno,0,0,0);
                            afterButtonClick.setText("You are signed in!");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 4:
                FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop5").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(uid)){
                            sign_in_off.setText("Sign Out");
                            sign_in_off.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_vectornologostartupnaobratno,0,0,0);
                            afterButtonClick.setText("You are signed in!");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 5:
                FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop6").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(uid)){
                            sign_in_off.setText("Sign Out");
                            sign_in_off.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_vectornologostartupnaobratno,0,0,0);
                            afterButtonClick.setText("You are signed in!");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
        }
        switch (position){
            case 0:
                FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop1").child("description").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String description = dataSnapshot.getValue().toString();
                        descriptionWorkshopsDetailTextView.setText(description);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 1:
                FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop2").child("description").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String description = dataSnapshot.getValue().toString();
                        descriptionWorkshopsDetailTextView.setText(description);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 2:
                FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop3").child("description").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String description = dataSnapshot.getValue().toString();
                        descriptionWorkshopsDetailTextView.setText(description);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 3:
                FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop4").child("description").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String description = dataSnapshot.getValue().toString();
                        descriptionWorkshopsDetailTextView.setText(description);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 4:
                FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop5").child("description").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String description = dataSnapshot.getValue().toString();
                        descriptionWorkshopsDetailTextView.setText(description);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 5:
                FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop6").child("description").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String description = dataSnapshot.getValue().toString();
                        descriptionWorkshopsDetailTextView.setText(description);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
        }
        switch (position){
            case 0:
                FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop1").child("currentlyEnrolled").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String enrolled = dataSnapshot.getValue().toString();
                        currentlyEnrolledDetailTextView.setText("Spots: " + enrolled);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 1:
                FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop2").child("currentlyEnrolled").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String enrolled = dataSnapshot.getValue().toString();
                        currentlyEnrolledDetailTextView.setText("Spots: " + enrolled);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 2:
                FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop3").child("currentlyEnrolled").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String enrolled = dataSnapshot.getValue().toString();
                        currentlyEnrolledDetailTextView.setText("Spots: " + enrolled);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 3:
                FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop4").child("currentlyEnrolled").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String enrolled = dataSnapshot.getValue().toString();
                        currentlyEnrolledDetailTextView.setText("Spots: " + enrolled);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 4:
                FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop5").child("currentlyEnrolled").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String enrolled = dataSnapshot.getValue().toString();
                        currentlyEnrolledDetailTextView.setText("Spots: " + enrolled);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 5:
                FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop6").child("currentlyEnrolled").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String enrolled = dataSnapshot.getValue().toString();
                        currentlyEnrolledDetailTextView.setText("Spots: " + enrolled);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
        }


        facilitatorDetailTextView.setText(facilitator);
        workshopdetailtopic.setText(topic);
        dateDetailTextView.setText("Starts at: " + time);
        capacityOfWorkshopDetailTextView.setText("/" + capacity);
        Picasso.with(this)
                .load(imageURL)
                .fit()
                .centerCrop()
                .into(workshopDetailImageView);

        sign_in_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = sign_in_off.getText().toString();
                if(text.equals("Sign In"))
                {

                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null) {
                        String uid = user.getUid();
                        FirebaseDatabase.getInstance().getReference().child("Users").child(uid).child("name").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if(dataSnapshot.getValue() != null){
                                    String name = dataSnapshot.getValue().toString();
                                    final Users  user = new Users(name);
                                    switch (position) {
                                        case 0:
                                            FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop1").child("capacityOfWorkshop").addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                    final Long capacity = Long.parseLong(dataSnapshot.getValue().toString());
                                                    FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop1").child("currentlyEnrolled").addListenerForSingleValueEvent(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            final Long enrolled = Long.parseLong(dataSnapshot.getValue().toString());
                                                            FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop2").addListenerForSingleValueEvent(new ValueEventListener() {
                                                                @Override
                                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                    if(dataSnapshot.hasChild(FirebaseAuth.getInstance().getCurrentUser().getUid()))
                                                                    {
                                                                        Toast.makeText(getApplicationContext(), "You are signed for another workshop at the same time slot", Toast.LENGTH_SHORT).show();
                                                                    }
                                                                    else
                                                                    {
                                                                        if(enrolled < capacity)
                                                                        {
                                                                            afterButtonClick.setText("You are signed in!");
                                                                            sign_in_off.setText("Sign Out");
                                                                            sign_in_off.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ic_vectornologostartupnaobratno,0,0,0);
                                                                            FirebaseDatabase.getInstance().getReference("EnrolledinWorkshop1")
                                                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                                                    .setValue(user);
                                                                            FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop1").addValueEventListener(new ValueEventListener() {
                                                                                @Override
                                                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                    String size = Long.toString(dataSnapshot.getChildrenCount());
                                                                                    FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop1").child("currentlyEnrolled").setValue(size);
                                                                                }

                                                                                @Override
                                                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                }
                                                                            });
                                                                        }
                                                                        else
                                                                        {
                                                                            Toast.makeText(getApplicationContext(), "Workshop is full", Toast.LENGTH_SHORT).show();
                                                                        }
                                                                    }
                                                                }

                                                                @Override
                                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                }
                                                            });
                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                }
                                            });
                                        break;
                                        case 1:
                                            FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop2").child("capacityOfWorkshop").addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                    final Long capacity = Long.parseLong(dataSnapshot.getValue().toString());
                                                    FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop2").child("currentlyEnrolled").addListenerForSingleValueEvent(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            final Long enrolled = Long.parseLong(dataSnapshot.getValue().toString());
                                                            FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop1").addListenerForSingleValueEvent(new ValueEventListener() {
                                                                @Override
                                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                    if(dataSnapshot.hasChild(FirebaseAuth.getInstance().getCurrentUser().getUid())){
                                                                        Toast.makeText(getApplicationContext(), "You are signed for another workshop at the same time slot", Toast.LENGTH_SHORT).show();
                                                                    }
                                                                    else
                                                                    {
                                                                        if(enrolled < capacity)
                                                                        {
                                                                            afterButtonClick.setText("You are signed in!");
                                                                            FirebaseDatabase.getInstance().getReference("EnrolledinWorkshop2")
                                                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                                                    .setValue(user);
                                                                            FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop2").addValueEventListener(new ValueEventListener() {
                                                                                @Override
                                                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                    String size = Long.toString(dataSnapshot.getChildrenCount());
                                                                                    FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop2").child("currentlyEnrolled").setValue(size);
                                                                                }

                                                                                @Override
                                                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                }
                                                                            });
                                                                        }
                                                                        else
                                                                        {
                                                                            Toast.makeText(getApplicationContext(), "Workshop is full", Toast.LENGTH_SHORT).show();
                                                                        }
                                                                    }
                                                                }

                                                                @Override
                                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                }
                                                            });
                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                }
                                            });
                                            break;
                                        case 2:
                                            FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop3").child("capacityOfWorkshop").addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                    final Long capacity = Long.parseLong(dataSnapshot.getValue().toString());
                                                    FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop3").child("currentlyEnrolled").addListenerForSingleValueEvent(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            final Long enrolled = Long.parseLong(dataSnapshot.getValue().toString());
                                                            FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop4").addListenerForSingleValueEvent(new ValueEventListener() {
                                                                @Override
                                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                    if(dataSnapshot.hasChild(FirebaseAuth.getInstance().getCurrentUser().getUid()))
                                                                    {
                                                                        Toast.makeText(getApplicationContext(), "You are signed for another workshop at the same time slot", Toast.LENGTH_SHORT).show();
                                                                    }
                                                                    else
                                                                    {
                                                                        if(enrolled < capacity)
                                                                        {
                                                                            afterButtonClick.setText("You are signed in!");
                                                                            FirebaseDatabase.getInstance().getReference("EnrolledinWorkshop3")
                                                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                                                    .setValue(user);
                                                                            FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop3").addValueEventListener(new ValueEventListener() {
                                                                                @Override
                                                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                    String size = Long.toString(dataSnapshot.getChildrenCount());
                                                                                    FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop3").child("currentlyEnrolled").setValue(size);
                                                                                }

                                                                                @Override
                                                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                }
                                                                            });
                                                                        }
                                                                        else
                                                                        {
                                                                            Toast.makeText(getApplicationContext(), "Workshop is full", Toast.LENGTH_SHORT).show();
                                                                        }
                                                                    }
                                                                }

                                                                @Override
                                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                }
                                                            });
                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                }
                                            });
                                            break;
                                        case 3:
                                            FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop4").child("capacityOfWorkshop").addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                    final Long capacity = Long.parseLong(dataSnapshot.getValue().toString());
                                                    FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop4").child("currentlyEnrolled").addListenerForSingleValueEvent(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            final Long enrolled = Long.parseLong(dataSnapshot.getValue().toString());
                                                            FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop3").addListenerForSingleValueEvent(new ValueEventListener() {
                                                                @Override
                                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                    if(dataSnapshot.hasChild(FirebaseAuth.getInstance().getCurrentUser().getUid()))
                                                                    {
                                                                        Toast.makeText(getApplicationContext(), "You are signed for another workshop at the same time slot", Toast.LENGTH_SHORT).show();
                                                                    }
                                                                    else
                                                                    {
                                                                        if(enrolled < capacity)
                                                                        {
                                                                            afterButtonClick.setText("You are signed in!");
                                                                            FirebaseDatabase.getInstance().getReference("EnrolledinWorkshop4")
                                                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                                                    .setValue(user);
                                                                            FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop4").addValueEventListener(new ValueEventListener() {
                                                                                @Override
                                                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                    String size = Long.toString(dataSnapshot.getChildrenCount());
                                                                                    FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop4").child("currentlyEnrolled").setValue(size);
                                                                                }

                                                                                @Override
                                                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                }
                                                                            });
                                                                        }
                                                                        else
                                                                        {
                                                                            Toast.makeText(getApplicationContext(), "Workshop is full", Toast.LENGTH_SHORT).show();
                                                                        }
                                                                    }
                                                                }

                                                                @Override
                                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                }
                                                            });
                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                }
                                            });
                                            break;
                                        case 4:
                                            FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop5").child("capacityOfWorkshop").addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                    final Long capacity = Long.parseLong(dataSnapshot.getValue().toString());
                                                    FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop5").child("currentlyEnrolled").addListenerForSingleValueEvent(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            Long enrolled = Long.parseLong(dataSnapshot.getValue().toString());
                                                            if(enrolled < capacity)
                                                            {
                                                                afterButtonClick.setText("You are signed in!");
                                                                FirebaseDatabase.getInstance().getReference("EnrolledinWorkshop5")
                                                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                                        .setValue(user);
                                                                FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop5").addValueEventListener(new ValueEventListener() {
                                                                    @Override
                                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                        String size = Long.toString(dataSnapshot.getChildrenCount());
                                                                        FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop5").child("currentlyEnrolled").setValue(size);
                                                                    }

                                                                    @Override
                                                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                    }
                                                                });
                                                            }
                                                            else
                                                            {
                                                                Toast.makeText(getApplicationContext(), "Workshop is full", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                }
                                            });
                                            break;
                                        case 5:
                                            FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop6").child("capacityOfWorkshop").addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                    final Long capacity = Long.parseLong(dataSnapshot.getValue().toString());
                                                    FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop6").child("currentlyEnrolled").addListenerForSingleValueEvent(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            Long enrolled = Long.parseLong(dataSnapshot.getValue().toString());
                                                            if(enrolled < capacity)
                                                            {
                                                                afterButtonClick.setText("You are signed in!");
                                                                FirebaseDatabase.getInstance().getReference("EnrolledinWorkshop6")
                                                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                                        .setValue(user);
                                                                FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop6").addValueEventListener(new ValueEventListener() {
                                                                    @Override
                                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                        String size = Long.toString(dataSnapshot.getChildrenCount());
                                                                        FirebaseDatabase.getInstance().getReference().child("workshops_uploads").child("Workshop6").child("currentlyEnrolled").setValue(size);
                                                                    }

                                                                    @Override
                                                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                    }
                                                                });
                                                            }
                                                            else
                                                            {
                                                                Toast.makeText(getApplicationContext(), "Workshop is full", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                }
                                            });
                                            break;
                                    }
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                }
                else
                {
                    sign_in_off.setText("Sign In");
                    sign_in_off.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ic_vectornologostartup,0,0,0);

                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null) {
                        String uid = user.getUid();
                        switch (position){
                            case 0:
                                FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop1").child(uid).setValue(null);
                                afterButtonClick.setText("");
                                break;
                            case 1:
                                FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop2").child(uid).setValue(null);
                                afterButtonClick.setText("");
                                break;
                            case 2:
                                FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop3").child(uid).setValue(null);
                                afterButtonClick.setText("");
                                break;
                            case 3:
                                FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop4").child(uid).setValue(null);
                                afterButtonClick.setText("");
                                break;
                            case 4:
                                FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop5").child(uid).setValue(null);
                                afterButtonClick.setText("");
                                break;
                            case 5:
                                FirebaseDatabase.getInstance().getReference().child("EnrolledinWorkshop6").child(uid).setValue(null);
                                afterButtonClick.setText("");
                                break;
                        }
                    }
                }
            }
        });
    }
}
