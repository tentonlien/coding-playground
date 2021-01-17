package com.mekcone.playground.oop;

/**
 * @author Tenton Lien
 */
public class Parameter {

    static class Foo {
        public String value;

        public Foo(String value) {
            this.value = value;
        }

        public void print() {
            System.out.println(value);
        }
    }

    static void modify(Foo foo) {
        foo.value = "foo-2";
    }

    public static void main(String[] args) {
        Foo foo = new Foo("foo-1");
        modify(foo);
        foo.print();
    }
}
