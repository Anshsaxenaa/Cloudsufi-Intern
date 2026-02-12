import java.util.*;

public class Jukebox1 {
    public static void main(String[] args) {
        new Jukebox1().go();

    }

    public void go() {
        /*
         * List<SongV2> songV2 = SongV2.getSongs();
         * System.out.println(songV2);
         * Collections.sort(songV2);
         * System.out.println(songV2);
         */
        /*
         * List<String> songs = MockSons.getSongsStrings();
         * TitleCompare titleCompare = new TitleCompare();
         * Collections.sort(songs, titleCompare);
         * System.out.println(songs);
         * 
         * List<String> songs2 = MockSons.getSongsStrings();
         * ArtistCompare artistCompare = new ArtistCompare();
         * Collections.sort(songs2, artistCompare);
         * System.out.println(songs2);
         */
        List<SongV2> songList = SongV2.getSongs();
        songList.sort((one, two) -> one.compareTo(two));
        System.out.println(songList);

        Set<SongV2> songSet = new HashSet<>(songList);
        System.out.println(songSet);
        songSet.add(new SongV2("Somersault", "katy perry", 134));
        System.out.println(songSet);
    }

    /*
     * class ArtistCompare implements Comparator<String> {
     * public int compare(String one, String two) {
     * return one.compareTo(two);
     * }
     * }
     * 
     * class TitleCompare implements Comparator<String> {
     * public int compare(String one, String two) {
     * return one.compareTo(two);
     * }
     * }
     */
}
