package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.Fragment.ErrorFragment;
import com.example.myapplication.Fragment.HomeFragment;
import com.example.myapplication.Home.ScrapActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private LinearLayout placeHolder;
    private Fragment selectedFragment;

    private Button scrap_btn;
    private Button capture_btn;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            selectedFragment = new ErrorFragment();
            if (item.getItemId() == R.id.navigation_home) {
                //Toast.makeText(getApplicationContext(), R.string.title_home, Toast.LENGTH_SHORT).show();
                selectedFragment = new HomeFragment();

            } else if (item.getItemId() == R.id.navigation_list) {
                //Toast.makeText(getApplicationContext(), R.string.title_list, Toast.LENGTH_SHORT).show();


            } else if (item.getItemId() == R.id.navigation_userInfo) {
                // Toast.makeText(getApplicationContext(), R.string.title_userInfo, Toast.LENGTH_SHORT).show();

            }


            getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, selectedFragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (selectedFragment == null) {
            selectedFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, selectedFragment).commit();
        }


    }
}
