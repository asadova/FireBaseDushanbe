package com.example.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GrantActivity extends AppCompatActivity {

    //Firebase variables
    private FirebaseDatabase grantsDB;
    private DatabaseReference grantsReference;
    private String id;

    //Interface variables
    private TextView grantNameView;
    private TextView grantDescriptionView;
    private TextView grantPlaceView;
    private TextView tagView;
    private TextView deadlineView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grant);

        Intent intent = getIntent();
        id = intent.getExtras().getString("grantId");

        //Initialize Firebase database and reference
        grantsDB = FirebaseDatabase.getInstance();
        grantsReference = grantsDB.getReference().child("grants").child(id);

        grantNameView = (TextView) findViewById(R.id.grantNameView);
        grantDescriptionView = (TextView) findViewById(R.id.grantDescriptionView);
        grantPlaceView = (TextView) findViewById(R.id.grantPlaceView);
        tagView = (TextView) findViewById(R.id.tagView);
        deadlineView = (TextView) findViewById(R.id.deadlineView);

        grantsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Grant grant = dataSnapshot.getValue(Grant.class);
                grantNameView.append("-> " + grant.getGrantName());
                grantDescriptionView.append("-> " + grant.getGrantDescription());
                grantPlaceView.append("-> " + grant.getPlace());
                tagView.append("-> " + grant.getTag());
                deadlineView.append("-> " + grant.getDeadline());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
