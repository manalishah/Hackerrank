/*
Problem Statement

A modified Kaprekar number is a positive whole number n with d digits, such that when we split its square into two pieces - a right hand piece r with d digits and a left hand piece l that contains the remaining d or d−1 digits, the sum of the pieces is equal to the original number (i.e. l + r = n).

Alternatively, a modified Kaprekar number is a positive whole number n with 2d digits (if its number of digits is even) or 2d + 1 digits (if its number of digits is odd), such that when we split its square into two pieces, a right hand piece r containing d or d + 1 digits, and a left piece l containing the remaining d digits, the sum of the two pieces is equal to the original number.

Note: r may have leading zeros.

Here's an alternative explanation from Wikipedia: In mathematics, a Kaprekar number for a given base is a non-negative integer, the representation of whose square in that base can be split into two parts that add up to the original number again. For instance, 45 is a Kaprekar number, because 45² = 2025 and 20+25 = 45.

The Task 
You are given the two positive integers p and q, where p is lower than q. Write a program to determine how many Kaprekar numbers are there in the range between p and q (both inclusive) and display them all.

Input Format

There will be two lines of input: p, lowest value q, highest value

Constraints: 
0<p<q<100000
Output Format

Output each Kaprekar number in the given range, space-separated on a single line. If no Kaprekar numbers exist in the given range, print INVALID RANGE.

Sample Input

1
100
Sample Output

1 9 45 55 99

Explanation

1, 9, 45, 55, and 99 are the Kaprekar Numbers in the given range.


*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ModifiedKaprekarNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        
        String op = "1 ";
        if(a>1){
            op = "";
        }
        for(long k = a; k <= b ; k++ ){
            long mul = k*k;
            //System.out.println(mul);
            if(mul>(long)10){
                String z = mul + "";
                int flag = 0;
                
                for(int i = 1; i<z.length(); i++){
                    long x = Long.parseLong(z.substring(0,z.length()-i));
                    long y = Long.parseLong(z.substring(z.length()-i));
                    
                    int p = z.substring(0,z.length()-i).length();
                    int q = z.substring(z.length()-i).length();
                    //System.out.print(x + " + " + y + " =" + (x+y)+" , ");
                    if(k == (x+y) && (p==q || p-1 == q || q-1 ==p)){
                        if(k == 10 || k == 100 || k == 1000 || k == 10000 || k == 100000){
                            break;
                        }
                        
                        flag = 1;
                        
                        //System.out.println("op "+k);
                        //System.out.println(x + " + " + y + " =" + (x+y));
                        break;
                    }
                }
                
                if(flag == 1){
                    op += k + " ";
                }
            }
        }
        if(op != ""){
            System.out.println(op);
        }
        else{
            System.out.println("INVALID RANGE");
        }
    }
}