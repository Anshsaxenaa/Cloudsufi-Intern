import java.util.*;

public class Jukebox1 {
    public static void main(String[] args) {
        new Jukebox1().go();

    }

    public void go() {
        List<SongV2> songV2 = SongV2.getSongs();
        System.out.println(songV2);
        Collections.sort(songV2);
        System.out.println(songV2);
    }
}
