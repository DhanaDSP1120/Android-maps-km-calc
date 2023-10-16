package com.dhanadsp1120.diatanceoftwopoint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
EditText la1,la2,lo1,lo2;
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        la1=findViewById(R.id.lat1);
        la2=findViewById(R.id.lat2);
        lo1=findViewById(R.id.lon1);
        lo2=findViewById(R.id.lon2);
        t=findViewById(R.id.distance);
    }
    public void calculate(View v)
    {
        int Radius = 6371;// radius of earth in Km
        String laa1= la1.getText().toString();
        String laa2= la2.getText().toString();
        String loo1= lo1.getText().toString();
        String loo2= lo2.getText().toString();
        double latt1 = Double.parseDouble(laa1);
        double latt2 = Double.parseDouble(laa2);
        double long1 = Double.parseDouble(loo1);
        double long2 = Double.parseDouble(loo2);
        double dLat = Math.toRadians(latt2 - latt1);
        double dLon = Math.toRadians(long2 - long1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(latt1))
                * Math.cos(Math.toRadians(latt2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        String x=Integer.toString(kmInDec);
        String xx=x+" KM";
        t.setText(xx);

    }
}
