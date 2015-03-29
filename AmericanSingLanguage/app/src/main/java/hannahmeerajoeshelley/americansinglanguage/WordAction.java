package hannahmeerajoeshelley.americansinglanguage;

/**
 * Created by joseph on 15-03-28.
 *
 * WordAction Object
 * Just a key/value pair
 *
 */
public class WordAction {
    private String lyricWord;
    private int lyricActionLink;

    public WordAction(String newWord, int newAction){
        lyricWord = newWord;
        lyricActionLink = newAction;
    }

    public String getLyricWord(){
        return lyricWord;
    }

    public int getLyricActionLink(){
        return lyricActionLink;
    }

    public void addWordAction(String newWord, int newAction){
        lyricWord = newWord;
        lyricActionLink = newAction;
    }
}
