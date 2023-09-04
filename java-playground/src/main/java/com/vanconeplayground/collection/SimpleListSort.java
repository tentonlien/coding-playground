package com.vanconeplayground.collection;

import java.util.*;

/**
 * @author Tenton Lien
 */
public class SimpleListSort {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(32);
        numList.add(128);
        numList.add(64);
        numList.add(512);
        numList.add(256);

        Collections.sort(numList);
        Collections.reverse(numList);
        System.out.println(numList.toString());
    }
}
