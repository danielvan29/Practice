package myCollection;

import java.util.HashMap;

public class MyHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> Sites = new HashMap<>();
        // 添加键值对
        Sites.put(1, "Google");
        Sites.put(2, "Sina");
        Sites.put(3, "TaoBao");
        Sites.put(4, "ZhiHu");
        System.out.println(Sites.get(1));
    }
}
