package com.shpp.p2p.cs.ivasyliev.assignment2;

public class Converter {

    /**
     * Tries to convert a string to a double
     * Wrap for {@code Double.parseDouble(String s)} without throwing an exception
     *
     * Example:
     * {@code
     *      String input1 = "123456789.987654321";
     *      double output1 = 123456789.987654321;
     *
     *      String input2 = "0,26";
     *      double output2 = 0.26;
     *
     *      String input3 = "not valid string";
     *      double output3 = Double.NaN;
     *
     *      String input4 = "";
     *      double output4 = Double.NaN;
     *
     *      String input5 = "   ";
     *      double output5 = Double.NaN;
     * }
     *
     * @param input string to convert
     * @return converted value or {@code Double.NaN} if conversion not possible.
     *
     * @see Double#parseDouble(String)
     * @see Double#NaN
     */
    public static double toDouble(String input) {
        if (input.isBlank()) return Double.NaN;

        String localizedInput = input.replace(',', '.');
        try {
            return Double.parseDouble(localizedInput);
        } catch (Exception ignored) {
            return Double.NaN;
        }
    }
}
