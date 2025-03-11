import java.util.Scanner;

public class PrefixSumBase {
    
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in); 
        System.out.println("Enter the length of Arr: ") ;
        int lengthOfArr = scan.nextInt();

        System.out.println("Enter your starting point of range: ") ;
        int a = scan.nextInt();

        System.out.println("Enter your ending point of range: ") ;
        int b = scan.nextInt();

        int[] array = new int[lengthOfArr] ;
        System.out.println("Enter your values, press enter for each value :");
        
        for(int i = 0; i<lengthOfArr ; i++){

            array[i] = scan.nextInt() ;

        }

        scan.close() ;

        

        int results = prefixSumRange(array, a, b) ;

        for(int i = 0 ; i< array.length ; i++ ){
            System.out.print( array[i]+" ") ;
        } 
        System.out.println();

        System.out.println("The sum from "+ a + " to "+ b +" is : " + results);

    }

    public static int[] prefixSum(int[] array){

        for(int i=1 ; i<array.length ; i++ ){

            array[i] = array[i] + array[i-1] ;
        }

        
        return array ;
    }

    public static int prefixSumRange( int[] array, int a, int b ){

        int sum = 0 ;

        prefixSum(array) ;

        for( int i=a ; i<b ; i++ ){

            sum = array[b] - array[a-1] ;

        }

        return sum;
    }
}
