import java.util.*;
import java.util.Collections;

public class Jukebox1 {
    public static void main(String[] args) {
        new Jukebox1().go();

    }

    public void go() {
        List<String> songs = MockSons.getSongsStrings();
        System.out.println(songs);
        Collections.sort(songs);
        System.out.println(songs);
    }

}
