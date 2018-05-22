package com.example.shiva.jarvis;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;




    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigation.inflateMenu(R.menu.bottom_menu);

        //c = getApplicationContext();
        //getSupportFragmentManager();


        //fragmentManager = getSupportFragmentManager();




        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.chat_room:
                        //ChatFragment chatFragment = new ChatFragment();
                        //fragment = new Fragment();

                        Fragment chatFragment = new ChatFragment();
                        fm = getFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.main_container, chatFragment);
                        ft.commit();
                       // Toast.makeText(Main2Activity.this, "chat", Toast.LENGTH_SHORT).show();


                        break;
                    case R.id.analytics:


                        fm = getFragmentManager();
                        AnalyticsFragment analyticsFragment = new AnalyticsFragment();
                        FragmentTransaction ft1 = fm.beginTransaction();
                        ft1.replace(R.id.main_container, analyticsFragment);
                        ft1.commit();
                        Toast.makeText(Main2Activity.this, "analytucs", Toast.LENGTH_SHORT).show();


                        break;
                }


               // FragmentTransaction transaction = fragmentManager.beginTransaction();
                //transaction.replace(R.id.main_container,test).commit();

               // transaction.commit();
                return true;
            }
        });

        /*if (savedInstanceState == null) {
            bottomNavigation.setSelectedItemId(R.id.chat_room); // change to whichever id should be default
        }*/
    }


}
