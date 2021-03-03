package myCollection;

import java.util.HashSet;

public class MyHashSet {
    public static void main(String[] args) {
        HashSet<String> sites = new HashSet<>();
        sites.add("Google");
        sites.add("Twitter");
        sites.add("TaoBao");
        sites.add("ZhiHu");
        sites.add("Twitter");  // 重复的元素不会被添加
        System.out.println(sites);
    }
}
