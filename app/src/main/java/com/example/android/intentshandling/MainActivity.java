package com.example.android.intentshandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sendMessage;
    Button call;
    EditText mobileNO;
    EditText messageBody;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendMessage = findViewById(R.id.btnSend);
        mobileNO = findViewById(R.id.mblTxt);
        messageBody = findViewById(R.id.msgTxt);
        call = findViewById(R.id.btnCall);

        sendMessage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("smsto:"));
                    i.setType("vnd.android-dir/mms-sms");
                    i.putExtra("address", new String(mobileNO.getText().toString()));
                    i.putExtra("sms_body", new String(messageBody.getText().toString()));
                    startActivity(Intent.createChooser(i, "Send sms via:"));
                }//end try

                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Error" + e.getMessage(), Toast.LENGTH_LONG).show();
                }//end catch

            }//end onClick()
        });
        ///////////////////////
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String phoneNO = "+968 92546999";
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNO, null));
                    startActivity(callIntent);
                }//end try
                
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Error" + e.getMessage(), Toast.LENGTH_LONG).show();
                }//end cach
            }//end onClick()
        });


    }//end onCreate()
}//end class