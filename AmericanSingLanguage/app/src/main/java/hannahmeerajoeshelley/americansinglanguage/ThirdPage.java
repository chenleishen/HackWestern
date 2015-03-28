package hannahmeerajoeshelley.americansinglanguage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;


public class ThirdPage extends Activity implements View.OnClickListener {

    RadioButton twinklebutton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_from_list);

        twinklebutton = (RadioButton) findViewById(R.id.radioButton);
        twinklebutton.setOnClickListener(this);
            
    }
        public void onClick (View v){
            final Context context = this;
            Intent intent = new Intent(context, StartTutorial.class);
            startActivity(intent);
        }

    }