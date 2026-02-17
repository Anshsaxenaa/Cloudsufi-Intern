import java.util.ArrayList;
import java.util.Iterator;

public class FailFast {
    public static void main(String args[]) {
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.add(4);
        Iterator<Integer> iter = ar.iterator();
        while (iter.hasNext()) {
            if (iter.next() == 2) { // This would not throw an exception as the remove function is being called in
                                    // the iterator
                iter.remove();
            }

            System.out.println(ar);
            iter = ar.iterator();

            while (iter.hasNext()) {
                if (iter.next() == 3) { // This Will Throw Exception as the remove function is bein called in the
                                        // arrayList
                    ar.remove(3);
                }
            }
            System.out.println(ar);
            iter = ar.iterator();

        }

    }
}
