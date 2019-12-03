package com.example.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText phoneEt;
    Button phoneBtn;
    String mobile;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneEt = findViewById(R.id.et_phone);
        phoneBtn = findViewById(R.id.proceed_btn);


        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();




        phoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mobile = phoneEt.getText().toString().trim();
                Log.d("ppppppppp", mobile);

                if(mobile.isEmpty() || mobile.length() < 11){
                    phoneEt.setError("Enter a valid mobile");
                    phoneEt.requestFocus();
                    return;
                }

                Intent phone = new Intent(context, otp_auth.class);
                phone.putExtra("phonenumber", mobile);

                startActivity(phone);
                finish();
            }
        });
    }
}
