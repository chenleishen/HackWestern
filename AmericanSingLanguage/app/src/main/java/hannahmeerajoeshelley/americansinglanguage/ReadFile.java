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
        try{
            FileReader fileToRead = new FileReader(path);
            BufferedReader bf = new BufferedReader(fileToRead);

            String aLine = bf.readLine();
            int numberOfLines = 0;
            while (aLine == null){
                numberOfLines++;
                aLine = bf.readLine();
            }
            bf.close();
            fileToRead.close();
            return numberOfLines;

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String[] openFile() throws IOException {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader textReader = new BufferedReader(fr);

            int numberOfLines = readLines();

            String[] textData = new String[numberOfLines];


            int i;


            for(i = 0; i < numberOfLines; i++) {

                textData[i] = textReader.readLine();
            }
            fr.close();
            textReader.close();
            return textData;
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }
}
