package hannahmeerajoeshelley.americansinglanguage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.IOException;


public class MainActivity extends SecondPage implements View.OnClickListener {

    ImageButton nextbutton;
    Button startButton;

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
