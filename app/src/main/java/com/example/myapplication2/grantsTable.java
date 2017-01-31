package com.example.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class grantsTable extends AppCompatActivity {

    private FirebaseDatabase grantsDB;
    private DatabaseReference grantsReference;

    private Button goToPubButton;
    private ListView grantsListView;
    GrantsListAdapter grantsListAdapter;
    ArrayList<Grant> grantItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grants_table_layout);

        //Initialize arrayList
        grantItems = new ArrayList<>();

        //Initialize Interface
        goToPubButton = (Button)findViewById(R.id.goBackButton);
        grantsListView = (ListView)findViewById(R.id.grantsListView);
        grantsListAdapter = new GrantsListAdapter(this, grantItems);
        grantsListView.setAdapter(grantsListAdapter);

        grantsDB = FirebaseDatabase.getInstance();
        grantsReference = grantsDB.getReference().child("grants");

        //кнопка пойти назад
        goToPubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPublish();
            }
        });

        //чтобы новый грант выводился на экран
        grantsReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Grant grant = dataSnapshot.getValue(Grant.class);
                // append добавляет к тексту
                // set меняет текст
                grantsListAdapter.add(grant);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void goToPublish(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
