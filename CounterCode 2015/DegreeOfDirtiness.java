/*
Problem Statement

There are N toilets in a row indexed from 1 to N. At a time, 2 people enter the washroom. The degree of dirtiness of each toilet is 0 initially and it increases by 1 after it is used each time. The 1st person occupies the 1st toilet with the lowest degree of dirtiness moving from 1 to N. The 2nd person occupies the toilet with the lowest degree of dirtiness moving from N to 1. The next two people enter the toilet when the first two people have left. Find the index of toilet and degree of dirtiness for the Mth person.

Note In case M is odd, the last person walks into the washroom alone and occupies the least dirty toilet moving from 1 to N.

Input Format 
The first line contains T, the number of test cases. Each test case consists of one line containing N, the number of toilets, and M, the person to enter the toilet, seperated by space.

Output Format 
The index of the toilet used by M and its degree of dirtiness D.

Constraints 
1≤T≤10 
1≤N≤50000 
1≤M≤106

Sample Input

3  
10 3  
5 8  
4 26 
Sample Output

2 0  
4 1  
4 6  
Explanation

In the second test case, 
for the first two persons, positions are 1 _ _ _ 2, degree of dirtiness 0 0 0 0 0 (dirtiness is 0 since they are the first to use it) 
for person 3 and 4, positions are _ 3 _ 4 _ , degree of dirtiness 1 0 0 0 1 
for 5 and 6, positions are _ _ 5 _ 6, degree of dirtiness 1 1 0 1 1 
for 7 and 8, positions are 7 _ _ 8 _, degree of dirtiness 1 1 1 1 2 so the answer is 4,1
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DegreeOfDirtiness {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int count = 0;
            String bathroom = " ";
            int i;
            int k;
            int flag = 0;
            
            
            if(m>n){
                int start;
                if(m%n == 0){
                    start = m - n + 1;
                }else{
                    start = m - m%n +1;
                }
                //System.out.println(start);
                count = 0;
                if(start%2 == 0){
                    for(k = 0,i = start+1; k<n/2; k++, i+=2){
                        bathroom += i;
                                               // System.out.println(bathroom);

                        count++;
                        if(i==m){
                            flag = 1;
                            break;
                        }
                    }
                    
                    if(flag == 0){
                        int end = start + n - 1;
                        for(i = end; i >= start; i-=2){
                            bathroom += i;
                       // System.out.println(bathroom);

                            count++;
                            if(i==m){
                                break;
                            }
                        }
                        
                    }
                    
                }
                else{
                    //System.out.println(start);
                    if(start%2 != 0 && n%2 !=0){
                        for(k = 0,i = start; k<=n/2; k++, i+=2){
                        bathroom += i;
                       // System.out.println(bathroom);
                        count++;
                        if(i==m){
                            flag = 1;
                            break;
                        }
                    }
                    }
                    else{
                    for(k = 0,i = start; k<n/2; k++, i+=2){
                        bathroom += i;
                        //System.out.println(bathroom);
                        count++;
                        if(i==m){
                            flag = 1;
                            break;
                        }
                    }
                    }
                    if(flag == 0){
                        int end;
                            end = i-3;
                        if(n%2==0){
                            end = i-1;
                        }
                        for(i = end; i >= start; i-=2){
                            bathroom += i;
                           //System.out.println(bathroom);
                            count++;
                            if(i==m){
                                break;
                            }
                            
                        }
                    }
                }
            }
            else{
                i = 0;
                for(i = 1; i<=n; i+=2){
                    bathroom += i;
                    count++;
                    if(i==m){
                        flag = 1;
                        break;
                    }
                }
                if(n%2 == 0){
                    i = n;
                }
                else{
                    i = n-1;
                }
                if(flag == 0){
                for(; i>=2; i-=2){
                    bathroom += i;
                    count++;
                    if(i==m){
                        break;
                    }
                }
                }
            }
            int dirty = 0;
            if(m%n == 0){
               dirty = m/n -1;
            }
            else{
                dirty = m/n;
            }
            System.out.println(count + " " + (dirty));
            t--;
        }
    }
}