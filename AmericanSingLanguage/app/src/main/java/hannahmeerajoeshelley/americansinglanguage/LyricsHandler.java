package hannahmeerajoeshelley.americansinglanguage;

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
        //TODO: Convert this to use a SQLlite

        //TEMP: Manually add to list
        buildTwinkle();
    }

    private void buildTwinkle(){
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
     * Overloading function
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
        String[] lyricsUntouched = new String[0]; //TODO: Change this
        //TODO: Finish this method

        return lyricsUntouched;
    };

    /* lyricsReadAPI
     * String -> (ArrayOf Strings)
     */
    public String[] lyricReadAPI(String songName){
        int trackID = 0;

        // curl --get --include "https://musixmatchcom-musixmatch.p.mashape.com/wsr/1.1/track.search?f_has_lyrics=1&page=1&page_size=5&q=Every+tear+drop+paradise+coldpay&q_artist=coldplay&q_lyrics=Every+tear+a+waterfall&q_track=paradise&q_track_artist=paradise+coldplay&s_track_rating=desc" \
        // -H "X-Mashape-Key: EEZTLb3jOTmshwWGf9EA4GGXgEFop1wZsP4jsnDKSP26wlBPLg" \
        // -H "Accept: application/json"
        //HttpHandler getREST = new HttpHandler();
        //String getTrackInfoREST = getREST.getRequest("https://musixmatchcom-musixmatch.p.mashape.com/wsr/1.1/track.search?f_has_lyrics=1&page=1&page_size=5&q=" + songName);
        //String[] delimitedTrackInfo = getTrackInfoREST.split("\\{\"");
        //String[] delimitedTrackInfo = getTrackInfoREST.split(",\"track_mbid\":");
        //
        //HttpResponse<JsonNode> response = Unirest.get("https://musixmatchcom-musixmatch.p.mashape.com/wsr/1.1/track.search?f_has_lyrics=1&page=1&page_size=5&q=hot+cross+buns&s_track_rating=desc")
        //        .header("X-Mashape-Key", "EEZTLb3jOTmshwWGf9EA4GGXgEFop1wZsP4jsnDKSP26wlBPLg")
        //        .header("Accept", "application/json")
        //        .asJson();

        // curl --get --include "https://musixmatchcom-musixmatch.p.mashape.com/wsr/1.1/track.lyrics.get?track_id=15449912" \
        // -H "X-Mashape-Key: EEZTLb3jOTmshwWGf9EA4GGXgEFop1wZsP4jsnDKSP26wlBPLg" \
        // -H "Accept: application/json"

        String[] testOut = new String[1];
        //testOut[0] = getTrackInfoREST;
        return testOut;
    }


    // Local-only constants
    private static final byte FILE = 0;
    private static final byte API = 1;
    private static final byte SQLLITE = 2;
    /* parseLyrics
     * (String String) -> (ArrayOf String)
     * Either the file name or song name to get from API is the input
     *
     * ... get lyrics from any source (toggle option)
     *      then passes it through lyricsToActions
     *
     */
    public ArrayList<String> parseLyrics(String nameOfSong, byte retrievalType){
        String[] lyricsUntouched = new String[0];
        ArrayList<String> makeActionList = new ArrayList<String>();

        // Get from File
        if(retrievalType == FILE){
            lyricsUntouched = lyricsReadFile(nameOfSong); //TODO: Merge ReadFile & ReadAPI
        }
        // Get from API
        if(retrievalType == API) {
            //lyricsUntouched = lyricsReadAPI(nameOfSong); //TODO: Use API from MashApe?
        }

        if(retrievalType == SQLLITE) {
            //lyricsUntouched = lyricsReadAPI(nameOfSong); //TODO: Use API from MashApe?
        }

        int i = lyricsUntouched.length - 1, b = i;
        for(; i>=0; --i) {
            String[] lyricLines = lyricsUntouched[b - i].split("[ .,\n\r]+");
            int j = lyricLines.length - 1, c = j;
            for(; j>=0; --j) {
                makeActionList.add(lyricsToActions(lyricLines[c - j]));
            }
        }

        return makeActionList;
    }


}
