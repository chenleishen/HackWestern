/**
 * Created by Hannah on 15-03-28.
 */
package hannahmeerajoeshelley.americansinglanguage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

    public class SecondPage extends Activity implements View.OnClickListener {

        ImageButton listbutton;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            listbutton = (ImageButton) findViewById(R.id.ChooseFromListButton);
            listbutton.setOnClickListener(this);
        }

        public void onClick (View v){
            final Context context = this;
            Intent intent = new Intent(context, ThirdPage.class);
            startActivity(intent);
        }

    }
