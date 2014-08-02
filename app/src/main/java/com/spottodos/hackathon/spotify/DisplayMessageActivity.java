package com.spottodos.hackathon.spotify;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.spottodos.hackathon.spotify.R;

import org.w3c.dom.Text;

public class DisplayMessageActivity extends Activity {

    private final String tag = "com.spottodos.hackathon.spotify.DisplayMessageActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String msg = getIntent().getStringExtra(MyActivity.EXTRA_MESSAGE);
        setContentView(R.layout.activity_display_message);
        TextView textView = (TextView) findViewById(R.id.displayText);
        textView.setText(msg);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
