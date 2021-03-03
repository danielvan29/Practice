package myCollection;

import java.util.ArrayList;
import java.util.Iterator;

public class MyIterator {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("shit");
        list.add("fuck");
        list.add("ass");

        Iterator<String> iterator = list.iterator();
        /*while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

        Object object = new Object();

        System.out.println(object.toString());
    }
}
