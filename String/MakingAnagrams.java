/*
    Sample Input :   cde
                     abc
    Sample Output :  4

    Explanation :  We delete the following characters from our 
                   two strings to turn them into anagrams of each other:

                Remove d and e from cde to get c.
                Remove a and b from abc to get c.
                We must delete 4 characters to make both strings anagrams, so we print 4 on a new line.

*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        int alphabet_arr [] = new int [26];
        char string_a []    = a.toCharArray() ; 
        char string_b []    = b.toCharArray() ;
        int result          = 0 ;

        for(int in : string_a){
            alphabet_arr[in-'a'] += 1 ;
        }
        
        for(int in : string_b){
            alphabet_arr[in-'a'] -=1 ;
        }

        for( int in : alphabet_arr){
            result += Math.abs(in) ;
        }
    return result ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
