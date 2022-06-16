package com.example.aeropuerto20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void Clickhome(View view){
        recreate();
    }

    public void clickDashboard(View view){
        redirectActivity(this, CheckIn.class);
    }

    public void clickAboutUs(View view){
        redirectActivity(this, PetCheck.class);
    }

    public void clickLogout(View view){
        logout(this);
    }

    public static void logout(Activity activity){
        AlertDialog.Builder builder= new AlertDialog.Builder(activity);
        builder.setTitle("SALIR");
        builder.setMessage("Usted quiere salir de la aplicacion");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.finishAffinity();
                System.exit(0);

            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    static void redirectActivity(Activity activity, Class Class) {
        Intent i = new Intent(activity,Class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(i);
    }

    public void compra(View view){
        Intent i = new Intent(this,Compra.class);
        startActivity(i);
    }

    public void vuelos(View view){
        Intent i = new Intent(this,vuelo.class);
        startActivity(i);
    }

    public void informacion(View view){
        Intent i = new Intent(this,informacion.class);
        startActivity(i);
    }

}