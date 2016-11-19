package edu.rit.dxf7606.buddysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SessionChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_choice);
    }

    public void goSolo(View view){
        startActivity(new Intent(SessionChoice.this, SoloSession.class));
    }

    public void goBuddy(View view){
        startActivity(new Intent(SessionChoice.this, BuddySelection.class));
    }

}
