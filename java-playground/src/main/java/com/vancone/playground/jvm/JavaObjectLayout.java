package com.vancone.playground.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author Tenton Lien
 */
public class JavaObjectLayout {

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(User.class).toPrintable());
    }

    static class User {
        String username;
        String password;
        String gender;
    }
}
