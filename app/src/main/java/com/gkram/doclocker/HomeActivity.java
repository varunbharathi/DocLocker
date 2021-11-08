package com.gkram.doclocker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView home_bottomnavigation_container;
    FrameLayout home_framelayout_container;
    int statusBarHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        statusBarHeight = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }

        home_bottomnavigation_container = findViewById(R.id.home_bottomnavigation_container);
        home_framelayout_container = findViewById(R.id.home_framelayout_container);

        home_framelayout_container.setPadding(0,statusBarHeight,0,0);


        getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout_container,new MyDocumentsFragment()).commit();
        home_bottomnavigation_container.setSelectedItemId(R.id.navigation_mydocumants);

        home_bottomnavigation_container.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.navigation_mydocumants:
                        fragment = new MyDocumentsFragment();
                        break;
                    case R.id.navigation_newdocument:
                        fragment = new NewDocumentFragment();
                        break;
                    case R.id.navigation_profile:
                        fragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout_container,fragment).commit();

                return true;
            }
        });
    }
}