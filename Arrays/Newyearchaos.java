/*
    Hacker rank - New Year Chaos
    Any person in the queue can bribe the person directly in front of them to swap positions. 
    If two people swap positions, they still wear the same sticker denoting 
    their original places in line. One person can bribe at most two others.

    Sample Input : 2     [ No. of inputs ]
                   5     [ No. of elements in the input]
                   2 1 5 3 4 [ Array input ]
                   5
                   2 5 1 3 4


    Sample Output : 3
                    Too chaotic
*/


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int array_index = 0;
        boolean count_swap = true ;

        /*
            The below 
        */
        for( array_index = 0 ; array_index < q.length ; array_index++ )
        {
            int diff = q[array_index] - (array_index+1) ;
            if( diff > 2 ){
                System.out.println("Too chaotic");
                count_swap = false ;
                break ;
            }
        }

        if(count_swap == true){
            
            int initial_state [] = new int [q.length];
            int no_of_swaps = 0 ;

             for(array_index = 0 ; array_index < q.length ; array_index++ )
                initial_state[array_index] = array_index+1 ;

             for(array_index = 0 ; array_index < q.length ; array_index++ )
             {
                 if(initial_state[array_index] != q[array_index]){
                      
                     int element = q[array_index] ;

                     if(initial_state[array_index+1] == element){
                         //swap once ;
                         swap(initial_state , array_index+1 , array_index);
                         no_of_swaps ++ ;
                     }
                     else if(initial_state[array_index+2] == element)
                     {
                         //swap twice
                         swap(initial_state , array_index+2 , array_index+1);
                         swap(initial_state , array_index+1 , array_index);
                         no_of_swaps += 2 ;
                     }
                 }
             }
             System.out.println(no_of_swaps);
             

        }


    }

    static void swap(int a[] , int index1 , int index2){
        int temp  = a[index1];
        a[index1] = a[index2];
        a[index2] =temp ;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
