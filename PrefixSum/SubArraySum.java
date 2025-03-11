import java.util.*;
// Contiguous means move sequentially within the array, cannot skip values in between.

public class SubArraySum {

    public static void main(String[] args ){

        Scanner scan = new Scanner(System.in) ;
        System.out.println("Enter the value of k: ");
        int k = scan.nextInt();
        System.out.println();

        System.out.println("Enter the values in your array separated by ',' :");
        String list = scan.next() ;
        System.out.println();

        String[] listArray = list.split(",") ;

        int[] array = new int[listArray.length] ;

        for(int i = 0 ; i<listArray.length ; i++ ){

            int val = Integer.parseInt(listArray[i]) ;

            array[i] =  val ;

        }

        int result = subarraySum( array, k ) ;

        System.out.println("The total number of subarrays (contiguous) whos sum is == k are : "+ result);

        for(int val : array ){

            System.out.println(val);
        }
        scan.close();


    }

    public static int subarraySum( int[] array, int k ){

        return 0 ;
    }

    

}
