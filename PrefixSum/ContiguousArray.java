import java.util.*;
public class ContiguousArray{

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the length of Arr: ") ;
        int lengthOfArr = scan.nextInt();
        int[] array = new int[lengthOfArr] ;
        System.out.println("Enter your values, press enter for each value :");
        
        for(int i = 0; i<lengthOfArr ; i++){

            array[i] = scan.nextInt() ;

        }

        scan.close() ;

        int results = findMaxLength(array) ;

        System.out.println("The maximum length of a contiguous subarray with equal 0s and 1s : "+ results);

    }

    public static int findMaxLength(int[] arrays){

        
        return 1 ;
    }



}