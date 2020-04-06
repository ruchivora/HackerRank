import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        int index = 0 ;
        long arr[] = new long [n+2];
        int inner_index = 0 ; 
        long max = -9999;

        for( index = 1 ; index < n+2 ;index++ )
                arr[index] = 0;
        
        //Access the 2-D array to get the corrsp operation
        for( index = 0 ; index < queries.length ; index++ )
        {
            int start_ind  = queries[index][0];
            int end_ind    = queries[index][1];
            long operation = queries[index][2]; 
            
            arr[start_ind] += operation;
            arr[end_ind+1] -= operation;
        }
            
        for( index = 2 ; index < arr.length ; index++)
                arr[index] += arr[index-1] ;
        
        for(index = 1 ; index < arr.length ; index++)
                max = (arr[index] > max) ? arr[index] : max ;
         
     return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
