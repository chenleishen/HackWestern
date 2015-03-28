package hannahmeerajoeshelley.americansinglanguage;

import java.io.IOException;

/**
 * Created by joseph on 15-03-28.
 */
public class ReadFileTest {
    public ReadFileTest(){
        //test1();
    }

    public void test1(){


        ReadFile test = new ReadFile("test.txt");
        String[] strTest = new String[0];
        try {
            strTest = test.openFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ApplicationTest.assertEquals("This is a test",strTest[0]);
        ApplicationTest.assertEquals("file",strTest[1]);
        ApplicationTest.assertEquals("and it",strTest[2]);
        ApplicationTest.assertEquals("works",strTest[3]);
    }

}
