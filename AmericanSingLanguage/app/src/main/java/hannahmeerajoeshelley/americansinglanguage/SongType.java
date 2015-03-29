package hannahmeerajoeshelley.americansinglanguage;

/**
 * Created by joseph on 15-03-28.
 */
public class SongType {
    private String songName;
    private String[] songMap;
    private String[] songLyrics;
    private int[] lyricMap;

    public SongType (String name, String[] map, String[] lyrics){
        songName = name;
        songMap = map;
        songLyrics = lyrics;
    }
    public SongType (String name, String[] map, String[] lyrics, int[] lMaps){
        songName = name;
        songMap = map;
        songLyrics = lyrics;
        lyricMap = lMaps;
    }

    public String getName(){
        return songName;
    }

    public String[] getSongMap(){
        return songMap;
    }

    public String[] getSongLyrics(){
        return songLyrics;
    }

    public int[] getLyricMap(){
        return lyricMap;
    }
}
