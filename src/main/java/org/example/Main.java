package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        // reverse string methods
        System.out.println("reverse string methods:");
        main.reverseStringAlgorithm("Hello");
        main.reverseStringAlgorithm2("World");
        main.reversStringBuilder("Hello");
        main.reversStringCollections("fake");

        System.out.println();
        System.out.println("******************");
        System.out.println();

        //palindrome
        main.isPalindromeAlgorithm("456q654");
        main.isPalindromeAlgorithm2("456654");

        System.out.println();
        System.out.println("******************");
        System.out.println();

        // count characters times
        main.countCharacterTimesAlgorithm("Hello world");

        System.out.println();
        System.out.println("******************");
        System.out.println();

        //TODO:
//        Given a string, find the smallest window length with all distinct characters of the given string.
//        For eg. str = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca” .
//        Input: aabcbcdbca
//        Output: dbca
//        Explanation:
//        Possible substrings= {aabcbcd, abcbcd,
//                bcdbca, dbca....}
//        Of the set of possible substrings 'dbca'
//        is the shortest substring having all the
//        distinct characters of given string.

//https://www.geeksforgeeks.org/smallest-window-contains-characters-string/?ref=lbp
    }

    public void countCharacterTimesAlgorithm(String input) {
        Map<String, Integer> map = new HashMap<>();
        String[] letters = input.split("");

        for (int i = 0; i < input.length(); i++) {
            Integer count = map.getOrDefault(letters[i], 0);
            if (count == 0) {
                map.putIfAbsent(letters[i], 1);
            } else {
                map.put(letters[i], count + 1);
            }
        }

        map.entrySet().
                forEach(
                        stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey() + " : " + stringIntegerEntry.getValue()));
    }


    // compare string and reversed string
    public void isPalindromeAlgorithm(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println(input.equals(reversed));
    }

    // compare first char and last char, then second and n-1, etc
    public void isPalindromeAlgorithm2(String input) {
        String[] letters = input.split("");
        boolean result = true;

        for (int i = 0; i <= input.length() / 2; i++) {
            if (!letters[i].equals(letters[input.length()-i-1])) {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }


    //reverse string algorithm using split from string
    public void reverseStringAlgorithm(String input) {
        if (Objects.isNull(input)) {
            throw new NullPointerException();
        }

        String[] letters = input.split("");
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= letters.length ; i++) {
            output.append(letters[letters.length-i]);
        }
        System.out.println("reverseStringAlgorithm:");
        System.out.println("Input: " + input + " - - - " + "Output: " + output.toString());
    }

    // using charAt from string
    public void reverseStringAlgorithm2(String input) {
        if (Objects.isNull(input)) {
            throw new NullPointerException();
        }

        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= input.length() ; i++) {
            output.append(input.charAt(input.length()-i));
        }
        System.out.println("reverseStringAlgorithm:");
        System.out.println("Input: " + input + " - - - " + "Output: " + output.toString());
    }

    // using reverse() from StringBuilder
    public void reversStringBuilder(String input) {
        System.out.println(new StringBuilder(input).reverse().toString());
    }

    public void reversStringCollections(String input) {
        List<String> chars = Arrays.asList(input.split(""));
        Collections.reverse(chars);
        chars.forEach(System.out::print);
    }

}