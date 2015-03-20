package com.app.myapplication.app.droidbatna.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;



public class MainActivity extends ActionBarActivity {

    TextView txt;

    EditText a;
    EditText b;
    EditText c;
    Button btn;
    CheckBox ax; //Les checkbox pour donnez des nombres négatif car j'ai mis inputtype dans les edittext : Number only
    CheckBox bx;
    CheckBox cx;

    String a1;
    String b1;
    String c1;

    int a2=0;
    int b2=0;
    int c2=0;

    int delta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.txt);
        a=(EditText)findViewById(R.id.a);
        b=(EditText)findViewById(R.id.b);
        c=(EditText)findViewById(R.id.c);

        ax=(CheckBox)findViewById(R.id.aneg);
        bx=(CheckBox)findViewById(R.id.bneg);
        cx=(CheckBox)findViewById(R.id.cneg);
    }
    public void solve(View view) { //cette fonction sera appleé si l'utilisateur clique sur le bouton (voir le fichier xml MainActivity onClick)
        a1 = a.getText().toString();
        b1 = b.getText().toString();
        c1 = c.getText().toString();

        if (a1.equals("") || b1.equals("") || c1.equals("")) { //pour vérifier si les cases sont vides ou non
            Toast.makeText(this, "SVP completéz les données !", Toast.LENGTH_SHORT).show();
        } else {
            a2 = Integer.parseInt(a1);
            if (ax.isChecked()) { //si le nombre est negatif ( check box is true)
                a2 = a2 * -1;
            }
            b2 = Integer.parseInt(b1);
            if (bx.isChecked()) {
                b2 = b2 * -1;
            }
            c2 = Integer.parseInt(c1);
            if (cx.isChecked()) {
                c2 = c2 * -1;
            }

            delta = b2 * b2 - 4 * a2 * c2;

            Intent i = new Intent(MainActivity.this, MainActivity2.class); //intent pour une autre activity
            i.putExtra("delta", delta);
            i.putExtra("a", a2);
            i.putExtra("b", b2);
            i.putExtra("c", c2);
            startActivity(i);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

