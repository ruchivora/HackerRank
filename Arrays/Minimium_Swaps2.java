/*
    


*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int index = 0 ;
        int no_of_swaps = 0; 

        for(index = 0 ; index < arr.length-1 ; index++){
            
            int req_no  = index+1;
            int next_no = req_no+1;
            
            if(arr[index] != req_no){
                //what i want on next index is at current index
                //be careful : index out of bound  , the element is not last element
                if((req_no == arr[index+1]) && (next_no == arr[index]))
                {
                    swap( arr , index ,index+1 );
                    no_of_swaps++ ;
                }
                else{
                        if(next_no == arr[index])
                        {
                            swap( arr , index+1 , index);
                            no_of_swaps++ ;
            
                            int inde = index+2 ;
                            while(inde!= arr.length && req_no != arr[inde])
                                inde++;
                            
                            swap(arr , index , inde );
                            no_of_swaps++ ;
                        }
                        else{
                                if(req_no == arr[index+1])
                                {
                                    int inde = index+2 ;
                                    while(inde!= arr.length && next_no != arr[inde])
                                          inde++;
                                    
                                    swap(arr , index , inde );
                                    swap(arr , index , index+1 );
                                    no_of_swaps+=2 ;
                                }
                                else{
                                    int inde =index+1 ;
                                    
                                    while(inde != arr.length && req_no != arr[inde])
                                        inde++;
                                    
                                    swap(arr , index , inde);
                                    no_of_swaps++;

                                }
                        }
                }

            }
        }

    return  no_of_swaps ;
    }
    static void swap(int arr[] , int index_1 , int index_2 )
    {
        int temp     = arr[index_1];
        arr[index_1] = arr[index_2];
        arr[index_2] = temp ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}