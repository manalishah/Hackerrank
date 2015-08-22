/*
Problem Statement

You are given a square matrix of size N×N. Calculate the absolute difference of the sums across the two main diagonals.

Input Format

The first line contains a single integer N. The next N lines contain N integers (each) describing the matrix.

Constraints 
1≤N≤100 
−100≤A[i]≤100
Output Format

Output a single integer equal to the absolute difference in the sums across the diagonals.

Sample Input

3
11 2 4
4 5 6
10 8 -12
Sample Output

15
Explanation

The first diagonal of the matrix is:

11
    5
        -12
Sum across the first diagonal = 11+5-12= 4

The second diagonal of the matrix is:

        4
    5
10
Sum across the second diagonal = 4+5+10 = 19 
Difference: |4-19| =15
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DiagonalDifference {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d[][] = new int[n][n];
        int d1 = 0;
        int d2 = 0;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                
                d[i][j] = sc.nextInt();
                if(i==j){
                    d1 += d[i][j];
                }
                
                if( i == (n-1-j) || j == (n-1-i)){
                    d2 += d[i][j];
                }
            }
        }
        System.out.println(Math.abs(d1-d2));
        
    }
}