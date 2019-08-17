package com.example.innu.webstorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ET_USER_NAME,ET_USER_PASS;
    String user_name,user_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          ET_USER_NAME=(EditText)findViewById(R.id.editText);
        ET_USER_PASS=(EditText)findViewById(R.id.editText2);


    }

    public  void SignUp(View view)
    {
        Intent i=new Intent(getApplicationContext(),registeractivity.class);
        startActivity(i);
    }
    public  void signin(View view)
    {
        user_name=ET_USER_NAME.getText().toString();
        user_pass=ET_USER_PASS.getText().toString();
        Toast.makeText(getApplicationContext(),user_name+" "+user_pass,Toast.LENGTH_LONG).show();
        String  method ="login";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        String res=String.valueOf(backgroundTask.execute(method,user_name,user_pass));
        if(method.equals("success"))
        {
            Intent i=new Intent(getApplicationContext(),homeactivity.class);
            startActivity(i);
        }
    }
}
