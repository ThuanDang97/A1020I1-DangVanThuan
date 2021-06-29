package B12_Java_Collection_Framework.ThucHanh.Luu_DSSV;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class DSSV {

    public static void main(String[] args) {
        Map<String, Integer> hasMap = new HashMap();

        hasMap.put("b", 22);
        hasMap.put("a", 20);
        hasMap.put("c", 21);
        System.out.println("hasMap");
        System.out.println(hasMap + "\n");

        System.out.println("treeMap");
        Map<String, Integer> treeMap = new TreeMap<>(hasMap);
        System.out.println(treeMap);

        Map<String, Integer> linkHashMap = new LinkedHashMap<>(hasMap);
        System.out.println("linkHashMap");
        System.out.println(linkHashMap);
    }
}
