package io.github.norritec.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class GreetingsActivity extends AppCompatActivity {

    private TextView mTextViewGreeting;

    private String gender, name,greeting, prefix, personalized_greeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);

        mTextViewGreeting = (TextView)findViewById(R.id.text_view_greeting);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            if (bundle.containsKey("gender")) {
                gender = bundle.getString("gender", "");
            }

            if (bundle.containsKey("name")){
                name = bundle.getString("name", "");
            }

            greeting = getGreeting();
            prefix = gender.equals("M") ? " Mr" : " Ms";
            personalized_greeting = getGreeting() + ", " + prefix + " " + name;
            mTextViewGreeting.setText(personalized_greeting);
        }


    }

    private String getGreeting() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        String greeting = "?";
        if (hour > 0 && hour <= 12)
            greeting = "Good Morning";
        else
        if (hour > 12 && hour <= 18)
            greeting = "Good Afternoon";
        else
        if (hour > 18 && hour <= 21)
            greeting = "Good Evening";
        else
        if (hour > 21 && hour <= 24)
            greeting = "Good Night";

        return greeting;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_greetings, menu);
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
