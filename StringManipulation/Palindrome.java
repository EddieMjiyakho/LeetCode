package StringManipulation;

import java.util.*;

public class Palindrome {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your palindrome: ");
        String line = scan.nextLine();
        scan.close();

        String res = checkPalindrome(line);
        System.out.println("Results: " + res);
    }

    public static String checkPalindrome(String line) {

        int left = 0;
        int right = line.length() - 1;

        char[] chars = line.toCharArray();

        while (left <= right) {

            if (chars[left] == chars[right]) { // How do I make it non case sensitive?
                left++;
                right--;
            } else {
                return "Not a palindrome";
            }
        }

        return "Is a palindrome";
    }
}
