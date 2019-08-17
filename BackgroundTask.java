package com.example.innu.webstorage;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class BackgroundTask extends AsyncTask<String,Void,String> {
Context ctx;
    BackgroundTask(Context ctx){
        this.ctx=ctx;
        Log.i("WebApp","Inside constr.....!");

    }
    @Override
    protected String doInBackground(String... params) {
       String url_reg="http://192.168.137.1:8080/webproject/insertUser";
        String url_log="http://192.168.137.1:8080/webproject/validateUser";

        Log.i("WebApp","Inside doInBack.....!");

        String method=params[0];
        URL url=null;
        HttpURLConnection httpURLConnection=null;
        OutputStream os=null;
        BufferedWriter bw=null;
        if(method.equalsIgnoreCase("register")){
            Log.i("WebApp","Inside doInBack if.....!");
            String name=params[1];
            String user_name=params[2];
            String user_pass=params[3];
            try{
                url=new URL(url_reg);
                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                os=httpURLConnection.getOutputStream();
                bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                //charset name=utf-8
                String data= URLEncoder.encode("name","UTF-8")+"="+
                        URLEncoder.encode(name,"UTF-8")+"&"+
                                URLEncoder.encode("user_name","UTF-8")+"="+
                                        URLEncoder.encode(user_name,"UTF-8")+"&"+
                                                URLEncoder.encode("user_pass","UTF-8")+"="+
                                                        URLEncoder.encode(user_pass,"UTF-8");

                bw.write(data);
                Log.i("WebApp","data send successfully to server.....!");
                bw.flush();
                bw.close();
                os.close();
                InputStream is=httpURLConnection.getInputStream();
                is.close();

                return "success";

            }catch(MalformedURLException  e){
                e.printStackTrace();
            }
            catch(IOException io){
                io.printStackTrace();
            }

        }
        else if(method.equalsIgnoreCase("login")){

            String user_name=params[1];
            String user_pass=params[2];
            try{
                url=new URL(url_log);
                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                os=httpURLConnection.getOutputStream();
                bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                //charset name=utf-8
                String data= URLEncoder.encode("user_name","UTF-8")+"="+
                        URLEncoder.encode(user_name,"UTF-8")+"&"+
                        URLEncoder.encode("user_pass","UTF-8")+"="+
                        URLEncoder.encode(user_pass,"UTF-8");

                bw.write(data);
                bw.flush();
                bw.close();
                os.close();
                InputStream is=httpURLConnection.getInputStream();
                is.close();

                return "success";

            }catch(MalformedURLException  e){
                e.printStackTrace();
            }
            catch(IOException io){
                io.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(ctx,s,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
