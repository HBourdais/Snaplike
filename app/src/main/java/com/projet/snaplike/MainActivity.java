package com.projet.snaplike;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab_plus, fab_calendar, fab_fb;
    Animation FabOpen, FabClose, FabRClockwise, FabRanticlockwise;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_calendar = (FloatingActionButton) findViewById(R.id.fab_calendar);
        fab_fb = (FloatingActionButton) findViewById(R.id.fab_fb);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        FabRClockwise  = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        FabRanticlockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);
        fab_plus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (isOpen)
                {
                    fab_fb.startAnimation(FabClose);
                    fab_calendar.startAnimation(FabClose);
                    fab_plus.startAnimation(FabRanticlockwise);
                    fab_calendar.setClickable(false) ;
                    fab_fb.setClickable(false) ;
                    isOpen = false;

                }
                else
                {
                    fab_fb.startAnimation(FabOpen);
                    fab_calendar.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabRClockwise);
                    fab_calendar.setClickable(true) ;
                    fab_fb.setClickable(true);
                    isOpen = true;

                }

            }

        });

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
