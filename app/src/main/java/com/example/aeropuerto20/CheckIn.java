package com.example.aeropuerto20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class CheckIn extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);

        drawerLayout=findViewById(R.id.drawer_activity);
    }
    public  void Clickhome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void clickDashboard(View view){
        recreate();
    }

    public void clickAboutUs(View view){
        MainActivity.redirectActivity(this, PetCheck.class);
    }

    public void clickLogout(View view){
        MainActivity.logout(this);
    }


}