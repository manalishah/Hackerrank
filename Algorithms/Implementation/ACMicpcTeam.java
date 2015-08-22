/*
Problem Statement

You are given a list of N people who are attending ACM-ICPC World Finals. Each of them are either well versed in a topic or they are not. Find out the maximum number of topics a 2-person team can know. And also find out how many teams can know that maximum number of topics.

Note Suppose a, b, and c are three different people, then (a,b) and (b,c) are counted as two different teams.

Input Format

The first line contains two integers, N and M, separated by a single space, where N represents the number of people, and M represents the number of topics. N lines follow.
Each line contains a binary string of length M. If the ith line's jth character is 1, then the ith person knows the jth topic; otherwise, he doesn't know the topic.

Constraints 
2≤N≤500 
1≤M≤500

Output Format

On the first line, print the maximum number of topics a 2-person team can know. 
On the second line, print the number of 2-person teams that can know the maximum number of topics.

Sample Input

4 5
10101
11100
11010
00101
Sample Output

5
2
Explanation

(1, 3) and (3, 4) know all the 5 topics. So the maximal topics a 2-person team knows is 5, and only 2 teams can achieve this.


*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ACMicpcTeam {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char z[][] = new char[n][m];
        int temp[] = new int[m];
        int teams[] = new int[(n*(m-1))/2];
        int max = m;
        int finalmax = 0;
        
        for(int i = 0; i<n; i++){
            z[i] = sc.next().toCharArray();
        }
        int count = 0;
        int counter = 0;
        for(int i = 0; i<n; i++){
            
            for(int j = i+1; j<n; j++){
                max = m;
                
                if(i!=j){
                    int k;
                    for(k = 0; k<m; k++){
                        temp[k] = Integer.parseInt(z[i][k]+"") + Integer.parseInt(z[j][k]+"");
                        if(temp[k] ==  0){
                            max--;
                        }
                        
                        
                    }
                    //for(int y : temp){
                      //      System.out.print(y);
                       //}
                    //System.out.println("");
                    teams[counter] = max;
                    if(finalmax<=max){
                        finalmax = max;
                    }
                    counter++;
                    //System.out.println("");
                }
                
            }
        }
        
        
        
        for(int x:teams){
            if(x == finalmax){
                count++;
            }
        }
        
        System.out.println(finalmax);
        System.out.println(count);
        
    }
}
