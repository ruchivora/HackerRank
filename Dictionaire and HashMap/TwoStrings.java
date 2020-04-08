/*

    Given two strings, determine if they share a common substring. 
    A substring may be as small as one character.

    For example, the words "a", "and", "art" share the common substring "a". 
    The words "be" and "cat" do not share a substring.

    Sample Input :  1
                    hello
                    world
    Sample Output : Yes [ The substrings "o" and "l"  are common to both strings.]

*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        int arr[] = new int[27] ;
        int count = 0 ;

        for( int i = 0 ; i < s1.length() ; i++ )
        {
            int temp   = (s1.charAt(i) - 'a') ;
            arr[temp] += 1 ;
        }
        

        for( int i = 0 ; i < s2.length() ; i++ )
            {
                int temp = (s2.charAt(i) - 'a' ) ;
                if( arr[temp] != 0 )
                {
                    arr[temp] -= 1 ;
                    count ++ ;
                } 
            }

        return ( count > 0 ) ? "YES" : "NO" ;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
