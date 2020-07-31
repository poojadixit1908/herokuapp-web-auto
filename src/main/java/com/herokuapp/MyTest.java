package com.herokuapp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {

    public static void main(String[] args) {

        //array
        int numbers[] = {12, 4, 8, 9, 10};

        //System.out.println(numbers[4]);

        for (int i : numbers) {
            System.out.println(i);
        }

        //list
        List<String> names = new ArrayList<>();
        names.add("Rajesh");
        names.add("Pooja");
        names.add("Ryansh");

        //System.out.println(names.get(2));

        for (String name : names) {
            System.out.println(name);
        }

        //Map

        Map<String, String> envUrlMap = new HashMap<>();
        envUrlMap.put("dev", "dev.qantas.com");
        envUrlMap.put("qa", "qa.qantas.com");

        System.out.println(envUrlMap.get("qa"));

    }
}
