package TwoPointers;
import java.util.*;

public class Practise {
    
    //Two Sum || sorted array
    public static int[] twoSum( int[] arr, int target ){

        int left=0;
        int right= arr.length-1;

        while(left<right){

            int sum = arr[left] + arr[right];

            if( sum == target ){
                
                return new int[] {left+1, right+1};
            }

            if( sum>target ){ 
                right--;

            } else{
                left++;

            }
        }

        return new int[]{-1, -1};

    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter coma seperated vals of array: ");
        String line = scan.nextLine();

        System.out.println("Enter target val: ");
        int target = scan.nextInt();
        scan.close();

        int[] array =  Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();

        String res = Arrays.toString((twoSum(array, target))) ;

        System.out.println( res);

    }
}
