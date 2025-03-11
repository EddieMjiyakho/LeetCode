import java.util.*;
import java.util.stream.Collectors;

public class Practise {
    
    //How to move zeros to the end of an array
    public void moveZerosToEnd( int[] arr){

        int j = 0;
        for(int i = 0 ; i<arr.length ; i++){
            
            if( arr[i] != 0 ){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        
        for(int i = 0 ; i<arr.length ; i++){
            if(i != arr.length-1){
                System.out.print(arr[i]+",");
            }else{ System.out.print(arr[i]+".");}
        }
    }


    //get missing Natural number in array
    public void getMissingNum( int[] arr){
        int n = arr.length+1;
        int sum = n*(n+1)/2;
        int sum2=0;
        for( int i = 0 ; i<arr.length ; i++){
            sum2 += arr[i] ;
        }

        int result = sum -sum2;
        System.out.println(result);
        
    }

    // Check_Pallindrome
    public static String palindrome( String name ){

        StringBuilder name1 = new StringBuilder(name);
        

        if( name.equals(name1.reverse().toString()) ){
            return "Is Palindrome";
        }else{
            return "Not Palindrome";
        }
    }


    //Binary_Search
    public static String binarySearch( int[] arr, int target ){

        int left = 0;
        int right = arr.length -1;
        List<Integer> mids = new ArrayList<>();

        while(left<=right){

            int mid = left + (right-left)/2;
            int val = arr[mid];
            mids.add(val);

            if( val==target){
                return mids.stream().map(String::valueOf).collect(Collectors.joining(", ", "[", "]")) ;

            } else if(val>target){ 

                right = mid-1;
            } else{

                left = mid+1;
            }
        }
        return "Value Not Found";

    }

    //Bubble_Sort
    public static void bubbleSort(int[] arr){

        for(int i = 0 ; i<arr.length-1; i++ ){
            for(int k=0 ; k<arr.length-i-1 ;k++){
                if(arr[k]>arr[k+1]){
                    int temp = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = temp;
                }
            }
        }

    }

    //Selection_Sort
    public static void selectionSort(int[] arr){

        for(int i=0; i<arr.length-1 ; i++){
            int min = i;
            for(int k=i+1; k<arr.length; k++){
                if(arr[min]>arr[k]){
                    min=k;
                }
            }
            int temp= arr[min] ;
            arr[min]= arr[i];
            arr[i]= temp;
        }
    }

    //Insertion_Sort
    public static void insertionSort(int[] arr){

        for(int i = 1 ; i<arr.length ;i++){

            int temp = arr[i];// starts at the second val of arr
            int k = i-1; //left of i

            while(k>=0 && arr[k]>temp){
                arr[k+1]=arr[k]; //shifting big value to right
                k--; //keep trackback after comparison
            }

            arr[k+1] = temp; //move temp to it's current correct position
        }
        

    }

    //Merge_Sort
    public static void mergeSort(int[] arr){

        int length = arr.length;

        if( length <= 1 ) return; //base case
        int mid = length/2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[length-mid];
        int k=0; //index for rightArr

        for(int i=0 ; i<length ;i++){

            if( i < mid ){

                leftArr[i] = arr[i];
            } else{ 
                rightArr[k] = arr[i]; // eg rightArr[0] = arr[5];
                k++;
            }
        }

        mergeSort(leftArr); //recuseve cases
        mergeSort(rightArr);
        merge( leftArr, rightArr, arr); // merging_&_sorting method
    }

    //merging_method
    public static void merge(int[] leftArr, int[] rightArr, int[] arr) {

        int leftSize = arr.length/2;
        int rightSize = arr.length - leftSize;
        int i = 0, l = 0, r = 0; //indices for arr, leftArr and rightArr

        while( l< leftSize && r< rightSize ){

            if( leftArr[l] < rightArr[r] ){ //take the smallest value btwn the arrays to arr
                arr[i] = leftArr[l];
                i++;
                l++;
            } else{
                arr[i] = rightArr[r];
                i++; 
                r++;
            }
        }

        //for the elements that will not have other elements to be compared with.

        while( l< leftSize){
            arr[i] = leftArr[l];
            i++;
            l++;
        }

        while( r< rightSize){
            arr[i] = rightArr[r];
            i++;
            r++;
        }    
    }

    //Qiuck_Sort (Lomutu partitioning)
    public static void quickSort(int[] arr, int start, int end ){

        if( end <= start) return ; //base case, 
        int pivot = lomutoPartition( arr, start, end);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }

    public static int lomutoPartition( int[] arr, int start, int end){

        int pivot = arr[end];
        int i = start-1; // the start-1 value

        for( int k = start; k <= end-1 ; k++){

            if( arr[k] < pivot ){
                i++;
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            } //else just increment k
        }

        //now when index k is at pivot
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp; 

        return i; //final index of pivot
    }

    //Possible ways to revrse a string avoiding spaces
    //1. Using StringBuilder to utilize .reverse()
    public static void reverseString( String line){

        String[] words = line.split(" ");

        String[] arr = new String[words.length];

        for(int i=0; i<words.length ; i++){

            StringBuilder name = new StringBuilder(words[i]);
            arr[i]= (name.reverse()).toString() ;    

        }

        for( int i=0; i<arr.length ;i++){

            System.out.print(arr[i]+" ");
        }
    }

    //Using pointers. (does not reverse the words individually)
    public static void reverseWthPointers( String line){

        char[] characters = line.toCharArray();
        int left = 0;
        int right = characters.length -1;

        while( left<= right ){

            if( characters[left] == ' '){
                left++;
            } else if( characters[right] == ' '){
                right--;
            } else{

                char temp = characters[left];
                characters[left] =characters[right];
                characters[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(new String(characters));
    }


    //while maintaining the positions of the spaces
    public static void reverseWthStack( String line ){

        char[] chars = line.toCharArray();

        Stack<Character> stack = new Stack<>();

        for(int i=0 ; i<chars.length ; i++){

            if(chars[i] !=' '){
            
                stack.push(chars[i]) ;
            } 
            
        }

        for( int i=0 ; i<chars.length;i++){

            if( chars[i] ==' '){
                i++;
            } else{
                chars[i] = stack.pop();// return the top element
            }
        }

        System.out.println(new String(chars));

    }

    //returns the sum of two indeces of the two nums in arr that add up to val
    public static int pairwise(int[] arr, int val) {
        boolean[] used = new boolean[arr.length]; // Track used indices
        int sum = 0;
    
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) { // Start from i+1 to avoid duplicate checks
                if (!used[i] && !used[j] && arr[i] + arr[j] == val) {
                    sum += (i+j); // Add index sum
                    used[i] = used[j] = true; // Mark as used
                    break; // Move to the next `i` to use the lowest possible indices
                }
            }
        }
        return sum;
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
  
        System.out.println("Enter array by commas: ");
        String line = scan.nextLine();
        System.out.println("Enter val: ");
        int val = scan.nextInt();
        scan.close();
        System.out.println();

        // reverseString(line);
        // System.out.println();
        // reverseWthPointers(line);
        // reverseWthStack(line);

        String[] elements = line.split(",");
        int[] array = new int[elements.length];

        for(int i = 0 ; i<elements.length ; i++){
            array[i] = Integer.parseInt(elements[i]);
        }

        // quickSort(array, 0, array.length-1);

        int result = pairwise( array, val);

        System.out.println(result);
        // String arrLine = Arrays.toString(array);

        // System.out.println( arrLine); 

        /*
        Practise obj = new Practise();
        obj.moveZerosToEnd(array);
        System.out.println();
        obj.getMissingNum(array);
        
        System.out.println("Enter String : ");
        String line = scan.nextLine();
        scan.close();

        System.out.println( palindrome(line));
        */
    }
}
