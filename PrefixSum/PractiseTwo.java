import java.util.*;

public class PractiseTwo {


    //Two_Pointers_Pattern
    //Trick: just focus on the nonZero elements, assume array is full of zeros else move nonZero to left
    public static void moveZero( int[] arr ){ 

        int left = 0; // to place non zero elements

        for(int right= 0; right<arr.length; right++){
            if( arr[right] != 0){
                //swap elements if right pointer finds non zero element
                int temp = arr[left];
                arr[left] =arr[right];
                arr[right] = temp;
                left ++;// move on
            }
        }
    }


    //given Arr of heights find two lines that can trap most water 
    //using two pointers
    public static String mostWater( int[] arr){

        int left=0;
        int maxLeft= 0;
        int maxRight= 0;
        int right = arr.length -1;
        int maxArea = 0;

        while( left<right){

            int height = Math.min( arr[left], arr[right]); // calc Area
            int width = right-left;
            int area = height*width;
            
            if( area > maxArea ){ //get max Area
                maxArea =area;
                maxLeft = arr[left];
                maxRight = arr[right];

            }
            if( arr[left] < arr[right]){ //moving from the lowest height
                left++;

            } else {
                right--;
            }
           
        }
        return maxLeft +" & "+ maxRight ;
    }



    //SlindingWindow 
    //Max Avg subArra of k (fixed window)
    //Just do the maxSum then return maxSum/k since if sum> then maxAvg will also be greater
    public static double maxAvg( int[] arr, int k ){

        int windowSum = 0; //sum within the window 
        int maxSum = 0;  

        //add of the first k elements
        for( int i=0; i<k ; i++){

            windowSum += arr[i];

        }

        maxSum = windowSum ;

        //Slide accross
        for( int i=k ; i<arr.length ; i++){

            windowSum +=arr[i] - arr[i-k]; // adding the next element in window while removing the left one
            maxSum = Math.max( maxSum, windowSum );

        }

        return (double) maxSum/k ;
    } 



    //Find longest substring without repeating charectors
    //Dynamic Sliding Window
    public static int longest( String name ){

        int left =0; //used to remove duplicates
        int maxLength =0;

        HashSet<Character> seen = new HashSet<>(); //to hold the chars

        for(int i=0; i<name.length() ;i++){

            while( seen.contains( name.charAt(i) ) ){

                seen.remove( name.charAt(left) ); //removing left elements until no duplicates
                left++; //moving the window away from left
            }
            
            seen.add( name.charAt(i) ); //then add that char that was causing duplicates 
            maxLength = Math.max( maxLength, i-left+1);
        }

        return maxLength;
    }



    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter values of arr sep by coma: ");
        String line = scan.nextLine();
        // System.out.println("Enter value k: ");
        // int k = scan.nextInt();
        scan.close();

        //
        //int[] array = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();

        // moveZero(array);

        int res = longest(line); 

        System.out.println(res);

    }
    

}
