package com.example.accessphoneservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int CALL = 1;

    private static String[] PERMISSIONS = {
            Manifest.permission.CALL_PHONE
    };


    public static void verifyThatWeCanCallSomeone(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS,
                    CALL
            );
        }
    }




    Button btnOpenUdemy;
    Button btnSearchGoogle;
    Button btnCall;
    Button btnAccessDialPad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verifyThatWeCanCallSomeone(MainActivity.this);


        btnOpenUdemy =  findViewById(R.id.btnOpenUdemy);
        btnSearchGoogle =  findViewById(R.id.btnSerachGoogle);
        btnCall =  findViewById(R.id.btnCall);
        btnAccessDialPad =  findViewById(R.id.btnAccessDialPad);


        btnOpenUdemy.setOnClickListener(MainActivity.this);
        btnSearchGoogle.setOnClickListener(MainActivity.this);
        btnCall.setOnClickListener(MainActivity.this);
        btnAccessDialPad.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.btnOpenUdemy:


                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.udemy.com"));
                startActivity(intent);

                break;

            case R.id.btnSerachGoogle:


                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("http://www.pakacademy79.com"));
                startActivity(intent2);

                break;

            case R.id.btnCall:

                if ( ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED ) {

                    ActivityCompat.requestPermissions( MainActivity.this, new String[] {  Manifest.permission.CALL_PHONE  }, CALL);

                } else {
                    Intent intent3 = new Intent(Intent.ACTION_CALL);
                    intent3.setData(Uri.parse("tel:344545465653232 "));
                    startActivity(intent3);
                }

                break;

            case R.id.btnAccessDialPad:


                Intent intent4 = new Intent(Intent.ACTION_DIAL);
                startActivity(intent4);

                break;

        }
    }
}
