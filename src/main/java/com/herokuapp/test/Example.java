package com.herokuapp.test;

public class Example {

    public static void main(String[] args) {

        String fullname = fullStateName("NSW");
        System.out.println(fullname);
    }

    public static String fullStateName(String shortName) {

        String fullName = null;

        switch (shortName) {
            case "NSW":
                fullName = "New South Wales";
                break;
            case "VIC":
                fullName = "Victoria";
                break;
        }

        return fullName;
    }
}
