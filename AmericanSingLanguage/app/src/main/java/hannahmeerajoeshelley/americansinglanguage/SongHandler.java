package hannahmeerajoeshelley.americansinglanguage;

import java.util.ArrayList;

/**
 * Created by joseph on 15-03-28.
 */
public class SongHandler {
    private ArrayList<SongType> songs;
    private static final byte HARD = 3;

    public SongHandler(){
        songs = new ArrayList<SongType>();

        //set the sound maps and such
        demo();
    }

    // Add demo songs to list
    private void demo(){
        String songName = "twinkle twinkle little star";
        LyricsHandler lyricsOne = new LyricsHandler();
        String[] maps = lyricsOne.getLyricMap(songName, HARD);
        String[] lyrics = lyricsOne.parseLyrics(songName, HARD);

        songs.add(new SongType(songName, maps, lyrics));
    }

    // Get SongType from interface
    public SongType getSongMeta(String songName){

        int i = songs.size() - 1, j = i;
        for (; i>=0; --i){
            if(songs.get(j - i).getName().toUpperCase().equals(songName.toUpperCase())){
                return songs.get(j - i);
            }
        }

        return null;
    }

}
