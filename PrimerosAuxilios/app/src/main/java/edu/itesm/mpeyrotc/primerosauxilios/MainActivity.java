package edu.itesm.mpeyrotc.primerosauxilios;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    TextView textView;
    EditText editText;
    Button button;


    private class WatsonTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView.setText("running the watson thread.");
                }
            });

            return "text to speech done.";
        }

        @Override
        protected void onPostExecute(String result) {
            textView.setText("TTS Status: " + result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_field);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        mToolBar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("The text to speech: " + editText.getText());
                textView.setText("TTS: " + editText.getText());

                WatsonTask task = new WatsonTask();
                task.execute(new String[]{});
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.nav_credits:
                intent = new Intent(this, CreditsActivity.class);
                this.startActivity(intent);
                break;
            case R.id.nav_info:
                intent = new Intent(this, InfoActivity.class);
                this.startActivity(intent);
                break;
            case R.id.nav_services:
                intent = new Intent(this, ServicesActivity.class);
                this.startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
