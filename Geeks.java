import java.util.LinkedList;

public class Geeks{
            public static void main(String[] args){
                LinkedList<String> al = new LinkedList<>();
                al.add("I");

                al.add("Ansh");
                al.add(1,"am");
                System.out.println(" string is :" +al);
                al.remove(1);
                System.out.println("New String is:" +al);
            }

        }