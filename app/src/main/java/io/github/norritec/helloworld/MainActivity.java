package io.github.norritec.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.R.attr.checked;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextName;
    private Button mButtonSubmit;
    private Activity mActivity;

    private String name, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mEditTextName = (EditText) findViewById(R.id.edit_text_name);
        mButtonSubmit = (Button) findViewById(R.id.button_submit);
        mActivity = this;

        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextName.getText().toString().isEmpty()) {
                    Toast.makeText(mActivity, "Please enter your name", Toast.LENGTH_SHORT).show();
                } else {
                    name = mEditTextName.getText().toString();


                    //Now that we get the name and the gender, let us parcel
                    //them into a bundle and ship to the next Activity
                    Intent intent = new Intent(MainActivity.this, GreetingsActivity.class);
                    intent.putExtra("gender", gender);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        //is the radio in the first place
        boolean checked = ((RadioButton) view).isChecked();

        //find out which radio button was checked
        switch (view.getId()) {
            case R.id.checkbox_male:
                if (checked) {
                    gender = "M";
                }
                break;
            case R.id.checkbox_female:
                if (checked) {
                    gender = "F";
                }
                break;

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
