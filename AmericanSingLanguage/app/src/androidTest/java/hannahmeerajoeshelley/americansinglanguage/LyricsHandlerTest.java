package hannahmeerajoeshelley.americansinglanguage;


import java.util.ArrayList;

/**
 * Created by joseph on 15-03-28.
 */
public class LyricsHandlerTest extends LyricsHandler {

    public LyricsHandlerTest(){
        ArrayList<WordAction> testActionList = new ArrayList<WordAction>();
        testActionList.add(new WordAction("a","1"));
        testActionList.add(new WordAction("b","2"));
        testActionList.add(new WordAction("c","3"));

        //WordToActions.class.sub;
        ApplicationTest.assertEquals("2",lyricsToActions("b",testActionList));
        ApplicationTest.assertEquals("3",lyricsToActions("c",testActionList));
        ApplicationTest.assertEquals("1",lyricsToActions("a",testActionList));
    }
}
