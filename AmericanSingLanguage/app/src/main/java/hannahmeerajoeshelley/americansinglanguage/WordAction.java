package hannahmeerajoeshelley.americansinglanguage;

/**
 * Created by joseph on 15-03-28.
 */
public class WordAction {
    private String lyricWord;
    private String lyricActionLink;

    public WordAction(String newWord, String newAction){
        lyricWord = newWord;
        lyricActionLink = newAction;
    }

    public String getLyricWord(){
        return lyricWord;
    }

    public String getLyricActionLink(){
        return lyricActionLink;
    }

    public void addWordAction(String newWord, String newAction){
        lyricWord = newWord;
        lyricActionLink = newAction;
    }
}
