package hannahmeerajoeshelley.americansinglanguage;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


/**
 * Created by chenleishen on 15-03-28.
 */

public class StartTutorial extends Activity {

    private VideoView myVideoView;
    private int position = 0;
    private ProgressDialog progressDialog;
    private MediaPlayer mediaPlay;
    private String word="twinkle";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.asl_tutorial_page);

        if (mediaPlay == null) {
            mediaPlay = MediaPlayer.create(this,R.raw.twinkle);
        }

        myVideoView = (VideoView) findViewById(R.id.video_view);
        myVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.twinkle));
        myVideoView.start();

//        progressDialog = new ProgressDialog(StartTutorial.this);
//        progressDialog.show();

//        try {
//            //set the media controller in the VideoView
//            myVideoView.setMediaPlayer(mediaPlay);
//            //set the uri of the video to be played
//            myVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.twinkle));
//        } catch (Exception e) {
//            Log.e("Error", e.getMessage());
//            e.printStackTrace();
//        }

//        myVideoView.requestFocus();
//        //we also set an setOnPreparedListener in order to know when the video file is ready for playback
//        myVideoView.setOnPreparedListener(new OnPreparedListener() {
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                // close the progress bar and play the video
//                progressDialog.dismiss();
//                //if we have a position on savedInstanceState, the video playback should start from here
//                myVideoView.seekTo(position);
//                if (position == 0) {
//                    myVideoView.start();
//                } else {
//                    //if we come from a resumed activity, video playback will be paused
//                    myVideoView.pause();
//                }
//            }
//        });


        //String mary = getResources().getString(R.string.my_big_string);
        //String[] words = mary.split("");

    }

}
