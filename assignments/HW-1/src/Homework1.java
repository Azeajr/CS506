public class Homework1 {

    /**
     * Find last index of element
     *
     * @param x array to search
     * @param y value to look for
     * @return last index of y in x; -1 if absent
     * @throws NullPointerException if x is null
     */
    public static int findLast(int[] x, int y) {
        for (int i = x.length - 1; i >= 0; i--) {
            if (x[i] == y) {
                return i;
            }
        }
        return -1;
    }
// test:  x = [2, 3, 5]; y = 2; Expected = 0

    /**
     * Counts the number of occurrence of a substring in another string
     *
     * @param source string to use as a source of the match
     * @param word   string which is a substring of the source
     * @return number of occurrences of word in source
     * @throws NullPointerException if source is null
     */

    public static int countOccurrence(String source, String word) {
        String[] temp = source.split(" ");
        int count = 0;
        for (String str : temp) {
            if (word == str) {
                count++;
            }
        }
        return count;
    }
// Test:
// source = "What is Software Testing? Why is Software Testing so important?";
// word = "Software";
// Expected = 2

    /**
     * Counts positive elements in array
     *
     * @param x array to search
     * @return number of positive elements in x
     * @throws NullPointerException if x is null
     */
    public static int countPositive(int[] x) {
        int count = 0;

        for (int i = 0; i < x.length; i++) {
            if (x[i] >= 0) {
                count++;
            }
        }
        return count;
    }
// test:  x = [-4, 2, 0, 2]; Expected = 2

    /**
     * Adds commas to long numbers at every third position starting from the right (e.g., "12345678" returns "12,345,678")
     *
     * @param digits string represents a number
     * @return a new string with a comma at every third position
     * @throws NullPointerException if digits is null
     */

    public static String addCommasToDigitString(String digits) {

        StringBuilder result = new StringBuilder();
        int nDigits = 0;
        for (int i = digits.length() - 1; i >= 0; i--) {
            result.insert(0, digits.charAt(i));
            nDigits++;
            if (((nDigits % 3) == 0) && (i > 1)) {
                result.insert(0, ",");
            }
        }
        return result.toString();
    }

// Test: digits = "1234"; Expected = "1,234";

    public static void main(String[] args) {

    }
}
