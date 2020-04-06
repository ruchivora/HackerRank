/*

    The first line contains an integer 'q', the number of queries.
    The next 'q' lines each contain a string 's' .
    Sample Input : 5
                   AAAA
                   BBBBB
                   ABABABAB
                   BABABA
                   AAABBB
    Sample Output : 3
                    4
                    0
                    0
                    4
*/


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//System.out.println(arrays.toString(arr)) ;

public class Solution {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {


        /*
            1. convert the string to char array
            2. create other array and fill the array accordingly .
            3. calculate the length and take the difference 
               that gives the number of elements deleted
        */
        

        char arr[] = new char[s.length()] ;
        int index  = 0 ;
        for( index = 0 ; index < s.length() ; index++)
             arr[index] = s.charAt(index) ; 
        
        
        char copy [] = new char[s.length()];
        copy[0] = arr [0];
        int i = 0 ; 
        
        for(index = 1 ; index < s.length() ; index++ ){
            if(copy[i] != arr[index] ){
                copy[++i] = arr[index] ;
            }
        }
        
        int x = s.length() - (i+1) ;

    return x;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
