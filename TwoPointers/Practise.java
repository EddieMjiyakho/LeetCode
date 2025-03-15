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

    //2461 MaxSum of Distinct vals of size K
    //Fixed Sliding Window
    public static long maxSumDistnct( int[] arr , int k){

        long maxSum = 0;
        long windowSum = 0;
        int left=0;

        Set<Integer> seen = new HashSet<>();

        for(int right=0; right<arr.length ;right++){

            //shrinking window if duplicates found
            while( seen.contains(arr[right] ) ){

                seen.remove(arr[left]);
                windowSum -= arr[left];
                left++;

            }

            //in general keep on adding new elements
            seen.add(arr[right]);
            windowSum += arr[right];

            //check if window is of size k
            if( right-left+1 == k ){

                maxSum = Math.max(maxSum, windowSum); //update maxSum

                seen.remove(arr[left]); //move on by removing leftmost
                windowSum -= arr[left];
                left++;
            }
        }

        return maxSum;
    }  


    //438. Find all anagrams in a string
    //Fixed size sliding window 
    public static List<Integer> findAnagrams( String s, String p){

        int window = p.length(); //window size
        int stringLen = s.length();

        // frequency arrays to get permutations
        //to keeps track of how many times each letter appears in p
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        // if s<p then no anagrams
        if( stringLen<window ){

            return new ArrayList<>();
        }

        //
        for( int i=0; i<window; i++){

            pFreq[ p.charAt(i)-'a']++; //
        }
        for( int i=0; i<window; i++){

            sFreq[ s.charAt(i)-'a']++;
        }

        List<Integer> result = new ArrayList<>();

        //Slide window across string s
        for( int i=window; i<stringLen ;i++){

            if( Arrays.equals(pFreq, sFreq) ){

                result.add( i-window ); //index of first occurence of anagram
            }

            sFreq[ s.charAt(i)-'a']++; //add 1 to the rightmost element
            sFreq[ s.charAt(i-window)-'a']--; // remove 1 to the leftmost element 
        }

        //window outside for loop
        if( Arrays.equals(pFreq, sFreq) ){

            result.add( stringLen-window ) ;
        }

        return result;
    }


    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter coma seperated vals of array: ");
        String line = scan.nextLine();

        System.out.println("Enter target val: ");
        int target = scan.nextInt();
        scan.close();

        int[] array =  Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();

        long res = maxSumDistnct(array, target) ;

        System.out.println( res);

    }
}
