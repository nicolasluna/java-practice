package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //        System.out.println("Hello world!");
        Main main = new Main();
        main.reverseStringAlgorithm("Hello");
        main.reverseStringAlgorithm2("World");
        main.reversStringBuilder("Hello");
        main.reversStringCollections("fake");
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