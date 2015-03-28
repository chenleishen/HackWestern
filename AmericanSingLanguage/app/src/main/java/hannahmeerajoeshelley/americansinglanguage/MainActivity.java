package hannahmeerajoeshelley.americansinglanguage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import java.io.IOException;


public class MainActivity extends SecondPage implements View.OnClickListener {

    ImageButton nextbutton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        nextbutton = (ImageButton) findViewById(R.id.NextButton);
        nextbutton.setOnClickListener(this);
    }

    public void onClick (View v){
        final Context context = this;
        Intent intent = new Intent(context, SecondPage.class);
        startActivity(intent);
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

    public void addListenerOnButton() {

        final Context context = this;

        ImageButton button;

        button = (ImageButton) findViewById(R.id.NextButton);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, SecondPage.class);
                startActivity(intent);

            }

        });

    }

    public class FileData {
        public void main(String[] args) throws IOException {

            String file_name = "testText.txt";
        }

    }
}
