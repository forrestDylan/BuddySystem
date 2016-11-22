package edu.rit.dxf7606.buddysystem;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SessionChoice extends AppCompatActivity {

    private static final int REQUEST_CONTACT_PERMISSIONS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_choice);
    }

    public void goSolo(View view){
        startActivity(new Intent(SessionChoice.this, SoloSession.class));
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void goBuddy(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) ==
                PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(this, BuddySelection.class);
            startActivity(intent);
        }

        else {

            requestPermissions(new String[]{ Manifest.permission.READ_CONTACTS}, REQUEST_CONTACT_PERMISSIONS);
        }
    }

}
