package myCollection;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayList<String> sites = new ArrayList<>();
        ArrayList<Integer> ints = new ArrayList<>();

        sites.add("Google");
        sites.add("Baidu");
        sites.add("Twitter");
        sites.add("Instagram");
        sites.add("Weibo");
        sites.add(0,"Java");
        //System.out.println(sites.get(0));
        //Collections.sort(sites);
        for (String i:sites) {
            System.out.println(i);
        }

        int[] myList = new int[10];
        System.out.println(myList.length);
    }
}
