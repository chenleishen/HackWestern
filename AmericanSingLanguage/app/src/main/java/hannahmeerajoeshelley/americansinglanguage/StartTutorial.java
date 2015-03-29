package hannahmeerajoeshelley.americansinglanguage;

import android.app.Activity;
import android.content.Intent;
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
    private SongHandler songHandler;
    private SongType songData;
    private String songName;
    private int pos;
    private final int videoView0 = R.id.video_view;
    private final int videoView1 = R.id.video_view1;


    public StartTutorial(){
        songHandler = new SongHandler();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // First thing is first get that data outta there
        Intent myIntent = getIntent();
        songName = myIntent.getStringExtra("songName");
        songData = songHandler.getSongMeta(songName);
        pos = 0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.asl_tutorial_page);

        TextView titleBox = (TextView) findViewById(R.id.TutorialTitle);

        // Play Video and hopefully it gets in a loop
        playNext();

        myVideoView.setOnCompletionListener(completionListener);
//        Log.d("SONG DATA", songData.getName());
//        for(int i = 0; i < songData.getSongLyrics().length; i++) {
//            if(songData.getLyricMap()[i] > 0) { //skip missing words
//                Log.d("SONG DATA", songData.getSongLyrics()[i]);
//                playView(videoView0, i);
//            }
//        }

    }
    public void playView(int viewID, int pos) {
        if (mediaPlay == null) {
            mediaPlay = MediaPlayer.create(this,songData.getLyricMap()[pos]);
        }

        myVideoView = (VideoView) findViewById(viewID);
        myVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + songData.getLyricMap()[pos]));
        myVideoView.start();
        while(myVideoView.isPlaying()){}
    }

   public void playNext(){
       if(pos < songData.getSongLyrics().length) {
//           if(pos % 2 == 0) {
//               myVideoView = (VideoView) findViewById(videoView1);
//               myVideoView.setVisibility(View.VISIBLE);
//               myVideoView.bringToFront();
//               playView(videoView0, pos);
//           }else{
//               myVideoView = (VideoView) findViewById(videoView0);
//               myVideoView.setVisibility(View.VISIBLE);
//               myVideoView.bringToFront();
//               playView(videoView0, pos);
//           }
           TextView titleBox = (TextView) findViewById(R.id.TutorialTitle);
           titleBox.setText(songData.getSongLyrics()[pos]);

           playView(videoView0, pos);
           pos++;
       }else{
           MediaPlayer mp = new MediaPlayer();
           mp.stop();
       }
   }


    private MediaPlayer.OnCompletionListener completionListener=new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mp) {
            mp.stop();
            playNext();
        }
    };
}
