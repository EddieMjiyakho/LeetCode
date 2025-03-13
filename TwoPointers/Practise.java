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

    //15. 3Sum
    public static List< List<Integer> > threeSum( int[] nums ){
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for( int i=0; i<nums.length-2 ; i++){

            if(i>0 && nums[i]==nums[i-1] ){  // Skip duplicates for 'i'
                continue;
            
            }

            int left = i+1;
            int right = nums.length-1;

            while( left<right ){

                int sum = nums[i]+ nums[left]+ nums[right];

                if( sum==0 ){

                    list.add( Arrays.asList( nums[i], nums[left], nums[right] ) );

                    // Skip duplicate values for 'left' and 'right'
                    while( left<right && nums[left]==nums[left+1]) left++;
                    while( left<right && nums[right]==nums[right-1]) right--;

                    left++;
                    right--;

                } else if( sum<0 ){
                    left++;

                } else{
                    right--;

                }
            }
        }

        return list;
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
