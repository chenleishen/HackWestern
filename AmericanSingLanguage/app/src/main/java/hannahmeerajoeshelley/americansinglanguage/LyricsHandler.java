package hannahmeerajoeshelley.americansinglanguage;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by joseph on 15-03-28.
 *
 * Random thought: When pulling from the DB. Save each song is it's own table
 *      This way the user "downloads" a song and only that small table is required
 *      and so there's no need to search the entire DB just the one relevant to the song.
 *
 *      Implementation: buildActionList will build just before playing a song(?).
 *      SQLlite will save each actionList for the song -- This whole thing will be slow.
 *
 *
 *
 */
public class LyricsHandler {
    //ActionList DEPRECIATED(?)
    private ArrayList<WordAction> savedActionList = new ArrayList<WordAction>();

    public LyricsHandler() {
        buildActionList(); //Add Twinkle Twinkle Little Star word list
    }

    /* buildActionList
     * Builds twinkle twinkle little star's word list
     * DEPRECIATED
     */
    private void buildActionList(){
        //TODO: Convert this to use a SQLlite

        //TEMP: Manually add to list
        buildTwinkle();
    }

    //DEPRECIATED TODO: Remove this
    private void buildTwinkle(){ //WTF is wrong with me just get the media/{word}.mp4
        savedActionList.add(new WordAction("a","media/a.mp4"));
        savedActionList.add(new WordAction("above","media/above.mp4"));
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
     * Overloading function
     * DEPRECIATED
     */
    private String lyricsToActions(String readWord) {
        return lyricsToActions(readWord, savedActionList);
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


    /* lyricsReadFile
     * String -> (ArrayOf String)
     *
     * ...
     *
     */
    public String[] lyricsReadFile(String songPath){
        String[] lyricsUntouched = null; //TODO: Change this
        //TODO: Finish this method

        return lyricsUntouched;
    };

    /* lyricsReadAPI
     * String -> (ArrayOf Strings)
     */
    public String[] lyricReadAPI(String songName){
        String searchSongName = songName.replace(" ", "+");
        Log.d("lyric API Attempt","searchSongName = " + searchSongName);
        GetHttp cURL = new GetHttp();
        String trackID = cURL.getResponse("https://musixmatchcom-musixmatch.p.mashape.com/wsr/1.1/track.search?f_has_lyrics=1&page=1&page_size=5&q=" + searchSongName, "track_id");
        Log.d("lyric API Attempt", "trackID = " + trackID);
        String lyricsUntouched = cURL.getResponse("GEThttps://musixmatchcom-musixmatch.p.mashape.com/wsr/1.1/track.lyrics.get?track_id=" + trackID, "lyrics_body");
        Log.d("lyric API Attempt", "lyricsUntouched = " + lyricsUntouched);
        String[] lyricsNewLine = lyricsUntouched.split("\n\r");
        return lyricsNewLine;
    }

    public String lyricsRetrieveMemory(String songName){
        String lyricGroup = new String();
        if(songName.toUpperCase().equals("TWINKLE TWINKLE LITTLE STAR")){
            lyricGroup = "Twinkle, twinkle, little star,\n" +
                            "How I wonder what you are.\n" +
                            "Up above the world so high,\n" +
                            "Like a diamond in the sky.\n" +
                            "Twinkle, twinkle, little star.\n" +
                            "How I wonder what you are.";
        }

        return lyricGroup;
    }


    // Local-only constants
    private static final byte FILE = 0;
    private static final byte API = 1;
    private static final byte SQLLITE = 2;
    private static final byte HARD = 3;
    /* parseLyrics
     * (String String) -> (ArrayOf String)
     * Either the file name or song name to get from API is the input
     *
     * ... get lyrics from any source (toggle option)
     *      then passes it through lyricsToActions
     *
     *     TODO: Depreciate this
     *
     */
    public String[] parseLyrics(String nameOfSong, byte retrievalType){ //ArrayList<String> parseLyrics(String nameOfSong, byte retrievalType){
        String[] lyricsUntouched = null;
        String lyricsNTouched = null;
        //ArrayList<String> makeActionList = new ArrayList<String>();

        // Get from File
        if(retrievalType == FILE){
            lyricsUntouched = lyricsReadFile(nameOfSong); //TODO: Merge ReadFile & ReadAPI
        }
        // Get from API
        if(retrievalType == API) {
            //lyricsUntouched = lyricsReadAPI(nameOfSong); //TODO: Use API from MashApe?
        }

        if(retrievalType == SQLLITE) {
            //lyricsUntouched = lyricsReadAPI(nameOfSong); //TODO: Add this one eventually?
        }

        if(retrievalType == HARD){
            lyricsNTouched = lyricsRetrieveMemory(nameOfSong);
        }

//        int i = lyricsUntouched.length - 1, b = i;
//        for(; i>=0; --i) {
//            String[] lyricLines = lyricsUntouched[b - i].split("[ .,\n\r]+");
//            int j = lyricLines.length - 1, c = j;
//            for(; j>=0; --j) {
//                makeActionList.add(lyricsToActions(lyricLines[c - j]));
//            }
//        }

        String[] lyricsTouched = lyricsNTouched.split("[ .,\n\r]+");

        return lyricsTouched;
    }

    private String[] songMapRetrieveMemory(String nameOfSong){
        String[] songMap = null;

        if(nameOfSong.toUpperCase().equals("TWINKLE TWINKLE LITTLE STAR")){
            String[] songMapTemp = {"4","1","2","3"
                                   ,"5","1","2","2","1","1"
                                   ,"3","1","2","1","1","1"
                                   ,"3","1","1","2","1","1"
                                   ,"4","2","2","2"
                                   ,"4","1","1","1","2","2"};
            songMap = songMapTemp;
        }

        return songMap;
    }


    public String[] getLyricMap(String nameOfSong, byte retrievalType){
        String[] songMap = null;

        // TODO: Impliment these
        // if(retievalType == FILE){}
        // if(retievalType == API){}
        // if(retievalType == SQLLITE){}

        if(retrievalType == HARD){
            songMap = songMapRetrieveMemory(nameOfSong);
        }

        return songMap;
    }

}
