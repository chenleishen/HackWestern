package hannahmeerajoeshelley.americansinglanguage;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
    private SongHandler songHandler;
    private SongType songData;
    private String songName;

    public StartTutorial(){
        songHandler = new SongHandler();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // First thing is first get that data outta there
        Intent myIntent = getIntent();
        songName = myIntent.getStringExtra("songName");
        songData = songHandler.getSongMeta(songName);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.asl_tutorial_page);

        TextView titleBox = (TextView) findViewById(R.id.TutorialTitle);
//        String mary = getResources().getString(R.string.twinkle_twinkle_little_star);
//        String[] words = mary.split("");
//        titleBox.setText(word);
        final int videoView0 = R.id.video_view, videoView1 = R.id.video_view1;

        Log.d("SONG DATA", songData.getName());
        for(int i = 0; i < songData.getSongLyrics().length; i++) {
            if(songData.getLyricMap()[i] > 0) { //skip missing words
                Log.d("SONG DATA", songData.getSongLyrics()[i]);
                playView(videoView0, 0);
            }
        }

    }
    public void playView(int viewID, int pos) {
        if (mediaPlay == null) {
            mediaPlay = MediaPlayer.create(this,songData.getLyricMap()[pos]);
        }

        myVideoView = (VideoView) findViewById(viewID);
        //myVideoView.setVisibility(View.VISIBLE);
        //myVideoView.bringToFront();
        myVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + songData.getLyricMap()[pos]));
        myVideoView.start();
        while(myVideoView.isPlaying()){}
//        myVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                //myVideoView.setVisibility(View.INVISIBLE);
//
//            }
//        });
    }


}
