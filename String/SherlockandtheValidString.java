/*
    Sample Input  : aabbcd
    Sample Output : NO

    Given s="aabbcd", we would need to remove two characters, 
    both c and d -> aabb or a and b -> abcd,
    to make it valid. We are limited to removing
    only one character, so 's' is invalid.
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        
        char input []     = new char[s.length()] ;
        int alph_count [] = new int[26] ;
        int i = 0 ;
        int max = 0 ;
        int min = 9999 ; 

        /*
            convert the string to char[] array .
        */
        for( i = 0 ; i < s.length() ; i++ )
              input[i] = s.charAt(i) ;

        /*
            if the length of the string is 1 
        */
        if( s.length() == 1 )
            return "YES" ;

        /*
            Initializing the alph_count array with the char array
        */
        for( i = 0 ; i < s.length() ; i++) {
                int to_number          = input[i] - 'a' ;
                alph_count[to_number] += 1 ;
            }

        /*
            Finding max and min element
        */
        for( i = 0 ; i < alph_count.length ; i++ )
            {
                if( max < alph_count[i] )    
                        max = alph_count[i] ;
                else{
                    if(min > alph_count[i]  &&  alph_count[i]!= 0)
                        min = alph_count[i] ;
                }
            }
        /*
            if all the characters has same frequency of occurance then return yes
        */
        if( max == min ){
            return "YES" ;
        }
        
        int max_count     = 0;
        int min_count     = 0;
        int total_entries = 0 ;
        String ans        = "YES" ;

        /*
            Counts the occurance of max and min elements and counts total no. of distict                charcters in the array .
        */
        for( i = 0 ; i < alph_count.length ; i++ ){

                if(alph_count[i] != 0){
                    total_entries ++ ;

                     if( alph_count[i] == max )
                         max_count++ ;

                     if( alph_count[i] == min )
                         min_count++ ;
                }              
        }
        /*
            Only if max_count+min_count == totalentries then check further
            because if 
        */
        if( (max_count+min_count) == total_entries )
        {
            //either of max_count or min_count is 1
            int diff_no    = Math.abs( max - min ) ;

            if(min_count == 1 && min ==1){
                //eg : aabbc
                ans = "YES";
            }else if( (max_count == 1 && max > min )  )
                    {
                        if(min == 1 && min_count > 1 )  // eg : aabbcd
                            ans ="NO";
                        else
                            ans = (diff_no == 1) ? "YES" : "NO" ;
                            // eg : aaabbcc
                    }
                 else
                    ans = "NO";  
        }
         else
                ans = "NO" ;
    return ans ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
