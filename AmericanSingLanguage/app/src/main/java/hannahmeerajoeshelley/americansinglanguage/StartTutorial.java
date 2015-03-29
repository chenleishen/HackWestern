package hannahmeerajoeshelley.americansinglanguage;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;


/**
 * Created by chenleishen on 15-03-28.
 */

public class StartTutorial extends Activity {

    private VideoView myVideoView;
    //private int position = 0;
    //private ProgressDialog progressDialog;
    private MediaPlayer mediaPlay;
    private String word="twinkle";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.asl_tutorial_page);

        TextView titleBox = (TextView) findViewById(R.id.TutorialTitle);
        String mary = getResources().getString(R.string.my_big_string);
        String[] words = mary.split("");

        playWord();

        myVideoView.setOnCompletionListener(completionListener);

//        int i = 0;
//        int size = words.length;
//
//        while(i < size) {
//                word = words[i];
//                titleBox.setText(word);
//                //playWord(word);
//                //i+=1;
//        }

    }

    public void playWord() {
        if (mediaPlay == null) {
            mediaPlay = MediaPlayer.create(this,R.raw.twinkle);
        }

        myVideoView = (VideoView) findViewById(R.id.video_view);
        myVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.twinkle));
        myVideoView.start();

    }

    private MediaPlayer.OnCompletionListener completionListener=new MediaPlayer.OnCompletionListener() {

        public void onCompletion(MediaPlayer mp) {
            mp.stop();
            playWord();
        }
    };


}
