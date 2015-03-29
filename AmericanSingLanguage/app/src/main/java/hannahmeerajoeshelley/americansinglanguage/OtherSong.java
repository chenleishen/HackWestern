package hannahmeerajoeshelley.americansinglanguage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class OtherSong extends Activity implements View.OnClickListener {

    ImageButton signaway;
    RadioButton radioButton1, radioButton2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_song);

        signaway = (ImageButton) findViewById(R.id.sign);
        signaway.setOnClickListener(this);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);

    }
    public void onClick (View v){
        final Context context = this;
        Intent intent =  null;
        if(radioButton1.isChecked() || radioButton2.isChecked()) {
            intent = new Intent(context, StartTutorial.class);
            startActivity(intent);

        }
        // prompt and refresh page
        else {
                /*new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Remember to select a radio box first")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //continue
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert).show();*/
            //intent = new Intent(context, BeforeTutorialTwinkle.class);
            finish();
            startActivity(getIntent());
        }
    }


}