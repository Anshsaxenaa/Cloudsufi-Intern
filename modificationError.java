import java.util.Iterator;
import java.util.ArrayList;

public class modificationError {
    public static void main(String Args[]) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("One");
        arr.add("Two");
        arr.add("Three");
        arr.add("Four");

        try {
            System.out.println(arr);
            Iterator<String> iter = arr.iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next() + ",");
                System.out.println("trying to add" + "to add an element" + "ine between iteration" + arr.add("Five"));
                System.out.println("updated Arraylist: ");
                iter = arr.iterator();

                while (iter.hasNext()) {
                    System.out.println(iter.next());
                }
            }
            System.out.println(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
