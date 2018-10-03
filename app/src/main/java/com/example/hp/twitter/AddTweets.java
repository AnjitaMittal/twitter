package com.example.hp.twitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTweets extends AppCompatActivity {
    EditText tweets;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    String username="asd";
    DatabaseReference tweetsDatabaseRefrence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tweets);
       tweets =(EditText)findViewById(R.id.textTweet);
        final Button addTweet=(Button)findViewById(R.id.tweet);
        firebaseDatabase=FirebaseDatabase.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
        tweetsDatabaseRefrence=firebaseDatabase.getReference().child("Tweets");
tweets.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
if(s.toString().length()>0){
    addTweet.setEnabled(true);
}else{
    addTweet.setEnabled(false);
}
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});
    }
  public void addTweet(View view){
      Tweets tweet = new Tweets(tweets.getText().toString(), username, null);
      tweetsDatabaseRefrence.push().setValue(tweet);
      Intent intent=new Intent(getApplicationContext(),MainActivity.class);
      startActivity(intent);
  }
}
