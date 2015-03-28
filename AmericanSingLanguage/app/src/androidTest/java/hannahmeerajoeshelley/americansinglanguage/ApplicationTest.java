package hannahmeerajoeshelley.americansinglanguage;

import android.app.Application;
import android.test.ApplicationTestCase;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);

        LyricsHandlerTest test = new LyricsHandlerTest();
        ReadFileTest test1 = new ReadFileTest();
    }

//        String file_name = "testText.txt";
//        ReadFile reading = new ReadFile("testText.txt");
//        reading.Openfile();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
}