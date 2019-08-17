package com.example.innu.webstorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registeractivity extends AppCompatActivity {
EditText ET_NAME,ET_USERNAME,ET_PASSWORD;
    String name,user_name,user_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);

        ET_NAME=(EditText)findViewById(R.id.editText3);
        ET_USERNAME=(EditText)findViewById(R.id.editText4);
        ET_PASSWORD=(EditText)findViewById(R.id.editText5);


    }

    public void register(View view){
        name=ET_NAME.getText().toString();
        user_name=ET_NAME.getText().toString();
        user_pass=ET_NAME.getText().toString();
        Toast.makeText(getApplicationContext(),"name"+name+"user name"+user_name+"user password"+user_pass,Toast.LENGTH_LONG).show();
        String method="register";
        BackgroundTask backgroundtask=new BackgroundTask(this);
        backgroundtask.execute(method,name,user_name,user_pass);
        Log.i("WebApp","data aseved on server.....!");
       //String msg= String.valueOf(backgroundtask.execute(method,name,user_name,user_pass));

        //if(msg.equals("success"))
        //{

          //  Intent i=new Intent(getApplicationContext(),homeactivity.class);
           // startActivity(i);
        //}
        finish();


    }
}
