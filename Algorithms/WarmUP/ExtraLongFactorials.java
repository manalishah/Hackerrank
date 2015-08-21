/*
Problem Statement

You are given an integer N. Print the factorial of this number.

N!=N×(N−1)×(N−2)×⋯×3×2×1
Note: Factorials of N>20 can't be stored even in a 64−bit long long variable. Big integers must be used for such calculations. Languages like Java, Python, Ruby etc. can handle big integers but we need to write additional code in C/C++ to handle such large values.

We recommend solving this challenge using BigIntegers.

Input Format 
Input consists of a single integer N.

Constraints 
1 ≤ N ≤ 100

Output Format 
Output the factorial of N.

Sample Input
25

Sample Output
15511210043330985984000000


================== Solution =======================
For the purpose of storing numbers larger than 64 bit we use BigInteger.
*/





import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ExtraLongFactorials {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        BigInteger b1 = new BigInteger("1");
        BigInteger b2;
        for(int i = 1; i<=n ; i++){
            String ii = i + "";
            b2 = new BigInteger(ii);
            b1 = b1.multiply(b2);
        }
        System.out.println(b1);
    }
}