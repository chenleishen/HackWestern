package hannahmeerajoeshelley.americansinglanguage;


import android.util.Log;

import java.util.ArrayList;

/**
 * Created by joseph on 15-03-28.
 */
public class LyricsHandlerTest extends LyricsHandler {

    public LyricsHandlerTest(){
        Log.d("ALOG", "hello");
        ArrayList<WordAction> testActionList = new ArrayList<WordAction>();
        testActionList.add(new WordAction("a","1"));
        testActionList.add(new WordAction("b","2"));
        testActionList.add(new WordAction("c","3"));

        //WordToActions.class.sub;
        ApplicationTest.assertEquals("2",lyricsToActions("b",testActionList));
        ApplicationTest.assertEquals("3",lyricsToActions("c",testActionList));
        ApplicationTest.assertEquals("1",lyricsToActions("a",testActionList));

        String[] testAPI = lyricReadAPI("hot cross buns");
        Log.d("Lyrics API Attempt", "API~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Log.d("Lyrics API Attempt", "API " + testAPI[0]);
        //Log.d("TEST APP", "" + testAPI[1]);
        //ApplicationTest.assertEquals("1", testAPI[0]);
    }
}
