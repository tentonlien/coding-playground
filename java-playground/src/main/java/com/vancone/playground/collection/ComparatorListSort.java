package com.vancone.playground.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tenton Lien
 */
public class ComparatorListSort {

    static class Student {
        public String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "{name: " + name + ", age: " + age +"}";
        }
    }

    public static List objectSort(List<Student> list) {
        return list.stream().sorted(Comparator.comparingInt(Student::getAge).reversed())
                .collect(Collectors.toList());
    }

    public static List intSort(List<Integer> list) {
        return list.stream().sorted(Comparator.comparingInt(Integer::intValue))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 17));
        students.add(new Student("Mary", 15));
        students.add(new Student("Amy", 18));
        students.add(new Student("Lily", 16));
        students.add(new Student("Mike", 14));

        System.out.println(students);

        students = objectSort(students);
        System.out.println(students);

        List<Integer> numList = new ArrayList<>();
        numList.add(2);
        numList.add(7);
        numList.add(4);
        numList.add(1);
        numList = intSort(numList);
        System.out.println(numList);
    }
}
