/*
    Sample Input  : 5
                    asasd
    Sample Output : 7
    The special palindromic substrings of s=asasd are { a,s,a,s,d,asa,sas }

*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {

        int index       = 0 ;
        long palindrome = 0 ;
        
        char arr []  = new char [s.length()] ;

        /*
            The below loop converts string to char array .
        */
        for( index = 0 ; index < arr.length ; index++ )
            arr[index]  = s.charAt(index) ;

        if( arr.length == 1 )
            return 1;

        /*
            The below for loop , loops through the entire char array and 
            finds the palindrome accordingly .
        */

        for( index = 0 ; index < arr.length ; index++ )
        {
            long left  = 0 ;
            long right = 0 ;

            /*
                The below condition is for odd length palindrome 
                eg : a, aba . 
                Also the condition is not valid if the index is 0 .
            */

            if( index != 0)
                left  = no_of_palindrome(arr , index-1 , index+1 ) ;
            
            /*
                The below condition is for even length palindrome 
                eg : aa, aaaa, 
            */
            right = no_of_palindrome(arr , index ,index+1);

            palindrome += left + right ;

        }
        /*
            s.length() is added because every single character 
            is also a palindrome i.e 'a' is also a palindrome .
        */
        return palindrome + s.length() ;
    }

    static long no_of_palindrome(char arr[] , int left , int right ){
        
        long palindrome = 0 ; 
        int element     = arr[left] ;

        /*
            The below condition i.e ( arr[left] == element &&  arr[right] ==element)
            ensures that only aabaa palindrome is counted and not abcba .
        */

        while(left >=0  && right < arr.length && ( arr[left] == element &&  arr[right]                   ==element) ) 
        {
            left--  ;
            right++ ;
            palindrome++;
        } 
        return palindrome ;                     
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
