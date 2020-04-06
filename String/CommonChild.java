/*
    Longest common subsequence .

    Sample Input  : HARRY
                    HARRY
    Sample Output : 2

    Explanation : The longest string that can be formed by 
    deleting zero or more characters from HARRY and HARRY is AY
    , whose length is 2.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
    Longest common subsequence . 
*/
public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {

        int str_len   = s1.length() ;
        System.out.println(str_len) ;
        int arr[][]   = new int [str_len+1][str_len+1] ;
        int index     = 0 ;
        int i         = 0 ;
        int j         = 0 ;
        /*
            Deriving the solution using Dynamic Programming .
            Array [2-Dimensional array]
        */
        for( i = 1 ; i < str_len+1 ; i++)
        {
            for( j = 1 ; j < str_len+1 ; j++)
            {
                int max = max( arr[i][j-1] , arr[i-1][j] ) ;

                if( s2.charAt(i-1) == s1.charAt(j-1) )
                    arr[i][j] = 1 + arr[i-1][j-1] ;
                else
                    arr[i][j] = max ;
            }
        }

     return  arr[str_len][str_len] ;
    }

    static int max(int no_1 , int no_2)
    {
        return  (no_1 >= no_2) ? no_1 : no_2 ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
