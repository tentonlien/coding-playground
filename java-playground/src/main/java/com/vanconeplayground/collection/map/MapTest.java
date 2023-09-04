package com.vanconeplayground.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tenton Lien
 */
public class MapTest {

    private Map<String, String> hashMap = new HashMap();

    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        mapTest.insert();
        mapTest.traverse();
        mapTest.fetchKey("China");
        mapTest.delete("Japan");
        mapTest.traverse();
    }

    public void insert() {
        hashMap.put("China", "Beijing");
        hashMap.put("Japan", "Tokyo");
        hashMap.put("Thailand", "Bangkok");
    }

    public void traverse() {
        // Traverse method 1
        for (Map.Entry<String, String> entry: hashMap.entrySet()) {
            System.out.print(entry.toString() + " ");
        }
        System.out.println();

        // Traverse method 2
        hashMap.forEach((key, value) -> {
            System.out.print(key + "=" + value + " ");
        });
        System.out.println();
    }

    public void fetchKey(String key) {
        System.out.println("Value of key '" + key + "': " + hashMap.get(key));
    }

    public void delete(String key) {
        hashMap.remove(key);
    }
}
