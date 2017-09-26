package edu.itesm.mpeyrotc.primerosauxilios;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolBar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolBar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            Intent intent = null;

            switch (item.getItemId()) {
                case R.id.nav_credits:
                    intent = new Intent(MainActivity.this, CreditsActivity.class);
                    break;
                case R.id.nav_info:
                    intent = new Intent(MainActivity.this, InfoActivity.class);
                    break;
                case R.id.nav_services:
                    intent = new Intent(MainActivity.this, ServicesActivity.class);
                    break;
            }

            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
