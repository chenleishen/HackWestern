package hannahmeerajoeshelley.americansinglanguage;

import java.util.ArrayList;

/**
 * Created by joseph on 15-03-28.
 */
public class LyricsHandler {
    //ActionList
    private ArrayList<WordAction> savedActionList = new ArrayList<WordAction>();

    public LyricsHandler() {
        buildActionList(); //Add Twinkle Twinkle Little Star word list
    }

    /* buildActionList
     * Builds twinkle twinkle little star's word list
     *
     */
    private void buildActionList(){
        savedActionList.add(new WordAction("a",""));
        savedActionList.add(new WordAction("above",""));
        savedActionList.add(new WordAction("are",""));
        savedActionList.add(new WordAction("diamond",""));
        savedActionList.add(new WordAction("high",""));
        savedActionList.add(new WordAction("how",""));
        savedActionList.add(new WordAction("i",""));
        savedActionList.add(new WordAction("in",""));
        savedActionList.add(new WordAction("like",""));
        savedActionList.add(new WordAction("little",""));
        savedActionList.add(new WordAction("sky",""));
        savedActionList.add(new WordAction("so",""));
        savedActionList.add(new WordAction("star",""));
        savedActionList.add(new WordAction("the",""));
        savedActionList.add(new WordAction("twinkle",""));
        savedActionList.add(new WordAction("up",""));
        savedActionList.add(new WordAction("what",""));
        savedActionList.add(new WordAction("wonder",""));
        savedActionList.add(new WordAction("world",""));
        savedActionList.add(new WordAction("you",""));
    }

    /* lyricsToActions
     * String (object) -> String
     *
     * Takes a word and an object WordAction and returns the matching lyric action link
     *
     */
    public String lyricsToActions(String readWord, ArrayList<WordAction> savedAction) {
        String tempReadWord = readWord.toUpperCase();
        //String tempReadAction = "";

        // TODO: optimize search for action fn - JSA
        // TODO: search action fn by sorting/hashing(?) then looking up hashed key(?)
        int i = savedAction.size() - 1;
        for (; i >= 0; --i) {
            if (tempReadWord.equals(savedAction.get(i).getLyricWord().toUpperCase())){
                return savedAction.get(i).getLyricActionLink();
            }
        }
        return "NO SIGN AVAILABLE";
    }


    /* lyricsReadFromFile
     * String -> (ArrayOf String)
     *
     * Takes a word and an object WordAction and returns the matching lyric action link
     *
     */
}
