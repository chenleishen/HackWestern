package hannahmeerajoeshelley.americansinglanguage;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by chenleishen on 15-03-28.
 */

public class StartTutorial extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asl_tutorial_page);
        String mary = getResources().getString(R.string.my_big_string);
        String[] words = mary.split(" ");
    }

}
