package myCollection;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> sites = new LinkedList<>();
        sites.add("Google");
        sites.add("Baidu");
        sites.add("JD");
        sites.add("Weibo");
        sites.addFirst("1pondo");
        System.out.println(sites);
    }
}
