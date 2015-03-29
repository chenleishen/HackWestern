package hannahmeerajoeshelley.americansinglanguage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;


public class ThirdPage extends Activity implements View.OnClickListener {

    RadioButton songbutton, songbutton1;
    int songselected;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_from_list);

        songbutton = (RadioButton) findViewById(R.id.radioButton);
        songbutton.setOnClickListener(this);
        songbutton1 = (RadioButton) findViewById(R.id.radioButton3);
        songbutton1.setOnClickListener(this);

    }
        public void onClick (View v){
            //get radio id
            //int selectedId = ((RadioButton) findViewById(R.id.radioButton)).getId();
            final Context context = this;
            Intent intent = null;
            if(songbutton.isChecked()) {
                intent = new Intent(context, BeforeTutorialTwinkle.class);
            }else if(songbutton1.isChecked()) {
                intent = new Intent(context, OtherSong.class);
            }
            startActivity(intent);
            //go to other song page
            


            //songbutton.getText()

        }



    }