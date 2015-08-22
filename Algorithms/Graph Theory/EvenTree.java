/*
Problem Statement

You are given a tree (a simple connected graph with no cycles). You have to remove as many edges from the tree as possible to obtain a forest with the condition that : Each connected component of the forest should contain an even number of vertices.

To accomplish this, you will remove some edges from the tree. Find out the number of removed edges.

Input Format 
The first line of input contains two integers N and M. N is the number of vertices and M is the number of edges. 
The next M lines contain two integers ui and vi which specifies an edge of the tree. (1-based index)

Output Format 
Print the answer, a single integer.

Constraints 
2 <= N <= 100.

Note: The tree in the input will be such that it can always be decomposed into components containing even number of nodes.

Sample Input

10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8
Sample Output

2
Explanation  
On removing edges (1, 3) and (1, 6), we can get the desired result.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EvenTree {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l[] = br.readLine().split(" ");
        int v = Integer.parseInt(l[0]);
        int e = Integer.parseInt(l[1]);
        
        int A[][] = new int[e][2];
        
        for(int i = 0; i<e; i++){
            String l1[] = br.readLine().split(" ");
            A[i][0] = Integer.parseInt(l1[0]);
            A[i][1]= Integer.parseInt(l1[1]);
        }
        int counter[]  = new int[v+1];
        for(int i = 1; i<=v; i++){
            counter[i] = 1;
        }
        for(int i = 0; i<e; i++){
            counter[A[i][1]] = 0;
        }
        
        int edge = 0;
        int total,flag;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = v; i>=0; i--){
            if(counter[i]==0){
                q.add(i);
                total = 0;
                
                for(Integer ele = q.poll(); ele != null; ){
                    flag = 0;
                    if(counter[ele] != 0){
                        total += counter[ele];
                        flag++;
                    }
                    else{
                        total++;
                    }
                    
                    if(flag == 0){
                        for(int j = 0; j<e; j++ ){
                            if(ele == A[j][1]){
                                q.add(A[j][0]);
                            }
                        }
                    }
                    ele = q.poll();
                    
                }
                
                counter[i] = total;
                    
            }
        }
        
        for(int i = 2; i<counter.length; i++){
            if(counter[i] % 2 == 0){
                edge++;
            }
        }
        
        System.out.println(edge);
    }
}


