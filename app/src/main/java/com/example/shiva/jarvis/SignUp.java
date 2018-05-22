package com.example.shiva.jarvis;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {
TextView nsn, match;
EditText pass,rePass;
Button signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        match = (TextView)findViewById(R.id.match);
        nsn = (TextView)findViewById(R.id.nsn);

        Typeface custom = Typeface.createFromAsset(getAssets(), "fonts/font_nokia.ttf");
        nsn.setTypeface(custom);


    }
}
