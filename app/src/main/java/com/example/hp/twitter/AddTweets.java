package com.example.hp.twitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTweets extends AppCompatActivity {
    TextView tweets;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    String username="asd";
    DatabaseReference tweetsDatabaseRefrence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tweets);
       tweets =(TextView)findViewById(R.id.textTweet);
        Button addTweet=(Button)findViewById(R.id.tweet);
        firebaseDatabase=FirebaseDatabase.getInstance();
        tweetsDatabaseRefrence=firebaseDatabase.getReference().child("tweets");

    }
  public void addTweet(View view){
      tweets tweet = new tweets(tweets.getText().toString(), username, null);
      tweetsDatabaseRefrence.push().setValue(tweet);
      Intent intent=new Intent(getApplicationContext(),MainActivity.class);
      startActivity(intent);
  }
}
