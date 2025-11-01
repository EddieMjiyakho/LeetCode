package StringManipulation;

import java.util.*;

public class Reversing {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your String: ");
        String line = scan.nextLine();
        scan.close();

        String res1 = reverse1(line); // stringBuilder
        String res2 = reverse2(line); // twoPinters
        String res3 = reverse3(line); // Recursion
        String res4 = reverse4(line); // Stack

        System.out.println("Your reversed string (via StringBuilder): " + res1);
        System.out.println("Your reversed string (via TwoPointers): " + res2);
        System.out.println("Your reversed string (via Recursion): " + res3);
        System.out.println("Your reversed string (via Stack): " + res4);

    }

    // using stringBuilder
    public static String reverse1(String line) {

        StringBuilder builder = new StringBuilder(line);

        return builder.reverse().toString();
    }

    // Two pointers
    public static String reverse2(String line) {

        int left = 0;
        int right = line.length() - 1;
        char[] charArr = line.toCharArray(); // split by chars

        while (left <= right) {
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(charArr); // toString() is not overriden by arrays (all arrays)
        // can also use new String(charArr);
    }

    // Recursive approach
    public static String reverse3(String line) {

        // base case: length of string is empty or 1.
        if (line.isEmpty() || line.length() == 1) {
            return line;
        }
        // recursive case: reverse the rest of the string and append first char
        return reverse3(line.substring(1)) + line.charAt(0);
    }

    // Using Stack
    public static String reverse4(String line) {

        Deque<Character> stack = new ArrayDeque<>(); // push and pop

        char[] charArr = line.toCharArray();

        // adding to the top of the stack
        for (char c : charArr) {
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();

        // remove from top of the stack
        while (!(stack.isEmpty())) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}