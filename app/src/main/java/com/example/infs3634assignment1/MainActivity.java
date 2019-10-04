package com.example.infs3634assignment1;

import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    Thread timing = null;
    Thread timing1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2();

        TextView cityName1 = (TextView)findViewById(R.id.cityName1);
        cityName1.setText("Sydney");
        TextView cityName2 = (TextView)findViewById(R.id.cityName2);
        cityName2.setText("New York");
        TextView cityName3 = (TextView)findViewById(R.id.cityName3);
        cityName3.setText("London");
        TextView cityName4 = (TextView)findViewById(R.id.cityName4);
        cityName4.setText("Moscow");
        TextView cityName5 = (TextView)findViewById(R.id.cityName5);
        cityName5.setText("Rome");
        TextView cityName6 = (TextView)findViewById(R.id.cityName6);
        cityName6.setText("Amsterdam");

        timing = new Thread(){
            public void run(){
                try{
                    while(!interrupted()){
                        Thread.sleep(1000);
                        button2();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        timing.start();

    }

    public void button1(){
        TextView time1 = (TextView)findViewById(R.id.time1);
        TextView time2 = (TextView)findViewById(R.id.time2);
        TextView time3 = (TextView)findViewById(R.id.time3);
        TextView time4 = (TextView)findViewById(R.id.time4);
        TextView time5 = (TextView)findViewById(R.id.time5);
        TextView time6 = (TextView)findViewById(R.id.time6);

        setTime1(time1, "Australia/Sydney");
        setTime1(time2, "America/New_York");
        setTime1(time3, "Europe/London");
        setTime1(time4, "Europe/Moscow");
        setTime1(time5, "Europe/Rome");
        setTime1(time6, "Europe/Amsterdam");
    }

    public void button2(){
        TextView time1 = (TextView)findViewById(R.id.time1);
        TextView time2 = (TextView)findViewById(R.id.time2);
        TextView time3 = (TextView)findViewById(R.id.time3);
        TextView time4 = (TextView)findViewById(R.id.time4);
        TextView time5 = (TextView)findViewById(R.id.time5);
        TextView time6 = (TextView)findViewById(R.id.time6);

        setTime2(time1, "Australia/Sydney");
        setTime2(time2, "America/New_York");
        setTime2(time3, "Europe/London");
        setTime2(time4, "Europe/Moscow");
        setTime2(time5, "Europe/Rome");
        setTime2(time6, "Europe/Amsterdam");
    }

    public void setTime2(TextView time, String timeZone){
        TimeZone tz = TimeZone.getTimeZone(timeZone);
        Calendar c = Calendar.getInstance(tz);
        String hour = String.format("%02d", c.get(Calendar.HOUR_OF_DAY));
        String minute = String.format("%02d", c.get(Calendar.MINUTE));
        String second = String.format("%02d", c.get(Calendar.SECOND));
        String day = String.format("%02d", c.get(Calendar.DAY_OF_MONTH));
        String month = String.format("%02d", c.get(Calendar.MONTH)+1);
        String year = String.format("%02d", c.get(Calendar.YEAR));
        time.setText(day + "/" + month + "/" + year + " " + hour + ":" + minute + ":" + second);
    }

    public void setTime1(TextView time, String timeZone){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
        TimeZone tz = TimeZone.getTimeZone(timeZone);
        Calendar c = Calendar.getInstance();
        sdf.setTimeZone(tz);
        time.setText(sdf.format(c.getTime()));
    }

    public void button1_click(View view){//24hr to 12hr
        if(timing != null){
            timing.interrupt();
            timing1 = new Thread(){
                public void run(){
                    try{
                        while(!interrupted()){
                            Thread.sleep(1000);
                            button1();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
            timing1.start();
        } else{
            timing.start();
        }
    }

    public void button2_click(View view){//12hr to 24hr
        if(timing1 != null){
            timing1.interrupt();
            timing = new Thread(){
                public void run(){
                    try{
                        while(!interrupted()){
                            Thread.sleep(1000);
                            button2();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
            timing.start();
        } else{
            timing1.start();
        }
    }

}
