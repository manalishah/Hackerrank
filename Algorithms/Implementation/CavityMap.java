/*
Problem Statement

You are given a square map of size n×n. Each cell of the map has a value denoting its depth. We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side (edge).

You need to find all the cavities on the map and depict them with the uppercase character X.

Input Format

The first line contains an integer, n, denoting the size of the map. Each of the following n lines contains n positive digits without spaces. Each digit (1-9) denotes the depth of the appropriate area.

Constraints 
1≤n≤100
Output Format

Output n lines, denoting the resulting map. Each cavity should be replaced with character X.

Sample Input

4
1112
1912
1892
1234
Sample Output

1112
1X12
18X2
1234
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CavityMap {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char map[][] = new char[n][n];
        for(int i = 0; i<n; i++){
            String l = sc.next();
            for(int j = 0; j<n; j++){
                map[i][j]= l.charAt(j);
            }
        }
       
        
        for(int i = 1; i<n-1; i++){
            for(int j = 1; j<n-1; j++){
                if(map[i][j]>map[i-1][j] && map[i][j]>map[i+1][j] && map[i][j]>map[i][j-1] && map[i][j]>map[i][j+1]){
                    map[i][j] = 'X';
                }
            }
        }
        
        for(int i =0; i<n; i++){
            System.out.println(new String(map[i]));
        }
       
        
        
    }
}