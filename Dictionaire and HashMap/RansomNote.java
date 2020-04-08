/*
    Given the words in the magazine and the words in the ransom note,
    print Yes if he can replicate his ransom note exactly using whole
    words from the magazine; otherwise, print No.

    For example, the note is "Attack at dawn". 
    The magazine contains only "attack at dawn". 
    The magazine has all the right words, but there's a case mismatch. 
    The answer is NO.

    Sample Input  : 6 4
                    give me one grand today night
                    give one grand today
    Sample Output : Yes


*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        Hashtable<String,Integer> mag = new Hashtable<String,Integer>() ;
        Hashtable<String,Integer> not = new Hashtable<String,Integer>() ;
        boolean b = true ;

        for( String i : magazine )
        {
            mag.put( i , mag.getOrDefault( i , 0 )+1 ) ;
        }
        for( String j : note )
        {
            if( mag.getOrDefault(j , 0) == 0 )
                {
                    System.out.println("No") ;
                    b = false ;
                    break ;
                }
            else mag.put( j , mag.get(j)-1 ) ;
        }

    if(b == true)
    System.out.println("Yes") ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
