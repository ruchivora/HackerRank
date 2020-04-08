/*
    Two strings are anagrams of each other if the letters of 
    one string can be rearranged to form the other string.
    Given a string, find the number of pairs of substrings 
    of the string that are anagrams of each other.
    Sample Input :  1
                    abba
    Sample Outout : 4
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        HashMap<String,Integer> seen = new HashMap<String,Integer>() ;
        int count = 0 ; 

        for( int i = 0 ; i < s.length() ; i++ )
        {
            String s1 = String.valueOf( s.charAt(i) );

            if( seen.containsKey(s1) )
            {
                count += seen.get(s1) ;
                seen.put( s1 , seen.getOrDefault(s1,0)+1 ) ;
            }
            else
                seen.put(s1,1) ;

            for( int j = i+1 ; j < s.length() ; j++ )
            {
                 String s2  = s.substring( i, j+1 ) ;
                 System.out.println(s2) ;
                 char arr[] = s2.toCharArray() ;
                 Arrays.sort(arr) ;
                 String s3 = new String(arr) ;

                 if( seen.containsKey(s3) )
                 {
                     count += seen.get(s3) ;
                     seen.put( s3 , seen.getOrDefault(s3,0)+1 ) ;
                 }
                 else
                    seen.put(s3,1) ;
            }
            
        }



    return count ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
