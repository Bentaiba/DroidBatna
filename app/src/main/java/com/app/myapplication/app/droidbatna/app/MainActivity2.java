package com.app.myapplication.app.droidbatna.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity2 extends ActionBarActivity {

    TextView sol;
    TextView d;
    TextView x1;
    TextView x2;

    int delta;
    double s1;
    double s2;

    int a;
    int b;
    int c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        sol=(TextView)findViewById(R.id.sol);
        d=(TextView)findViewById(R.id.delta);
        x1=(TextView)findViewById(R.id.x1);
        x2=(TextView)findViewById(R.id.x2);

        Intent i = this.getIntent();
        delta=i.getIntExtra("delta",-1);

        a=i.getIntExtra("a",0);
        b=i.getIntExtra("b",0);
        c=i.getIntExtra("c",0);

        if(delta>0 && a!=0){ //Calcul des solutions et delta

            sol.setText("Les 2 solutions sont :");
            d.setText("Delta = " + delta);

            s1=(-b-Math.sqrt(delta))/(2*a);
            s2=(-b+Math.sqrt(delta))/(2*a);
            x1.setText("x1 = "+s1);
            x2.setText("x2 = "+s2);

        }else if(delta==0 && a!=0){

            sol.setText("La solution est :");
            d.setText("Delta = " + delta);
            s1=(-b)/(2*a);
            x1.setText("x = "+s1);

        }else if(delta<0 && a!=0){

            sol.setText("il n ' y pas de solutions :");
            d.setText("Delta = " + delta);

        }else if(a==0){

            sol.setText(" a=0 c'est impossible de resoudre l'equation");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
