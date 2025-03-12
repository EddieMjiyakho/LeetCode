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

    
    //88. Merge 2 Sorted arrays
    //m & n are num of elements in arr1 and arr2 respectively
    public void merge( int[] arr1, int m, int[] arr2, int n ){

        int k = (m+n)-1; //total indexing for final array= arr1 (last index)
        int i= m-1; //index for arr1
        int j= n-1; //index for arr2

        //the trick is to start merging from end of arrays
        //since arr is sorted
        //merges in reverse
        while( i>=0 & j>=0 ){

            if( arr1[i] > arr2[j] ){
                arr1[k] = arr1[i];
                i--;

            } else{
                arr1[k] = arr2[j];
                j--;

            }
            k--;
        } 

        //fills arr1 with leftover nums from arr2
        while( j>=0 ){ 
            arr1[k] = arr2[j];
            j--;
            k--;
        }
        
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
