package StringManipulation;

import java.util.Arrays;
import java.util.Scanner;

public class StreamsLambdas {

    // How to use Stream
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your string of integers: ");
        String line = scan.nextLine();
        scan.close();

        String[] numStrings = line.split(",");
        int[] nums = new int[numStrings.length];

        for (int i = 0; i < numStrings.length; i++) {

            nums[i] = Integer.parseInt(numStrings[i]);
        }
        System.out.println(Arrays.toString(nums));

        // Now using Stream&Lambdas

        int[] nums1 = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(nums1).forEach(n -> System.out.println(n));

        /*
         * To use stream() on arrays I had to use the utility Arrays class since it has
         * stream(), Arrays.stream()
         * that is also used by collections (eg List).
         * stream(line.split(",")); I am treating the String[] as a stream
         * mapToInt( n -> Integer.parseInt(n) ); mapping every val to int to form a new
         * stream, same (Integer::parseInt)
         * then convert that stream toArray();
         * Stream can only be used once then it locks,
         * but when using methods on stream, I am more likely creating a new stream from
         * that one.
         */
    }
}
