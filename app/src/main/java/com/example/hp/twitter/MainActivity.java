package com.example.hp.twitter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.hp.twitter.Fragments.chat_fragment;
import com.example.hp.twitter.Fragments.home_fragment;
import com.example.hp.twitter.Fragments.notification_fragment;
import com.example.hp.twitter.Fragments.search_fregment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private int RC_SIGN_IN=55;
    private String TAG;
    Toolbar toolbar;
    int count=0;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    DatabaseReference tweetsDatabaseRefrence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//     toolbar =(Toolbar)findViewById(R.id.toolbar);
       firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        tweetsDatabaseRefrence=firebaseDatabase.getReference().child("Tweets");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
        //FLOATINGACTION BUTTON
        FloatingActionButton fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),AddTweets.class);
                startActivity(intent);
            }
        });

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_home_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_search_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_message_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_notifications_black_24dp));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                if (tabLayout.getSelectedTabPosition() == 0) {
                    Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                    home_fragment savedFragment = new home_fragment();


                    if (count == 0) {

                        count = 1;

                        fragmentManager.beginTransaction().add(R.id.tweetsrecycle, savedFragment).commit();

                    }
                    else
                    {

                        fragmentManager.beginTransaction().replace(R.id.tweetsrecycle, savedFragment).commit();

                    }


                }
                else if (tabLayout.getSelectedTabPosition() == 1)
                {


                    Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();

                    search_fregment sFragment = new search_fregment();

                    fragmentManager.beginTransaction().replace(R.id.tweetsrecycle, sFragment).commit();


                }
                else if (tabLayout.getSelectedTabPosition() == 2)
                {


                    Toast.makeText(getApplicationContext(), "Message", Toast.LENGTH_SHORT).show();

                    chat_fragment cFragment = new chat_fragment();

                    fragmentManager.beginTransaction().replace(R.id.tweetsrecycle, cFragment).commit();

                } else if (tabLayout.getSelectedTabPosition() == 3) {

                    Toast.makeText(getApplicationContext(), "Notification", Toast.LENGTH_SHORT).show();
                    notification_fragment nFragment = new notification_fragment();
                    fragmentManager.beginTransaction().replace(R.id.tweetsrecycle, nFragment).commit();

                }

            }

            @Override

            public void onTabUnselected (TabLayout.Tab tab){

                }

                @Override
                public void onTabReselected (TabLayout.Tab tab){

                }
            }
        );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * We can add menu item using java code or xml resource file
         */

        // How to in java

//        MenuItem menuItem = menu.add("Next Image");
//        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
//        menuItem.setIcon(R.drawable.ic_add_a_photo_black_24dp);
//        menuItem.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        // How to using menu resource file.


        getMenuInflater().inflate(R.menu.dp_menu, menu);
//setActionBar(toolbar);
      //  Drawable nextImageDrawable = menu.findItem(R.id.dp).getIcon();

        return true;
    }

}
