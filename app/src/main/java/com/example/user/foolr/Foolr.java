package com.example.user.foolr;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStreamWriter;


public class Foolr extends ActionBarActivity {
    TextView txt;
    EditText passwd;
    private final static String STORETEXT="storetext.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foolr);
        ImageView image1 = (ImageView) findViewById(R.id.imageView);
        image1.setImageResource(R.drawable.img1);
        boolean firstTime = true;
        Toast.makeText(this, "looks like your first time please input your password.", Toast.LENGTH_LONG).show();

        txt = (TextView)findViewById(R.id.textView);
        passwd = (EditText) findViewById(R.id.editText);

    final String passwordStorage = "";
        passwd.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                   saveClicked();
                    System.out.println();
                    if(passwd.getText().toString() == passwordStorage){
                       // Go to next activity
                   }

                    return true;
                }
                return false;
            }

    });
    }
    public void saveClicked() {

        try {

            OutputStreamWriter out= new OutputStreamWriter(openFileOutput(STORETEXT, 0));

            out.write(passwd.getText().toString());

            out.close();

            Toast.makeText(this, "The contents are saved in the file.", Toast.LENGTH_LONG).show();

            System.out.print("test");
        }

        catch (Throwable t) {

            Toast

                    .makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG)

                    .show();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_foolr, menu);
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

    public void setTxt()
    {
        txt.setText(passwd.getText());
    }
}
