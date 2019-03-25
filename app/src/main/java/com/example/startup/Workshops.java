package com.example.startup;

import android.app.AlertDialog;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class Workshops extends AppCompatActivity implements RecyclerAdapterWorkshops.OnItemClickListener{

    private RecyclerView mRecyclerView;
    private RecyclerAdapterWorkshops mAdapter;
    private DatabaseReference mDatabaseRef;
    private ValueEventListener mDBListener;
    private List<Workshops_class> mWorkshops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isNetworkAvailable())
        {buildDialog(Workshops.this).show(); }
        else{
        setContentView(R.layout.activity_workshops);

        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mWorkshops = new ArrayList<>();
        mAdapter = new RecyclerAdapterWorkshops(Workshops.this, mWorkshops);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(Workshops.this);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("workshops_uploads");

        mDBListener = mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mWorkshops.clear();

                for (DataSnapshot workshopSnapshot : dataSnapshot.getChildren()) {
                    Workshops_class upload = workshopSnapshot.getValue(Workshops_class.class);
                    upload.setKey(workshopSnapshot.getKey());
                    mWorkshops.add(upload);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Workshops.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }}

    public void onItemClick(int position) {
        Workshops_class clickedWorkshop = mWorkshops.get(position);
        String[] workshopData = {clickedWorkshop.getImageUrl(),clickedWorkshop.getTopic(), clickedWorkshop.getFacilitator(),clickedWorkshop.getTime(),clickedWorkshop.getCurrentlyEnrolled(),clickedWorkshop.getCapacityOfWorkshop()};
        Intent intent = new Intent(this, WorkshopInformation.class);
        intent.putExtra("IMAGE_KEY", workshopData[0]);
        intent.putExtra("TOPIC_KEY", workshopData[1]);
        intent.putExtra("FACILITATOR_KEY", workshopData[2]);
        intent.putExtra("TIME_KEY",workshopData[3]);
        intent.putExtra("ENROLLED_KEY",workshopData[4]);
        intent.putExtra("CAPACITY_KEY",workshopData[5]);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                            // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    protected void onDestroy() {
        super.onDestroy();
        if (null != mDatabaseRef)
            mDatabaseRef.removeEventListener(mDBListener);
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or Wi-Fi to access this activity. Press OK to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }
}
