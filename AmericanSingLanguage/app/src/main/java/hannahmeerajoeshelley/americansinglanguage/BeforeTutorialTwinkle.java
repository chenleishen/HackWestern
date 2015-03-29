package hannahmeerajoeshelley.americansinglanguage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class BeforeTutorialTwinkle extends Activity implements View.OnClickListener {

    ImageButton signaway;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.before_tutorial_twinkle);

        signaway = (ImageButton) findViewById(R.id.sign);
        signaway.setOnClickListener(this);

    }
    public void onClick (View v){
        final Context context = this;
        Intent intent = new Intent(context, StartTutorial.class);
        startActivity(intent);
    }

}