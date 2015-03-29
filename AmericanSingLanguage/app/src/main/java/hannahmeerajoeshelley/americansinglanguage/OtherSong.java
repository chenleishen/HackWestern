package hannahmeerajoeshelley.americansinglanguage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;


public class OtherSong extends Activity implements View.OnClickListener {

    ImageButton signaway;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_song);

        signaway = (ImageButton) findViewById(R.id.sign);
        signaway.setOnClickListener(this);

    }
    public void onClick (View v){
        final Context context = this;
        Intent intent = new Intent(context, StartTutorial.class);
        startActivity(intent);
    }


}