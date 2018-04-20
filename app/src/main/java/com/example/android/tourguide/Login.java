package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button learnMore;
    private Button freeTrial;
    private Button login;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        learnMore = (Button) findViewById(R.id.learnmore);
        freeTrial = (Button) findViewById(R.id.freeTrial);
        login = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);

        learnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://en.wikipedia.org/wiki/Minya_Governorate";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        /*
        * Login on click function
        * checks username and password
         */
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentUsername = username.getText().toString();
                String currentPasswword = password.getText().toString();
                if (currentUsername.equals("ali") && currentPasswword.equals("123")) {

                    Intent intent = new Intent(Login.this, tourPlaces.class);
                    startActivity(intent);

                }
            }
        });
        /*
        * Free Trial on click function
        * it moves to the places and shows only the info
         */
        freeTrial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, tourPlaces.class);
                startActivity(intent);
            }
        });
    }
}
