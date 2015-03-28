package hannahmeerajoeshelley.americansinglanguage;

/**
 * Created by meerakanani on 15-03-28.
 */

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {
    private String path;
    public ReadFile(String file_path) {
        path = file_path;
    }

    private int readLines() throws IOException {
        FileReader fileToRead = new FileReader(path);
        BufferedReader bf = new BufferedReader(fileToRead);

        String aLine;
        int numberOfLines = 0;
        while ( (aLine = bf.readLine()) != null) {
            numberOfLines++;
        }
        bf.close();
        return numberOfLines;

    }

    public String [] Openfile() throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);

        int numberOfLines = readLines();

        String[] textData = new String[numberOfLines];



        int i;


        for(i = 0; i < numberOfLines; i++) {

            textData[i] = textReader.readLine();
        }
        return textData;
    }

}
