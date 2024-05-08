package com.autoit.calc.util;

import java.util.List;
import java.util.Random;

public class CalcUtils {

    public static final Random RANDOM = new Random();
    private static final List<String> NUMBERS = List.of(
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine"
    );

    public static String getRandomNumber() {
        int randomNumber = RANDOM.nextInt(NUMBERS.size());
        return NUMBERS.get(randomNumber);
    }
}
