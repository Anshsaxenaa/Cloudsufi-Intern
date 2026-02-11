import java.util.ArrayList;
import java.util.List;

public class SongV2 implements Comparable<SongV2> {
    public String title;
    public String artist;
    public int bpm;

    public int compareTo(SongV2 s) {
        return this.title.compareTo(s.title);
    }

    SongV2(String title, String artist, int bpm) {

        this.title = title;

    }

    public String gettitle() {
        return gettitle();
    }

    public String getartist() {
        return getartist();
    }

    public int getbpm() {
        return getbpm();
    }

    public String toString() {
        return title;
    }

    public static List<SongV2> getSongs() {
        List<SongV2> songs = new ArrayList<>();
        songs.add(new SongV2("Somersault", "katy perry", 134));
        songs.add(new SongV2("Cold", "katy perry", 43));
        songs.add(new SongV2("$10", "katy perry", 96));
        songs.add(new SongV2("Animals", "katy perry", 105));
        songs.add(new SongV2("Cassidy", "katy perry", 12));
        songs.add(new SongV2("50 Ways", "katy perry", 154));
        return songs;

    }

}